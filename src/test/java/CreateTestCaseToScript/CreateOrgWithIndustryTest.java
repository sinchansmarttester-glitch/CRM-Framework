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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndustryTest {

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
		Row row1=sh.getRow(4);
		String industry=row1.getCell(3).toString();
		String type=row1.getCell(4).toString();
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
	        driver.findElement(By.linkText("Organizations")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	        driver.findElement(By.name("accountname")).sendKeys(name);
	        
	        WebElement ele1=driver.findElement(By.name("industry"));
	        Select sel1=new Select(ele1);
	        sel1.selectByVisibleText(industry);
	        
	        WebElement ele2=driver.findElement(By.name("accounttype"));
	        Select sel2=new Select(ele2);
	        sel2.selectByVisibleText(type);
	        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	        Thread.sleep(2000);
	        //verify
	        String actIn=driver.findElement(By.id("dtlview_Industry")).getText();
	        if(actIn.contains(industry))
	        {
	        	System.out.println(industry+" Information is verified==PASS");
	        }
	        else
	        {
	        	System.out.println(industry+" Information is not verified==FAIL");
	        }
	        
	        String actType=driver.findElement(By.id("dtlview_Type")).getText();
	        if(actType.contains(type))
	        {
	        	System.out.println(type+" Information is verified==PASS");
	        }
	        else
	        {
	        	System.out.println(type+" Information is not verified==FAIL");
	        }
	        
	        driver.quit();
	}

}
