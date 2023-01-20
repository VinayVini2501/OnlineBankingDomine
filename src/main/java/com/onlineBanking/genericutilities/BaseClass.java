package com.onlineBanking.genericutilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
public class BaseClass
{
	static
	{
		 // System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		// System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
	}
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib= new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public DatabaseUtility dLib=new DatabaseUtility();
	@BeforeSuite
	public void connectDB() throws Throwable
	{
		//dLib.connectToDB();
		System.out.println("--CONNECT TO DB----");
	}
	@Parameters("Browser")
	@BeforeClass(groups = {"Smoke", "Regression"})
	
	public void ConnectBCi() throws Throwable
	{
		String Browser = fLib.readDataFromPropertyFile("browser");
		if(Browser.equalsIgnoreCase("edge"))
		{
			driver = new  EdgeDriver();
		}
		else if (Browser.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
			System.out.println("---Launch the Browser----");
		}
		else if (Browser.equalsIgnoreCase("FireFox"))
		{
			driver= new FirefoxDriver();
			System.out.println("---Launch the Browser----");
		}
		else
		{
			System.out.println("Invalid browser");
		}
		sdriver=driver;
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		String URL = fLib.readDataFromPropertyFile("url");
		System.out.println(URL);
		driver.get(URL);
	}
	@BeforeMethod
	public void connectBM()
	{
		System.out.println("----Login to Application");
	}
	@AfterMethod
	public void connectAM()
	{
		System.out.println("---Logout from Application");
	}
	@AfterClass
	public void connectAC()
	{
		driver.quit();
	}
	@AfterSuite
	public void disconnectDB() throws Throwable
	{
		//dLib.closeDB();
		System.out.println("--Close DB Connection");
	}
}
