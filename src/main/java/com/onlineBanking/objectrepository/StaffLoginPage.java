package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineBanking.genericutilities.FileUtility;

public class StaffLoginPage
{
	@FindBy(name = "staff_id")
	private WebElement staffid;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "staff_login-btn")
	private WebElement StaffLoginButton;
	
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void setStaffid(FileUtility fLib,  String StaffId,String Password1) throws Throwable
	{
		staffid.sendKeys(StaffId);
		password.sendKeys(Password1);
		StaffLoginButton.click();
	}
}
