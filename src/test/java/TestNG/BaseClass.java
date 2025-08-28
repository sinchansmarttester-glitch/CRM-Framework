package TestNG;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CreateGenericUtility.DatabaseUtility;
import CreateGenericUtility.ExcelUtility;
import CreateGenericUtility.FileUtility;
import CreateGenericUtility.JavaUtility;
import CreateGenericUtility.WebDriverUtility;
import POM.HomePage;
import POM.LoginPage;

public class BaseClass {
	public DatabaseUtility dlib = new DatabaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	@Test(enabled  = false)
	@BeforeSuite(groups= {"SmokeTest"})
	public void CreateBs() throws Throwable {
		System.out.println("Connect to Db,Report Config");
		dlib.getDbConnection();
	}
	
	@Parameters("browser")
	@BeforeClass
	public void launchBrowser(String BROWSER) throws IOException {
		System.out.println("Launch The Browser");
		String browser = BROWSER;
		System.out.println(browser);
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new FirefoxDriver();
		}
		sdriver=driver;
	}

	@BeforeClass(groups= {"SmokeTest"})
	
	public void CreateBc() throws IOException {
		System.out.println("Launch The Browser");
		//String BROWSER = flib.getDataFromPropertiesFile("browser");
		String BROWSER =System.getProperty("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	@BeforeMethod(groups= {"SmokeTest"})
	public void CreateBm() throws IOException, Throwable {
		System.out.println("Login");
//		String URL = flib.getDataFromPropertiesFile("url");
//		String USERNAME = flib.getDataFromPropertiesFile("usn");
//		String PASSWORD = flib.getDataFromPropertiesFile("pwd");
		String URL =System.getProperty("url");
		String USERNAME =System.getProperty("usn");
		String PASSWORD =System.getProperty("pwd");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);

	}

	@AfterMethod(groups= {"SmokeTest"})
	public void CreateAm() {
		System.out.println("Logout");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups= {"SmokeTest"})
	public void CreateAc() {
		System.out.println("Close The Browser");
		driver.quit();
	}

	@AfterSuite(groups= {"SmokeTest"})
	public void CreateAs() {
		System.out.println("Close the DB,Report Backup Connection");
		dlib.closeDbConnection();
	}
}
