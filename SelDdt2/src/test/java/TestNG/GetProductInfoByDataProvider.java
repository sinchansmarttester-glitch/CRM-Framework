package TestNG;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CreateGenericUtility.ExcelUtility;


public class GetProductInfoByDataProvider {
@Test(dataProvider = "getData")
public void getProductInfo(String Brand,String ProductName) throws Throwable
{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Brand,Keys.ENTER);
	
	String s="//div[text()='"+ProductName+"']/../..//div[@class='cN1yYO']";
	String price=driver.findElement(By.xpath(s)).getText();
	System.out.println(price);
	Thread.sleep(2000);
	driver.quit();
}
@DataProvider
public Object[][] getData() throws Throwable
{
	ExcelUtility eLib=new ExcelUtility();
	int rowNum=eLib.getRowCount("Sheet4");
	Object[][] objArr=new Object[rowNum][2];
	for(int i=0;i<rowNum;i++)
	{
		objArr[i][0]=eLib.getDataFromExcel("Sheet4",i+1,0);
		objArr[i][1]=eLib.getDataFromExcel("Sheet4",i+1, 1);
	}
	return objArr;
}
}
