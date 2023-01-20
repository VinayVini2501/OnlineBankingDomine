package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class View_Active_CustomerPage
{
	@FindBy(name="home")
	private WebElement StaffHome;
	
	public View_Active_CustomerPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}

	public void Staffhome()
	{
		StaffHome.click();
	}
}
