package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept {
 static WebDriver driver;
	public static void main(String[] args) {
 driver=new ChromeDriver();
driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//Approach 1:
//driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//driver.findElement(By.id("input-password")).sendKeys("test@123");

//Approach 2:
//WebElement emailId=driver.findElement(By.id("input-email"));
//WebElement password= driver.findElement(By.id("input-password"));
//
//emailId.sendKeys("test@gmail.com");
//password.sendKeys("test@123");
//	}

	//Approach 3
	
//	By email=By.id("input-email");
//	By pwd=By.id("input-password");
//	
//	WebElement emailId=driver.findElement(email);
//	WebElement password=driver.findElement(pwd);
//	
//	emailId.sendKeys("test@gmail.com");
//	password.sendKeys("test@123");
	
	//Approach 4:
//	By email=By.id("input-email");
//	By pwd=By.id("input-password");
//	
//	WebElement emailId=getElement(email);
//	WebElement password=getElement(pwd);
//	emailId.sendKeys("test@gmail.com");
//	password.sendKeys("test@123");
	
	//Approach 5
//	By email=By.id("input-email");
//	By pwd=By.id("input-password");
//
//	
//	getSendkeys(email, "test@gmail.com");
//	getSendkeys(pwd, "test@123");
	
	//Approach 6
By email=By.id("input-email");
By pwd=By.id("input-password");
	ElementUtil ele=new ElementUtil(driver);

	ele.getSendkeys(email, "test@gmail.com");
	ele.getSendkeys(pwd, "test@123");
}
//	public static WebElement getElement(By locator) {
//		return driver.findElement(locator);
//	}
//	
//	public static void getSendkeys(By locator,String value) {
//		getElement(locator).sendKeys(value);
//	}
	

}
