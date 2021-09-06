package appium;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class googleTask {
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	List<MobileElement> tasks;
	
	@BeforeClass
	void beforeClass() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "MobilePixel4Emu");
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.google.android.apps.tasks");
		cap.setCapability("appActivity", ".ui.TaskListsActivity");
		
		URL appServer = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, cap);
		// Create object for WebDriverWait class
		wait = new WebDriverWait(driver, 10);
	}
	
	@DataProvider
	public Object[] taskNames() {
		Object[] task = new Object[] {
				"Complete Activity with Google Tasks",
				"Complete Activity with Google Keep",
				"Complete the second Activity Google Keep"
		};
		return task;
	}
	
	@Test(dataProvider="taskNames", priority=1)
	void addTasks(String taskName) throws InterruptedException {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("welcome_get_started"))).click();
		} catch(TimeoutException toe) {}
		// Task
		createTask(taskName);
		Thread.sleep(1000);
		tasks = driver.findElements(MobileBy.id("task_name"));
		// Assertion
		Assert.assertEquals(tasks.get(0).getText(), taskName);
	}
	
	@Test(priority=2, invocationCount = 3)
	void deleteTasks() throws InterruptedException {
		// Task Detail
		driver.findElements(MobileBy.id("task_name")).get(0).click();
		Thread.sleep(1000);
		// Delete
		driver.findElementById("delete_task_option").click();
	}
	
	@AfterClass
	void afterClass() {
		driver.quit();
	}
	
	void createTask(String taskName) {
		// Add task
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("tasks_fab"))).click();
		// Create Tasks
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title"))).sendKeys(taskName);
		// Save
		driver.findElementById("add_task_done").click();
	}
}