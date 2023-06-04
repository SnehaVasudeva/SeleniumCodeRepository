package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRMApplication {
static WebDriver driver;
	public static void main(String[] args) {
	
driver=new ChromeDriver();
driver.get("https://classic.freecrm.com/");
driver.manage().window().maximize();
driver.findElement(By.name("username")).sendKeys("Newautomation");
driver.findElement(By.name("password")).sendKeys("Selenium@12345");
driver.findElement(By.xpath("//input[@type='submit']")).click();
driver.switchTo().frame("mainpanel");
driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//selectContact("Ali khan");
multiplesameNames("Ali khan");

String companyName=getCompanyName("deepti gupta");
String phoneNumber=getPhoneNumber("deepti gupta");
String email=getEmail("deepti gupta");
System.out.println(companyName +" " +phoneNumber +" " +email);
List<String> listDetails=getAlldetails("deepti gupta");
System.out.println(listDetails);

	}
	
	public static void selectContact(String contactName) {
		driver.findElement(By.xpath("//a[text()='"+contactName+"']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
	}
	public static void multiplesameNames(String contactName) {
		List<WebElement> sameNameContacts=driver.findElements(By.xpath("(//a[text()='"+contactName+"'])/parent::td/preceding-sibling::td/input[@type='checkbox']"));
		for(WebElement e:sameNameContacts) {
			e.click();
		}
		
		
		}
	
	public static List<String> getAlldetails(String contactName) {
		List<WebElement> contactDetails=driver.findElements(By.xpath("//a[text()='\"+contactName+\"']/parent::td/following-sibling::td"));
		List<String> contactDetailsList= new ArrayList<String>();
		for(WebElement e:contactDetails) {
			String text=e.getText();
			contactDetailsList.add(text);
		}
		return contactDetailsList;
	}
	public static String getCompanyName(String contactName) {
		return driver.findElement(By.xpath("//a[text()='"+contactName+"']/parent::td/following-sibling::td/a[@context='company']")).getText();
	}
	
	public static String getPhoneNumber(String contactName) {
		return driver.findElement(By.xpath("//a[text()='"+contactName+"']/parent::td/following-sibling::td/span[@context='phone']")).getText();
	}
	
	public static String getEmail(String contactName) {
		return driver.findElement(By.xpath("(//a[text()='deepti gupta']/parent::td/following-sibling::td/a)[2]")).getText();

}
}
