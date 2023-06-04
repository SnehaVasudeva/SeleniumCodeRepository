package windowHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlerConceptList3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'facebook.com')]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
List<String>windowList=new ArrayList<String>(windowHandles);
String parentId=windowList.get(0);
String childId=windowList.get(1);
driver.switchTo().window(childId);
System.out.println("Child url " +driver.getCurrentUrl());
driver.close();
driver.switchTo().window(parentId);
System.out.println("Parent url " +driver.getCurrentUrl());
driver.quit();
	}

}
