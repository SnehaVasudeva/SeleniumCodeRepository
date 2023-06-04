package openCartApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartRegisterPage {
	public static void main(String[] args) {

		BrowserUtil util = new BrowserUtil();
		WebDriver driver = util.initBrowser("chrome");
		util.getUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		util.maximizeWindow();
		String regTitle = util.displayTitle();
		String regUrl = util.displayCurrentUrl();

		Verify.verifyEquals(regTitle, "Register Account");
		Verify.verifyContains(regUrl, "https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		ElementUtil ele = new ElementUtil(driver);
		/**
		 * This to find the locators in registration page
		 */
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By phone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPwd = By.id("input-confirm");
		By chkBox = By.name("agree");
		By btnContinue = By.xpath("//input[@value='Continue']");
		By textSuccess = By.tagName("h1");
		By contAgain = By.xpath("//a[text()='Continue']");
		By verifyMyAcc = By.xpath("//h2[text()='My Account']");
		/**
		 * This is to check the placeholder values for each field in registration page
		 */
		String attrFirstName = ele.doGetAttribute(firstName, "placeholder");
		String attrLasttName = ele.doGetAttribute(lastName, "placeholder");
		String attrEmail = ele.doGetAttribute(email, "placeholder");
		String attrPhone = ele.doGetAttribute(phone, "placeholder");
		String attrPassword = ele.doGetAttribute(password, "placeholder");
		String attrConfPassword = ele.doGetAttribute(confirmPwd, "placeholder");

		System.out.println(attrFirstName);
		System.out.println(attrLasttName);
		System.out.println(attrEmail);
		System.out.println(attrPhone);
		System.out.println(attrPassword);
		System.out.println(attrConfPassword);
		
				

		ele.doSendKeys(firstName, "Tester");
		ele.doSendKeys(lastName, "QA");
		ele.doSendKeys(email, "opencarttest4@gmail.com");
		ele.doSendKeys(phone, "917288929934");
		ele.doSendKeys(password, "Test123#");
		ele.doSendKeys(confirmPwd, "Test123#");
		
		String verifyFname = ele.doGetAttribute(firstName, "value");
		System.out.println(verifyFname);

		
		String verifyLname = ele.doGetAttribute(lastName, "value");
		System.out.println(verifyLname);

		
		String verifyEmail = ele.doGetAttribute(email, "value");
		System.out.println(verifyEmail);

		
		String verifyPhone = ele.doGetAttribute(phone, "value");
		System.out.println(verifyPhone);

		
		String verifyPassword = ele.doGetAttribute(password, "value");
		System.out.println(verifyPassword);

	
		String verifyConfPassword = ele.doGetAttribute(confirmPwd, "value");
		System.out.println(verifyConfPassword);

//		ele.doClick(chkBox);
//		ele.doClick(btnContinue);
//		String regComplete = ele.getText(textSuccess);
//
//		Boolean flag = Verify.verifyEquals(regComplete, "Your Account Has Been Created!");
//		if (flag) {
//			System.out.println("Registration successfull");
//		} else
//			System.out.println("Registration not successfull");
////		ele.doClick(contAgain);
////		String MyAccDisplay = ele.getText(verifyMyAcc);
////		Verify.verifyEquals(MyAccDisplay, "My Account");
	}

}