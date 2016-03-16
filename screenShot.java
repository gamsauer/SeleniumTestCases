/*
 * Description: Taking a screenshot and saving it to a file
 * Author:  gsr732 (GA Sauer)
 * Date:  March 16, 2016
 * 
 */


package seleniumTestScripts;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Random;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;


public class screenShot {
	
	public static WebDriver driver;
	public static String baseUrl;
	public static String artSearch; 

	public static void main(String[] args) throws Exception {
		
		setUp();
		testData();
		artSearch();
		tearDown();
		

	}
	
	// Setup Firefox driver
	public static void setUp() throws Exception {

	//Set FireFox as driver	
	driver = new FirefoxDriver();
		
	// Maximize the browser's window
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	

	}
	
	public static void testData() 
	{
		baseUrl = "https://www.art.com/";
		artSearch = "Italian Love Story";

		
	}
	
	public static void artSearch() throws Exception {
	
	// Open up URL in baseURL variable
	driver.get(baseUrl);
		
	
	// Clear out and enter search criteria
	WebElement searchText = driver.findElement(By.id("search_text"));
	searchText.click();
	searchText.sendKeys(artSearch);

	
	// Click Search button
	driver.findElement(By.xpath("//div[@id='hdr-bar-cont']//div[@class='hdr_search hide-until-tab']/form/input[@class='hdr_search_btn']")).click();

	
	}
	
	public static void tearDown() throws Exception {
		
		//Date with YYYYMMddHHnn format 
		Date serverDate = new Date();
		SimpleDateFormat dateFormatted = new SimpleDateFormat("YYYYMMddHHmm");
		String displayDate = dateFormatted.format(serverDate);
		//System.out.println(date);
		//serverDate = dateFormatted.format(System.currentTimeMillis());
		//System.out.println(System.currentTimeMillis());
		//System.out.println(displayDate);
		
		//Generation of random number of a length of 10		
		Random randNum = new Random();
		int answer = randNum.nextInt(100000000) + 1000000000;


		//Generate file name and directory location
		String fileName = artSearch + "_" +  answer + "_" + displayDate + ".jpg";
		String directory  = "//Users//Mac//Selenium//Screenshots//";
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		driver.quit();
		
		System.out.println("Successful");
	}
	
}


