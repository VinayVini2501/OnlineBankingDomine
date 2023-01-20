package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage
{
	@FindBy(xpath = "//input[@name='viewdet']")
	private WebElement View_Active_Customer;
	
	@FindBy(xpath = "//input[@name='view_cust_by_ac']")
	private WebElement View_Customer_By_Acno;
	
	@FindBy(xpath = "//input[@name='apprvac']")
	private WebElement Approve_Pending_Account;
	
	@FindBy(xpath = "//input[@name='del_cust']")
	private WebElement Delete_Customer_Accno;
	
	@FindBy(xpath = "//input[@name='credit_cust_ac']")
	private WebElement Credit_Customer;
	
	@FindBy(name="home")
	private WebElement StaffHome;
	
	@FindBy(name="logout_btn")
	private WebElement Staff_Logout;
	
	@FindBy(xpath = "//img[@src='img/customers/No_image.jpg']")
	private WebElement Staff_Image;
	
	public StaffHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ApprovePendingAccount()
	{
		Approve_Pending_Account.click();
	}
	
	public void ViewActiveCustomer1()
	{
		View_Active_Customer.click();
	}
	
	public void Home()
	{
		StaffHome.click();
	}
	
	public void ViewCustomerByAccountNumber()
	{
		View_Customer_By_Acno.click();
	}
	
	public void CreditCustomer()
	{
		Credit_Customer.click();
	}
	
	public void DeleteCustomer()
	{
		Delete_Customer_Accno.click();
	}
}
