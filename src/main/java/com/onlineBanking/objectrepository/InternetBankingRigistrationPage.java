package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineBanking.genericutilities.ExcelUtility;
import com.onlineBanking.genericutilities.WebDriverUtility;
public class InternetBankingRigistrationPage 
{
	@FindBy(name="holder_name")
	private WebElement Accountholdername;
	
	@FindBy(name="accnum")
	private WebElement AccountNumber;
	
	@FindBy(name="dbtcard")
	private WebElement DebitCardNumber;
	
	@FindBy(name="dbtpin")
	private WebElement DebitCardPin;
	
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement MobileNumber;
	
	@FindBy(name="pan_no")
	private WebElement PanNumber;
	
	@FindBy(name="dob")
	private WebElement DateOfBirth;
	
	@FindBy(name="last_trans")
	private WebElement LastTransaction;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement Password;
	
	@FindBy(xpath = "//input[@name='cnfrm_password']")
	private WebElement ConfirmPassword;
	
	@FindBy(name ="submit")
	private WebElement SubmitButton;
	
	public InternetBankingRigistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setInternetbankingRigistration(WebDriverUtility wLib,ExcelUtility eLib, WebDriver driver) throws Throwable
	{
		Accountholdername.sendKeys(eLib.getDataFromExcel("Psheet", 0, 1));
		AccountNumber.sendKeys(eLib.getDataFromExcel("Psheet", 11, 1));
		DebitCardNumber.sendKeys(eLib.getDataFromExcel("Psheet", 14, 1));
		DebitCardPin.sendKeys(eLib.getDataFromExcel("Psheet", 15, 1));
		MobileNumber.sendKeys(eLib.getDataFromExcel("Psheet", 12, 1));
		PanNumber.sendKeys(eLib.getDataFromExcel("Psheet", 4, 1));
		DateOfBirth.click();
		DateOfBirth.sendKeys("25-01-1995");
		LastTransaction.sendKeys(eLib.getDataFromExcel("Psheet", 13, 1));
		Password.sendKeys(eLib.getDataFromExcel("Psheet", 16, 1));
		ConfirmPassword.sendKeys(eLib.getDataFromExcel("Psheet", 17, 1));
		SubmitButton.click();
		
		String CustID = wLib.getTextAlert(driver);
		System.out.println(CustID);
		
		char ch4[]= CustID.toCharArray();
		char ch7[]= new char[7];
		 int j=0;
		for(int i=0; i<ch4.length; i++)
		{
			if(ch4[i]>='0' && ch4[i]<='9')
			{
				ch7[j]=(ch4[i]);
				j++;		
			}

		}
		String str5= new String(ch7);
		System.out.println(str5);
		wLib.acceptAlert(driver);

		eLib.WriteDataExcel("Psheet", 18, 1, str5);
	}
}
