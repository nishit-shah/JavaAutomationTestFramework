package com.spec.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.spec.framework.base.BasePage;

public class CategoriesPage extends BasePage{

	public CategoriesPage() {
		
		// TODO Auto-generated constructor stub
	}


	
	@FindBy(name="cat_title")
	public WebElement txtCategory;
	
	@FindBy(name="submit")
	public WebElement btnSubmitCategory;
}
