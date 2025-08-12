package ListenerUtility;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(ListenerUtility.ListenerImplementationClass.class)
public class InvoiceTest extends BaseClass {
@Test(retryAnalyzer =ListenerUtility.RetryListener.class)
public void createInvoiceTest()
{
	System.out.println("execute createInvoiceTest");
	String title=driver.getTitle();
	Assert.assertEquals(title, "Home");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");
}
//@Test
//public void invoiceTest()
//{
//	System.out.println("execute invoiceTest");
//	System.out.println("Step-1");
//	System.out.println("Step-2");
//	System.out.println("Step-3");
//	System.out.println("Step-4");
//}

}
