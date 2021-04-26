package com.spec.framework.base;

import org.openqa.selenium.support.PageFactory;

public class Base {

	public static BasePage CurrentPage;
	
	//Updated Constructor to change from "DriverContenxt.Driver" to "LocalDriverContext.getRemoteWebDriver()" for Selenium Grid
	public <TPage extends BasePage> TPage GetInstance(Class<TPage>page) {
		Object obj = PageFactory.initElements(LocalDriverContext.getRemoteWebDriver(), page);
		//Custom Control page factory initialization--DO NOT UNCOMMENT THIS CODE
		//Object obj = ControlFactory.initElements(DriverContext.Driver, page);
		
		return page.cast(obj);
	}
}
