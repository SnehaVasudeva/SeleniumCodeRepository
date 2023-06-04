package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElement {
static WebDriver driver;
	public static void main(String[] args) {
		 driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		mandatoryFields("input-firstname");
		
	}
	
	public static void mandatoryFields(String value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String mandField=js.executeScript(("return window.getComputedStyle(document.querySelector(\"label[for='"+value+"']\"),'::before').getPropertyValue('content')")).
				toString();
				
		System.out.println(mandField);
		if(mandField.contains("*")) {
			System.out.println("This is a mandatory field");
		}
	}

}
