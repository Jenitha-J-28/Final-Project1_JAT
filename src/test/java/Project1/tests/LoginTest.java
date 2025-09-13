package Project1.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import Project1.Base.BasicTest;
import Project1.pageObjects.LoginPage;

public class LoginTest extends BasicTest{

	LoginPage logPage;

//1. Login with Valid Credentials
	@Test (priority = 1)
public void ValidLogin() throws InterruptedException {
	LoginPage logPage = new LoginPage(driver);
	logPage.doLogin("jenitha@gmail.com", "abcdefg");
	Thread.sleep(5000);
	 Assert.assertTrue(driver.getCurrentUrl().contains("contactList"), 
	       "Login not successful - user not on Contact List page");
	}

//2.Login with incorrect Password
	@Test (priority = 2)
public void inValidpswdLogin() {
	logPage = new LoginPage(driver);
	logPage.doLogin("jenitha@gmail.com", "23as");
	logPage.checkErrorMsg();
	}

//3.Login with empty fields
	@Test (priority = 3)
public void emptyLogin() {
	logPage = new LoginPage(driver);
	logPage.clickOnLogin();
	logPage.checkErrorMsg();
	}
//4.Login with invalid Email Format	
	@Test (priority = 4)
public void inValidemailLogin() {
		logPage = new LoginPage(driver);
		logPage.enterEmail("Jenitha.com");
		logPage.enterpaswd("abcdefg");
		logPage.clickOnLogin();
		logPage.checkErrorMsg();
		}
//5.Verify Password Field Mask
	@Test (priority = 5)
public void pswdMask() {
	logPage = new LoginPage(driver);
	logPage.enterEmail("Jenitha.com");
	logPage.enterpaswd("abcdefg");
	logPage.passwordMask();
}
}
