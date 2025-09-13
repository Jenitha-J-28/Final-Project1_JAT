package Project1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactListPage {
WebDriver driver;

public ContactListPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(id="add-contact")
WebElement AddContactBtn;

@FindBy(id="logout")
WebElement LogoutBtn;

public void ClickOnAddContact() {
	AddContactBtn.click();
}

public void ClickOnLogotBtn() {
	LogoutBtn.click();
}

public boolean CheckAtContactPage() {
	return driver.getCurrentUrl().contains("Contact List App");
}

}
