package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.manager.SeleniumManager;

public class SeleniumManagerConcept {

	public static void main(String[] args) {
//		ChromeOptions co=new ChromeOptions();
//        co.addArguments("--remote-allow-origins=*");
//		 WebDriver driver=new ChromeDriver(co);
		 WebDriver driver=new EdgeDriver();
		// String cPath=SeleniumManager.getInstance().getDriverPath("chromedriver");
		 String cPath=SeleniumManager.getInstance().getDriverPath("geckodriver");
		 System.out.println(cPath);

	}

}
