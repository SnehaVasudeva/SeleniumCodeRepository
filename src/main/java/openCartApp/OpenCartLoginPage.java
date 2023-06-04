package openCartApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCartLoginPage {

	public static void main(String[] args) {
		BrowserUtil browUtil = new BrowserUtil();
		WebDriver driver = browUtil.initBrowser("chrome");
		browUtil.getUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		try {
			browUtil.getUrl(new URL("https://naveenautomationlabs.com/opencart/index.php?route=account/login"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String actTitle = browUtil.displayTitle();
		System.out.println(actTitle);
		Verify.verifyEquals(actTitle, "Account Login");
		String actUrl = browUtil.displayCurrentUrl();
		System.out.println(actUrl);
		Verify.verifyContains(actUrl, "https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		ElementUtil ele = new ElementUtil(driver);

		By emailId = By.id("input-email");
		By pwd = By.id("input-password");
		By click = By.xpath("//input[@value='Login']");
		By rightPanelList = By.className("list-group-item");
		By footerList = By.xpath("//footer//a");

		System.out.println("-------Before login-----------");

		int rightPanelListBeforeLoginCount = ele.listSize(rightPanelList);
		System.out.println("Total count before login " + rightPanelListBeforeLoginCount);

		List<String> listRightPanelTextBeforeLogin = ele.dogetElementsText(rightPanelList);

		ele.doSendKeys(emailId, "opencarttest4@gmail.com");

		ele.doSendKeys(pwd, "Test123#");
		ele.doClick(click);
		System.out.println("-------After login-----------");

		int rightPanelListAfterLoginCount = ele.listSize(rightPanelList);
		System.out.println("Total count after login " + rightPanelListAfterLoginCount);
		List<String> listRightPanelTextAfterLogin = ele.dogetElementsText(rightPanelList);
		if (listRightPanelTextAfterLogin.contains("Logout")) {
			System.out.println("LogOut is available");
		} else {
			System.out.println("Logout  not available");
		}

		ele.ElementsSpecificList(rightPanelList, "Logout");

		ele.dogetElementsText(footerList);
		ele.ElementsSpecificList(footerList, "Brands");

		// browUtil.doQuit();
	}

}
