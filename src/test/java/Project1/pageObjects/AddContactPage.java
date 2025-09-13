package Project1.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddContactPage {

	WebDriver driver;
	
	public AddContactPage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="add-contact")
	WebElement AddContBtn;
	
	@FindBy(id="firstName")
	WebElement FirstName;
	
	@FindBy(id="lastName")
	WebElement LastName;
	
	@FindBy(id="birthdate")
	WebElement Birthdate;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="phone")
	WebElement Phone;
		
	@FindBy(id="street1")
	WebElement Street1;
	
	@FindBy(id="street2")
	WebElement Street2;
	
	@FindBy(id="city")
	WebElement City;
	
	@FindBy(id="stateProvince")
	WebElement StateProvince;
	
	@FindBy(id="postalCode")
	WebElement PostalCode;
	
	@FindBy(id="country")
	WebElement Country;
	
	@FindBy(id="submit")
	WebElement Submit;
	
	@FindBy(css = ".main-content > #error")
	WebElement ErrorMessage;
	
	public void doAddContact(String FN, String LN, String BD,String mail, String PN,String St1,String St2,String cityname,String state,String PC, String cntry) {
		AddContBtn.click();
		FirstName.sendKeys(FN);
		LastName.sendKeys(LN);
		Birthdate.sendKeys(BD);
		Email.sendKeys(mail);
		Phone.sendKeys(PN);
		Street1.sendKeys(St1);
		Street2.sendKeys(St2);
		City.sendKeys(cityname);
		StateProvince.sendKeys(state);
		PostalCode.sendKeys(PC);
		Country.sendKeys(cntry);
		Submit.click();
		}
	public void clickAddConBtn() {
		AddContBtn.click();
	}
	public void enterFirstName(String FN) {
		FirstName.sendKeys(FN);
	}
	public void enterLastName(String LN) {
		LastName.sendKeys(LN);
	}
	public void enterPhoneNumber(String PN) {
		Phone.sendKeys(PN);
	}
	public void enterAddress1(String St1) {
		Street1.sendKeys(St1);
	}
	public void clickOnSubmit() {
		Submit.click();
	}
	public String getErrorMessage() {
		return ErrorMessage.getText().trim();
	}
}
