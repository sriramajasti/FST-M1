package CRM;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class getCopyRight{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
          WebDriver driver = new FirefoxDriver();
		
		
		driver.get("http://alchemy.hguy.co/crm");
		
		WebElement text = driver.findElement(By.id("admin_options"));
		System.out.println(text.getText());
	        
	      
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.close();
		
	        

	}

}