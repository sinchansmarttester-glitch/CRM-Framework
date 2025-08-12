package TestNG;



import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import POM.ContactPage;
import POM.CreateNewContactPage;
import POM.CreatingNewOrgPage;
import POM.HomePage;
import POM.OrganizationInfoPageVerify;
import POM.OrganizationPage;

public class CreateContactWithOrganizationTest extends BaseClass{
	
	
	@Test
	public void createContactTest() throws Throwable, Throwable {
	String lastName=elib.getDataFromExcel("Sheet3",7, 4);
	HomePage hp=new HomePage(driver);
	hp.getContactsLnk().click();
	ContactPage cp=new ContactPage(driver);
	cp.getCreateContactLink().click();
	CreateNewContactPage cnp=new CreateNewContactPage(driver);
	cnp.createContact(lastName);
	String actLastName=driver.findElement(By.id("mouseArea_Last Name")).getText();
    if(actLastName.contains(lastName))
    {
    	System.out.println(lastName+" LastName is verified==PASS");
    }
    else
    {
    	System.out.println(lastName+" LastName is not verified==FAIL");
    }
	
	}
	@Test
	public void createContactWithSupportDate() throws Throwable, IOException
	{
		String lastName=elib.getDataFromExcel("Sheet3",7, 4)+jlib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.getContactsLnk().click();
		ContactPage cp=new ContactPage(driver);
		cp.getCreateContactLink().click();
		String startDate=jlib.getSystemDateYYYYDDMM();
        String endDate=jlib.getRequiredDateYYYYDDMM(30);
    	CreateNewContactPage cnp=new CreateNewContactPage(driver);
        cnp.ccWithSupportDate(lastName, startDate, endDate);
        
        String actStartDate=driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
        if(actStartDate.equals(startDate))
        {
        	System.out.println(startDate+" Date is verified==PASS");
        }
        else
        {
        	System.out.println(startDate+" Date is not verified==FAIL");
        }
        String actEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
        if(actEndDate.equals(endDate))
        {
        	System.out.println(endDate+" Date is verified==PASS");
        }
        else
        {
        	System.out.println(endDate+" Date is not verified==FAIL");
        }

		
	}
	@Test

	public void createContactWithOrg() throws IOException, InterruptedException {
		

				String name=elib.getDataFromExcel("Sheet3",1, 2)+jlib.getRandomNumber();
//		        String industry=elib.getDataFromExcel("Sheet3",4,3);
//		        String type=elib.getDataFromExcel("Sheet3",4, 4);
//		        String phoneNo=elib.getDataFromExcel("Sheet3",7,3);
		        String lastName=elib.getDataFromExcel("Sheet3",7, 4);
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
		        
		        hp.getContactsLnk().click();
		        ContactPage cp=new ContactPage(driver);
		        cp.getCreateContactLink().click();
		        CreateNewContactPage cnc=new CreateNewContactPage(driver);
		        cnc.createContact(lastName);
	        
	        
//	        WebElement ele1=driver.findElement(By.name("industry"));
//	        Select sel1=new Select(ele1);
//	        sel1.selectByVisibleText(industry);
//	        
//	        WebElement ele2=driver.findElement(By.name("accounttype"));
//	        Select sel2=new Select(ele2);
//	        sel2.selectByVisibleText(type);
//	        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//	        Thread.sleep(3000);
//	        //Date and LastName
//	        driver.findElement(By.linkText("Contacts")).click();
//	        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//	        Thread.sleep(2000);
//            
//	        
//	       
//	        driver.findElement(By.name("lastname")).sendKeys(lastName);
//	        String startDate=jlib.getSystemDateYYYYDDMM();
//	        String endDate=jlib.getRequiredDateYYYYDDMM(30);
//	        driver.findElement(By.name("support_start_date")).clear();
//	        driver.findElement(By.name("support_start_date")).sendKeys(startDate);
//	        driver.findElement(By.name("support_end_date")).clear();
//	        driver.findElement(By.name("support_end_date")).sendKeys(endDate);
//	        driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
//	        //Child Window
//	        wlib.switchToTabOnUrl(driver, "module=Accounts");
//	        driver.findElement(By.name("search_text")).sendKeys(name);
//	        driver.findElement(By.name("search")).click();
//             Thread.sleep(2000);
//	        driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
//	        
//	        parent
//	        wlib.switchToTabOnUrl(driver, "module=Contacts");
//
//	        
	        String actLastName=driver.findElement(By.id("mouseArea_Last Name")).getText();
	        if(actLastName.contains(lastName))
	        {
	        	System.out.println(lastName+" LastName is verified==PASS");
	        }
	        else
	        {
	        	System.out.println(lastName+" LastName is not verified==FAIL");
	        }
	        
}

}
