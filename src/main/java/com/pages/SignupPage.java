package com.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;
import com.commonactions.Commonactions;
import com.pages.HomePage;
import com.utility.Log;

public class SignupPage extends Base {

	Commonactions actions;

	// Web Elements
	@FindBy(id = "ctl00_mainContent_rbtnl_Trip_1")
	WebElement roundtrip;

	@FindBy(id = "ctl00_HyperLinkLogin")
	WebElement mouseOnSignup;

	@FindBy(linkText = "SpiceClub Members")
	WebElement spiceClube;

	@FindBy(linkText = "Member Login")
	WebElement memberLogin;

	@FindBy(linkText = "Sign up")
	WebElement signupNavigation;

	@FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle")
	WebElement title;

	@FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName")
	WebElement firstName;

	@FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxLastName")
	WebElement lastName;

	@FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINTLMOBILENUMBER")
	WebElement mobNumber;

	@FindBy(id = "CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldAgentPassword")
	WebElement password;

	@FindBy(id = "CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldPasswordConfirm")
	WebElement confirmPassword;

	@FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINPUTDOB")
	WebElement dob;

	@FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxEmail")
	WebElement email;

	@FindBy(id = "chkSpiceClubTnC")
	WebElement agree;

	@FindBy(id = "CONTROLGROUPREGISTERVIEW_ButtonSubmit")
	WebElement submit;

	@FindBy(xpath = "//tbody[@class='datepickerYears']/tr/td/a/span")
	List<WebElement> ListOfyears;

	@FindBy(xpath = "//tbody[@class='datepickerMonths']/tr/td/a/span")
	List<WebElement> monthOfyears;
	
	@FindBy(xpath = "//tbody[@class='datepickerDays']/tr/td/a/span")
	List<WebElement> dateOfMonth;
	
	@FindBy(xpath = "//table/thead/tr/th[2]/a/span")
	WebElement monthReturn;

	/*
	 * @FindBy(id = "popup_container") WebElement alert;
	 */

	public SignupPage() {
		PageFactory.initElements(getDriver(), this);

	}

	public String validatePageTitle() {
		return getDriver().getTitle();
	}

	public void selectRoundtrip() {
		Commonactions.waitForElement(getDriver(), roundtrip);
		Commonactions.click(getDriver(), roundtrip);
	}

	public void mouseOnSignup() {
		Commonactions.waitForElement(getDriver(), mouseOnSignup);
		Commonactions.mouseover(getDriver(), mouseOnSignup);
	}

	public void mouseOnSpiceClube() {
		Commonactions.waitForElement(getDriver(), spiceClube);
		Commonactions.mouseoverExample(getDriver(), spiceClube);

	}

	public void signupNavigation() {
		Commonactions.waitForElement(getDriver(), signupNavigation);
		Commonactions.mouseoverExample(getDriver(), signupNavigation);
		Commonactions.click(getDriver(), signupNavigation);

	}

	public void memberLogin() {
		Commonactions.waitForElement(getDriver(), memberLogin);
		Commonactions.click(getDriver(), memberLogin);

	}
	
	static int counts=0;
	
	public void signUpDataProvider(String title1, String firstname1, String lastname1, String mobnumber1,
			String password1, String confirmpassword1,String date, String email1) {

		
		  // title Commonactions.waitForElement(getDriver(), title);
		
		  Commonactions.scrollByVisibilityOfElement(getDriver(), title);
		  Commonactions.click(getDriver(), title); 
		  Commonactions.selectByValue(title,title1);
		  
		  // firstName Commonactions.waitForElement(getDriver(), firstName);
		  Commonactions.type(firstName, firstname1);
		  
		  // lastName Commonactions.waitForElement(getDriver(), lastName); //
		  lastName.sendKeys("Chaturvedi"); Commonactions.type(lastName, lastname1);
		  
		  // mobileNumber Commonactions.waitForElement(getDriver(), mobNumber); //
		  mobNumber.sendKeys("7712345678"); Commonactions.type(mobNumber, mobnumber1);
		  
		  // password Commonactions.waitForElement(getDriver(), password); //
		  password.sendKeys("P@ssword123"); Commonactions.type(password, password1);
		  
		  // confirmPassword Commonactions.waitForElement(getDriver(),confirmPassword); 
		  
		  
		  // confirmPassword.sendKeys("P@ssword123");
		  Commonactions.type(confirmPassword, confirmpassword1);
		  
		  //alert //Commonactions.Alert(getDriver());
		 
		
		
		// dob
		//dateOfBirth(date);
		

		// email
		Commonactions.waitForElement(getDriver(), email);
		// email.sendKeys("himanshu12@gmail.coms");
		Commonactions.type(email, email1);

		// agreeterms
		// Commonactions.waitForElement(getDriver(), agree);
		// Commonactions.click(getDriver(), agree);

		// submit
		// submit();

	}

	
	/*
	 * public void title() { Commonactions.waitForElement(getDriver(), title);
	 * Commonactions.scrollByVisibilityOfElement(getDriver(), title);
	 * Commonactions.click(getDriver(), title); Commonactions.selectByValue(title,
	 * "MR");
	 * 
	 * }
	 * 
	 * public void firstName() { Commonactions.waitForElement(getDriver(),
	 * firstName); firstName.sendKeys("Himanshu");
	 * 
	 * }
	 * 
	 * public void lastName() { Commonactions.waitForElement(getDriver(), lastName);
	 * lastName.sendKeys("Chaturvedi");
	 * 
	 * }
	 * 
	 * public void mobNumber() { Commonactions.waitForElement(getDriver(),
	 * mobNumber); mobNumber.sendKeys("7712345678");
	 * 
	 * }
	 * 
	 * public void password() { Commonactions.waitForElement(getDriver(), password);
	 * password.sendKeys("P@ssword123");
	 * 
	 * }
	 * 
	 * public void confirmPassword() { Commonactions.waitForElement(getDriver(),
	 * confirmPassword); confirmPassword.sendKeys("P@ssword123");
	 * 
	 * }
	 */
	  public void dateOfBirth(String date) { 
	  
	  Commonactions.waitForElement(getDriver(), dob);
	  if(counts>0) {
		  Commonactions.waitForElement(getDriver(), dob);
		  dob.click();
		  try {
			Thread.sleep(2000L);
			monthReturn.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			Thread.sleep(2000L);
			 monthReturn.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+counts);
		  
	  }else {dob.click(); counts++;
	  
	  System.out.println("/////////////////////////////////////////////////"+counts);
	  }
	  
	  
	  
	  String month[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	     // 06/02/2000
	    String[] selectdate = date.split("/");
		String monthSelected = selectdate[0];
		String day = selectdate[1];
		String year = selectdate[2];
		String dayselect = null;
		int count = 0;
	  
		int monthName = Integer.parseInt(monthSelected);
		
	  for (int i = 0; i < ListOfyears.size(); i++) {
		
		  
	  if (ListOfyears.get(i).getText().equals(year)) {
	  
	  System.out.println("Test case is passed in year" + ListOfyears.get(i));
	  ListOfyears.get(i).click();
	  
	  for (int m = 0; m < monthOfyears.size(); m++) {
	  
	  if (monthOfyears.get(m).getText().equals(month[monthName-1])) {
	  
	  System.out.println("Test case is passed in month" + monthOfyears.get(m));
	  monthOfyears.get(m).click();
	  
	  
	  for (int d = 0; d < dateOfMonth.size(); d++) {
	  
		 if(d<10) {
		  dayselect = day.substring(1);
		 }
		 
	  if (dateOfMonth.get(d).getText().equals(dayselect)) {
	  
	  System.out.println("Test case is passed in date"+ dateOfMonth.get(d));
	  dateOfMonth.get(d).click(); 
	  break;
	  
	  }
	  
	  
	  }
	  
	 } 
	  
	  }
	  
	  } else {
	  
	  System.out.println("Test case is not passed"); } 
	  
	  }
	  
	  }
	  
		/*
		 * public void email() { Commonactions.waitForElement(getDriver(), email);
		 * email.sendKeys("himanshu12@gmail.coms");
		 * 
		 * }
		 * 
		 * public void agreeTerms() { Commonactions.waitForElement(getDriver(), agree);
		 * Commonactions.click(getDriver(), agree);
		 * 
		 * }
		 * 
		 * public void submit() { WebDriver driver = getDriver();
		 * 
		 * Commonactions.waitForElement(driver, submit); Commonactions.click(driver,
		 * submit); Commonactions.Alert(driver);
		 * 
		 * }
		 * 
		 * public void alert() { // Commonactions.waitForElement(getDriver(), alert);
		 * 
		 * }
		 * 
		 * public void years() {
		 * 
		 * }
		 */
	 
}
