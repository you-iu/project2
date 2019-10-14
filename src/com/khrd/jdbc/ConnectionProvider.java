package com.khrd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() throws SQLException {
		String jdbcDriver = "jdbc:apache:commons:dbcp:project";//커넥션 풀의 이름
		return DriverManager.getConnection(jdbcDriver);
	}
}
