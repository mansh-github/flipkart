package com.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;
import com.commonactions.Commonactions;
import com.utility.ExcelLibrary;
import com.utility.Log;

public class HomePage extends Base {

	ExcelLibrary excelDetails = new ExcelLibrary();
	
	public HomePage() {

		PageFactory.initElements(getDriver(), this);
	}

	Commonactions actions;

	// Web Elements
	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement loginCancleButton;

	@FindBy(xpath = "//div[@class='eFQ30H'] //div[@class='xtXmba']")
	List<WebElement> uiItems;
	
	@FindBy(xpath = "//input[@class='_3704LK']")
	WebElement SearchButton;

	@FindBy(xpath = "//input[@class='_34uFYj']")
	WebElement searchBrand;

	@FindBy(xpath = "//div[@class='_1KOcBL']/section[5]/div[2] //div[@class='_24_Dny']")
	WebElement selectBrand;

	@FindBy(css = "[class='_5THWM1'] div")
	List<WebElement> sortBy;

	@FindBy(css = "[class='_2MImiq']")
	WebElement scrollPagination;

	@FindBy(css = "[class='yFHi8N'] a")
	List<WebElement> searchRequestedMobile;

	@FindBy(xpath = "//div[@class='col col-7-12'] //div[@class='_4rR01T']")
	List<WebElement> modelName;

	@FindBy(css = "[class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement addToCart;

	@FindBy(xpath = "//*[@class='_1YokD2 _3Mn1Gg']/div[1] //*[@class='_1AtVbE col-12-12']/div/div //a[@class='_2Kn22P gBNbID']")
	List<WebElement> removeFromCart;
	
	@FindBy(xpath = "//*[@class='_1YokD2 _3Mn1Gg']/div[1] //*[@class='_1AtVbE col-12-12']/div/div/following-sibling::div[1]/div/div[2]")
	List<WebElement> removeButton;

	@FindBy(css = "[class='_3dsJAO _24d-qY FhkMJZ']")
	WebElement confirmRemove;
	
	@FindBy(css = "[class='_3dsJAO _24d-qY FhkMJZ']")
	WebElement removed;
			
	public String validatePageTitle() {
		return getDriver().getTitle();
	}

	public void selectUIitems() {

		Iterator<WebElement> itr = uiItems.iterator();
		int count;
		
		while (itr.hasNext()) {

			WebElement el = (WebElement) itr.next();

			String iteamName = el.getText();
			
			String MobileName = excelDetails.getCellData("FlipkartInput",0,2);

			if (iteamName.contentEquals(MobileName)) {

				Commonactions.click(getDriver(), el);
				break;
			}

			System.out.println(iteamName);
		}

	}
	
	public void searchButton() {

		Commonactions.waitForElement(getDriver(), SearchButton);
		
		//Commonactions.type(SearchButton, "mobile");
	
		Actions a = new Actions(getDriver());
		  a.moveToElement(SearchButton).click().sendKeys("mobiles").sendKeys(Keys.ENTER)
		  .build().perform();
		 
		// Commonactions.click(getDriver(), loginCancleButton);
		// Commonactions.scrollByVisibilityOfElement(getDriver(), searchBrand);

	}

	public void loginCancleButton() {

		System.out.println("inside login");
		Commonactions.click(getDriver(), loginCancleButton);
	}

	public void searchBrand() {

		Commonactions.waitForElement(getDriver(), searchBrand);
		
		String BrandName = excelDetails.getCellData("FlipkartInput", 1, 2);
		
		Commonactions.type(searchBrand, BrandName);
		// Commonactions.click(getDriver(), loginCancleButton);
		// Commonactions.scrollByVisibilityOfElement(getDriver(), searchBrand);

	}

	public void selectBrand() {
		Commonactions.waitForElement(getDriver(), selectBrand);
		Commonactions.click(getDriver(), selectBrand);

	}

	public void sortBy() {

		System.out.println("inside sortby method");

		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<WebElement> itr = sortBy.iterator();
		while (itr.hasNext()) {

			WebElement el = itr.next();

			System.out.println(el.getText());

			String shortBy = excelDetails.getCellData("FlipkartInput", 2, 2);
			
			if (el.getText().equals(shortBy)) {

				Commonactions.waitForElement(getDriver(), el);
				Commonactions.click(getDriver(), el);
				break;
			}
		}

	}

	public void scrollPagination() {

		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Commonactions.scrollByVisibilityOfElement(getDriver(), scrollPagination);

	}

	public void searchRequestedMobile() {

		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int count = 0;
		boolean b = false;

		Iterator<WebElement> itr = searchRequestedMobile.iterator();
		while (itr.hasNext()) {

			if (count < 10) {

				WebElement el = itr.next();

				Iterator<WebElement> modelNames = modelName.iterator();

				while (modelNames.hasNext()) {

					WebElement modelName = modelNames.next();
					
					String desireModelName = excelDetails.getCellData("FlipkartInput", 3, 2);

					if (modelName.getText().equals(desireModelName)) {

						 //Commonactions.scrollByVisibilityOfElement(getDriver(), modelName);

						Commonactions.explicitWait(getDriver(), modelName, 5);
						System.out.println("phone model is available");
						try {
							Thread.sleep(4000L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//Commonactions.scrollByVisibilityOfElement(getDriver(), modelName);
						modelName.click();

						b = true;
						break;
					}
				}

				if (b) {
					break;
				}
				Commonactions.click(getDriver(), el);
				count++;
				System.out.println("count =  " + count);
				try {
					Thread.sleep(4000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public void addToCart() {

		Commonactions.switchToNewWindow(getDriver());
		Commonactions.waitForElement(getDriver(), addToCart);
		Commonactions.click(getDriver(), addToCart);

	}

	
	public void removeFromCart() throws InterruptedException {
		
		Commonactions.implicitWait(getDriver(), 4);

		Commonactions.switchToNewWindow(getDriver());
		//Commonactions.waitForElements(getDriver(), removeFromCart);
		Thread.sleep(2000L);
		Iterator<WebElement> itrNames = removeFromCart.iterator();
		Thread.sleep(2000L);
		Iterator<WebElement> itrbuttons = removeButton.iterator();
		
		WebElement removeButton;
		WebElement modelName;
		
		while(itrNames.hasNext()) {
			
			
			modelName = itrNames.next();
			Thread.sleep(2000L);
			removeButton = itrbuttons.next();
			
			
			System.out.println(modelName.getText());
			
			String removeModel = excelDetails.getCellData("FlipkartInput", 6, 2);
			
			if(modelName.getText().equals(removeModel)) {
				
				System.out.println("inside cart = "+ modelName.getText());	
				
				try {
					
					Thread.sleep(2000L);
					removeButton.click();
					//Commonactions.click(getDriver(), removeButton);
				} catch (Exception e) {
					
					System.out.println("in catch start" +e);
					removeButton = itrbuttons.next();
					Commonactions.click(getDriver(), removeButton);
					System.out.println("in catch stop");
				}
			
                
				/*
				 * removeButton = itrbuttons.next(); removeButton.click();
				 */
				//Commonactions.click(getDriver(), removeButton);
				
				System.out.println("alert inside");
				Thread.sleep(2000L);
				Commonactions.switchToNewWindow(getDriver());
				removed.click();
                System.out.println("alert clicked");
                
				
				break;
			}
		}
		

	}
}
