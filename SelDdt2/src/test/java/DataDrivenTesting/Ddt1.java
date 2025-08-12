package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ddt1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream f=new FileInputStream("E:\\\\Facebook.properties");
        Properties p=new Properties();
        p.load(f);
        String Browser=p.getProperty("browser");
        String Url=p.getProperty("url");
        String username=p.getProperty("UserName");
        String Password=p.getProperty("Pwd");
        
        WebDriver driver=null;
        if(Browser.equals("chrome"))
        {
        	driver=new ChromeDriver();
        }
        else if(Browser.equals("firefox"))
        {
        	driver=new FirefoxDriver();
        }
        else
        {
        	driver=new ChromeDriver();
        }
        
        driver.get(Url);
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(Password);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='Logout']"));
        Thread.sleep(5000);
       // driver.quit();
	}

}
