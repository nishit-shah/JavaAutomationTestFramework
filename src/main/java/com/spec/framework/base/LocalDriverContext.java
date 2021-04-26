package com.spec.framework.base;

import org.openqa.selenium.remote.RemoteWebDriver;



public class LocalDriverContext {

	//This class is used for Selenium Grid execution
	private static ThreadLocal<RemoteWebDriver> remoteWebDriverThreadLocal = new ThreadLocal<>();
	
	public static RemoteWebDriver getRemoteWebDriver() {
		return remoteWebDriverThreadLocal.get();
	}
	
	static void setRemoteWebDriverThreadLocal(RemoteWebDriver driverThreadLocal) {
	remoteWebDriverThreadLocal.set(driverThreadLocal);
	}
	
	
}
