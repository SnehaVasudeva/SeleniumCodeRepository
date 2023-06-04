package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class QuitAndClose {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(co);
	driver.get("https://www.amazon.com");
	System.out.println(driver.getTitle());
	Thread.sleep(5000);
	driver.close();
	//System.out.println(driver.getTitle());

	}

}
