package AssignmentTestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpotifyTopSongs {

	    public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	        ChromeOptions option = new ChromeOptions();
	        option.addArguments("--disable-notifications");

	        WebDriver driver = new ChromeDriver(option);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        driver.get("https://open.spotify.com/");

	        driver.findElement(By.xpath("//span[text()='Log in']")).click();
	        WebElement mailtxt = driver.findElement(By.xpath("//input[@placeholder='Email or username']"));
	        mailtxt.sendKeys("sinchan.smarttester@gmail.com");

	        driver.findElement(By.xpath("//span[text()='Continue']")).click();

	        
	        Thread.sleep(10000);

	        
	        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("arijit singh");

	        
	        Thread.sleep(2000);

	        List<WebElement> songList = driver.findElements(By.xpath("//div[@class='e-91000-text encore-text-body-medium encore-internal-color-text-base btE2c3IKaOXZ4VNAb8WQ standalone-ellipsis-one-line']"));

	        System.out.println("Songs by Arijit Singh:");
	        for (WebElement song : songList) {
	            System.out.println(song.getText());

	        }

	        
	        FileInputStream fis = new FileInputStream(".\\SelDdt\\src\\test\\resources\\TestCaseToScript.xlsx");
	        Workbook wb = WorkbookFactory.create(fis);
	        Sheet sh = wb.getSheet("Songs");

	        int rowCount = sh.getLastRowNum();
	        Row row = sh.createRow(rowCount + 1);  // Create new row

	        
	        row.createCell(0).setCellValue("Tum Hi Ho");
	        row.createCell(1).setCellValue("Ve Kamleya");
	        row.createCell(2).setCellValue("Phir Bhi Tumko Chaahunga");

	        fis.close(); 


	        FileOutputStream fos = new FileOutputStream(".\\SelDdt\\src\\test\\resources\\TestCaseToScript.xlsx");
	        wb.write(fos);
	        wb.close();
	        fos.close();

	        System.out.println("Executed");

	        driver.quit();
	    }
	}

