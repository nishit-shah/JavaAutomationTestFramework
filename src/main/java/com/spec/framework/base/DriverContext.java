package com.spec.framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spec.framework.config.Settings;

public class DriverContext {

	//Commented following code for executing tests in grid
//	public static WebDriver Driver;
//	public static Browser Browser;
//	
//	public static void setDriver(WebDriver driver) {
//		Driver = driver;
//	}
	
	//Updated code for changing instance from "Driver" to "LocalDriverContext.getRemoteWebDriver()"
	public static void WaitForPageToLoad() {
		WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(),30);
		JavascriptExecutor jsExecutor=(JavascriptExecutor)LocalDriverContext.getRemoteWebDriver();
		
		ExpectedCondition<Boolean> jsLoad = webDriver -> ((JavascriptExecutor)LocalDriverContext.getRemoteWebDriver()).executeScript("return document.readyState").toString().equals("complete");
		
		//Get JS Ready
		boolean jsReady = jsExecutor.executeScript("return document.readyState").toString().equals("complete");
		
		if(!jsReady)
			wait.until(jsLoad);
		else
			Settings.Logs.WriteLog("Page is ready!");
	}
	
	public static void WaitForElementVisible(final WebElement elementFindBy) {
		WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(elementFindBy));
	}
	
	public static void WaitForElementTextVisible(final WebElement elementFindBy,String text) {
		WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(),30);
		wait.until(ExpectedConditions.textToBePresentInElement(elementFindBy,text));
	}
	
	public static void WaitUntilTextDisplayed(final By element,String text) {
		WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(),30);
		wait.until(textDisplayed(element,text));
	}
	
	private static ExpectedCondition<Boolean> textDisplayed(final By elementFindBy, final String text){
		return webDriver -> webDriver.findElement(elementFindBy).getText().contains(text);
	}
	
	public static void WaitElementEnabled(final By elementFindBy) {
		WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(),30);
		wait.until(webDriver-> webDriver.findElement(elementFindBy).isEnabled());
	}
	
	public static void GoToUrl(String url) {
		LocalDriverContext.getRemoteWebDriver().get(url);
	}
	
	
}
