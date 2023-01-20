package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.onlineBanking.genericutilities.ExcelUtility;
import com.onlineBanking.genericutilities.WebDriverUtility;

public class Pending_Customerpage 
{
	@FindBy(name = "application_no")
	private WebElement ApplicationNumber;
	
	@FindBy(name = "search_application")
	private WebElement SearchApplication;
	
	@FindBy(name = "approve_cust")
	private WebElement ApproveCust;
	
	@FindBy(name="home")
	private WebElement StaffHome;
	
	public Pending_Customerpage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void PendingCustomerPage(WebDriver driver,ExcelUtility eLib, WebDriverUtility wLib) throws Throwable
	{
		ApplicationNumber.sendKeys(eLib.getDataFromExcel("Psheet", 10, 1));
		SearchApplication.click();
		ApproveCust.click();
		
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
		String text1 =wLib.getTextAlert(driver);
		System.out.println(text1);

		char ch3[]= text1.toCharArray();
		char ch2[]= new char[13];
		int j = 0;
		for(int i=0; i<ch3.length; i++)
		{
			if(ch3[i]>='0' && ch3[i]<='9')
			{
				ch2[j]=(ch3[i]);
				j++;		
			}
		}
		String str1= new String(ch2);
		System.out.println(str1);
		wLib.acceptAlert(driver);

		eLib.WriteDataExcel("Psheet", 11, 1, str1);
		StaffHome.click();
	}
}
