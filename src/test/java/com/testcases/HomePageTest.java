package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.Base;
import com.commonactions.Commonactions;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utility.ExtentManager;
import com.utility.Log;

public class HomePageTest extends Base{

	HomePage hp;
	LoginPage lp;
	
	public HomePageTest() {
		super();
	}
	
	//@Test(groups= {"Sanity", "E2E"})
	
	@Test
	public void testNavigateToFlipkartHomePage() throws InterruptedException {
		
		Log.startTestCase("testLoginFunctionality");
		Log.info("Verifying Login functtionality");
		
		ExtentManager.test.log(Status.INFO, "Verifying Login functtionality");
		
		hp = new HomePage();
		lp = new LoginPage();
		
		hp.loginCancleButton(); // click on cancel button
		hp.selectUIitems();    // find mobile item in list
		hp.searchButton();     // type in search box
		hp.searchBrand();      // search for mobile brand
		hp.selectBrand();      // select brand
		hp.sortBy();           // sort by
		//hp.scrollPagination(); // scroll till pagination bar
		hp.searchRequestedMobile(); // search for requested mobile to buy
		hp.addToCart();        // add item to cart   
		
		lp.validateLoginFunction();
		
		hp.removeFromCart();   // remove item from cart
		
		
		Log.info("Verified successfully Login functtionality");		
		ExtentManager.test.log(Status.PASS, "Login functionality working successfully");
		Log.endTestCase("testLoginFunctionality");
		
		
		}
	
	public void testLoginCancleButton() {
		hp = new HomePage();
		hp.loginCancleButton(); 	
	}

	public void testSelectUIitems() {
		hp = new HomePage();
		hp.selectUIitems();	
	}

	public void testSearchButton() {
		hp = new HomePage();
		hp.searchButton(); 	
	}

	public void tesSearchBrand() {
		hp = new HomePage();
		hp.searchBrand(); 	
	}
	
	public void tesSelectBrand() {
		hp = new HomePage();
		hp.selectBrand(); 	
	}

	public void testSortBy() {
		hp = new HomePage();
		hp.sortBy();
	}

	public void testScrollPagination() {
		hp = new HomePage();
		hp.scrollPagination(); 	
	}
	
	public void testSearchRequestedMobile() {
		hp = new HomePage();
		hp.loginCancleButton(); 	
	}
	
	public void testAddToCart() {
		hp = new HomePage();
		hp.loginCancleButton(); 	
	}
	
	public void testSelectBrand() {
		hp = new HomePage();
		hp.loginCancleButton(); 	
	}
	
	public void testValidateLoginFunction() {
		hp = new HomePage();
		hp.loginCancleButton(); 	
	}
	
	public void tesRemoveFromCart() {
		hp = new HomePage();
		hp.loginCancleButton(); 	
	}
}
