package CRM;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;;



public class login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 WebDriver driver = new FirefoxDriver();
			
			
			driver.get("http://alchemy.hguy.co/crm");
			
			driver.findElement(By.id("user_name")).sendKeys("admin");
			driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
			driver.findElement(By.xpath("//*[@id=\'bigbutton\']")).click();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String actual = "https://alchemy.hguy.co/crm/index.php?module=Home&action=index";
			String expected = driver.getCurrentUrl();
			
		Assert.assertTrue(actual.contentEquals(expected));
		System.out.println("Assertion is Passed");
		
		
		
		driver.close();
		
	}

}