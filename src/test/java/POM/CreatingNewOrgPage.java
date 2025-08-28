package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrgPage {
	WebDriver driver;
	public CreatingNewOrgPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	@FindBy(id="phone")
	private WebElement phoneNumTxt;
	@FindBy(name="industry")
	private WebElement industryTxt;
	@FindBy(name="accounttype")
	private WebElement typeTxt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(name="search_text")
	private WebElement searchEdt;
	@FindBy(name="search_field")
	private WebElement searchDD;
	@FindBy(name="submit")
	private WebElement searchBtn;
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getSearchDD() {
		return searchDD;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getPhoneNumTxt() {
		return phoneNumTxt;
	}
	public WebElement getIndustryTxt() {
		return industryTxt;
	}
	public WebElement getTypeTxt() {
		return typeTxt;
	}
	public void createOrgWithPhNo(String name,String phoneNo)
	{
		orgNameEdt.sendKeys(name);
		phoneNumTxt.sendKeys(phoneNo);
		saveBtn.click();
	}
	
	public void createOrg(String name)
	{
		orgNameEdt.sendKeys(name);
		saveBtn.click();
		
	}
	public void createOrgWithPhNoIndustryType(String name,String phoneNo,String industry,String type)
	{
		orgNameEdt.sendKeys(name);
		phoneNumTxt.sendKeys(phoneNo);
		industryTxt.sendKeys(industry);
		typeTxt.sendKeys(type);
		saveBtn.click();
	}
	
	
}
