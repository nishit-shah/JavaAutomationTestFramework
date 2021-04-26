package com.spec.framework.utilities;

import java.io.File;

import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent = new ExtentReports();
	private static Platform platform;
	private static String reportFileName = "JATFReport.html";
	private static String macPath = System.getProperty("user.dir")+"/TestReport";
	private static String windowsPath = System.getProperty("user.dir")+"\\TestReport";
	private static String winReportFileLoc = windowsPath + "\\" + reportFileName;
	private static String macReportFileLoc = macPath + "/" + reportFileName;
	
	public static ExtentReports createInstance() {
		platform = getCurrentPlatform();
		String fileName = getReportFileLocation(platform);
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
		
		//Configuration
		htmlReporter.config().setDocumentTitle(fileName); // Tittle of Report
		htmlReporter.config().setReportName(fileName); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report
		
		//attach reporter
		extent.attachReporter(htmlReporter);
		
		//Return the extent report object
		return extent;
	}
	
	//Select the extent report file location based on platform
	private static String getReportFileLocation(Platform platform) {
		String reportFileLocation = null;
		switch(platform) {
		case MAC:
			reportFileLocation = macReportFileLoc;
			createReportPath(macPath);
			System.out.println("Extent Report Path for MAC: " + macPath +"\n");
			break;
			
		case WINDOWS:
			reportFileLocation = winReportFileLoc;
			createReportPath(windowsPath);
			System.out.println("Extent Report Path for MAC: " + windowsPath +"\n");
			break;
			
			default:
				System.out.println("ExtentReport path has not been set! There is a problem!\n");
		}
		
		
		return reportFileLocation;
	}
	
	private static void createReportPath(String path) {
		File testDirectory = new File(path);
		if(!testDirectory.exists()) {
			if(testDirectory.mkdir()) {
				System.out.println("Directory:" + path + " is created");
			}else {
				System.out.println("Failed to create directory: " + path);
			}
		}else {
			System.out.println("Directory already exists: " + path);
		}
		
	}
	
	private static Platform getCurrentPlatform() {
		if(platform == null) {
			String operSys = System.getProperty("os.name").toLowerCase();
			if(operSys.contains("win")) {
				platform = Platform.WINDOWS;
			}else if (operSys.contains("mac")) {
				platform = Platform.MAC;
			}
		}
		return platform;
	}
}
