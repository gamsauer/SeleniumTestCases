/*
 * Description: Using Firefox text fields, calendars and dropdowns
 * Author:  gsr732 (GA Sauer)
 * Date:  March 11, 2016
 * 
 */

package seleniumTestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;

public class calendarsTextFieldsDropdowns {

	public static void main(String[] args) throws Exception {

		setUp();
		textFieldsDropDowns();

	}

	public static WebDriver driver;
	public static String baseUrl;
	public static String fromCity;
	public static String toCity;

	// Setup Firefox driver and URL
	public static void setUp() throws Exception {

		
	driver = new FirefoxDriver();
	baseUrl = "https://www.expedia.com/";
		
	// Maximize the browser's window
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	// Open up URL in baseURL variable
	driver.get(baseUrl);
	
	}	
	

	public static void textFieldsDropDowns() throws Exception {

	fromCity = "New York, NY, United States (NYC-All Airports)";
	toCity = "Chicago (and vicinity), Illinois, United States of America";
	
	// Enter Flying from and Flying to text fields
	driver.findElement(By.id("package-origin")).sendKeys(fromCity);
	driver.findElement(By.id("package-destination")).sendKeys(toCity);
	
	
	//Choose Departing date	
	WebElement departCal = driver.findElement(By.id("package-departing"));
	departCal.sendKeys("3/15/2016");
	
	
	//Choose  Returning date
	WebElement returnCal = driver.findElement(By.id("package-returning"));
	returnCal.sendKeys("4/15/2016");
	
	//Choose Rooms
	Select rooms = new Select(driver.findElement(By.id("package-rooms")));
	rooms.selectByVisibleText("1");
	
	//Choose Adults
	Select adults = new Select(driver.findElement(By.id("package-1-adults")));
	adults.selectByVisibleText("4");
	
	//Choose Children
	Select kids = new Select(driver.findElement(By.id("package-1-children")));
	kids.selectByVisibleText("0");
	
	
	// Click Search button
	driver.findElement(By.id("search-button")).click();


	
	
	}
}
		
	



