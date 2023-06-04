package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {

	WebDriver driver;

	public WebDriver initDriver(String browser) {
		System.out.println("Launching the browser " + browser);
		if(browser==null) {
			System.out.println("URL cannot be null");
			throw new MyException("BROWSERNULLEXCEPTION");
		}
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":

			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Please pass the right browser");
			throw new MyException("BROWSERNOTCORRECT");
		}
		return driver;
	}
	
	
	public void launchUrl(String url) {
		if(url==null) {
			System.out.println("URL cannot be null");
			throw new MyException("URLNULLEXCEPTION");
		}
		if(url.contains("http"))
		{
		driver.get(url);
		}
		else
			System.out.println("http(s) is missing");
	}
	
	public void launchUrl(URL url) {
		if(url==null) {
			System.out.println("URL cannot be null");
			throw new MyException("URLNULLEXCEPTION");
		}
		String mainUrl= String.valueOf(url);
		if(mainUrl.contains("http")) {
			driver.navigate().to(url);
		}
		else
			System.out.println("http(s) is missing");
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	public void quitBrowser() {
		driver.quit();
	}

	public void closeBrowser() {
		driver.close();
	}
}