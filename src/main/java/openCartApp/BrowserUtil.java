package openCartApp;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
	WebDriver driver;

	public WebDriver initBrowser(String browser) {
		
		System.out.println("Launching the  browser " +browser);
		
		
		if(browser==null) {
			System.out.println("You have entered null as browser");
			throw new MyException("BROWSERNOTFOUNDEXCEPTION");
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
			break;
		}
		return driver;
					
		}
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public void getUrl(String url) {
		if(url==null) {
			throw new MyException("URLNOTFOUNDEXCEPTION");
		}
		
		if(url.contains("http")) {
			driver.get(url);
		}
		else
			System.out.println("You have not entered url with http(s)");
		
	}
	
	public void getUrl(URL url) {
		if(url==null) {
			throw new MyException("URLNOTFOUNDEXCEPTION");
		}
		
		String mainUrl=String.valueOf(url);
		if(mainUrl.contains("http")) {
			driver.get(mainUrl);
		}
		else
			System.out.println("You have not entered url with http(s)");
	}
	
	public String displayTitle() {
		return driver.getTitle();
	}
	
	public String displayCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void doQuit() {
		driver.quit();
	}
	
	public void doclose() {
		driver.close();
	}

}
