package Listener_Utility;

import org.testng.Assert;
import org.testng.annotations.Test;

import ListenerUtility.BaseClass;

public class Invoice_Test extends BaseClass {
	@Test
	public void createInvoiceTest()
	{
		System.out.println("execute createInvoiceTest");
		String title=driver.getTitle();
		Assert.assertEquals(title,"Home");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
