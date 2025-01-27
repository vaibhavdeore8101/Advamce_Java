package com.JDBC.Select;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class SelectDemo4 {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static FileInputStream file;
	private static Properties properties = new Properties();
	private static String filePath ="D:\\Adv. Java\\JDBC\\src\\resources\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {
		
		try {
			
			file=new FileInputStream(filePath);
			properties.load(file);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
			
			statement = connection.createStatement();
			query = "select * from emp1";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1) + " | "
								+ resultSet.getString(2) + " | "
								+ resultSet.getInt(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				if (file != null) {
					file.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
