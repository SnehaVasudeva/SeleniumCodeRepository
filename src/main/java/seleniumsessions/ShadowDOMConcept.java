package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMConcept {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	String jspath = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
JavascriptExecutor js=(JavascriptExecutor)driver;
WebElement ele=(WebElement)js.executeScript(jspath);
ele.sendKeys("cheese pizza");
	}

}
