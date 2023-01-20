package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineBanking.genericutilities.ExcelUtility;
import com.onlineBanking.genericutilities.WebDriverUtility;
public class AddBenificiaryPage
{
	@FindBy(xpath = "//input[@name='beneficiary_name']")
	private WebElement BenificiaryName;
	
	@FindBy(xpath = "//input[@name='beneficiary_acno']")
	private WebElement BenificiaryAccountNumber;
	
	@FindBy(xpath = "//input[@name='Ifsc_code']")
	private WebElement IfscCode;
	
	@FindBy(xpath = "//select[@name='beneficiary_acc_type']")
	private WebElement AccountType;
	
	@FindBy(xpath = "//input[@name='add_beneficiary_btn']")
	private WebElement AddButton;
	
	public AddBenificiaryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void setAddBenificiaryPage(ExcelUtility eLib, WebDriver driver, WebDriverUtility wLib) throws Throwable
	{
		BenificiaryName.sendKeys(eLib.getDataFromExcel("Psheet", 20, 1));
		BenificiaryAccountNumber.sendKeys(eLib.getDataFromExcel("Psheet", 21, 1));
		IfscCode.sendKeys(eLib.getDataFromExcel("Psheet", 22, 1));
		wLib.select(AccountType,"Saving");
		AddButton.click();
		String text = wLib.getTextAlert(driver);
		System.out.println(text);
		wLib.acceptAlert(driver);
	}

}
