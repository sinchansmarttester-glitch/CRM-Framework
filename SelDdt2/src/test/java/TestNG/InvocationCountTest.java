package TestNG;

import org.testng.annotations.Test;

public class InvocationCountTest {
		@Test(invocationCount = 5)
		public void createAccountPageTest()
		{
			System.out.println("UserName Textfield is Executed");
			System.out.println("Password Textfield is Executed");
			System.out.println("Confirm Password Textfield is Executed");
			System.out.println("Signin Button is Executed");
			System.out.println("--------------------------------");

		}
		@Test(enabled = false)
		public void loginPageTest()
		{
			System.out.println("UserName Textfield is Executed");
			System.out.println("Password Textfield is Executed");
			System.out.println("Login Button is Executed");

		}
}
