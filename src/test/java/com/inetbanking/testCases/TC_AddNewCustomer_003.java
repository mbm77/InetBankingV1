package com.inetbanking.testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException, AWTException {
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		AddCustomerPage custpage = new AddCustomerPage(driver);
		custpage.addNewCustomer();
		//driver.navigate().to("https://demo.guru99.com/v3/manager/addcustomerpage.php");
		
		
		logger.info("providing customer details...");
		
		custpage.custName("mbm");
		
		logger.info("entered username...");
		custpage.custGender("female");
		logger.info("entered gender...");
		//Thread.sleep(4000);
		if(browser == "chrome") {
			custpage.custDOBChrome("07","02","1997");
		}else {
			custpage.custDOB("2018-03-22");
		}
		
		logger.info("entered dob...");
		//Thread.sleep(4000);
		custpage.custaddress("India");
		logger.info("entered address...");
		custpage.custCity("Nellore");
		logger.info("entered city...");
		custpage.custState("AP");
		custpage.custPhoneNo("9848022338");
		logger.info("entered phone...");
		custpage.custPinNo(500080);
		logger.info("entered pincode...");
		String email = randomString()+"@gmail.com";
		custpage.custEmailId(email);
		logger.info("entered email...");
		custpage.custPassword("abc@123");
		logger.info("entered password...");
		custpage.custSubmit();
		
		
		logger.info("validation started.....");
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().dismiss();
			driver.switchTo().defaultContent();
		}
		
		
		
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		Thread.sleep(3000);
		if(res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}else {
			takesScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	

}
