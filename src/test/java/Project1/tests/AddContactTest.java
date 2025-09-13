package Project1.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import Project1.Base.BasicTest;
import Project1.pageObjects.AddContactPage;
import Project1.pageObjects.ContactListPage;
import Project1.pageObjects.LoginPage;

public class AddContactTest extends BasicTest  {
AddContactPage AddConPage;
ContactListPage contactList;
LoginPage login;

//Add with Valid inputs
@Test (priority =1)
public void AddWithValidDetails() throws InterruptedException {
	AddConPage =new AddContactPage(driver);
	contactList = new ContactListPage(driver);
	login = new LoginPage(driver);
	login.doLogin("jenitha@gmail.com", "abcdefg");
	AddConPage.doAddContact("Kristen25", "Johan15", "2002-02-10", "kevin5@gmail.com", "9876543214", "Strret1", "Street2", "Madurai", "TamilNadu", "625001", "India");
	AddConPage.clickOnSubmit();
	Thread.sleep(5000);
	String currentUrl = driver.getCurrentUrl();
	System.out.println("The Contact added Successfully : " + currentUrl);
	}

//Leaving required field empty
@Test (priority =2)
public void missingREquiredField() throws InterruptedException {
	AddConPage =new AddContactPage(driver);
	contactList = new ContactListPage(driver);
	login = new LoginPage(driver);
	login.doLogin("jenitha@gmail.com", "abcdefg");
	AddConPage.doAddContact(" ", " ", "2002-09-10", "kvin@gmail.com", "9876543212", "Strret1", "Street2", "Madurai", "TamilNadu", "625001", "India");
	AddConPage.clickOnSubmit();
	Thread.sleep(5000);
	System.out.println(driver.getPageSource());
	Assert.assertEquals(AddConPage.getErrorMessage(),"Contact validation failed: firstName: Path `firstName` is required., lastName: Path `lastName` is required.");
}

//Verify Phone field without numeric data
@Test (priority =3)
public void numericPhoneField() throws InterruptedException {
	AddConPage =new AddContactPage(driver);
	contactList = new ContactListPage(driver);
	login = new LoginPage(driver);
	login.doLogin("jenitha@gmail.com", "abcdefg");
	AddConPage.doAddContact("Kvin", "Johan", "2002-09-10", "kvin@gmail.com", "abcdef", "Strret1", "Street2", "Madurai", "TamilNadu", "625001", "India");
	AddConPage.clickOnSubmit();
	Thread.sleep(5000);
	System.out.println(driver.getPageSource());
	Assert.assertEquals(AddConPage.getErrorMessage(),"Contact validation failed: phone: Phone number is invalid");
}

//Verify with Duplicating Contact
@Test (priority =4)
public void duplicateContactAdd() throws InterruptedException {
	AddConPage =new AddContactPage(driver);
	contactList = new ContactListPage(driver);
	login = new LoginPage(driver);
	login.doLogin("jenitha@gmail.com", "abcdefg");
	AddConPage.doAddContact("Kristen25", "Johan15", "2002-02-10", "kevin5@gmail.com", "9876543214", "Strret1", "Street2", "Madurai", "TamilNadu", "625001", "India");
	AddConPage.clickOnSubmit();
	Thread.sleep(5000);
	String currentUrl = driver.getCurrentUrl();
	System.out.println("The System allowed to add duplicate Contacts : " + currentUrl);
}

//Add with Valid inputs New entry after adding Contact
@Test (priority =5)
public void AddWithValidNewDetails() throws InterruptedException {
	AddConPage =new AddContactPage(driver);
	contactList = new ContactListPage(driver);
	login = new LoginPage(driver);
	login.doLogin("jenitha@gmail.com", "abcdefg");
	AddConPage.doAddContact("Kris45", "Johan45", "2002-02-11", "kevin45@gmail.com", "9876543219", "Strret1", "Street2", "Madurai", "TamilNadu", "625001", "India");
	AddConPage.clickOnSubmit();
	Thread.sleep(5000);
	contactList.ClickOnAddContact();
	String currentUrl = driver.getCurrentUrl();
	System.out.println("The System redirected to the add Contacts page for new entry : " + currentUrl);
}

}
