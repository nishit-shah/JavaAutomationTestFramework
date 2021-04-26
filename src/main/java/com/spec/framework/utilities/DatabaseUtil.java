package com.spec.framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class DatabaseUtil {
	
	public static Connection openMySQLDBConnection(String host,String port,String databasename,String username,String password) throws SQLException {
		String url = "jdbc:mysql://"+host+":"+port+"/"+databasename;
		try {
			return DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	public static void closeMySQLDBConnection() {
		
	}
	
	public static void ExecuteQuery(String query,Connection connection) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet= statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
