package com.spec.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.spec.framework.base.BasePage;

public class HomePage extends BasePage{

	public HomePage() {
		// TODO Auto-generated constructor stub
		
	}
	
	@FindBy(linkText = "Login")
	public WebElement lnkLogin;
	
	public LoginPage clickLogin() {
		lnkLogin.click();
		return GetInstance(LoginPage.class);
	}
	
	public boolean isLoginLink() {
		return lnkLogin.isDisplayed();
	}
	
}
