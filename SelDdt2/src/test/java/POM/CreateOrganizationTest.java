package POM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CreateGenericUtility.ExcelUtility;
import CreateGenericUtility.FileUtility;
import CreateGenericUtility.JavaUtility;
import CreateGenericUtility.WebDriverUtility;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Create Object
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		//read data
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("usn");
		String PASSWORD=flib.getDataFromPropertiesFile("pwd");
		//random number

		String name=elib.getDataFromExcel("Sheet3",1, 2)+jlib.getRandomNumber();
				WebDriver driver=null;
        if(BROWSER.equals("chrome"))
        {
        	driver=new ChromeDriver();
        }
        else if(BROWSER.equals("firefox"))
        {
        	driver=new FirefoxDriver();
        }
        else
        {
        	driver=new ChromeDriver();
        }
        
       wlib.waitForPageToLoad(driver);
        driver.get(URL);
        LoginPage lp=new LoginPage(driver);
        lp.loginToApp(URL,USERNAME,PASSWORD);
        
        HomePage hp=new HomePage(driver);
        
        hp.navigateToCampaignPage();
        hp.getOrganizationLnk().click();
        
        OrganizationPage op=new OrganizationPage(driver);
        op.getCreateOrganizationBtn().click();
        
        CreatingNewOrgPage cop=new CreatingNewOrgPage(driver);
        cop.createOrg(name);

        
        OrganizationInfoPageVerify oip=new OrganizationInfoPageVerify(driver);
        String actName=oip.getHeaderMsg().getText();
        if(actName.contains(name))
        {
        	System.out.println(name+" OrgName is verified==PASS");
        }
        else
        {
        	System.out.println(name+" OrgName is not verified==FAIL");
        }
      Thread.sleep(2000);
      hp.getOrganizationLnk().click();
      cop.getSearchEdt().sendKeys(name);
      wlib.select(cop.getSearchDD(), "Organization Name");
      cop.getSearchBtn().click();
      
      driver.findElement(By.xpath("//a[text()='"+name+"']/../../td[8]/a[text()='del']")).click();
      driver.switchTo().alert().accept();
	}

}
