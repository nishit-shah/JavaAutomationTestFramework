package com.spec.test.seleniumtest;



import org.testng.annotations.Test;

import com.spec.framework.utilities.ExcelUtil;
import com.spec.test.pages.HomePage;
import com.spec.test.pages.LoginPage;

public class LoginTest extends TestInitialize{

	@Test
	public void UserLoginTest() {

		CurrentPage = GetInstance(HomePage.class);
		CurrentPage = CurrentPage.As(HomePage.class).clickLogin();
		// Reading data from excel file
		CurrentPage.As(LoginPage.class).Login(ExcelUtil.ReadCell("Username", 1), ExcelUtil.ReadCell("Password", 1));

	}

}
