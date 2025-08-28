package CreateTestCaseToScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream f=new FileInputStream("E:\\DDT.properties");
		Properties p=new Properties();
		p.load(f);
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("usn");
		String PASSWORD=p.getProperty("pwd");
		
		Random ran=new Random();
		int ranInt=ran.nextInt(1000);
		
		FileInputStream f1=new FileInputStream(".\\src\\test\\resources\\TestCaseToScript.xlsx");
		Workbook wb=WorkbookFactory.create(f1);
		Sheet sh=wb.getSheet("Sheet3");
		Row row=sh.getRow(1);
		String name=row.getCell(2).toString()+ranInt;
		wb.close();
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
	        Thread.sleep(2000);
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
