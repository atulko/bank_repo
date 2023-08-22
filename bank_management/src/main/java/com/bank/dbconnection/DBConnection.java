package com.bank.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/user_db";
	String username = "root";
	String password = "root";

	private static final String selectAll = "select * from user";

	public void loadDriver() {
		try {
			Class.forName(driver);
			System.out.println("Driver loaded in class...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			try {
				try {
					conn = DriverManager.getConnection(url, username, password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("connected");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(selectAll);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;

	}

	public static void main(String[] args) throws Exception {
		DBConnection conn = new DBConnection();
		conn.loadDriver();
		conn.getConnection();

	}
}
