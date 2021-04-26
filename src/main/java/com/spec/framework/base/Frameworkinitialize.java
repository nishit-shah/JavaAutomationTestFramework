package com.spec.framework.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.spec.framework.config.Settings;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frameworkinitialize extends Base {
	//Changing Driver instance to RemoteWebDriver for Selenium Grid
	//WebDriver driver = null;
	RemoteWebDriver driver = null;
	
	public void InitializeBrowser(BrowserType browsertypes) throws MalformedURLException {
		
		switch(browsertypes) {
		
		case Firefox:
		{
			WebDriverManager.firefoxdriver().setup();
			DesiredCapabilities capabilities = new DesiredCapabilities().firefox();
			driver=new RemoteWebDriver(new URL(Settings.SeleniumGridHub),capabilities);
			LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
			break;
		}
		case Chrome:
		{
			DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
			WebDriverManager.chromedriver().setup();
			driver=new RemoteWebDriver(new URL(Settings.SeleniumGridHub),capabilities);
			//driver=new ChromeDriver();
			LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
			break;
		}
		case IE:
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		case Edge:
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		}
		case Safari:
		{
			
			driver = new SafariDriver();
			break;
		}
		
		}
		
		//Commenting code for Selenium Grid Changes in Driver Instance creation
//		DriverContext.setDriver(driver);
//		DriverContext.Browser = new Browser(driver);
	}
}
