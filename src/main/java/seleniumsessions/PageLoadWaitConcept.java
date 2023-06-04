package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoadWaitConcept {
	public static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//pageLoadTimeout(20);
		if(isPageLoaded(20)) {
			System.out.println("Page is fully loaded");
		}

	}
	
	public static Boolean isPageLoaded(int timeout) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(timeout));
		String state=wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\'complete\'")).toString();
		return Boolean.parseBoolean(state);
	}

	public static void pageLoadTimeout(int timeout) {
		long endTime = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < endTime) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String state = js.executeScript("return document.readyState").toString();
			if (state.equals("complete")) {
				System.out.println("Page is fully loaded");
				break;

			} else {
				System.out.println("page is not loaded yet");
			}
		}
	}
	
	

}
