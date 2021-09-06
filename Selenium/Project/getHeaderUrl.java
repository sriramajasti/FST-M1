package CRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class getHeaderUrl{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

WebDriver driver = new FirefoxDriver();
		
		
		driver.get("http://alchemy.hguy.co/crm");
		
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        
	        WebElement image = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form[1]/div[1]/img"));
	         System.out.println("url is" + image.getAttribute("src"));
	         
	         Thread.sleep(2000);
	       
	         driver.close();
	        
	}

}