package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMApp {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		By userName=By.xpath("//input[@placeholder='Username']");
		By password=By.name("password");
		By loginBtn=By.xpath("//button[@type='submit']");
		By adminModule=By.xpath("//span[text()='Admin']");
		
		doSendKeys(userName,"Admin");
		doSendKeys(password,"admin123");
		doClick(loginBtn);
		Thread.sleep(3000);
		doClick(adminModule);
		Thread.sleep(3000);
		doclickEmpCheckbox("Cassidy.Hope");
		System.out.println(employeeDetailsRightSide("Cassidy.Hope"));
		System.out.println("Row count " +getRowSize());
		System.out.println("Column count " +getColumnSize());
		getSingleColumnList();
		getAllTableData();
	
		getEmpEnabledStatusCount();
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator,String name) {
		getElement(locator).sendKeys(name);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static void doclickEmpCheckbox(String employeeName) {
		driver.findElement(By.xpath("//div[text()='"+employeeName+"']/parent::div/preceding-sibling::div[@role='cell']")).click();
	}
	
	public static List<String> employeeDetailsRightSide(String employeeName) {
		List<WebElement> empDetailsList= driver.findElements(By.xpath("//div[text()='"+employeeName+"']/parent::div/following-sibling::div"));
		List<String> empListDetails=new ArrayList<String>();
		for(WebElement e:empDetailsList) {
			String text=e.getText();
			if(!text.isEmpty()) {
			empListDetails.add(text);
			}
		}
		return empListDetails;
		
	}

	
	
	public static int getRowSize() {
		return driver.findElements(By.xpath("//div[@role='table']//div[@role='rowgroup']/div")).size();
	}
	
	public static int getColumnSize() {
		return driver.findElements(By.xpath("//div[@role='table']/div[@role='rowgroup']//div[@role='columnheader']")).size();
	}
	
	public static void getSingleColumnList(){
		List<WebElement> list= driver.findElements(By.xpath("//div[@role='table']//div[@role='row']//div[@role='cell'][2]"));
	
		for(WebElement e:list) {
			String text=e.getText();
			System.out.println(text);
	}
	}
	
	public static void getAllTableData() {
	
	
		for(int row=2;row<=getRowSize();row++){
			for(int cell=1;cell<=getColumnSize();cell++)
			{
				String text=driver.findElement(By.xpath("((//div[@role='table']//div[@role='row'])["+row+"]//div[@role='cell'])["+cell+"]")).getText();
				if(!text.isEmpty()) {
					System.out.print(text +" ");
				}
				
		}
			
			System.out.println();
		}
		
	}
	
	public static void getEmpEnabledStatusCount() {
		
		int count=0;	
		
		for(int row=2;row<=getRowSize();row++){
			
			String textEnable=driver.findElement(By.xpath("(//div[@role='table']//div[@role='row'])["+row+"]//div[@role='cell'][5]")).getText();
			
			if(textEnable.equals("Enabled")) {
				count++;
				for(int cell=1;cell<=getColumnSize();cell++) {
				String text=driver.findElement(By.xpath("(//div[@role='table']//div[@role='row'])["+row+"]//div[@role='cell']["+cell+"]")).getText();
				System.out.println(text);
				}
		}
			
		
						
				}
		System.out.println("Count of enabled status " +count);
		
	
}
	}

