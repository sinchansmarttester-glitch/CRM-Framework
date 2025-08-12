package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LastNameTextBox;
	
	@FindBy(name="support_start_date")
	private WebElement StartDateTextBox;
	
	@FindBy(name="support_end_date")
	private WebElement LastDateTextBox;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;


	public WebElement getLastNameTextBox() {
	return LastNameTextBox;
	}



	public WebElement getStartDateTextBox() {
		return StartDateTextBox;
	}



	public WebElement getLastDateTextBox() {
		return LastDateTextBox;
	}



	public WebElement getSaveButton() {
	return saveButton;
	}


	public void createContact(String lastName)
	{
	LastNameTextBox.sendKeys(lastName);
	saveButton.click();
	}
	public void ccWithSupportDate(String lastName,String startDate,String endDate) {
		LastNameTextBox.sendKeys(lastName);
        StartDateTextBox.clear();
		StartDateTextBox.sendKeys(startDate);
		LastDateTextBox.clear();
		LastDateTextBox.sendKeys(endDate);
		saveButton.click();

	}
}
