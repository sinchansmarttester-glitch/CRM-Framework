package TestNG;

import org.testng.annotations.Test;

public class PriorityTest {
@Test(priority=0)
public void loginPageTest()
{
	System.out.println("UserName Textfield is Executed");
	System.out.println("Password Textfield is Executed");
	System.out.println("Login Button is Executed");
	System.out.println("Login page is Executed");
	System.out.println("--------------------------------");
}

@Test(priority = -1)
public void createAccountPageTest()
{
	System.out.println("UserName Textfield is Executed");
	System.out.println("Password Textfield is Executed");
	System.out.println("Confirm Password Textfield is Executed");
	System.out.println("Signin Button is Executed");
	System.out.println("Create Account Page is Executed");
	System.out.println("--------------------------------");
}

@Test(priority=1)
public void homepageTest()
{
	System.out.println("HomePage is Executed");

}
}
