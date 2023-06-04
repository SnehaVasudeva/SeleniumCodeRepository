package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultSelectDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		driver.manage().window().maximize();
		By singleSelectDropdown = By.id("select-demo");
		By multipleDropDown = By.id("multi-select");
		WebElement singledd = driver.findElement(singleSelectDropdown);
		WebElement multipledd = driver.findElement(multipleDropDown);

		Select select1 = new Select(singledd);
		Select select2 = new Select(multipledd);
		System.out.println(select1.isMultiple());
		System.out.println(select2.isMultiple());
		

		select2.selectByVisibleText("California");
		select2.selectByVisibleText("Florida");
		select2.selectByValue("Pennsylvania");
		select2.selectByIndex(4);
//		
		System.out.println(select2.getFirstSelectedOption().getText());
		List<WebElement> selectedList=select2.getAllSelectedOptions();
	for(WebElement e:selectedList) {
		String text=e.getText();
		System.out.println(text);
			}
	select2.deselectByVisibleText("California");
	select2.deselectByValue("Pennsylvania");
//	select2.deselectByIndex(4);
	select2.deselectAll();
	}

}
