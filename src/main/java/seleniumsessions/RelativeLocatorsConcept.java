package seleniumsessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;

public class RelativeLocatorsConcept {

	public static void main(String[] args) {
	
WebDriver driver=new ChromeDriver();
driver.get("https://www.aqi.in/dashboard/china");
WebElement stationText=driver.findElement(By.linkText("Baotou, China"));

String pmLevel=driver.findElement(with(By.tagName("p")).toRightOf(stationText)).getText();
System.out.println(pmLevel);
String rank=driver.findElement(with(By.tagName("p")).toLeftOf(stationText)).getText();
System.out.println(pmLevel);
String city=driver.findElement(with(By.tagName("p")).below(stationText)).getText();
System.out.println(city);
String city1=driver.findElement(with(By.tagName("p")).above(stationText)).getText();
System.out.println(city1);

String near=driver.findElement(with(By.tagName("p")).near(stationText)).getText();
System.out.println(near);
	}

}
