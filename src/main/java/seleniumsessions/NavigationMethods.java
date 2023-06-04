package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class NavigationMethods {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.navigate().refresh();
		
		driver.get("http://www.saucedemo.com");
		driver.navigate().back();
//		driver.navigate().to("http://www.saucedemo.com");
//		driver.navigate().back();
//		driver.navigate().forward();
//		String page=driver.getPageSource();
//		System.out.println(page);
		

		

	}

}
