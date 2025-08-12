package Calender;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KSRTC {
	@Test
	public void krctcBokin_Test() throws InterruptedException, Throwable {


		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		driver.manage().window().maximize();

		driver.get("https://ksrtc.in/");

		
		driver.findElement(By.xpath("//span[text()='Select Departure City']")).click();



		driver.findElement(By.xpath("(//input[@placeholder='Search Your City Name'])[1]")).sendKeys("Adoni");

		driver.findElement(By.xpath("//em[.='Adoni']")).click();

		driver.findElement(By.xpath("//span[text()='Select Destination City']")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Search Your City Name'])[2]")).sendKeys("Bengaluru");

		driver.findElement(By.xpath("//li[.='Bengaluru']")).click();

		driver.findElement(By.id("departDate")).click();
		//driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']"));
         //Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='6']")).click();

        driver.findElement(By.id("submitSearch")).click();
        
        
       //sSystem.out.println(data);
        FileInputStream fis = new FileInputStream(".\\SelDdt\\src\\test\\resources\\TestCaseToScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		 Sheet sh = wb.getSheet("KSRTC");
        driver.findElement(By.xpath("//span[text()='1944MNTMYS']")).getText();
		List<WebElement> bus1details = driver.findElements(By.xpath("(//span[@class='service--route sc']/ancestor::div[@class='listinng-block-left'])[1]/descendant::div[@class='triptimebold darkText1']"));
		
	
		List<WebElement> bus2details = driver.findElements(By.xpath("(//span[@class='service--route sc']/ancestor::div[@class='listinng-block-left'])[2]/descendant::div[@class='triptimebold darkText1']"));
		
		// Create header row
		Row header = sh.createRow(0);
		header.createCell(0).setCellValue("Bus 1 Times");
		header.createCell(1).setCellValue("Bus 2 Times");

		// First loop for bus1details
		for (int i = 0; i < bus1details.size(); i++) {
		    Row row = sh.getRow(i + 1);
		    if (row == null) {
		        row = sh.createRow(i + 1);
		    }
		    row.createCell(0).setCellValue(bus1details.get(i).getText());
		    System.out.println(bus1details.get(i).getText());
		}

		// Second loop for bus2details
		for (int i = 0; i < bus2details.size(); i++) {
		    Row row = sh.getRow(i + 1);
		    if (row == null) {
		        row = sh.createRow(i + 1);
		    }
		    row.createCell(1).setCellValue(bus2details.get(i).getText());
		    System.out.println(bus2details.get(i).getText());
		}

		FileOutputStream fos = new FileOutputStream(".\\SelDdt\\src\\test\\resources\\TestCaseToScript.xlsx");
		wb.write(fos);
		wb.close();
}
}