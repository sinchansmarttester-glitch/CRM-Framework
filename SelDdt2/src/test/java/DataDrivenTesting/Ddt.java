package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ddt {

	public static void main(String[] args) throws IOException {
		FileInputStream f=new FileInputStream("E:\\DDT.properties");
		Properties p=new Properties();
		p.load(f);
		String Browser=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("usn");
		String PASSWORD=p.getProperty("pwd");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.quit();
		

	}

}
