package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXPath {
	static WebDriver driver;
	public static void main(String[] args) {
	 driver=new ChromeDriver();
	driver.get("https://selectorshub.com/xpath-practice-page/");
	//getColumnValues("Get to Know Us");
	selectUser("Joe.Root");
	List<String> userDetails=getUserTableValues("Joe.Root");
	System.out.println(userDetails);
	}
	
//	public static void getColumnValues(String columnName) {
//		System.out.println(columnName);
//		List<WebElement> columnValues=driver.findElements(By.xpath("//div[text()='"+columnName+"']/following-sibling::ul//a"));
//		for(WebElement e:columnValues) {
//			String text=e.getText();
//			System.out.println(text);
//			
//			
//		}
//	}
	
	public static void selectUser(String userName) {
		driver.findElement(By.xpath("//a[text()='"+userName+"']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
	}

	public static List<String> getUserTableValues(String userName) {
		System.out.println(userName);
		List<WebElement> userValues=driver.findElements(By.xpath("//a[text()='Joe.Root']/parent::td/following-sibling::td"));
		List<String> employeeDetail=new ArrayList<String>();
		for(WebElement e:userValues) {
			String text=e.getText();
			//System.out.println(text);
			employeeDetail.add(text);
		
						
		}
		return employeeDetail;
	}

}
