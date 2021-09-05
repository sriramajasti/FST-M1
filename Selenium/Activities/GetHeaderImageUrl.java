package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetHeaderImageUrl {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		WebElement imgsrc=driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		System.out.println("Header image URL is: "+imgsrc.getAttribute("src"));
		driver.close();
	}
}
