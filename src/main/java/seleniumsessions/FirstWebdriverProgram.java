package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstWebdriverProgram {
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		String browser="firefox";
		WebDriver driver=null;
	
		switch(browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SNEHA\\Downloads\\chromedriver.exe");
			ChromeOptions co=new ChromeOptions();
            co.addArguments("--remote-allow-origins=*");
			 driver=new ChromeDriver(co);
			break;
		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\SNEHA\\Downloads\\geckodriver.exe");
			driver=new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "C:\\Users\\SNEHA\\Downloads\\msedgedriver.exe");
			driver=new EdgeDriver();
			break;
		default:System.out.println("Please pass the right browser");
			break;
		}
			driver.get("https://www.amazon.com/");
			String title=driver.getTitle();	
			System.out.println(title);
			if(title.contains("Amazon.com")) {
				System.out.println("Correct title");
			}
			else
				System.out.println("Incorrect title");
			
	
//driver.quit();

		
		
		
		

	}

}
