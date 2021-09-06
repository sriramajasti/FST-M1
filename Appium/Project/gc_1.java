package appium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class gc_1{
	
	 // Instantiate Appium Driver
	//AndroidDriver driver;
	AppiumDriver<MobileElement> driver = null;
	
	WebDriverWait wait;
	
	@BeforeClass
    public void setup() throws InterruptedException, IOException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "47aa2ebc");
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
        
      
        try {
            // Initialize driver
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            System.out.println("Chrome is opened");
            //Initialize wait
            wait = new WebDriverWait(driver, 10);         
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	@Test
	public void ToDoList() throws InterruptedException {
		String URL = "https://www.training-support.net/selenium";
	
		//open the URL
		driver.get(URL);

		
		//scroll to TO Do list
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"To-Do List Elements get added at run time\"))")).click();
		
		//adding all arrays to the string
		String[] input = {"Add tasks to list", 
				"Get number of tasks", 
				"Clear the list"}; 
		//input field on the page and enter the following three tasks	
		for(String in : input) {
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[contains(@resource-id, 'taskInput')]"))).click();
		driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'taskInput')]").sendKeys(in); 
		//click add task
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Add Task\")"))).click();
		
		Boolean isdisplay = driver.findElement(MobileBy.AndroidUIAutomator("text(\""+in+"\")")).isDisplayed();
		if(isdisplay) {
			continue;
		}
		}
		//Strike out the task added
		for(String strike : input) {
			
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\""+strike+"\")"))).click();
		}
		//find and click clear list button
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@clickable = 'true']")));
		driver.findElementByXPath("//android.view.View[@clickable = 'true']").click();
		
		
		//Verify if element is present or not		
		for(String strike : input) {

			MobileElement ele  = driver.findElement(MobileBy.AndroidUIAutomator("text(\""+strike+"\")"));
			Assert.assertFalse(ele.isDisplayed());
			System.out.println("list is clear with task: "+strike);
	
		
		}
	}
	
	@AfterClass
	public void last() {
		driver.quit();
	}

}