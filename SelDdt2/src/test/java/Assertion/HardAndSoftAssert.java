package Assertion;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssert {
@Test
public void homePageTest(Method m)
{
	System.out.println(m.getName()+"Test Start");
	SoftAssert saObj=new SoftAssert();
	System.out.println("Step-1");
	System.out.println("Step-2");
	Assert.assertEquals("Home", "Home1");
	System.out.println("Step-3");
	System.out.println("Step-4");
	saObj.assertEquals("Crm Home", "Crm Home");
	System.out.println(m.getName()+"Test End");
}
@Test
public void logoOfHomePageTest(Method m)
{
	System.out.println(m.getName()+"Test Start");
	SoftAssert saObj=new SoftAssert();
	System.out.println("Step-1");
	System.out.println("Step-2");
	saObj.assertTrue(true);
	System.out.println("Step-3");
	System.out.println("Step-4");
	System.out.println(m.getName()+"Test End");
}
}
