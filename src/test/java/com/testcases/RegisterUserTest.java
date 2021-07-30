package com.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.Base;
import com.dataproviders.Dataproviders;
import com.pages.RegisterUserPage;
import com.utility.ExtentManager;
import com.utility.Log;

public class RegisterUserTest extends Base {

		@Test(groups = { "Sanity", "E2E", "Smoke" },dataProvider = "AddUser", dataProviderClass = Dataproviders.class)
		public void testPageTitle(String firstName,String lastName,String email,String password,String mobile) {
			RegisterUserPage registerPage = new RegisterUserPage();
			Log.startTestCase("testLoginFunctionality");
			Log.info("Verifying Login Shopping functionality");
			ExtentManager.test.log(Status.INFO, "Verifying Login Shopping Positive functionality");
			
			registerPage.clickCreateUser();
			registerPage.enterFirstName(firstName);
			registerPage.enterLastName(lastName);
			registerPage.enterEmail(email);
			registerPage.enterPassword(password);			
			registerPage.enterMobileNumber(mobile);
			registerPage.clickHomePageIcon();
			
			Log.info("Verified successfully Login Shopping Positive functionality");
			ExtentManager.test.log(Status.PASS, "Shopping Login Positive functionality working successfully");
			Log.endTestCase("testLoginFunctionality");
		}

}
