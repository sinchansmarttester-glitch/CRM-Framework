package CreateGenericUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Create Object
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
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
        
        Thread.sleep(2000);
        driver.get(URL);
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Organizations")).click();
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        driver.findElement(By.name("accountname")).sendKeys(name);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	        
	    //Verify
        Thread.sleep(3000);
        String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        System.out.println(header);
        
        if(header.contains(name))
        {
        	System.out.println(name+ " is created==PASS");
        }
        else
        {
        	System.out.println(name+ " is not created==FAIL");
        }
         String orgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
        if(orgName.contains(name))
        {
        	System.out.println(name+ " information is created==PASS");
        }
        else
        {
        	System.out.println(name+ " information is not created==FAIL");
        }
        driver.quit();
	}

}
