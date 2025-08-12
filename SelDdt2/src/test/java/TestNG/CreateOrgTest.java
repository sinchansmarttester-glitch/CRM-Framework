package TestNG;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import POM.CreatingNewOrgPage;
import POM.HomePage;
import POM.OrganizationInfoPageVerify;
import POM.OrganizationPage;

public class CreateOrgTest extends BaseClass {

	@Test(groups= {"SmokeTest"})
	public void createOrg() throws Throwable {

		String name=elib.getDataFromExcel("Sheet3",1, 2)+jlib.getRandomNumber();
		wlib.waitForPageToLoad(driver);
     
       
        
        HomePage hp=new HomePage(driver);
        
        hp.getOrganizationLnk().click();
        
        OrganizationPage op=new OrganizationPage(driver);
        op.getCreateOrganizationBtn().click();
        
        CreatingNewOrgPage cop=new CreatingNewOrgPage(driver);
        cop.createOrg(name);

        
        OrganizationInfoPageVerify oip=new OrganizationInfoPageVerify(driver);
        String actName=oip.getHeaderMsg().getText();
        if(actName.contains(name))
        {
        	System.out.println(name+" OrgName is verified==PASS");
        }
        else
        {
        	System.out.println(name+" OrgName is not verified==FAIL");
        }
         String orgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
        if(orgName.contains(name))
        {
        	System.out.println(name+ " information is created==PASS");
        }
        else
        {
        	System.out.println(name+ " information is not created==FAIL");
        }
        
	}
	@Test(groups= {"SmokeTest"})
	public void createOrgWithPhoneNo() throws EncryptedDocumentException, IOException
	{
		String name=elib.getDataFromExcel("Sheet3",1, 2)+jlib.getRandomNumber();
		String phoneNo=elib.getDataFromExcel("Sheet3",7, 3);
		wlib.waitForPageToLoad(driver);
		
		 HomePage hp=new HomePage(driver);
	        
	        hp.getOrganizationLnk().click();
	        
	        OrganizationPage op=new OrganizationPage(driver);
	        op.getCreateOrganizationBtn().click();
	        
	        CreatingNewOrgPage cop=new CreatingNewOrgPage(driver);
	        cop.createOrgWithPhNo(name, phoneNo);
		
		 String actPhoneNo=driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
	        if(actPhoneNo.contains(phoneNo))
	        {
	        	System.out.println(phoneNo+" Number is verified==PASS");
	        }
	        else
	        {
	        	System.out.println(phoneNo+" Number is not verified==FAIL");
	        }
	}
	@Test(groups= {"SmokeTest"})
	public void createOrgWithIndustryAndAccountType() throws Throwable, IOException
	{
		String name=elib.getDataFromExcel("Sheet3",1, 2)+jlib.getRandomNumber();
		String industry=elib.getDataFromExcel("Sheet3",4, 3);
		String type=elib.getDataFromExcel("Sheet3",4, 4);
		String phoneNo=elib.getDataFromExcel("Sheet3",7, 3);
		HomePage hp=new HomePage(driver);
        
        hp.getOrganizationLnk().click();
        
        OrganizationPage op=new OrganizationPage(driver);
        op.getCreateOrganizationBtn().click();
        
        CreatingNewOrgPage cop=new CreatingNewOrgPage(driver);
        cop.createOrgWithPhNoIndustryType(name, phoneNo, industry, type);
        
        String actIn=driver.findElement(By.id("dtlview_Industry")).getText();
        if(actIn.contains(industry))
        {
        	System.out.println(industry+" Information is verified==PASS");
        }
        else
        {
        	System.out.println(industry+" Information is not verified==FAIL");
        }
        
        String actType=driver.findElement(By.id("dtlview_Type")).getText();
        if(actType.contains(type))
        {
        	System.out.println(type+" Information is verified==PASS");
        }
        else
        {
        	System.out.println(type+" Information is not verified==FAIL");
        }
	}
	

}
