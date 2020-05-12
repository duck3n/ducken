package com.exam.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnTest {
	public static void main(String[] args) {
		//MakeConnection.getInstance().getConnection();
		
		try {
			ConnectionProvider.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
