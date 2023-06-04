package seleniumsessions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsAction {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB)
			.sendKeys(Keys.TAB)
			  .sendKeys(Keys.TAB)
			  .sendKeys(Keys.TAB)
			  .sendKeys(Keys.TAB)
			  	.sendKeys("MAcbook Pro")
			  		.sendKeys(Keys.ENTER).perform();
			  
			 // .build();
		


	}

}
