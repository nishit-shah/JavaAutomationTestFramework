package com.spec.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spec.framework.base.BasePage;
import com.spec.framework.base.DriverContext;
import com.spec.framework.controls.elements.Button;
import com.spec.framework.controls.elements.ButtonBase;
import com.spec.framework.controls.elements.TextBox;
import com.spec.framework.controls.elements.TextBoxBase;
import com.spec.test.cucumbertest.model.LoginModel;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	public LoginPage() {
	
	}

	@FindBy(name="username")
	public WebElement txtUserName;
	
	@FindBy(name="password")
	public WebElement txtPassword;
	
	@FindBy(name = "login")
	public WebElement btnLogin;
	
	//Experimental R&D. DO NOT USE THIS ELEMENTS
	@FindBy(name="username")
	public WebElement txtUserNameM;
	
	@FindBy(name="password")
	public WebElement txtPasswordM;
	
	@FindBy(name = "login")
	public WebElement btnLoginM;
	//TILL HERE
	
	public AdminPage Login(String username,String password) {
		txtUserName.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.submit();
		DriverContext.WaitForPageToLoad();
		return GetInstance(AdminPage.class);
		
	}
	
	public AdminPage LoginCuc(LoginModel loginModel) {
		txtUserName.sendKeys(loginModel.getUsername());
		txtPassword.sendKeys(loginModel.getPassword());
		btnLogin.submit();
		DriverContext.WaitForPageToLoad();
		return GetInstance(AdminPage.class);
		
	}
	
	//DO NOT USE THIS METHOD
	public AdminPage LoginM(String username,String password) {
		TextBox txtUser = new TextBoxBase(txtUserNameM);
		txtUser.EnterText(username);
		TextBox txtPass = new TextBoxBase(txtPasswordM);
		txtPass.EnterText(password);
		Button btnLogIn = new ButtonBase(btnLoginM);
		btnLogIn.performSubmit();;
		return GetInstance(AdminPage.class);
		
	}
	
	public boolean isLogin() {
		return txtUserName.isDisplayed();
	}
}
