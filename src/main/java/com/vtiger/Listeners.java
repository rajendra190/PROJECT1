package com.vtiger;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener

{

	public void onTestStart(ITestResult result) 
	
	{
		System.out.println("Test eXECUTION sTARTED "+ result.getMethod().getMethodName());
	}
	

	public void onTestSuccess(ITestResult result) 
	
	{
		System.out.println("Test eXECUTION Success "+ result.getMethod().getMethodName());	
	}

	
	public void onTestFailure(ITestResult result) 
	
	{
		TakesScreenshot src = (TakesScreenshot)Base_class.sdriver;
		File source = src.getScreenshotAs(OutputType.FILE);

		String dest= System.getProperty("user.dir")+"/screenshot/"+result.getMethod().getMethodName()+".PNG";
		File destnation = new File(dest);

		try 
		{
			FileUtils.copyFile(source, destnation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) 
	{

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}

	public void onStart(ITestContext context) 
	{

	}

	public void onFinish(ITestContext context) 
	{

	}


}
