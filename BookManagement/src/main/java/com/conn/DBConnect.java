package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection getConn() {
		try {
			Class.forName(DbDetails.DBDRIVER);
			Connection conn = DriverManager.getConnection(
			DbDetails.CONSTR, DbDetails.USERNAME, DbDetails.PASSWORD);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
