package com.Freelancer.AddPublicationTestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Freelancer.LoginTestCases.BaseClass;
import com.Freelancer.pageObjects.AddEducation;
import com.Freelancer.pageObjects.AddPublication;
import com.Freelancer.pageObjects.AddQualifications;
import com.Freelancer.pageObjects.DashboardPage;
import com.Freelancer.pageObjects.LoginPage;

public class TC_AP_001 extends BaseClass{
	String publication = "Cyber Security";
	String publisher = "Auntor";
	String summary = "This is my first Cyber Security publication.";
	

@Test(priority=1)
public void addPublicationWithValidInfo() throws InterruptedException, IOException {
	loginToFreelancer();
	DashboardPage dp = new DashboardPage(driver);
	dp.clickDashboardProfile();
	Thread.sleep(3000);
	dp.clickViewProfile();
	Thread.sleep(3000);
	AddPublication AP = new AddPublication(driver);
	logger.info("providing Publication Details");
	AP.clickAddPublicationBtn();
	AP.setPublication(publication);
	AP.setPublisher(publisher);
	AP.setSummary(summary);
	AP.clickSaveBtn();
	Thread.sleep(2000);
	logger.info("Validation Start...");
	if(AP.getSavedPublicationTitle().equals(publication)) {
		logger.info("TC_AP_001 Passed");
		Assert.assertTrue(true);
	}else {
		logger.warn("TC_AP_001 Failed");
		captureScreen(driver,"addPublicationWithValidInfo");
		Assert.fail();
	}
	
} 
	
	
	
	
}
