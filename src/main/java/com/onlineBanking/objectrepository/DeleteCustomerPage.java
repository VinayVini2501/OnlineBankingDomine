package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineBanking.genericutilities.ExcelUtility;
import com.onlineBanking.genericutilities.WebDriverUtility;

public class DeleteCustomerPage 
{
	@FindBy(name="Cust_ac_no")
	private WebElement CustomerAccountNumber;
	
	@FindBy(name="Cust_ac_Id")
	private WebElement CustomerID;
	
	@FindBy(name="reason")
	private WebElement Reason;
	
	@FindBy(xpath = "//input[@name='delete']")
	private WebElement DeleteButton;
	
	public DeleteCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setDeleteCustomerPage(ExcelUtility eLib, WebDriver driver, WebDriverUtility wLib) throws Throwable
	{
		CustomerAccountNumber.sendKeys(eLib.getDataFromExcel("Psheet", 25, 1));
		CustomerID.sendKeys(eLib.getDataFromExcel("Psheet", 26, 1));
		Reason.sendKeys(eLib.getDataFromExcel("Psheet", 27, 1));
		DeleteButton.click();
		//wLib.acceptAlert(driver);
	}
}
