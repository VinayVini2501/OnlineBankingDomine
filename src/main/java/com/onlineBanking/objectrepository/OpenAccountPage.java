package com.onlineBanking.objectrepository;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineBanking.genericutilities.ExcelUtility;
import com.onlineBanking.genericutilities.JavaUtility;
import com.onlineBanking.genericutilities.WebDriverUtility;
public class OpenAccountPage 
{
	JavaUtility jLib= new JavaUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib=new WebDriverUtility();

	@FindBy(name="name")
	private WebElement nameText;
	
	@FindBy(xpath = "//select[@name='gender']")
	private WebElement genderselectbox;
	
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobile;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='landline']")
	private WebElement landline;
	
	@FindBy(xpath = "//input[@name='dob']")
	private WebElement dob;
	
	@FindBy(xpath = "//input[@name='pan_no']")
	private WebElement 	Panno;
	
	@FindBy(xpath = "//input[@name='citizenship']")
	private WebElement citizen;
	
	@FindBy(xpath = "//input[@name='homeaddrs']")
	private WebElement homeaddress;
	
	@FindBy(xpath = "//input[@name='officeaddrs']")
	private WebElement Officeaddress;
	
	@FindBy(xpath = "//select[@name='state']")
	private WebElement stateselectbox;
	
	@FindBy(xpath = "//select[@name='city']")
	private WebElement cityselectbox;
	
	@FindBy(xpath = "//input[@name='pin']")
	private WebElement pin;
	
	@FindBy(xpath = "//input[@name='arealoc']")
	private WebElement area;
	
	@FindBy(xpath = "//select[@name='acctype']")
	private WebElement acctypeselectbox;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement sumitbtn;
	
	public OpenAccountPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setopenaccontpage(WebDriverUtility wLib) throws Throwable
	{
		nameText.sendKeys(eLib.getDataFromExcel("Psheet", 0, 1));
		
		wLib.select(eLib.getDataFromExcel("Sheet2", 0, 1), genderselectbox);
		Random ra=new Random();
		int random=100+ra.nextInt(899);
		String phno=eLib.getDataFromExcel("Psheet", 1, 1)+random;
		eLib.WriteDataExcel("Psheet", 12, 1, phno);
		mobile.sendKeys(phno);
		email.sendKeys(eLib.getDataFromExcel("Psheet", 2, 1));
		landline.sendKeys(eLib.getDataFromExcel("Psheet", 3, 1));
		dob.click();
		dob.sendKeys("25-01-1995");
		Panno.sendKeys(eLib.getDataFromExcel("Psheet", 4, 1));
		citizen.sendKeys(eLib.getDataFromExcel("Psheet", 5, 1));
		homeaddress.sendKeys(eLib.getDataFromExcel("Psheet", 6, 1));
		Officeaddress.sendKeys(eLib.getDataFromExcel("Psheet", 7, 1));
		wLib.select(eLib.getDataFromExcel("Sheet2", 1, 1), stateselectbox);
		wLib.select(eLib.getDataFromExcel("Sheet2", 2, 1), cityselectbox);
		pin.sendKeys(eLib.getDataFromExcel("Psheet", 8, 1));
		area.sendKeys(eLib.getDataFromExcel("Psheet", 9, 1));
		wLib.select(eLib.getDataFromExcel("Sheet2", 3, 1), acctypeselectbox);
		sumitbtn.click();
	}
}
