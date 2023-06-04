package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FramesConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		List<WebElement> frame=driver.findElements(By.tagName("iframe"));
		System.out.println(frame.size());
	Thread.sleep(5000);	

	driver.switchTo().frame("frame1");
	Thread.sleep(5000);
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("hello");
	
driver.switchTo().frame("frame3");

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");

		WebElement animals = driver.findElement(By.id("animals"));
		Select select = new Select(animals);
		select.selectByValue("avatar");
	}

}
