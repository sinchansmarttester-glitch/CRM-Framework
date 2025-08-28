package Report;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CreateContactTest{
	ExtentReports report;
	@BeforeSuite
	public void configBC()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("Crm testSuite Result");
		spark.config().setDocumentTitle("Crm Report");
		spark.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Os", "Windows-10");
		report.setSystemInfo("Browser", "chrome-100");
	}
	@AfterSuite
	public void configAs()
	{
		report.flush();
	}
@Test
public void createContactTest()
{
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	TakesScreenshot ts=(TakesScreenshot)driver;
	String path=ts.getScreenshotAs(OutputType.BASE64);
	ExtentTest test=report.createTest("createContactText");
	test.log(Status.INFO,"Login to app");
	test.log(Status.INFO,"Navigate to contact page");
	test.log(Status.INFO,"Create Contact");
	if("HDFC".equals("HDFC"))
	{
		test.log(Status.PASS,"Contact is created");
	}
	else
	{
		test.log(Status.FAIL,"Contact is not created");
		test.addScreenCaptureFromBase64String(path, "ErrorFile");
	}
	driver.close();
}
}
