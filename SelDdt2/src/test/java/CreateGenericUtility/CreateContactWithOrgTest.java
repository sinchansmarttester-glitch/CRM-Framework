package CreateGenericUtility;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContactWithOrgTest {

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
		        String industry=elib.getDataFromExcel("Sheet3",4,3);
		        String type=elib.getDataFromExcel("Sheet3",4, 4);
		        String phoneNo=elib.getDataFromExcel("Sheet3",7,3);
		        String lastName=elib.getDataFromExcel("Sheet3",7, 4);
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
	        driver.manage().window().maximize();
	        Thread.sleep(2000);
	        driver.get(URL);
	        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	        driver.findElement(By.id("submitButton")).click();
	        driver.findElement(By.linkText("Organizations")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	        driver.findElement(By.name("accountname")).sendKeys(name);
	        driver.findElement(By.id("phone")).sendKeys(phoneNo);
	        
	        WebElement ele1=driver.findElement(By.name("industry"));
	        Select sel1=new Select(ele1);
	        sel1.selectByVisibleText(industry);
	        
	        WebElement ele2=driver.findElement(By.name("accounttype"));
	        Select sel2=new Select(ele2);
	        sel2.selectByVisibleText(type);
	        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	        Thread.sleep(3000);
	        //Date and LastName
	        driver.findElement(By.linkText("Contacts")).click();
	        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	        Thread.sleep(2000);
            
	        
	       
	        driver.findElement(By.name("lastname")).sendKeys(lastName);
	        String startDate=jlib.getSystemDateYYYYDDMM();
	        String endDate=jlib.getRequiredDateYYYYDDMM(30);
	        driver.findElement(By.name("support_start_date")).clear();
	        driver.findElement(By.name("support_start_date")).sendKeys(startDate);
	        driver.findElement(By.name("support_end_date")).clear();
	        driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	        driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	        //Child Window
	        wlib.switchToTabOnUrl(driver, "module=Accounts");
	        driver.findElement(By.name("search_text")).sendKeys(name);
	        driver.findElement(By.name("search")).click();
             Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
	        
//	        parent
	        wlib.switchToTabOnUrl(driver, "module=Contacts");

	        
	        String actLastName=driver.findElement(By.id("mouseArea_Last Name")).getText();
	        if(actLastName.contains(lastName))
	        {
	        	System.out.println(lastName+" LastName is verified==PASS");
	        }
	        else
	        {
	        	System.out.println(lastName+" LastName is not verified==FAIL");
	        }
	        
	        
	        		driver.quit();



}

}
