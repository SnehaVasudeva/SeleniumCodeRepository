package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameShadowDOM {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	
driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
driver.manage().window().maximize();
Thread.sleep(2000);
driver.switchTo().frame("pact");
String jsPath= "return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")";
JavascriptExecutor js=(JavascriptExecutor)driver;
WebElement ele=(WebElement)js.executeScript(jsPath);
ele.sendKeys("Green Tea");



	
	}

}
