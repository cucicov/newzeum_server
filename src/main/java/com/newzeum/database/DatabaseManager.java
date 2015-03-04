package com.newzeum.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

	private void exampleConnection() {
		try {
			// add to the Build Path 'C:\Program Files (x86)\MySQL\Connector.J 5.1\mysql-connector-java-5.1.34-bin.jar'
		   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");

		   Statement stmt = conn.createStatement();

		      String sql = "SELECT id, value FROM new_table";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
		         int id  = rs.getInt("id");
		         String value = rs.getString("value");

		         System.out.print("ID: " + id);
		         System.out.println(", Value: " + value);
		      }
		      rs.close();
		    

		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		}
	}
	
}
