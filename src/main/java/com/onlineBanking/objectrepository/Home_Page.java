package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineBanking.genericutilities.WebDriverUtility;

public class Home_Page 
{
		@FindBy(xpath = "//li[.='Open Account']")
		private WebElement OpenAccount;
		
		@FindBy(xpath = "//li[.='Apply Debit Card']")
		private WebElement ApplayDebitCard;
		
		@FindBy(xpath = "//li[.='Fund Transfer']")
		private WebElement FundTranfer;
		
		@FindBy(xpath = "//div[@class='ebanking']")
		private WebElement InternetBanking;
		
		@FindBy(xpath = "//li[.='Register']")
		private WebElement Rigister;
		
		@FindBy(xpath = "//li[.='Login ']")
		private WebElement Login;
		
		@FindBy(xpath = "//a[@href='index.php']")
		private WebElement Homepage;
		
		@FindBy(xpath = "//a[@href='staff_login.php']")
		private WebElement StaffLogin;
		
		public Home_Page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void setOpenAccount() {
			OpenAccount.click();
		}

		public void setApplayDebitCard() {
			ApplayDebitCard.click();
		}

		public void setFundTranfer() {
			FundTranfer.click();
		}

		public void setInternetBanking(WebDriverUtility wLib, WebDriver driver)
		{
			wLib.mousehover(driver, InternetBanking);
			Rigister.click();
		}

		public void setRigister(WebElement rigister)
		{
			Rigister = rigister;
		}

		public void setLogin(WebDriverUtility wLib, WebDriver driver)
		{
			wLib.mousehover(driver, InternetBanking);
			Login.click();
		}

		public void setHomepage()
		{
			Homepage.click();
		}

		public void setStaffLogin()
		{
			StaffLogin.click();
		}
}
