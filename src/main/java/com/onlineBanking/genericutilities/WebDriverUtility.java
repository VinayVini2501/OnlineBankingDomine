package com.onlineBanking.genericutilities;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility
{
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void elementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void select( WebElement element, String value)
	{
		Select sal = new Select(element);
		sal.selectByValue(value);
	}

	public void select( WebElement element, int index)
	{
		Select sal = new Select(element);
		sal.selectByIndex(index);
	}

	public void select(String visibleText, WebElement element)
	{
		Select sal = new Select(element);
		sal.selectByVisibleText(visibleText);
	}

	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}

	public void DoubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void enterKeyPress(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}


	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);	
	}

	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);	
	}

	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);	
	}

	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}

	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}

	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();	
	}
	
	public String getTextAlert(WebDriver driver)
	{
		String text=driver.switchTo().alert().getText();
	     return text;
	}

	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		//step 1: use getWindowHandals to captur all window id's
		Set<String> Windows = driver.getWindowHandles();

		//step 2: iterate through the windows
		Iterator<String> it = Windows.iterator();

		// step 3: check whether  there is next window
		while(it.hasNext())
		{
			// step 4: capture current window id
			String windId = it.next();

			//step 5: Switch to current window and capture title
			String CurrentWindTitle = driver.switchTo().window(windId).getTitle();

			// step 6:check whether current window is expected
			if(CurrentWindTitle.contains(partialTitle))
			{
				break;
			}
		}	
	}

	public static String getScreenShot(WebDriver driver, String screeShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screeShotName+".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("Window.scrollBy(0,800)"," ");
	
	}
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")");
		
		
	}



}
