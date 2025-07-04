package automation.pageobjects;

import org.openqa.selenium.WebDriver;

import automation.constants.Constants;

public class PageUtils {
	
	public static LoginPage navigateToLoginPage(WebDriver driver) {
		
		driver.get(Constants.loginPageURl);
		return new LoginPage(driver);
	}

}
