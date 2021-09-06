package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;


public class menuChecking{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver = new FirefoxDriver();
			
			
			driver.get("http://alchemy.hguy.co/crm");
			
			driver.findElement(By.id("user_name")).sendKeys("admin");
			driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
			driver.findElement(By.xpath("//*[@id=\'bigbutton\']")).click();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.findElement(By.id("toolbar"));
	
			WebElement Activitylink =driver.findElement(By.xpath("//*[@id=\"grouptab_3\"]"));
			
			String Activitylink1= Activitylink.getText() ;
			System.out.println(Activitylink1);
			
			Assert.assertEquals(Activitylink1,"ACTIVITIES");
			
			driver.close();
			
			
	}
}