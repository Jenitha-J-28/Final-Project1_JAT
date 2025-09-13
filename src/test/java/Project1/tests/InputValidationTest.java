package Project1.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import Project1.Base.BasicTest;
import Project1.pageObjects.AddContactPage;
import Project1.pageObjects.ContactListPage;
import Project1.pageObjects.LoginPage;

public class InputValidationTest extends BasicTest {
LoginPage login;
AddContactPage AddCon;
ContactListPage conList;

//Verify max character limit for contact fields
@Test (priority=1)
public void verifyCharLimit() throws InterruptedException {
	login = new LoginPage(driver);
	AddCon = new AddContactPage(driver);
	conList = new ContactListPage(driver);
	login.doLogin("Jenitha@gmail.com", "abcdefg");
	conList.ClickOnAddContact();
	AddCon.enterFirstName("jshdgfjkhasdgfsahdghasdghfsdg skjdfhggsdhfjfjksdlhfkjasgdajlkueywieuyiuwhbjascjshdgfjkhasdgfsahdghasdghfsdg skjdfhggsdhfjfjksdlhfkjasgdajlkueywieuyiuwhbjasc");
	AddCon.enterLastName("Jaden");
	AddCon.clickOnSubmit();
	Thread.sleep(3000);
	Assert.assertEquals(AddCon.getErrorMessage(),"Contact validation failed: firstName: Path `firstName` (`jshdgfjkhasdgfsahdghasdghfsdg skjdfhggsdhfjfjksdlhfkjasgdajlkueywieuyiuwhbjascjshdgfjkhasdgfsahdghasdghfsdg skjdfhggsdhfjfjksdlhfkjasgdajlkueywieuyiuwhbjasc`) is longer than the maximum allowed length (20).");
}

//Verify unicode/emojis in addressfield
@Test (priority=2)
public void verifyUnicodeEmoji() throws InterruptedException {
	login = new LoginPage(driver);
	AddCon = new AddContactPage(driver);
	conList = new ContactListPage(driver);
	login.doLogin("Jenitha@gmail.com", "abcdefg");
	conList.ClickOnAddContact();
	AddCon.enterFirstName("Karthi");
	AddCon.enterLastName("Jeni");
	AddCon.enterAddress1("\\uD83C\\uDFE0 Str11");
	AddCon.clickOnSubmit();
	Thread.sleep(3000);
	Assert.assertTrue(driver.getCurrentUrl().contains("contact"), 
		        "Contact not saved");
	String currentUrl = driver.getCurrentUrl();
	//Assert.assertTrue(currentUrl.contains("contact"),"Contact not saved or did not navigate back to contact list");
	System.out.println("Contacts with emoji added successfully and the current url is : "+ currentUrl);
	//WebElement successMsg = driver.findElement(By.cssSelector(".alert-success, .toast, .message"));
    //Assert.assertTrue(successMsg.isDisplayed(), "Contact with Unicode/emoji address not accepted!");
}
}
