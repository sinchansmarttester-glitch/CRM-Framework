package CreateGenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
//Implicitly wait
public void waitForPageToLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
//Explicit Wait
public void waitForElementPresent(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
//switch to child
public void switchToTabOnUrl(WebDriver driver,String partialUrl)
{
	Set<String> set=driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext())
	{
		String windowId=it.next();
		driver.switchTo().window(windowId);
		String actUrl = driver.getCurrentUrl();
		if(actUrl.contains(partialUrl))
		{
			break;
		}
	}
}
//switch to parent
public void switchToTabOnTitle(WebDriver driver,String partialTitle)
{
	Set<String> set=driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext())
	{
		String windowId=it.next();
		driver.switchTo().window(windowId);
		String actUrl = driver.getTitle();
		if(actUrl.contains(partialTitle))
		{
			break;
		}
	}
}

public void switchToFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}

public void switchToFrame(WebDriver driver,String nameId)
{
	driver.switchTo().frame(nameId);
}

public void switchToFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}

public void switchToAlertAndAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

public void switchToAlertAndCancel(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

public void select(WebElement element,String text)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);;
}

public void select(WebElement element,int index)
{
	Select sel=new Select(element);
	sel.selectByIndex(index);
}

public void mouseMoveOnElement(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.moveToElement(element).perform();
}

public void mouseRightClick(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.contextClick(element).perform();
}

public void mouseDoubleClick(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.doubleClick(element).perform();
}

public void mouseDragandDrop(WebDriver driver,WebElement src,WebElement dest)
{
	Actions a=new Actions(driver);
	a.dragAndDrop(src,dest).perform();
}

public void mouseClickandHold(WebDriver driver,WebElement src)
{
	Actions a=new Actions(driver);
	a.clickAndHold(src).perform();
	a.release().perform();
}

public void takeScreenshot(WebDriver driver,String ssName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File temp=ts.getScreenshotAs(OutputType.FILE);
	File perm=new File("./Screenshot"+ssName+".png");
	FileHandler.copy(temp, perm);
}

public void disableElements(WebDriver driver,WebElement disable) 
{
    JavascriptExecutor jse=(JavascriptExecutor)driver;
    jse.executeScript("arguement[0].click();",disable);
}

public void scrollAction(WebDriver driver,int x,int y)
{
    JavascriptExecutor jse=(JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy("+x+","+y+")");
}

public void scrollIntoView(WebDriver driver,WebElement element)
{
    JavascriptExecutor jse=(JavascriptExecutor)driver;
    jse.executeScript("arguments[0].scrollIntoView(true);", element);
}

public void refreshPage(WebDriver driver) 
{
	driver.navigate().refresh();
}

public void navigateBack(WebDriver driver) {
	driver.navigate().back();
}

public void navigateForward(WebDriver driver) {
	driver.navigate().forward();
}
}