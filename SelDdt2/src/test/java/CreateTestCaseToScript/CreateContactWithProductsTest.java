package CreateTestCaseToScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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

public class CreateContactWithProductsTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
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
		Row row2=sh.getRow(7);
		String phoneNo=row2.getCell(3).getStringCellValue();
		Row row3=sh.getRow(7);
		String lastName=row3.getCell(4).toString()+ranInt;
		Row row4=sh.getRow(1);
		String title=row4.getCell(4).toString()+ranInt;
		Row row5=sh.getRow(1);
		String productName=row5.getCell(5).toString()+ranInt;
		
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
	        driver.findElement(By.id("phone")).sendKeys(phoneNo);
	        
	        WebElement ele1=driver.findElement(By.name("industry"));
	        Select sel1=new Select(ele1);
	        sel1.selectByVisibleText(industry);
	        
	        WebElement ele2=driver.findElement(By.name("accounttype"));
	        Select sel2=new Select(ele2);
	        sel2.selectByVisibleText(type);
	        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	        Thread.sleep(2000);
	        //Date and LastName
	        driver.findElement(By.linkText("Contacts")).click();
	        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	        Thread.sleep(2000);

	        Date d=new Date();
	        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	        String startDate=sim.format(d);
	        Calendar cal=sim.getCalendar();
	        cal.add(Calendar.DAY_OF_MONTH, 30);
	        String endDate=sim.format(cal.getTime());
	        driver.findElement(By.name("lastname")).sendKeys(lastName);
	        driver.findElement(By.name("support_start_date")).clear();
	        driver.findElement(By.name("support_start_date")).sendKeys(startDate);
	        driver.findElement(By.name("support_end_date")).clear();
	        driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.linkText("Documents")).click();
	        driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
	        driver.findElement(By.name("notes_title")).sendKeys(title);
	        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.linkText("Products")).click();
	        driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	        driver.findElement(By.name("productname")).sendKeys(productName);
	        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	        //verify

	       
	        String actProductName=driver.findElement(By.id("mouseArea_Product Name")).getText();
	        if(actProductName.contains(productName))
	        {
	        	System.out.println(productName+" Title is verified==PASS");
	        }
	        else
	        {
	        	System.out.println(productName+" Title is not verified==FAIL");
	        }
	        
	        
	        		driver.quit();


	}

}
