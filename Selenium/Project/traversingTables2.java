package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class traversingTables2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/crm/");
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		//input[@id='txtPassword']
		driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
		driver.findElement(By.xpath("//a[@id='grouptab_0']")).click();
		driver.findElement(By.xpath("//a[@id='moduleTab_9_Leads']")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table [@class='list view table-responsive']")));

		//table [@class='list view table-responsive']/tbody/tr[2]
		int n=10;
		for (int i = 1; i <= n; i++) {
			   
				
				WebElement nameValue=driver.findElement(By.xpath("//table [@class='list view table-responsive']/tbody/tr["+i+"]/td[@type='name']"));
				String userName=nameValue.getText();
				System.out.print("User Name  from :"+i+" row is"+userName);
				WebElement userValue=driver.findElement(By.xpath("//table [@class='list view table-responsive']/tbody/tr["+i+"]/td[@type='relate']"));
				String userLevel=userValue.getText();
				System.out.print("\t\t\t\t\t\t\t\tUser permission level from "+i+" row is "+userLevel);
				System.out.println();
//				System.out.println("Iteration is :"+i);
			}
		

}

}
