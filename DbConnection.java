
// this class is created for multiple logins and connections
package com.jasjot.application.app.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
     private static Connection con;
     
     
	  public static  Connection getConnect() {
		
		  try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			System.out.println("Connection ready "+ con);
			
			
			
			 
		} catch (Exception e) {
			System.out.println("Connection Exception"+e);
		}
		  
		  
		  return con;

	}
	
	public static void main(String[] args) {
		
	//	getConnect();
		
	}

}


