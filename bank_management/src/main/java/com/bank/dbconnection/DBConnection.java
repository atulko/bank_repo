
package com.bank.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/bank_db";
	private static String username = "root";
	private static String password = "root";

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}