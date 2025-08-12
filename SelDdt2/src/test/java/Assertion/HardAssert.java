package Assertion;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
@Test
public void homePageTest(Method md)
{
	System.out.println(md.getName()+"Test Start");
	System.out.println("Step-1");
	System.out.println("Step-2");
	Assert.assertEquals("Home","Home");
	System.out.println("Step-3");
	Assert.assertEquals("Crm Home","Crm Home" );
	System.out.println("Step-4");
	System.out.println(md.getName()+"Test End");
}
@Test
public void logoInHomePageTest(Method md)
{
	System.out.println(md.getName()+"Test Start");
	System.out.println("Step-1");
	System.out.println("Step-2");
	Assert.assertTrue(true);
	System.out.println("Step-3");
	System.out.println("Step-4");
	System.out.println(md.getName()+"Test End");
}
}
