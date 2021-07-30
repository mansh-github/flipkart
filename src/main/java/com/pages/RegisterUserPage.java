package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;
import com.commonactions.Commonactions;

public class RegisterUserPage extends Base {
	

	
	public RegisterUserPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//button[contains(text(),' Create New Account ')]")
	private WebElement createUser;
	
	@FindBy(xpath = "//button[contains(text(),' Create New Account ')]")
	private WebElement registerUser;
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passWord;
	
	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='mobile']")
	private WebElement mobile;
	
	@FindBy(xpath = "//input[@type='email']")
	private WebElement email;
	
	@FindBy(xpath = "/html/body/app-root/app-register/app-header/nav/a")
	private WebElement home;
	
	public void clickCreateUser() {
		Commonactions.waitForElement(getDriver(), createUser);

		createUser.click();
	}
	
	public void clickRegisterUser() {
		Commonactions.waitForElement(getDriver(), createUser);

		createUser.click();
	}
	
	public void enterEmail(String emails) {
		Commonactions.waitForElement(getDriver(), email);

		userName.sendKeys(emails);
	}
	
	public void enterUserName(String username) {
		Commonactions.waitForElement(getDriver(), userName);

		userName.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		Commonactions.waitForElement(getDriver(), passWord);

		passWord.sendKeys(password);
	}
	
	public void enterFirstName(String firstname) {
		Commonactions.waitForElement(getDriver(), firstName);

		firstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) {
		Commonactions.waitForElement(getDriver(), lastName);

		lastName.sendKeys(lastname);
	}
	
	public void enterMobileNumber(String mobileNumber) {
		Commonactions.waitForElement(getDriver(), mobile);

		mobile.sendKeys(mobileNumber);
	}
	
	public void clickHomePageIcon() {
		Commonactions.waitForElement(getDriver(), home);

		home.click();
	}
	
	
	


}
