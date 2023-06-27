package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
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

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/loginData.xlsx";
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getColumnCount(path, "Sheet1");
		String[][] logindata = new String[rowCount][colCount];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				XLUtils.getCellData(path, "sheet1", i, j);
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
