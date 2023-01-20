package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineBanking.genericutilities.ExcelUtility;

public class CustomerDetailsPage 
{
	@FindBy(name = "account_no")
	private WebElement accno;
	
	@FindBy(name = "submit_view")
	private WebElement Submit;
	
	@FindBy(xpath = "//input[@value='Home']")
	private WebElement home;
	
	public CustomerDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void CustomerDetails( WebDriver driver,ExcelUtility eLib) throws Throwable
	{
		Thread.sleep(2000);
		accno.sendKeys(eLib.getDataFromExcel("Psheet", 11, 1));
		Submit.click();
		home.click();
	}
}
