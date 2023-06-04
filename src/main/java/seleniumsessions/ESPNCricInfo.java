package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ESPNCricInfo {

		static WebDriver driver;
			public static void main(String[] args) {
			
		driver=new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/indian-premier-league-2023-1345038/delhi-capitals-vs-mumbai-indians-16th-match-1359490/full-scorecard");
		driver.manage().window().maximize();
		List<String> playerInfo=getPlayerDetails("Cameron Green");
		System.out.println(playerInfo);
		
			}
			
					
public static List<String> getPlayerDetails(String playerName) {
	List<WebElement> playerDetails=driver.
			findElements(By.xpath("//span[text()='"+playerName+"']//ancestor::td[@class='ds-flex ds-items-center']/following-sibling::td"));
	List<String> playerInfo= new ArrayList<String>();
	for(WebElement e:playerDetails) {
		String text=e.getText();
		
		playerInfo.add(text);
	}
	return playerInfo;
	
}
}
