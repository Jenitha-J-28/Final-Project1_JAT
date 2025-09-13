package Project1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Project1.Base.BasicTest;
import Project1.pageObjects.EditDelContatPage;
import Project1.pageObjects.LoginPage;

public class EditDelContactTest extends BasicTest{
	EditDelContatPage editDel;
	LoginPage login;
	
//Edit Contact
	@Test (priority=1)
public void editContact() {
	editDel = new EditDelContatPage(driver);
	login = new LoginPage(driver);
	login.doLogin("jenitha@gmail.com", "abcdefg");
	editDel.openContactUsingName("Simon");
	editDel.clickEditBtn();
	editDel.updateCity("Chennai");
	editDel.saveChanges();
	Assert.assertTrue(true);
}

//Unsaved Edit Contact
	@Test (priority=2)
public void cancelEditContact() {
	editDel = new EditDelContatPage(driver);
	login = new LoginPage(driver);
	login.doLogin("jenitha@gmail.com", "abcdefg");
	editDel.openContactUsingName("Simon");
	editDel.clickEditBtn();
	editDel.updateCity("Madurai");
	editDel.CancelChanges();
	Assert.assertTrue(true);
}

//Delete Contact
	@Test (priority=4)
public void DeleteContact() {
	editDel = new EditDelContatPage(driver);
	login = new LoginPage(driver);
	login.doLogin("jenitha@gmail.com", "abcdefg");
	editDel.openContactUsingName("Simon");
	editDel.clickDelBtnAcceptAlert();
	}

//Cancel Delete Contact
	@Test (priority=3)
public void CancelDeleteContact() {
	editDel = new EditDelContatPage(driver);
	login = new LoginPage(driver);
	login.doLogin("jenitha@gmail.com", "abcdefg");
	editDel.openContactUsingName("Simon");
	editDel.clickDelBtnCancelAlert();
	}
}
