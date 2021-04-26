package com.spec.test.cucumbertest.stepsdefinition;

import java.io.IOException;

import com.spec.framework.base.DriverContext;
import com.spec.framework.base.Frameworkinitialize;
import com.spec.framework.config.ConfigReader;
import com.spec.framework.config.Settings;
import com.spec.framework.utilities.ExcelUtil;
import com.spec.framework.utilities.LogUtil;

import io.cucumber.java.Before;

public class TestInitialize extends Frameworkinitialize {

	@Before
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
