package com.Eventum.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Eventum.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;


public class configTest extends TestBase {
	
	@BeforeSuite()
	public void setExtent() {

		extent = new ExtentReports("AutoReport/index.html", true);
		extent.addSystemInfo("Framework", "Page Object");
		extent.addSystemInfo("Author", "Eventum");
		extent.addSystemInfo("Enviroment", "Mac PC");
		extent.addSystemInfo("Test", "Test Name");

	}

	@AfterSuite()
	public void endReport() {

		extent.flush();

	}
	
	

}
