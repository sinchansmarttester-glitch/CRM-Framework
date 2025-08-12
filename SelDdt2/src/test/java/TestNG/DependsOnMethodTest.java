package TestNG;

import org.testng.annotations.Test;

public class DependsOnMethodTest {
	
	@Test(dependsOnMethods = "createAccountPageTest")
	public void loginPageTest()
	{
		System.out.println("UserName Textfield is Executed");
		System.out.println("Password Textfield is Executed");
		System.out.println("Login Button is Executed");
		System.out.println("Login page is Executed");
		System.out.println("--------------------------------");
	}

	@Test
	public void createAccountPageTest()
	{
		System.out.println("UserName Textfield is Executed");
		System.out.println("Password Textfield is Executed");
		System.out.println("Confirm Password Textfield is Executed");
		System.out.println("Signin Button is Executed");
		System.out.println("Create Account Page is Executed");
		System.out.println("--------------------------------");
	}

	@Test(dependsOnMethods = "loginPageTest")
	public void homepageTest()
	{
		System.out.println("HomePage is Executed");

	}

}
