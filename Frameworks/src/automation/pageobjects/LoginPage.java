package automation.pageobjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage{
	
	WebDriver driver ;
	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "signInBtn")
	WebElement signInButton;
	
	@FindBy(className = "error")
	WebElement error;
	
	@FindBy(id = "inputUsername")
	WebElement usernameField; 
	
	@FindBy(name = "inputPassword")
	WebElement passwordField;
	
	public void enterUsername(String username) {
		
		usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		
		passwordField.sendKeys(password);
	}
	
	public void signIn() {
		
		signInButton.click();
	}
	
	public boolean ErrorDisplayed() {
		
		return error.isDisplayed();
		
	}
}
