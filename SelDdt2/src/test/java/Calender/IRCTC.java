package Calender;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class IRCTC {
	@Test
	public void trainTicketBooking_Test() throws Throwable {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");

		driver.findElement(By.xpath("//img[@id='disha-banner-close']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-8 ui-autocomplete ui-widget']")).click();

		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Howrah");
		driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[2]")).click();
		Thread.sleep(1500);
//		WebElement cross = driver
//				.findElement(By.xpath("//a[@class='fa fa-window-close pull-right loginCloseBtn ng-tns-c19-13']"));
//		WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(15));
//		wdw.until(ExpectedConditions.elementToBeClickable(cross));
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-9 ui-autocomplete ui-widget']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Smvt Bengaluru");
		driver.findElement(By.xpath("//div[@class='ng-trigger ng-trigger-overlayAnimation ng-tns-c58-9 ui-autocomplete-panel ui-widget ui-widget-content ui-corner-all ui-shadow ng-star-inserted']")).click();
		
		driver.findElement(By.xpath("//span[@class='ng-tns-c59-10 ui-calendar']")).click();
		
		for(;;)

		{

			try

			{

				driver.findElement(By.xpath("//div[@aria-label='Fri Sep 19 2025']")).click();

				break;

			}

			catch(Exception e)

			{

				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();

			}

		}

		
	}
}
