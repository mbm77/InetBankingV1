package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//ul[@class = 'menusubnav']//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	@CacheLookup
	WebElement txtCustomerName;

//	@FindBy(how = How.NAME, using = "rad1")
//	@CacheLookup
//	WebElement rdGender;
	
	@FindBy(how = How.CSS, using = "[type='radio'][value='m']")
	public WebElement male;

	@FindBy(how = How.CSS, using = "[type='radio'][value='f']")
	public WebElement female;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinNo;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtPhoneNo;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmailId;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;

	public void addNewCustomer() {
		WebElement element = ldriver.findElement(By.xpath("//ul[@class = 'menusubnav']//a[normalize-space()='New Customer']"));
		Actions actions = new Actions(ldriver);
		actions.moveToElement(element).click().perform();
		//lnkAddNewCustomer.click();
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}

	public void custGender(String cgender) {
		if(cgender == "male") {
			male.click();	
		}else {
			female.click();
		}
		
	}
	
	public void custDOBChrome(String mm, String dd, String yy) {
			
			txtdob.sendKeys(mm);
			txtdob.sendKeys(dd);
			txtdob.sendKeys(yy);
		
	}

	public void custDOB(String dob) {
		
			txtdob.click();
			txtdob.sendKeys(dob);
	}
	
	public void custaddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void custPinNo(int pinno) {
		txtPinNo.sendKeys(String.valueOf(pinno));
	}
	
	public void custPhoneNo(String phoneno) {
		txtPhoneNo.sendKeys(phoneno);
	}
	
	public void custEmailId(String emailid) {
		txtEmailId.sendKeys(emailid);
	}
	
	public void custPassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}
	
	public void custSubmit() {
		btnSubmit.click();
	}
	
	
	
	
	

}
