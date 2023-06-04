package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	static WebDriver driver;

	public static void searchElementList(By searchLocator, String searchText, By searchList, String suggestionName)
			throws InterruptedException {
		driver.findElement(searchLocator).sendKeys(searchText);
		Thread.sleep(3000);
		List<WebElement> suggestionList = driver.findElements(searchList);
		System.out.println(suggestionList.size());

		if (suggestionList.size() > 0) {
			for (WebElement e : suggestionList) {
				String text = e.getText();
				if (text.length() > 0) {
				
					if (text.contains(suggestionName)) {
						e.click();
						break;
					}
				}
					else
					{
						System.out.println("Blank Value -No suggestions");
					break;
					}
				} 
			}
		
			
				else
				{
					System.out.println("Suggestion name not found");
				}
			}
		
			
		
	

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("L2AGLb")).click();
		driver.findElement(By.xpath("//a[text()='English']")).click();
		By search = By.name("q");
		By searchList = By.xpath("//div[@class='lnnVSe']");

		searchElementList(search, "selenium", searchList, "webdriver");

	}

}
