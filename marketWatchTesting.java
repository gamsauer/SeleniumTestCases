/*
 * Description: Using Firefox, validate page title, close any pop ups,
 * 				test text field, link and button.
 * Author:  gsr732 (GA Sauer)
 * Date:  March 6, 2016
 * *Updated:  March 9, 2016
 */

package seleniumTestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import org.openqa.selenium.By;

public class marketWatchTesting {

	public static void main(String[] args) throws Exception {

		setUp();
		verifyPageTitle();
		textFieldsLinksButtons();

	}

	public static WebDriver driver;
	public static String baseUrl;
	public static String ticker;

	// Setup Firefox driver and URL
	public static void setUp() throws Exception {
	
	//Use selenium Firefox profile
	ProfilesIni fxProfile = new ProfilesIni();
	FirefoxProfile myprofile = fxProfile.getProfile("selenium");

		
	driver = new FirefoxDriver(myprofile);
	baseUrl = "http://www.marketwatch.com/tools/quotes/lookup.asp";
		
	// Maximize the browser's window
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}	
	
	public static void verifyPageTitle() {

	System.out.println(driver.getWindowHandles());
	
	// Open up URL in baseURL variable
	driver.get(baseUrl);
	
	// Get title of webpage and verify the correct one displays
	
	System.out.println("Results from webpage title test:");
	
	if (driver.getTitle().equals("Stock Ticker Symbol Lookup - MarketWatch")){
		System.out.println("The correct page has displayed.");
	}
	else{
		System.out.println("Wrong page has displayed.  " + driver.getTitle() + " has displayed.");

		}
	}
	
	
	
	public static void textFieldsLinksButtons() {

	ticker = "SBUX";
	
	// Enter stock ticket symbol in Name text field
	driver.findElement(By.id("Lookup")).sendKeys(ticker);
	
	// Click Search button
	driver.findElement(By.xpath(".//div[@id='nonchrome']//div//div//form//ul//li[@class='search']")).click();


	
	
	}
		
	}


