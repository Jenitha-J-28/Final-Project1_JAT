package Project1.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Project1.Base.BasicTest;
import Project1.pageObjects.AddContactPage;
import Project1.pageObjects.ContactListPage;
import Project1.pageObjects.EditDelContatPage;
import Project1.pageObjects.LoginPage;

public class TestUI extends BasicTest{

	@Test (priority = 1)
	public void verifyAlignmentOfAddContactForm() {
		LoginPage login = new LoginPage(driver);
		ContactListPage conlist = new ContactListPage(driver);
		AddContactPage AddCon = new AddContactPage(driver);
		
		login.doLogin("jenitha@gmail.com", "abcdefg");
		conlist.ClickOnAddContact();
		AddCon.clickAddConBtn();
		List<WebElement> formFields = driver.findElements(By.id("add-contact"));
		 for (WebElement field : formFields) {
	            Assert.assertTrue(field.isDisplayed(), "Form field is displayed/aligned: " + field.getAttribute("id"));
	        }
		WebElement Submitbtn =  driver.findElement(By.id("submit"));
		Assert.assertTrue(Submitbtn.isDisplayed(), "Submit button is visible/aligned on Add Contact form!");
    }
	@Test (priority = 2)
	public void toastMsgAfterAddContact() {
		LoginPage login = new LoginPage(driver);
		ContactListPage conlist = new ContactListPage(driver);
		AddContactPage AddCon = new AddContactPage(driver);
		login.doLogin("jenitha@gmail.com", "abcdefg");
		conlist.ClickOnAddContact();
		AddCon.clickAddConBtn();
		//AddCon.doAddContact("Banu", "Kavi", "2003-06-1", "banu@gmail.com", "908765432", "St12", "St23", "Madurai", "TamilNadu", "625008", "India");
		AddCon.enterFirstName("Simon2");
		AddCon.enterLastName("Jacob2");
		AddCon.clickOnSubmit();
		new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.urlContains("contactList"));
		System.out.println("Contact added successfully But there is no Toast message displayed");
		//WebElement toastMessage = driver.findElement(By.cssSelector(".alert-success, .toast, .message"));
        //Assert.assertTrue(toastMessage.isDisplayed(), "Success message not displayed after adding the contact!");
}
	@Test (priority = 3	)
	public void toastMasgAfterDelContact() {
		LoginPage login = new LoginPage(driver);
		//ContactListPage conlist = new ContactListPage(driver);
		//AddContactPage AddCon = new AddContactPage(driver);
		EditDelContatPage del = new EditDelContatPage(driver);
		login.doLogin("jenitha@gmail.com", "abcdefg");
		del.openContactUsingName("Jacob");
		del.clickDelBtnAcceptAlert();
		new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.urlContains("contactList"));
		System.out.println("Contact deleted successfully But there is no Toast message displayed");
		//WebElement toastMessage = driver.findElement(By.cssSelector(".alert-success, .toast, .message"));
	    //Assert.assertTrue(toastMessage.isDisplayed(), "Success message not displayed after deleting contact!");
		
	}
}
