package com.spec.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends Base {

	//Updated Constructor to change from "DriverContenxt.Driver" to "LocalDriverContext.getRemoteWebDriver()" for Selenium Grid
	public BasePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(LocalDriverContext.getRemoteWebDriver(), this);
	}
	
	public <TPage extends BasePage> TPage As(Class<TPage>pageInstance) {
		try {
			return (TPage)this;
		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
}
