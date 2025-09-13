package Project1.pageObjects;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver ContactListTestdriver) {
		this.driver = ContactListTestdriver;
		PageFactory.initElements(driver, this);
		}
	
	//Data
	String emailId = "jenthajeyasekaran28@gmail.com";
	String PasswordText = "123456";
	
    //WebElements
	//WebElement Signup = driver.findElement(By.id("signup"));
	
	@FindBy(id="signup")
	WebElement Signup;
	
	//WebElement FirstName = driver.findElement(By.id("firstName"));
	@FindBy(id="firstName")
	WebElement FirstName;
	
	//WebElement LastName = driver.findElement(By.id("lastName"));
	@FindBy(id="lastName")
	WebElement LastName;
	
	//WebElement Email = driver.findElement(By.id("email"));
	@FindBy(id="email")
	WebElement Email;
	
	//WebElement Password = driver.findElement(By.id("password"));
	@FindBy(id="password")
	WebElement Password;
	
	//WebElement Submit = driver.findElement(By.id("submit"));
	@FindBy(id="submit")
	WebElement Submit;
	
	@FindBy(id="logout")
	WebElement Logout;
	
	@FindBy(id="error")
	WebElement ErrorMsg;
	
	//Capturing the methods
	public void doRegistration(String fname,String lname,String mail,String pswd) {
		Signup.click();
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		Email.sendKeys(mail);
		Password.sendKeys(pswd);
		Submit.click();
		//Logout.click();
	}
	
	public void enterEmail(String mail) {
		Email.sendKeys(mail);
	}
	public void enterpassword(String pswd) {
		Password.sendKeys(pswd);
	}
	public void enterFirstName(String fname) {
		FirstName.sendKeys(fname);
	}
	public void enterLastName(String lname) {
		LastName.sendKeys(lname);
	}
	public void clickOnSignUp() {
		Submit.click();
	}
	
	public void clickOnLogout() {
		Logout.click();
	}
	
	public String getErrorMsg() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement error = wait.until(ExpectedConditions.visibilityOf(ErrorMsg));
	        return error.getText().trim();
	    } catch (Exception e) {
	        return "";
	    }
	}
}



