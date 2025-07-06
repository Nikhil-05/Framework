package automation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public static String extractExactText(String text, String diff, int indx) {

		String[] textArray = text.split(diff);

		String exactText = textArray[indx];

		return exactText;

	}

	public static WebElement explicitlyWait(WebDriver driver, int duration, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));

		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));

		return ele;

	}

}
