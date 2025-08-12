package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectForGUIUsingSelenium {

	public static void main(String[] args) throws SQLException, InterruptedException {
		//create project for GUI using Selenium
		String projectName="God Of OffSide";
		WebDriver driver=new FirefoxDriver();
		driver.get("http://49.249.28.218:8091/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("DADA");
		
		Select sel=new Select(driver.findElement(By.xpath("(//select[@name='status'])[2]")));
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Thread.sleep(3000);
		//Verify the project in DB in backend using JDBC
		boolean flag=false;
		 com.mysql.jdbc.Driver driverRef= new com.mysql.jdbc.Driver();
		 DriverManager.registerDriver(driverRef);
		 Connection con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
		 Statement stat=con.createStatement();
		 ResultSet r=stat.executeQuery("SELECT * FROM project");
		 while(r.next())
		{
			String actProjectName=r.getString(4);
			if(projectName.equals(actProjectName))
			{
				flag=true;
				System.out.println(projectName+" is available==PASS");
			}
		}
		 if(flag==false)
		 {
			 System.out.println(projectName+" is not available==FAIL"); 
		 }
		 con.close();
	
	}

}
