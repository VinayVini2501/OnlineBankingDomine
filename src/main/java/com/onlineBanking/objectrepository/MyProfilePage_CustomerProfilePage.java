package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage_CustomerProfilePage 
{
	@FindBy(xpath = "//li[.='My Account']")
	private WebElement MyAccount;
	
	@FindBy(xpath = "//li[.='My Profile']")
	private WebElement MyProfile;
	
	@FindBy(xpath = "//li[.='Change Password']")
	private WebElement ChangePassword;
	
	@FindBy(xpath = "//li[.='Fund Transfer']")
	private WebElement FundTransfer;
	
	@FindBy(xpath = "//li[.='Statement']")
	private WebElement Statement;
	
	@FindBy(xpath = "//input[@name='home']")
	private WebElement Home;
	
	@FindBy(xpath = "//input[@name='logout_btn']")
	private WebElement Logout;
	
	@FindBy(xpath = "//img[@src='img/customers/No_image.jpg']")
	private WebElement immage;
	
	public MyProfilePage_CustomerProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void FundTransfer()
	{
		FundTransfer.click();
	}

}
