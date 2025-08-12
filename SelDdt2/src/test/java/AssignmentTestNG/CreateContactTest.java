package AssignmentTestNG;

import org.testng.annotations.Test;

import TestNG.BaseClass;

public class CreateContactTest extends BaseClass{
	@Test
	public void createContact()
	{
		System.out.println("Contact created");
	}
	@Test
	public void createContactWithOrg()
	{
		System.out.println("Contact with Organization is created");
	}
	
}
