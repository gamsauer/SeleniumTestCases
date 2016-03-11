/*
 * Description: Using Firefox search stock symbol (text field
 * by country (dropdown) and type (dropdown).
 * Author:  gsr732 (GA Sauer)
 * Date:  March 6, 2016
 * *Updated:  March 9, 2016
 */

package seleniumTestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import org.openqa.selenium.By;

public class textFieldSearch {

	public static void main(String[] args) throws Exception {

		setUp();
		textFieldSearch();

	}

	public static WebDriver driver;
	public static String baseUrl;
	public static String ticker;

	// Setup Firefox driver and URL
	public static void setUp() throws Exception {

		
	driver = new FirefoxDriver();
	baseUrl = "http://www.marketwatch.com/tools/quotes/lookup.asp";
		
	// Maximize the browser's window
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	// Open up URL in baseURL variable
	driver.get(baseUrl);
	
	}	
	

	
	public static void textFieldSearch() {

	ticker = "SBUX";
	
	// Enter stock ticket symbol in Name text field
	driver.findElement(By.id("Lookup")).sendKeys(ticker);
	
	//Select Country dropdown
	Select country = new Select(driver.findElement(By.id("Country")));
	country.selectByValue("ca");	
	
	//Select Security Type
	Select security = new Select(driver.findElement(By.id("Type")));
	security.selectByVisibleText("Fund");
	
	// Click Search button
	driver.findElement(By.xpath(".//div[@id='nonchrome']//div//div//form//ul//li[@class='search']")).click();


	
	
	}
		
	}


