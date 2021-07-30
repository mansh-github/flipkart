package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.utility.ExtentManager;

public class Base {


	
//	public static WebDriver driver;
	public static Properties prop;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	
	//@BeforeSuite(groups = { "Smoke", "Regression","Sanity" })
	@BeforeSuite(groups = {"Smoke"})
	public void LogInitializer() {
		ExtentManager.setExtent();
	}
	
	public Base(){
		try {
			prop = new Properties(); 
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/configuration"
					+ "/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	
	public static void Initialization(String browserName) throws InterruptedException {
	//	String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
			driver.set(new ChromeDriver());
		}else if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/IEDriverServer.exe");
			driver.set(new InternetExplorerDriver());
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/geckodriver.exe");
			driver.set(new FirefoxDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		//getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		getDriver().get(prop.getProperty("url"));
		Thread.sleep(3000);
	}
	
	/*
	 * @Parameters("browser")
	 * 
	 * @BeforeMethod(groups = { "Smoke", "Regression","Sanity" }) public void
	 * setup(String browser) throws InterruptedException { Initialization("chrome");
	 * }
	 */
	
	@BeforeTest
	public void setup() throws InterruptedException {
	System.out.println("in browser");
		Initialization("chrome");
	}
	
	//@AfterMethod(groups = { "Smoke", "Regression","Sanity" })
	@AfterTest
	public void closer() {
		/*
		 * HomePage homepage = new HomePage(); homepage.logout(); LoginPage loginpage =
		 * new LoginPage(); loginpage.validatePageLogo();
		 */
		//getDriver().quit();
	}

	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() {
		ExtentManager.endReport();
	}
	

	
}
