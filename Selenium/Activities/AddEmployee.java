package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployee {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");
		//input[@id='txtPassword']
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_pim_viewPimModule']")));
//		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.xpath("//a[@id='//input[@id='btnAdd']")).click();
		//input[@id='firstName']
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Test1");
		//input[@id='middleName']
		driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys("FST");
		//input[@id='lastName']
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Aug");
		//input[@id='btnSave']
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
		//input[@id='btnAddAttachment']
		driver.findElement(By.xpath("//input[@id='btnAddAttachment']")).click();
		WebElement chooseFile = driver.findElement(By.xpath("//input[@id='ufile']"));
		chooseFile.sendKeys("C:\\Users\\JASTISRIRAMAMURTHY\\Desktop\\Errors_Screen.png");
		driver.findElement(By.xpath("//input[@id='btnSaveAttachment']")).click();
		
		
		
}
}
