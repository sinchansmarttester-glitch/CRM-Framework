package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CreateGenericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
WebDriver driver;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name="user_name")
private WebElement usernameEdt;
@FindBy(name="user_password")
private WebElement passwordEdt;
@FindBy(id="submitButton")
private WebElement loginBtn;


//Object Encapsulation
public WebElement getUsernameEdt() {
	return usernameEdt;
}


public WebElement getPasswordEdt() {
	return passwordEdt;
}

public WebElement getLoginBtn() {
	return loginBtn;
}

//Provide Action
public void loginToApp(String url,String username,String password)
{
	driver.get(url);
	driver.manage().window().maximize();
	usernameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	loginBtn.click();
	waitForPageToLoad(driver);
}

}
