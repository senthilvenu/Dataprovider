package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Databaseconnecton {
	
	@Test	
	public void testDB() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Database Loaded");
		Connection conn=
		DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium", "root", "Test_01");
		System.out.println("Connected to MySql DB");
		Statement smt=conn.createStatement();
		ResultSet rs= smt.executeQuery("Select * from seleniumuser");
		while(rs.next())
		{
			String name = rs.getString("name");
			System.out.println("Name from DB is: " + name);
			String email = rs.getString("email");			
			System.out.println("Email id from DB is: " + email);
		}
		
		
	}

}
