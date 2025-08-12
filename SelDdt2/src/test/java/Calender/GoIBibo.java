package Calender;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoIBibo {
@Test
public void goiBibo_test() throws Throwable{
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	driver.get("https://www.goibibo.com/");
	driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
	driver.findElement(By.xpath("//span[text()='Flights']")).click();
	driver.findElement(By.xpath("//span[text()='From']")).click();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bangaluru");
	driver.findElement(By.xpath("(//span[@class='autoCompleteTitle '])[1]")).click();
	
	driver.findElement(By.xpath("(//span[text()='To'])[2]")).click();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Kolkata");
	driver.findElement(By.xpath("(//span[@class='autoCompleteTitle '])[1]")).click();
	//Click on Departure

	driver.findElement(By.xpath("//span[@class='sc-12foipm-3 dtSKny fswWidgetLabel' and text()='Departure']")).click();

	for(;;)

	{

		try

		{

			driver.findElement(By.xpath("//div[@aria-label='Fri Nov 14 2025']")).click();

			break;

		}

		catch(Exception e)

		{

			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();

		}

	}

	//Click on Return

	driver.findElement(By.xpath("//span[text()='Return']")).click();

			for(;;)

			{

				try

				{

					driver.findElement(By.xpath("//div[@aria-label='Thu Jan 01 2026']")).click();

					break;

				}

				catch(Exception e)

				{

					driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();

				}

			}
}
	
	
	
	
}
