package com.spec.framework.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.spec.framework.config.Settings;

public class LogUtil {

	//File format for the Log file
	ZonedDateTime date = ZonedDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
	String fileNameFormat=date.format(formatter);
	
	
	private BufferedWriter bufferedwriter = null;
	
	//Create Log file
	public void CreateLogFile() {
		try {
			File dir = new File(System.getProperty("user.dir")+Settings.LogPath);
			if(!dir.exists()) {
				dir.mkdir();
			}
			File logFile = new File(dir+"/"+ fileNameFormat+".log");
			FileWriter fwriter = new FileWriter(logFile.getAbsoluteFile());
			bufferedwriter = new BufferedWriter(fwriter);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//Write message within the log
	public void WriteLog(String message) {
		try {
			formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
			String dateFormat=date.format(formatter);
			bufferedwriter.write("["+dateFormat+"]"+message);
			bufferedwriter.newLine();
			bufferedwriter.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
