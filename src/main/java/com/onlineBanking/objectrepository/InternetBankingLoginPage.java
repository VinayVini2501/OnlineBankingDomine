package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineBanking.genericutilities.ExcelUtility;

public class InternetBankingLoginPage
{
	@FindBy(name = "customer_id")
	private WebElement CustomerID;
	
	@FindBy(xpath = "//input[@class='password']")
	private WebElement Password;
	
	@FindBy(xpath = "//input[@class='login-btn']")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//label[.='FORGET PASSWORD ?']")
	private WebElement FORGET_PASSWORD;
	
	public InternetBankingLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setInternetLoginBankig(ExcelUtility eLib, WebDriver driver) throws Throwable
	{
		CustomerID.sendKeys(eLib.getDataFromExcel("Psheet", 18, 1));
		Password.sendKeys(eLib.getDataFromExcel("Psheet", 16, 1));
		LoginButton.click();
	}
}
