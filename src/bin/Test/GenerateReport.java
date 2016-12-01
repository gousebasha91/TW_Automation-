package bin.Test;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import bin.Utility.Utility;

public class GenerateReport implements ITestListener{
 
@Override
public void onTestStart(ITestResult result) {
	System.out.println("+Begin test: " + result.getName());
	Reporter.log("+Begin test: " + result.getName());
	
}

@Override
public void onTestSuccess(ITestResult result) {
	
	System.out.println("+Test Passed: " + result.getName());
	Reporter.log("++Test Passed: " + result.getName());
	
}

@Override
public void onTestFailure(ITestResult result) {
	
	System.out.println("+Test Failed: " + result.getName());
	Reporter.log("++Test Failed: " + result.getName());
	Utility.takescreesnshot(result.getName());
	
}

@Override
public void onTestSkipped(ITestResult result) {
	
	System.out.println("+Test Skipped: " + result.getName());
	Reporter.log("++Test skipped: " + result.getName());
	
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	System.out.println("+Test Failed: " + result.getName());
	Reporter.log("++Test Failed: " + result.getName());
}

@Override
public void onStart(ITestContext context) {
	
	System.out.println("+Test Started: " + context.getName());
	Reporter.log("++Test Started: " + context.getName());
}

@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	System.out.println("+Test Finish: " + context.getName());
	Reporter.log("++Test Finish: " + context.getName());
}
}
