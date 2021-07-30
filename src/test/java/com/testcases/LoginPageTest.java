package com.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.Base;
import com.dataproviders.Dataproviders;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignupPage;
import com.utility.ExtentManager;
import com.utility.Log;


public class LoginPageTest extends Base{

	LoginPage loginpage;
	
	/*
	 * public LoginPageTest() { super(); }
	 */
	
//	@Test(priority=1)
	public void testPageTitle() {
		
		Log.startTestCase("testPageTitle");
		String title = loginpage.validatePageTitle();
		Log.info("Verifying page title");
		Assert.assertEquals(title, "OrangeHRM");
		Log.endTestCase("testPageTitle");
		
		
	}
	
//	@Test(priority=2)
	public void testPageLogoPresence() {
		/*
		 * Log.startTestCase("testPageLogoPresence"); //boolean flag =
		 * loginpage.validatePageLogo(); Log.info("Verifying page Logo");
		 * Assert.assertTrue(flag); System.out.println("*******LOGO********  "+flag);
		 * Log.endTestCase("testPageLogoPresence");
		 */
	}
	
	//@Test(groups= {"Sanity", "E2E", "Smoke"})
	@BeforeMethod
	public void test() {}
	
	@Test(dataProvider = "SignupData", dataProviderClass = Dataproviders.class)
	public void testLoginFunctionality(String title1, String firstname, String lastname, String mobnumber, String password1,
			String confirmpassword,String date, String email1) {
		Log.startTestCase("testLoginFunctionality");
		Log.info("Verifying Login functtionality");
		
		ExtentManager.test.log(Status.INFO, "Verifying Login functtionality");
		
		LoginPage loginpage = new LoginPage();
		SignupPage signup = new SignupPage();
		
		  signup.selectRoundtrip(); 
		  signup.mouseOnSignup(); 
		  signup.mouseOnSpiceClube();
		  signup.signupNavigation();
		 
		
		/////////////////////////////////////////// signup fields
		signup.signUpDataProvider(title1,firstname,lastname,mobnumber,password1,confirmpassword,date,email1);	
		/*
		 * signup.title(); signup.firstName(); signup.lastName(); signup.mobNumber();
		 * signup.password(); signup.confirmPassword(); signup.dateOfBirth();
		 * signup.email(); signup.agreeTerms();
		 */
		/*
		 * signup.submit(); signup.alert();
		 */
		
		
		Log.info("Verified successfully Login functtionality");		
		ExtentManager.test.log(Status.PASS, "Login functionality working successfully");
		Log.endTestCase("testLoginFunctionality");
	}
		
	@BeforeMethod
	public void before() {
		
		System.out.println("sfskdjfaslk");
	}
}
