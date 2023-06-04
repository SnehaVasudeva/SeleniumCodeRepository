package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class W3SchoolApp {

	static WebDriver driver;
	public static void main(String[] args) {
	
driver=new ChromeDriver();
driver.get("https://www.w3schools.com/html/html_tables.asp");
driver.manage().window().maximize();
	int rowSize=getRowCount();
	System.out.println(rowSize);
	int colmnSize=getColumnCount();
	System.out.println(colmnSize);
	//table[@id='customers']//tbody/tr[2]/td[1]
	System.out.println(getCustomerdetails("Alfreds Futterkiste"));
	getSpecificColumndata();
	System.out.println("-----------Table contents-------------");
	getAllDetailsFromTable();
	
	}
	
	public static int getRowCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
	}
	
public static int getColumnCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//th")).size();
	
		}

public static List<String> getCustomerdetails(String customerName) {
	
	List<WebElement> customerDetails=driver.findElements(By.xpath("//td[text()='"+customerName+"']/following-sibling::td"));
	List<String> customerDescription=new ArrayList<String>();
	for(WebElement e:customerDetails) {
		String text=e.getText();
		customerDescription.add(text);
		
	}
	return customerDescription;	
}

public static void getSpecificColumndata() {
String leftXpath= "//table[@id='customers']//tbody/tr[";
String rightXpath="]/td[1]";
for(int row=2;row<=getRowCount();row++) {
	String fullXpath=leftXpath +row+ rightXpath;
	String text=driver.findElement(By.xpath(fullXpath)).getText();
	System.out.println(text);
}

	}

//public static void getAllDetailsFromTable() {
//	
//	for(int row=2;row<=getRowCount();row++) {
//		for(int col=1;col<=getColumnCount();col++) {
//			String tableDetails=driver.
//					findElement(By.xpath("//table[@id='customers']/tbody/tr["+row+"]/td["+col+"]")).getText();
//			
//			System.out.print(tableDetails +" ");
//		}
//		System.out.println(" ");
//		
//	}
//
//}

public static void getAllDetailsFromTable() {
	List<WebElement> list=driver.findElements(By.xpath("//table[@id='customers']/tbody//td"));
	for(WebElement e:list) {
		String text=e.getText();
		System.out.println(text);
			
			
		}
		
}
}







