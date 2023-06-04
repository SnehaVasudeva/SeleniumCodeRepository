package openCartApp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {
	private WebDriver driver;
	public ElementUtil(WebDriver driver) {
	this.driver=driver;
	}
	
	

	public WebElement getElement(By locator) {
		WebElement element=null;
		try {
		element=driver.findElement(locator);
		
		}
		catch(NoSuchElementException e) {
			System.out.println("Element is not found " +locator);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
	
				e1.printStackTrace();
			}
			element=driver.findElement(locator);
			
		}
		return element;
	}
	
	public void doSendKeys(By locator,String value) {
		if(value==null) {
			throw new MyException("VALUENULLEXCEPTION");
		}
		doClear(locator);
		getElement(locator).sendKeys(value);
	}
	
	public void doClear(By locator) {
		getElement(locator).clear();
	}
	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String getText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doGetAttribute(By locator,String name) {
		return getElement(locator).getAttribute(name);
	}
	
	public  List<WebElement> getElements(By locator) {

		
		List<WebElement> list=driver.findElements(locator);
		
		return list;
		}
	public void displayLoctor(By footerLocator) {
		
		List<WebElement> listFooter=getElements(footerLocator);
		for(int i=0;i<listFooter.size();i++) {
			String text=listFooter.get(i).getText();
			System.out.println(text);
		}
	}
	
		
		public  void getSendkeys(By locator,String value) {
			getElement(locator).sendKeys(value);
		}
		public List<String> dogetElementsText(By locator) {
			
			List<WebElement> list=getElements(locator);
			List<String> elementsLinkList=new ArrayList<String>();
			int count=0;
			for(WebElement e:list) {
				String text=e.getText();
//				if(!text.isEmpty()) {
//					System.out.println(e.getText());
//				}
				if(text.length()>0) {
					System.out.println(count +" = " +text);
					
				}
				count++;
				elementsLinkList.add(text);
				
			}
			return elementsLinkList;
			
//			for(int i=0;i<list.size();i++) {
//				String text=list.get(i).getText();
//				if(!text.isEmpty()) {
//					System.out.println(i +" = " +text);
//				}
//			}
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
		/**
		 * This method is to find the specific list link and click on the specific link 		
		 * @param locator
		 * @param eleText
		 */
				
				public void ElementsSpecificList(By locator,String eleText) {
					List<WebElement> elementList=getElements(locator);
					
					System.out.println("Total count of footer links: " +elementList.size());
					
//					for(int i=0;i<elementList.size();i++) {
//						String text=elementList.get(i).getText();
//					
//					
//						if(text.equals(eleText))) {
//							elementList.get(i).click();
//							
//							//break;
							
//						}
//					}
					for(WebElement e:elementList) {
						String text=e.getText();
						if(text.equals(eleText)) {
							
							e.click();
							break;
						}
					}
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
						
				public  void selectDropdownVisibleText(By locator,String name) {
					
					Select select=new Select(getElement(locator));
					select.selectByVisibleText(name);
				}
				
				public  void selectDropdownIndex(By locator,int index) {
					
					Select select=new Select(getElement(locator));
					select.selectByIndex(index);
				}
				
				public  void selectDropdownValue(By locator,String name) {
					
					Select select=new Select(getElement(locator));
					select.selectByValue(name);
				}
				
				public  int dropDownSize(By locator) {
					Select select=new Select(getElement(locator));
					List<WebElement> allOptions=select.getOptions();
					return allOptions.size();
				}
				
				public  List<String> getAllDropdownOptions(By locator) {
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
					
					
				
				public  void doSelectDropDownValue(By locator,String name) {
					List<WebElement> listDropDown=getElements(locator);
					
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
						//System.out.println(listText);
						if(flag==false) {
							System.out.println(name +" dropdown option is not available");
						
					}
					
					
					
					
				}

	
				}
			


