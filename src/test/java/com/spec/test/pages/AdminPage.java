package com.spec.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.spec.framework.base.BasePage;
import com.spec.framework.base.DriverContext;

public class AdminPage extends BasePage {

	public AdminPage() {
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText = "Categories")
	public WebElement lnkCategories;
	
	@FindBy(xpath = "//h1/small")
	public WebElement txtLoggedInUser;
	
	public CategoriesPage clickCategory() {
		DriverContext.WaitForElementVisible(lnkCategories);
		lnkCategories.click();
		return GetInstance(CategoriesPage.class);
	}
	
	public String getLoggedinUser() {
		return txtLoggedInUser.getText();
	}
}
