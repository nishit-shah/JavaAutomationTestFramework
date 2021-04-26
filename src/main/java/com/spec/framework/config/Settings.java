package com.spec.framework.config;

import java.sql.Connection;

import com.spec.framework.base.BrowserType;
import com.spec.framework.utilities.LogUtil;

public class Settings {

	//For Application Backend
	public static Connection AUTConnection;
	//For Application Backend connection
	public static String DBHost;
	public static String DBPort;
	public static String DBName;
	public static String DBUser;
	public static String DBPassword;
	
	//Logpath for Framework
	public static String LogPath;
	//Excel file path for DDT
	public static String ExcelSheetPath;
	//Application URL
	public static String AUT;
	//Browser Type
	public static BrowserType Browsertype;
	
	//Log Util for Logs
	public static LogUtil Logs;
	
	//Selenium Grid Hub
	public static String SeleniumGridHub;
	
	
	
	
}
