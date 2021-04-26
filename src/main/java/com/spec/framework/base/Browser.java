package com.spec.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

	private WebDriver driver;
	RemoteWebDriver Driver;
	//public BrowserType Type;
	public Browser(WebDriver Driver) {
		// TODO Auto-generated constructor stub
		driver = Driver;
	}
	public Browser(RemoteWebDriver Driver) {
		// TODO Auto-generated constructor stub
		this.Driver = Driver;
	}
//	public void GoToUrl(String url) {
//		driver.get(url);
//	}

	
	public void Maximize() {
		this.Driver.manage().window().maximize();
	}
}




