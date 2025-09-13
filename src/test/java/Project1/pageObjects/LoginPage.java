package Project1.pageObjects;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
WebDriver driver;

public LoginPage(WebDriver ContactListTestdriver) {
	this.driver = ContactListTestdriver;
	PageFactory.initElements(driver,this);
	}

@FindBy(id="email") 
WebElement Email;

@FindBy(id="password") 
WebElement Password;

@FindBy(id="submit") 
WebElement Submit;

@FindBy(id="error")
WebElement Error;

public void doLogin(String lmail,String lpswd) {
	Email.sendKeys(lmail);
	Password.sendKeys(lpswd);
	Submit.click();
}
public void enterEmail(String email) {
	Email.sendKeys(email);
}

public void enterpaswd(String password) {
	Password.sendKeys(password);
}

public void clickOnLogin() {
	Submit.click();
}

public String checkErrorMsg() {
	String errorMsg = Error.getText();
	return errorMsg;
}

public void passwordMask() {
	String pswdtype = Password.getAttribute("type");
	Assert.assertEquals(pswdtype, "password", "Password field should be masked.");
	}

public boolean isAtLoginPage() {
    new WebDriverWait(driver, Duration.ofSeconds(5))
	        .until(ExpectedConditions.visibilityOf(Email));
	return driver.getCurrentUrl().contains("list.herokuapp.com");
}
}
