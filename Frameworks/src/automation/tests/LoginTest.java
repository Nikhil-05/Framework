package automation.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.configurations.Configuration;
import automation.constants.Constants;
import automation.pageobjects.LoginPage;
import automation.pageobjects.PageUtils;

public class LoginTest extends Configuration {

	@Test
	public void DirectSignIn() {

		LoginPage lp = PageUtils.navigateToLoginPage(driver);

		lp.signIn();

		Assert.assertTrue(lp.ErrorDisplayed());
	}

	@Test
	public void onlyUsernameSignIn() {

		LoginPage lp = PageUtils.navigateToLoginPage(driver);

		lp.enterUsername(Constants.username);

		lp.signIn();

		Assert.assertTrue(lp.ErrorDisplayed());

	}

	@Test
	public void invalidSignIn() {

		LoginPage lp = PageUtils.navigateToLoginPage(driver);

		lp.enterUsername(Constants.username);

		lp.enterPassword(Constants.incorrectPassword);

		lp.signIn();

		Assert.assertTrue(lp.ErrorDisplayed());
	}

	@Test
	public void ValidLogin() {

		LoginPage lp = PageUtils.navigateToLoginPage(driver);

		lp.clickFypLink();

		lp.clickRstLogin();

		String pass = lp.extractRealPassword();

		lp.goToLogin();

		PageUtils.explicitlyWait(driver, 2, lp.getUsernameField()).sendKeys(Constants.username);

		lp.enterPassword(pass);

		lp.signIn();

		PageUtils.explicitlyWait(driver, 5, lp.getHelloText());

		assertTrue(lp.extractUsernameAndCompare());
	}

}
