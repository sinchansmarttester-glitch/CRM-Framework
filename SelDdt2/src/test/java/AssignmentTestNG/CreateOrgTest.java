package AssignmentTestNG;

import org.testng.annotations.Test;

import TestNG.BaseClass;

public class CreateOrgTest extends BaseClass {
	@Test
	public void createOrg()
	{
		System.out.println("Organization created");
	}
	@Test
	public void createOrgWithPhoneNo()
	{
		System.out.println("Organization with phone number created");
	}
	
}
