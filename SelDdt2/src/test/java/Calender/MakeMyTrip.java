package Calender;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTrip {
	@Test
	public void myTrip_test() throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
	driver.findElement(By.xpath("//span[text()='From']")).click();
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Bangaluru");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@class='makeFlex flexOne spaceBetween appendRight10']")).click();
	
	driver.findElement(By.xpath("//span[text()='To']")).click();
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Kolkata");

	driver.findElement(By.xpath("//span[@class='makeFlex flexOne spaceBetween appendRight10']")).click();
	
	driver.findElement(By.xpath("//span[@class='lbl_input appendBottom10' and text()='Departure']")).click();

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

	//Click on Return

	driver.findElement(By.xpath("//span[text()='Return']")).click();

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
			driver.findElement(By.xpath("//a[text()='Search']"));
	}
}
