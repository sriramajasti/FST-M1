package CRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class verifyTitle{

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub


		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("http://alchemy.hguy.co/crm");
		 String title = driver.getTitle();
	        
	        System.out.println("Page title is: " + title);
	        
	        Assert.assertTrue(title.contains("SuiteCRM"));
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.close();
	      
		
	}
}