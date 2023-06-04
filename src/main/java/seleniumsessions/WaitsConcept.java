package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsConcept {
public static WebDriver driver;
	public static void main(String[] args) {
		 driver = new ChromeDriver();
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		 driver.get("https://classic.freecrm.com/");
		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		alertGetText(5);
//		alertAccept(3);
//		alertSendKeys(3, "hello");
		By forgotPwd=By.linkText("Forgot Password?");
		readyForClick(3,forgotPwd);
		String title=verifyTitle("CRMPRO Log In Screen",4);
		System.out.println(title);
		


	}
	public static void readyForClick(int timeout,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public static String verifyTitle(String fullTitle,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.titleIs(fullTitle))) {
			String title=driver.getTitle();
			return title;
		}
			else {
				System.out.println("Title is not present on web page with the given timeout ");
		return null;
			}
		}
	
	
	public static Alert alertIsPresent(int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));	
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void alertGetText(int timeout) {
		alertIsPresent(timeout).getText();
	}
	
	public static void alertAccept(int timeout) {
		alertIsPresent(timeout).accept();
	}
	
	public static void alertDismiss(int timeout) {
		alertIsPresent(timeout).dismiss();
	}
	
	public static void alertSendKeys(int timeout,String value) {
		alertIsPresent(timeout).sendKeys(value);
	}
}
