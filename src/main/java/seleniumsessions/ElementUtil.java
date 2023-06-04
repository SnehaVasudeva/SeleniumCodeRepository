package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public  WebElement getElement(By locator) {
		
		return driver.findElement(locator);
	}
	
public  List<WebElement> getElements(By locator) {

		
	List<WebElement> list=driver.findElements(locator);
	
	return list;
	}
	
	public  void getSendkeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	public void dogetText(By locator) {
		
		List<WebElement> list=getElements(locator);
		
		for(WebElement e:list) {
			String text=e.getText();
			
		
			if(text.length()>0) {
				System.out.println(text);
				
			}
	
			
		}
		
//		for(int i=0;i<list.size();i++) {
//			String text=list.get(i).getText();
//			if(!text.isEmpty()) {
//				System.out.println(i +" = " +text);
//			}
//		}
	}
		public boolean isDisplayedElement(By locator) {
			return getElement(locator).isDisplayed();
		}
		
		public int listSize(By locator) {
			return getElements(locator).size();
		}
		
			public List<String> dogetElementsAttribute(By locator,String name) {
				
				List<WebElement> list=getElements(locator);
				List<String> listImage=new ArrayList<String>();
				for(WebElement e:list) {
					String image= e.getAttribute(name);
					
				listImage.add(image);
					}
			
			return listImage;
			
			
				
			}
			public  void searchElementList(By searchLocator, String searchText, By searchList, String suggestionName)
					throws InterruptedException {
				getSendkeys(searchLocator, searchText);
				
				Thread.sleep(3000);
				List<WebElement> suggestionList = getElements(searchList);
				System.out.println(suggestionList.size());
			
				if (suggestionList.size() > 0) {
					for (WebElement e : suggestionList) {
						String text = e.getText();
						if (text.length() > 0) {
						System.out.println(text);
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
						else {
							System.out.println("No search suggestions");
						}
							
					}
					
					
				
			
}



