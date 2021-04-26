package com.spec.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.spec.framework.base.BrowserType;

public class ConfigReader {

	public static void PopulateSettings() throws IOException {
		ConfigReader cnfReader= new ConfigReader();
		cnfReader.ReadProperty();
	}
	private void ReadProperty() throws IOException {
		Properties props = new Properties();
		//Load the property file available in same package
		InputStream inputStream = new FileInputStream("src\\main\\java\\com\\spec\\framework\\config\\GlobalConfig.properties");
		props.load(inputStream);
		
		//temporarily disablint following line of code to fix the issue
		//props.load(getClass().getResourceAsStream("GlobalConfig.properties"));
		Settings.AUT = props.getProperty("AUTUrl");
		Settings.DBHost = props.getProperty("dbHost");
		Settings.DBPort = props.getProperty("dbPort");
		Settings.DBName = props.getProperty("dbName");
		Settings.DBUser = props.getProperty("dbUsername");
		Settings.DBPassword = props.getProperty("dbPassword");
		Settings.LogPath = props.getProperty("logPath");
		Settings.ExcelSheetPath = props.getProperty("excelFilePath");
		Settings.Browsertype= BrowserType.valueOf(props.getProperty("BrowserType"));
		Settings.SeleniumGridHub = props.getProperty("SeleniumGrid");
	}
}
