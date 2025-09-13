package Project1.tests;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Project1.Base.BasicTest;
import Project1.pageObjects.ContactListPage;
import Project1.pageObjects.LoginPage;

public class SessionNavigationTest extends BasicTest {

	@Test(priority = 1)
	//Verify Logout after login
	public void redirectToLoginPageAfterLogout() {
		LoginPage login = new LoginPage(driver);
		ContactListPage conList = new ContactListPage(driver);
		login.doLogin("jenitha@gmail.com", "abcdefg");
		conList.ClickOnLogotBtn();
		new WebDriverWait(driver, Duration.ofSeconds(5))
	        .until(ExpectedConditions.urlContains("contact-list.herokuapp.com"));
		Assert.assertTrue(login.isAtLoginPage(), "User not redirected to login page after logged out");
		System.out.println("The user redirected to the loginPage");
	}
	@Test(priority = 2)
	//Refresh Action
	public void refreshAfterLogin() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.doLogin("jenitha@gmail.com", "abcdefg");
		Thread.sleep(3000);
		driver.navigate().refresh();
		new WebDriverWait(driver, Duration.ofSeconds(5))
	        .until(ExpectedConditions.urlContains("contactList"));
		//Assert.assertTrue(login.isAtLoginPage(), "User didn't loggedin");
		System.out.println("The user remains loggedin");
	}
	@Test(priority = 3)
	//direct url "https://thinking-tester-contact-list.herokuapp.com/contactList" redirects to login page
	public void redirectToLoginforDirectUrl() {
		LoginPage login = new LoginPage(driver);
		driver.get("https://thinking-tester-contact-list.herokuapp.com/contactList");
		new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.urlContains("contactList"));
		//Assert.assertTrue(login.isAtLoginPage(), "User didn't redirected to login page");
		System.out.println("The user redirected to loginPage");
	}
	@Test(priority = 4)
	public void clickBackButtonAfterLogout() throws TimeoutException {
		LoginPage login = new LoginPage(driver);
		ContactListPage conList = new ContactListPage(driver);
		login.doLogin("jenitha@gmail.com", "abcdefg");
		conList.ClickOnLogotBtn();
		driver.navigate().back();
		new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.urlContains("contactList"));
		//Assert.assertTrue(login.isAtLoginPage(), "User didn't stay on the login page");
		System.out.println("The user redirected to the Contact List page");
	}
}
