package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineBanking.genericutilities.ExcelUtility;
import com.onlineBanking.genericutilities.WebDriverUtility;

public class CreditCustomerPage
{
	@FindBy(xpath = "//input[@name='customer_account_no']")
	private WebElement CustomerAccno;

	@FindBy(xpath = "//input[@name='credit_amount']")
	private WebElement CreditAmount;

	@FindBy(xpath = "//input[@name='credit_btn']")
	private WebElement Creditbutton;

	@FindBy(name = "home")
	private WebElement home;

	public CreditCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void CreditCustomerPage1(WebDriverUtility wLib,ExcelUtility eLib,WebDriver driver) throws Throwable
	{
		CustomerAccno.sendKeys(eLib.getDataFromExcel("Psheet", 11, 1));
		CreditAmount.sendKeys(eLib.getDataFromExcel("Psheet", 13, 1));
		Creditbutton.click();
		wLib.acceptAlert(driver);
		home.click();
	}
}
