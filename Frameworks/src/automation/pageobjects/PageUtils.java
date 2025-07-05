package automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.constants.Constants;

public class PageUtils {
	
	public static LoginPage navigateToLoginPage(WebDriver driver) {
		
		driver.get(Constants.loginPageURl);
		return new LoginPage(driver);
	}
	
	public static String extractText(WebElement ele) {
		
		String text = ele.getText().trim();
		return text;
		
	}
	
	public static String ExtractExactTest(String text, String diff, Integer indx) {
		
		String [] textArray = text.split(diff);
		
		String exactText = textArray[indx];
		
		return exactText;

	}

}
