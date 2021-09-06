package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
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
import io.appium.java_client.android.AndroidDriver;

public class googleKeepReminder {
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	
	@BeforeClass
	void beforeClass() throws MalformedURLException {
		DesiredCapabilities deCaps = new DesiredCapabilities();
		deCaps.setCapability("deviceName", "MobilePixel4Emu");
		deCaps.setCapability("platformName", "Android");
		deCaps.setCapability("automationName", "UiAutomator2");
		deCaps.setCapability("appPackage", "com.google.android.keep");
		deCaps.setCapability("appActivity", ".activities.BrowseActivity");
		
		URL appServer = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, deCaps);
		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	void googleKeep() throws InterruptedException {
		// Add task
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("new_note_button"))).click();
		// Title
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title_editor_fragment")));
		MobileElement title = driver.findElementById("editable_title");
		title.click(); title.sendKeys("Add Note");
		// Description
		driver.findElementById("edit_note_text").sendKeys("This note is for testing");
		// Set Reminder
		setReminder("Night");
		// Back
		driver.findElement(MobileBy.AccessibilityId("Open navigation drawer")).click();
		Thread.sleep(1000);
		MobileElement reminder = driver.findElementById("reminder_chip_text");
		Assert.assertTrue(reminder.getText().contains("Today"), "Add note with reminder");
	}
	
	@AfterClass
	void afterClass() {
		driver.quit();
	}
	
	void setReminder(String time) throws InterruptedException {
		// Add Reminder
		driver.findElementById("menu_reminder").click();
		// Wait
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id("menu_text")));
		List<MobileElement> reminderMenu = driver.findElementsById("menu_text");
		for(MobileElement item:reminderMenu) {
			if(item.getText().equals("Pick a date & time")) {
				item.click();
				break;
			}
		}
		// Wait
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("alertTitle")));
		// Set Time
		driver.findElementsById("text").get(1).click();
		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath("//android.widget.LinearLayout[4]/android.widget.TextView[1]")).click();
		// Save
		driver.findElementById("save").click();
	}
}