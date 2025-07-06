package automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.constants.Constants;

public class LoginPage {

	WebDriver driver;

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

	@FindBy(linkText = "Forgot your password?")
	WebElement fypLink;

	@FindBy(className = "reset-pwd-btn")
	WebElement rstLogin;

	@FindBy(className = "infoMsg")
	WebElement infoMsg;

	@FindBy(className = "go-to-login-btn")
	WebElement goToLoginBtn;

	@FindBy(tagName = "h2")
	WebElement helloText;

	public WebElement getHelloText() {
		return helloText;
	}

	public WebElement getUsernameField() {
		return usernameField;
	}

	public void enterUsername(String username) {

		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {

		passwordField.sendKeys(password);
	}

	public void clickFypLink() {

		fypLink.click();

	}

	public void signIn() {

		signInButton.click();
	}

	public void clickRstLogin() {

		PageUtils.explicitlyWait(driver, 5, rstLogin).click();

	}

	public void goToLogin() {

		goToLoginBtn.click();
	}

	public String extractRealPassword() {

		String msg = PageUtils.extractText(infoMsg);

		String ogPswrd = PageUtils.extractExactText(msg, "'", 1);

		return ogPswrd;

	}

	public boolean ErrorDisplayed() {

		return error.isDisplayed();

	}

	public boolean extractUsernameAndCompare() {

		String helloMsg = PageUtils.extractText(helloText);

		String uname = PageUtils.extractExactText(helloMsg, " ", 1);

		String ogUname = PageUtils.extractExactText(uname, ",", 0);

		return ogUname.equalsIgnoreCase(Constants.username);
	}
}
