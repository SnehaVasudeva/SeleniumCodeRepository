package openCartApp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterScenarios {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil utilBr = new BrowserUtil();
		driver = utilBr.initBrowser("Chrome");
		utilBr.getUrl("https://naveenautomationlabs.com/opencart/");
		utilBr.maximizeWindow();
		// ElementUtil utilEle=new ElementUtil(driver);
		By footerLocator = By.xpath("//footer//a");
		By aboutUsLink = By.linkText("About Us");
		getFooterLinks(footerLocator);
		String actTitle=doclickLink(aboutUsLink);
		Verify.verifyEquals(actTitle, "About Us");

//		By emailId = By.id("input-email");
//		By pwd = By.id("input-password");
//		By click = By.xpath("//input[@value='Login']");
//		List<String> footerList = getFooterLinks(footerLocator);
//
//	
//		doSendKeys(emailId, "opencarttest4@gmail.com");
//		doSendKeys(pwd, "Test123#");
//		doClick(click);
//		Thread.sleep(1000);

	}

	public static void doSendKeys(By locator, String value) {

		getElement(locator).sendKeys(value);
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<String> getFooterLinks(By locator) {
		List<WebElement> footerList = getElements(locator);
		List<String> footerTextList = new ArrayList<String>();
		for (WebElement e : footerList) {
			String text = e.getText();
			footerTextList.add(text);
			System.out.println(text);
		}
		return footerTextList;
	}

	public static String doclickLink(By locator) {

		WebElement linkText = getElement(locator);
		linkText.click();
		String title=driver.getTitle();
return title;
	}
}
