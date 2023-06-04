package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;

public class RelativeLocatorRegistration {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	WebElement radioBtnNo=driver.findElement(By.xpath("//input[@value='0' and @type='radio']"));
	driver.findElement(with(By.tagName("input")).toLeftOf(radioBtnNo)).click();
	
//	WebElement radioBtnYes=driver.findElement(By.xpath("//input[@value='1' and @type='radio']"));
//	driver.findElement(with(By.tagName("input")).toRightOf(radioBtnYes)).click();
	
	WebElement policy=driver.findElement(By.linkText("Privacy Policy"));
	driver.findElement(with(By.tagName("input")).toRightOf(policy)).click();

	}

}
