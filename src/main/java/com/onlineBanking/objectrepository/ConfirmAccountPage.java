package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineBanking.genericutilities.ExcelUtility;
import com.onlineBanking.genericutilities.WebDriverUtility;
public class ConfirmAccountPage
{
	@FindBy(xpath = "//input[@name='cnfrm-submit']")
	private WebElement confirmbutton;
	
	@FindBy(xpath = "//input[@onclick='history.back()']")
	private WebElement Backbutton;
	
	public ConfirmAccountPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}

	public String setConfirmbutton(WebDriverUtility wLib , ExcelUtility eLib,WebDriver driver) throws Throwable
	{
		confirmbutton.click();	
		
		String text = wLib.getTextAlert(driver);
		System.out.println(text);
		
		char ch[]= text.toCharArray();
		String st="";
		for(int i=0; i<ch.length; i++)
		{
			if(ch[i]>='0' && ch[i]<='9')
			{
				st=st+ch[i];		
			}

		}
		System.out.println(st);
		String str=new String(st);
		
		wLib.acceptAlert(driver);

		eLib.WriteDataExcel("Psheet", 10, 1, st);
		return str;
	}
}


	


	 
	


