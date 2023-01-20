package com.onlineBanking.objectrepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.onlineBanking.genericutilities.WebDriverUtility;

public class FundTransferPage
{
	@FindBy(xpath = "//input[@name='add_beneficiary']")
	private WebElement AddBeneficiary;

	@FindBy(xpath = "//input[@name='delete_beneficiary']")
	private WebElement DeleteBeneficiary;

	@FindBy(xpath = "//input[@name='view_beneficiary']")
	private WebElement ViewBenificiary;

	@FindBy(xpath = "//select[@name='beneficiary']")
	private WebElement SelectBenificiary;

	@FindBy(xpath = "//input[@name='trnsf_amount']")
	private WebElement TransferAmount;

	@FindBy(xpath = "//input[@name='trnsf_remark']")
	private WebElement TransferAmountRemark;

	@FindBy(xpath = "//input[@name='fnd_trns_btn']")
	private WebElement SendButton;

	public FundTransferPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void AddBeneficiary()
	{
		AddBeneficiary.click();
	}
	public void setSelectBenificiary(WebDriverUtility wLib, WebDriver driver)
	{
		wLib.select(SelectBenificiary, 1);
		TransferAmount.sendKeys("2000");
		TransferAmountRemark.sendKeys("Sent Amount");
		SendButton.click();

		String otp = driver.findElement(By.xpath("//label[@class='OTP_msg']")).getText();
		System.out.println(otp);

		char chh[]=otp.toCharArray();
		String st12=" ";

		int count4=0;
		for(int i= chh.length-1;i>=0; i--)
		{
			if(chh[i]>='0' && chh[i]<='9')
			{
				if(count4<6)
				{
					st12=st12+chh[i];
					count4++;
				}
				else
				{

				}
			}
		}
		System.out.println(st12);
		StringBuilder st13 = new StringBuilder(st12);
		st13.reverse();
		System.out.println(st13);

		driver.findElement(By.name("otpcode")).sendKeys(st13);
		driver.findElement(By.name("verify-btn")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		String text6 =  wLib.getTextAlert(driver);
		System.out.println(text6);
		wLib.acceptAlert(driver);
	}
}
