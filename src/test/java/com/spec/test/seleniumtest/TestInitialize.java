package com.spec.test.seleniumtest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;

import com.spec.framework.base.DriverContext;
import com.spec.framework.base.Frameworkinitialize;
import com.spec.framework.base.LocalDriverContext;
import com.spec.framework.config.ConfigReader;
import com.spec.framework.config.Settings;
import com.spec.framework.utilities.DatabaseUtil;
import com.spec.framework.utilities.ExcelUtil;
import com.spec.framework.utilities.LogUtil;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
public class TestInitialize extends Frameworkinitialize {

	@BeforeClass
	public void Initialize() throws IOException {

		//Initialize Config
		ConfigReader.PopulateSettings();
		
		// Custom Logger functionality
		Settings.Logs = new LogUtil();
		Settings.Logs.CreateLogFile();
		Settings.Logs.WriteLog("Framework Initialized");

		Settings.Logs.WriteLog("Test Cycle Created");
		InitializeBrowser(Settings.Browsertype);
		Settings.Logs.WriteLog("Browser initialized");
		//DriverContext.Browser.GoToUrl(Settings.AUT);
		DriverContext.GoToUrl(Settings.AUT);
		Settings.Logs.WriteLog("Navigated to URL");

		try {

			ExcelUtil excel = new ExcelUtil(Settings.ExcelSheetPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
