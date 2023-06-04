package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreshWorks {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
driver=new ChromeDriver();
driver.get("https://www.freshworks.com/");
driver.manage().window().maximize();
Thread.sleep(5000);
driver.findElement(By.id("onetrust-accept-btn-handler")).click();
By footerLocator=By.xpath("//nav[@class='sc-662dedcb-0 fMAcTI']//ul/li/a/span");
getFooterList(footerLocator);
	}
	
	public static void getFooterList(By footerLocator) {
		List<WebElement> list=driver.findElements(footerLocator);
		System.out.println(list.size());
		for(WebElement e:list) {
			String text=e.getText();
			System.out.println(text);
			
		}
		
	}

}
