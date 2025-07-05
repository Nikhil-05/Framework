package automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.configurations.Configuration;
import automation.constants.Constants;
import automation.pageobjects.LoginPage;
import automation.pageobjects.PageUtils;

public class LoginTest extends Configuration {
	
	@Test
	public void DirectSignIn(){
		
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
	public void ValidLogin() throws InterruptedException {
		
		LoginPage lp = PageUtils.navigateToLoginPage(driver);
		
		lp.clickFypLink();
		
		Thread.sleep(2000);
		
		lp.clickRstLogin();
		
		String pass = lp.extractRealPassword();
		
		Thread.sleep(2000);
		
		lp.goToLogin();
		
		Thread.sleep(2000);
		
		lp.enterPassword(pass);
		
	}


}
