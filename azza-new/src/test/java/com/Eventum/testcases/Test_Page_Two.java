package com.Eventum.testcases;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Eventum.base.TestBase;
import com.Eventum.utils.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class Test_Page_Two extends TestBase {
	public Test_Page_Two() { // constructor
		super();
		
	}
	
	
	@BeforeMethod
	public void start(Method method) throws InterruptedException, Throwable {
		
		//logger = extent.startTest(method.getName());
		initialization(prop.getProperty("local"));
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
}
	
	@Test
	public void Test_Case_1() throws InterruptedException {
		//System.out.println("Hello world!");
		 Actions actions = new Actions(driver);
		
		 actions.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Username']"))).sendKeys("admin").build().perform();
		 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
		 driver.findElement(By.xpath("//button[@class='col-xs-12 btn btn-primary']")).click();
		 WebElement reports=driver.findElement(By.xpath("//a[@href='#report']"));
	     Actions action=new Actions(driver);
	     action.moveToElement(reports).build().perform();
	     driver.findElement(By.linkText("Report Designer")).click();
	     driver.findElement(By.xpath("//span[@class='floatingBtn']")).click();
		 driver.findElement(By.xpath("//div[@class='row']//li[6]")).click();		 
	     driver.findElement(By.id("widgetActions")).click();
		 driver.findElement(By.xpath("//div[@class='dropdown open btn-group']//i[@class='fa fa-database']")).click();
	     driver.findElement(By.xpath("//div[@class='ms-parent input-select srcType-menu']//button[@class='ms-choice']")).click();
	     Thread.sleep(10000);
	List<WebElement> ff =driver.findElements(By.xpath("//div[contains(@class,'ms-parent input-select srcType-menu')]//ul//li"));
	//System.out.println(ff.size());
	     ff.get(2).click();
	     Thread.sleep(10000);

	     driver.findElement(By.xpath("//button[@tooltip='Select Network Element']")).click();
	     driver.findElement(By.xpath("//input[@placeholder='Search in Tree']")).sendKeys("area interface");
	     


	}
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
