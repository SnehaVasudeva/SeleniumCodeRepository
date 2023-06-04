package windowHandlers;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlerConcept1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'facebook.com')]")).click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		System.out.println("Facebook URL " + driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentID);
		System.out.println("Parent URL " + driver.getCurrentUrl());
		driver.quit();
	}

}
