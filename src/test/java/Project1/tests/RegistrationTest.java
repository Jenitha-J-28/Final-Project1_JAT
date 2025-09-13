package Project1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Project1.Base.BasicTest;
import Project1.pageObjects.RegistrationPage;

public class RegistrationTest extends BasicTest {
	RegistrationPage regPage;
	
//6.Sign up with Valid inputs
	@Test (priority=1)
public void validSignup() throws InterruptedException {
	regPage = new RegistrationPage(driver);
	regPage.doRegistration("Irin1","Jessica1", "IrinJes@gmail.com", "kevin4Jake");
	regPage.clickOnSignUp();
	Thread.sleep(5000);
	Assert.assertTrue(driver.getCurrentUrl().contains("contactList"), 
	        "User was not redirected to contact list after signup");
	Thread.sleep(3000);
	regPage.clickOnLogout();
}

//7.Sign up with existing email
	@Test (priority=2)
public void ExistingEmailSignup() {
	regPage = new RegistrationPage(driver);
	regPage.doRegistration("Kevin","Jake", "kevin@gmail.com", "kevinJake");
	regPage.clickOnSignUp();
	//Assert.assertTrue(regPage.getErrorMsg().contains("Email address is already in use"));
	Assert.assertEquals(regPage.getErrorMsg(), "Email address is already in use");
}

//8.Sign up with blank Fields
	@Test (priority=3)
public void blankFieldSignup() {
	regPage = new RegistrationPage(driver);
	regPage.doRegistration(" "," ", " ", " ");
	regPage.clickOnSignUp();
	Assert.assertEquals(regPage.getErrorMsg(), "User validation failed: firstName: Path `firstName` is required., lastName: Path `lastName` is required., email: Email is invalid, password: Path `password` is required.");
}

//7.Sign up with invalid email format
	@Test (priority=4)
public void invalidEmailFormatSignup() {
	regPage = new RegistrationPage(driver);
	regPage.doRegistration("Kristen","Johan", "johan.com", "johanJake");
	regPage.clickOnSignUp();
	Assert.assertEquals(regPage.getErrorMsg(), "User validation failed: email: Email is invalid");
}
}
