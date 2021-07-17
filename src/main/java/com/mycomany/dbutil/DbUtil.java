package com.mycomany.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static Connection con;

	private DbUtil() {
	
	}

	public static Connection createConnection()  {//Singelton pattern
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_management", "root","1234567890");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection Established :"+ con);
		return con;
	}		
}

//public static Connection createConnection()  {//Singelton pattern
//	//	con = DriverManager.getConnection("jdbc:mysql:localhost:3306/customer_manangement?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","1234567890");
//		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_management", "root","1234567890");
//		System.out.println("Connection Established :"+ con);
//		return con;
//	}		