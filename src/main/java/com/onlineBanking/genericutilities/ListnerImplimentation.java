package com.onlineBanking.genericutilities;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplimentation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result)
	{
		// Execution Starts from here
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"-----> Test Script Execution Is Started");
	}

	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"----->Passed");
		Reporter.log(MethodName+"----->TestScript Execution Successful");
	}

	public void onTestFailure(ITestResult result)
	{
		String Failedscript = result.getMethod().getMethodName();

		String FS =Failedscript +new JavaUtility().getSystemDateAndTimeInFormet();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+FS+".png");
		String filepath =dest.getAbsolutePath();
		try
		{
			FileUtils.copyFile(src, dest);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filepath);
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("--Test Script Execution is Failed");
	}
	
	public void onTestSkipped(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"----->Skipped");
		Reporter.log(MethodName+"----->TestScript Execution is Skipped");
	}
	
	public void onStart(ITestContext context)
	{
		//Configure the Report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Online Banking");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-URL", "https://localhost:8888");
		report.setSystemInfo("Reporter Name", "Vinay");
		

	}

	public void onFinish(ITestContext context)
	{
		// Consolidated the report
		report.flush();

	}






}



