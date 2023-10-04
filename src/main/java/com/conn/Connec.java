package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Connec {

	private static Connection con;
	public static Connection getco() {
		if(con==null) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Sankha325#@");
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
			}
		return con;
	}
}
