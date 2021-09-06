package appium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

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

public class Chrome_Activity2 {
	
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
        //caps.setCapability("autoWebview", true);
        
      
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
	
	@Test(priority=1)
	public void Loginform() throws InterruptedException {
		String URL = "https://www.training-support.net/selenium";
		//open the URL
		driver.get(URL);

		//scroll to Login form
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Login Form Please sign in.\"))")).click();
	}
	
	
	@Test(priority=2)
	public void Correctcase() throws InterruptedException {	
		//input to username
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[contains(@resource-id, 'username')]"))).click();
		driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'username')]").sendKeys("admin"); 
		
		//input to password
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[contains(@resource-id, 'password')]"))).click();
		driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'password')]").sendKeys("password"); 
		
		new TouchAction(driver).press(PointOption.point(1000, 1050)).waitAction().moveTo(PointOption.point(1000, 500)).release().perform();
		
		//click login button
				wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Log in\")"))).click();
			//get confirm message
				wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@resource-id, 'confirmation')]")));
				String confirm_msg  = driver.findElementByXPath("//android.view.View[contains(@resource-id, 'confirmation')]").getText();
		
		Assert.assertEquals(confirm_msg, "Welcome Back, admin");
		System.out.println("Test case 1 is passed");
		
		
	}
	
	@Test(priority=3)
	public void InCorrectcase() throws InterruptedException {	
		
		
		//input to username
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[contains(@resource-id, 'username')]"))).click();
		driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'username')]").sendKeys("admin1"); 
		
		//input to password
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[contains(@resource-id, 'password')]"))).click();
		driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'password')]").sendKeys("password1"); 
		
		//click login button
		new TouchAction(driver).press(PointOption.point(1000, 1050)).waitAction().moveTo(PointOption.point(1000, 500)).release().perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Log in\")"))).click();
		
		
		//Get text of the message displayed
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@resource-id, 'confirmation')]")));
		String confirm_msg  = driver.findElementByXPath("//android.view.View[contains(@resource-id, 'confirmation')]").getText();
		
		//Assert the message displayed
		Assert.assertEquals(confirm_msg, "Invalid Credentials");
		System.out.println("Test case2 is passed");
		
		
	}
	
	@AfterClass
	public void last() {
		driver.quit();
	}

}