package Assertion;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReporterTest {
	@Test
	public void homePageTest(Method m)
	{
		System.out.println(m.getName()+"Test Start");
		SoftAssert saObj=new SoftAssert();
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		saObj.assertEquals("Home", "Home");
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);
		saObj.assertEquals("Crm Home", "Crm Home");
		saObj.assertAll();
		Reporter.log(m.getName()+"Test End");
	}
	@Test
	public void logoOfHomePageTest(Method m)
	{
		Reporter.log(m.getName()+"Test Start");
		SoftAssert saObj=new SoftAssert();
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		saObj.assertTrue(true);
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);
		saObj.assertAll();
		Reporter.log(m.getName()+"Test End");
	}
}
