package seleniumsessions;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonClass {

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil bu = new BrowserUtil();
		WebDriver driver=bu.initDriver("chrome");
		bu.launchUrl("https://www.amazon.com");
		String actTitle=bu.getPageTitle();
		System.out.println(actTitle);
		Verify.verifyEquals(actTitle, "Amazon.com. Spend less. Smile more.");
		String actUrl=bu.getPageURL();
		System.out.println(actUrl);
		Verify.verifyContains(actUrl, "amazon.com");

		ElementUtil util=new ElementUtil(driver);
		
		By searchLocator=By.id("twotabsearchtextbox");
		
//		boolean elementDisplay=util.isDisplayedElement(searchLocator);
//		if(elementDisplay) {
//			util.getSendkeys(searchLocator, "Easter");
			
			By searchList = By.xpath("//div[@class='s-suggestion-container']");

			util.searchElementList(searchLocator, "Easter", searchList, "eggs");
		}
	
	
}
		
		
	
	
//		By totalLinks= By.tagName("a");
//		util.dogetText(totalLinks);
//		int listSize=util.listSize(totalLinks);
//		System.out.println(listSize);
//		
//		By images= By.tagName("img");
//		List<String> listImages=util.dogetElementsAttribute(images, "alt");
//		if(listImages.contains("Keyboards")) {
//			System.out.println("Pass");
//		}
//		int totalImages=util.listSize(images);
//		System.out.println(totalImages);
		
		//bu.quitBrowser();




