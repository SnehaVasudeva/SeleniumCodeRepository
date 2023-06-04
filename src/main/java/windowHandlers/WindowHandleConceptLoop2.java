package windowHandlers;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleConceptLoop2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//a[contains(@href,'linkedin.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'facebook.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'twitter.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'youtube.com')]")).click();
	String parentID=driver.getWindowHandle();
	
Set<String> windowHandle= driver.getWindowHandles();
 
Iterator<String> it=windowHandle.iterator();
while(it.hasNext()) {
String windowID=it.next();

if(!windowID.equals(parentID)) {
	driver.switchTo().window(windowID);
		System.out.println("Child URL " +driver.getCurrentUrl());
		driver.close();
}
}
driver.switchTo().window(parentID);
System.out.println("Parent URL " +driver.getCurrentUrl());
	driver.quit();
}
	

	}


