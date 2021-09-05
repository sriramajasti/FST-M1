package seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class HRMProject {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);
//        Assert.assertEquals(title,"OrangeHRM");	
        if(title.matches("OrangeHRM"))
        {
        	System.out.println("Page title is Orange HRM close the browser");
        	driver.close();
        }
        else
        	System.out.println ("Page title is not Orange HRM");
//        try {
//            Assert.assertEquals(title, "OrangeHRM");
//            System.out.println("Page title is Orange HRM close the browser");
//            driver.close();
//          } catch (AssertionError e) {
//            System.out.println("Not equal");
//            throw e;
//          }
	}
}


