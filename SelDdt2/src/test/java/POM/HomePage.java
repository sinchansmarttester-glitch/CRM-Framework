
package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Calendar")
	private WebElement CalendarLnk;
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	@FindBy(linkText="Leads")
	private WebElement leadsLnk;
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	@FindBy(linkText="Documents")
	private WebElement documentsLnk;
	@FindBy(linkText="Email")
	private WebElement emailLnk;
	@FindBy(linkText="Trouble Tickets")
	private WebElement tTicketsLnk;
	@FindBy(linkText="Dashboard")
	private WebElement dashboardLnk;
	@FindBy(linkText="More")
	private WebElement morelnk;
	@FindBy(linkText="Campaigns")
	private WebElement campaignLnk;
	@FindBy(xpath ="(//img[@src='themes/softed/images/user.PNG'])[1]")
	private WebElement adminImg;
	@FindBy(linkText ="Sign Out")
	private WebElement signOutLnk;
	
	
	public WebElement getMorelnk() {
		return morelnk;
	}
	public WebElement getCampaignLnk() {
		return campaignLnk;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCalendarLnk() {
		return CalendarLnk;
	}
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}
	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	public WebElement getContactsLnk() {
		return contactsLnk;
	}
	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}
	public WebElement getProductsLnk() {
		return productsLnk;
	}
	public WebElement getDocumentsLnk() {
		return documentsLnk;
	}
	public WebElement getEmailLnk() {
		return emailLnk;
	}
	public WebElement gettTicketsLnk() {
		return tTicketsLnk;
	}
	public WebElement getDashboardLnk() {
		return dashboardLnk;
	}
	public WebElement getAdminImg() {
		return adminImg;
	}
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	
     public void navigateToCampaignPage()
     {
    	 Actions act=new Actions(driver);
    	 act.moveToElement(morelnk).perform();
    	 campaignLnk.click();
     }
	public void logout()
	{
		Actions act=new Actions(driver);
   	 act.moveToElement(adminImg).perform();
   	 signOutLnk.click();
	}
	
	
	
}
