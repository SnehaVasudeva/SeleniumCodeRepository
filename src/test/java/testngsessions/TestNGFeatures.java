package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGFeatures {
	
	@BeforeSuite
	public void dbConnection() {
		System.out.println("BS-Connect to db");
		
			}
	
	@BeforeTest
	public void createUser() {
		System.out.println("BT-Connect to db");
	}
	
	@BeforeClass
	public void openBrowser() {
		System.out.println("BC-Open Browser");
	}
	
	@BeforeMethod
	public void loginToApp() {
		System.out.println("BM-Login to app");
	}
	
	@Test
	public void searchUserTest() {
		System.out.println("Test-Search User");
	}
	
	@Test
	public void addToCartTest() {
		System.out.println("Test-Add to Cart");
	}
	
	@Test
	public void registerUserTest() {
		System.out.println("Test-RegisterUser");
	}
	
	@AfterMethod
	public void logOut() {
		System.out.println("AM-Log out");
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("AT-Close Browser");
	}
	
	@AfterClass
	public void deleteUser() {
		System.out.println("AC-Delete User");
	}
	
	@AfterSuite
	public void dbDisconnect() {
		System.out.println("AS-Disconnect from db");
	}
	
	
}
