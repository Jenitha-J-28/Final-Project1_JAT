package Project1.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDelContatPage {
	String name = "Kevin";

	WebDriver driver;
	
	public EditDelContatPage(WebDriver ContactListTestdriver) {
		this.driver = ContactListTestdriver;
		PageFactory.initElements(driver,this);
		}
	
@FindBy(id="edit-contact")
WebElement EditBtn;

@FindBy (id="delete")
WebElement DeleteButton;

@FindBy (id="return")
WebElement returnToContact;

@FindBy (id="city")
WebElement City;

@FindBy (id="submit")
WebElement Save;

@FindBy (id="cancel")
WebElement Cancel;

public void openContactUsingName(String name) {
    WebElement contact = driver.findElement(
        org.openqa.selenium.By.xpath("//table//tr[td[contains(text(),'" + name + "')]]")
    );
    contact.click();
}

public void clickEditBtn() {
	EditBtn.click();
}

public void clickDelBtnAcceptAlert() {
	DeleteButton.click();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	String currentUrl = driver.getCurrentUrl();
	System.out.println("The contact is deleted Successfully and the current url is : "+currentUrl);
}

public void clickDelBtnCancelAlert() {
	DeleteButton.click();
	Alert alert = driver.switchTo().alert();
	alert.dismiss();
	String currentUrl = driver.getCurrentUrl();
	System.out.println("The contact is not deleted and the current url is : "+currentUrl);
}

public void updateCity(String CN) {
	City.sendKeys(CN);
}

public void saveChanges() {
	Save.click();
}

public void CancelChanges() {
	Cancel.click();
}
}
