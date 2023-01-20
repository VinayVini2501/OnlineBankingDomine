package com.onlineBanking.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineBanking.genericutilities.ExcelUtility;
import com.onlineBanking.genericutilities.WebDriverUtility;
public class ApplayDebitCardPage
{
	@FindBy(name="holder_name")
	private WebElement AccountHolderName;
	
	@FindBy(name="dob")
	private WebElement dob;
	
	@FindBy(name="pan")
	private WebElement pan;
	
	@FindBy(name="mob")
	private WebElement mob;
	
	@FindBy(name="acc_no")
	private WebElement AccNo;
	
	@FindBy(name="dbt_crd_submit")
	private WebElement debitcardbutton;
	
	public ApplayDebitCardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setApplaydebitcard(WebDriverUtility wLib,ExcelUtility eLib, WebDriver driver) throws Throwable
	{
		AccountHolderName.sendKeys(eLib.getDataFromExcel("Psheet", 0, 1));
		dob.click();
		dob.sendKeys("25-01-1995");
		pan.sendKeys(eLib.getDataFromExcel("Psheet", 4, 1));
		mob.sendKeys(eLib.getDataFromExcel("Psheet", 12, 1));
		AccNo.sendKeys(eLib.getDataFromExcel("Psheet", 11, 1));
		debitcardbutton.click();
		String dbno= wLib.getTextAlert(driver);
		System.out.println(dbno);

		char dbch[]=dbno.toCharArray();
		String dbtno=" ";
		String pinno=" ";
		int count1 =0;

		for(int i=0; i<dbch.length; i++)
		{
			if(dbch[i]>='0' && dbch[i]<='9')
			{
				if(count1 <12)
				{
					dbtno=dbtno+dbch[i];
					count1++;
				}
				else
				{
					pinno=pinno+dbch[i];
				}	  
			}
		}
		System.out.println(dbtno);
		System.out.println(pinno);
		wLib.acceptAlert(driver);

		//Write the debitcard number and pin number in Excel CreateAccount Sheet
		eLib.WriteDataExcel("Psheet", 14, 1, dbtno);
		eLib.WriteDataExcel("Psheet", 15, 1, pinno);
		
	}

}
