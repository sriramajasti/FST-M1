package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class gettingColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 WebDriver driver = new FirefoxDriver();
			
			
			driver.get("http://alchemy.hguy.co/crm");
			
			driver.findElement(By.id("user_name")).sendKeys("admin");
			driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
			driver.findElement(By.xpath("//*[@id=\'bigbutton\']")).click();
			
			String backcolor = driver.findElement(By.id("toolbar")).getCssValue("background-color");
			System.out.println("background color  is:" + backcolor);
			driver.close();
	}

}