package Listener_Utility;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import CreateGenericUtility.DatabaseUtility;
import CreateGenericUtility.ExcelUtility;
import CreateGenericUtility.FileUtility;
import CreateGenericUtility.JavaUtility;
import CreateGenericUtility.WebDriverUtility;

public class BaseClass {
	public DatabaseUtility dlib = new DatabaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	
	
	@BeforeSuite
	public void CreateBs()
	{
		System.out.println("Connect to Db,Report Config");
	}
@BeforeClass
	public void CreateBc() {
		System.out.println("Launch The Browser");
}
@BeforeMethod
public void CreateBm()  {
	System.out.println("Login");
}
@AfterMethod
public void CreateAm() {
	System.out.println("Logout");
}
@AfterClass
public void CreateAc() {
	System.out.println("Close The Browser");
}
@AfterSuite
public void CreateAs() {
	System.out.println("Close the DB,Report Backup Connection");
}
}

