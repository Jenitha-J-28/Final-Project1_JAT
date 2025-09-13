package Project1.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasicTest {
	String url ="https://thinking-tester-contact-list.herokuapp.com/";
	protected WebDriver driver;
	
	@BeforeMethod
	public void launchBrowserandApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	
	@AfterMethod
	public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}

