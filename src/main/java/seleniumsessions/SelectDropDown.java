package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
public static WebDriver driver;
	public static void main(String[] args) {

driver=new ChromeDriver();

driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
driver.manage().window().maximize();
By dropDownLocator=By.id("Form_getForm_Country");
By LocatorDropdown=By.xpath("//select[@id='Form_getForm_Country']/option)");

//selectDropdownVisibleText(dropDownLocator,"India");
//selectDropdownIndex(dropDownLocator,5);
//selectDropdownValue(dropDownLocator,"Iceland");
//getAllDropdownOptions(dropDownLocator);
doSelectDropdownValue(dropDownLocator,"Africa");

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void selectDropdownVisibleText(By locator,String name) {
	
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(name);
	}
	
	public static void selectDropdownIndex(By locator,int index) {
		
		Select select=new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void selectDropdownValue(By locator,String name) {
		
		Select select=new Select(getElement(locator));
		select.selectByValue(name);
	}
	
	public static int dropDownSize(By locator) {
		Select select=new Select(getElement(locator));
		List<WebElement> allOptions=select.getOptions();
		return allOptions.size();
	}
	
	public static List<String> getAllDropdownOptions(By locator) {
		Select select=new Select(getElement(locator));
		List<WebElement> allOptions=select.getOptions();
		List<String> listText=new ArrayList<String>();
		System.out.println(allOptions.size());
		for(WebElement e:allOptions) {
			String text=e.getText();
			listText.add(text);
		
			}
		return listText;
		}
	
	
		
	
	public static boolean doSelectDropdownValue(By locator,String name) {
		List<WebElement> listDropDown=driver.findElements(locator);
		
		boolean flag=false;
		for(WebElement e:listDropDown) {
			
			String text=e.getText();
		System.out.println(text);
		
			if(text.equals(name)) {
				
				e.click();
				flag=true;
			     break;
			}
		}
		
			if(flag==false) {
				System.out.println(name +" dropdown option is not available");
			
		}
		
		
			return flag;
		
	}


}
