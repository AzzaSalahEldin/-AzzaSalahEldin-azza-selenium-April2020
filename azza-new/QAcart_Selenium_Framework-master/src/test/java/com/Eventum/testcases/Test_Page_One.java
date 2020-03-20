package com.Eventum.testcases;


import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.Eventum.base.TestBase;
import com.Eventum.utils.TestUtil;
import com.relevantcodes.extentreports.LogStatus;


public class Test_Page_One extends TestBase {
	
	
	public Test_Page_One() { // constructor
		super();
	}
	public static void main(String [] args)
	{
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { TestNG.class });
		testSuite.addListener(new Object());
		testSuite.setDefaultSuiteName("My Test Suite");
		testSuite.setDefaultTestName("My Test");
		testSuite.setOutputDirectory("/Users/pankaj/temp/testng-output");
		testSuite.run();
	}
	@Test
	@BeforeMethod
	public void start(Method method) throws InterruptedException, Throwable {
		
		//logger = extent.startTest(method.getName());
		initialization(prop.getProperty("local"));
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
}
	
	
	@Test
	public void Test_Case_1() throws InterruptedException {
		//System.out.println("Hello world!");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@class='col-xs-12 btn btn-primary']")).click();
		 WebElement reports=driver.findElement(By.xpath("//a[@href='#report']"));
	     Actions action=new Actions(driver);
	     action.moveToElement(reports).build().perform();
	     driver.findElement(By.linkText("Report Designer")).click();
	     driver.findElement(By.xpath("//button[@tooltip='Add Report']")).click();
	     
	     WebElement text =driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[2]/div/div/div/div[2]/input"));
	     text.click();
	     text.clear();
	     text.sendKeys("test-automationtryryyyyyyyyyyyyyyyyyyyyy");
	     Thread.sleep(1000); 
	    // driver.findElement( By.cssSelector("input.cancelForm-btn btn btn-danger")).click();
	     //List<WebElement> submit  =driver.findElements(By.xpath("//button[@type='button']"));
	    // System.out.println(submit.size());
	     //submit.get(2).click();
	    // WebElement mainElement = submit.get(2);
	    // mainElement.click();
	     driver.findElement(By.xpath("//button[contains(@class , 'submitForm-btn')]")).click();
	     
	     
	     
	   //  driver.findElement(By.xpath("//span[@class='floatingBtn']")).click();
	    // driver.findElement(By.xpath("//div[@class='row']//li[6]")).click();		 
      //driver.findElement(By.id("widgetActions")).click();
		// driver.findElement(By.xpath("//div[@class='dropdown open btn-group']//i[@class='fa fa-database']")).click();
	     
	     
	}
	
	
	
	@Test
	@AfterMethod
	public void tearDown(ITestResult result) throws Throwable {
		
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL, "Test Failed " + result.getThrowable());
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(picturePath));
			

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case Skipped is " + result.getName());

		} else {
			logger.log(LogStatus.PASS, "Test passed");
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(picturePath));
			
		}

		extent.endTest(logger);
		//driver.quit();
	}
	
	
	

}
