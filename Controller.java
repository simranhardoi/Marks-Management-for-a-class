package com.jasjot.application.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.jasjot.application.app.db.DbConnection;
import com.jasjot.application.app.entities.Student;


public class Controller {
	
	private static Connection con;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rst;

	
	Controller(){
		
	}
	

	public static int storeData(Student stu) {
	    
		int iStore = -1;
		
		try {
			
			con = DbConnection.getConnect();
		    String qry = "insert into student(rno,stname, email, class,gender,marks) values (?,?,?,?,?,?)";
		    // with question marks in values always use prepare statement
		    
		    pst = con.prepareStatement(qry);
		    pst.setInt(1,stu.getRno());
		    pst.setString(2,stu.getStName());
		    pst.setString(3, stu.getEmail());
		    pst.setString(4, stu.getClassName());
		    pst.setString(5,stu.getGender());
		    pst.setInt(6,stu.getMarks());
		    
		   iStore = pst.executeUpdate();
		    
						
		} catch (Exception e) {
			System.out.println("Data registration exception using prepared Statement " + e);
		}
		
		return iStore;
	}




	public static int storeDataUsingStatement(Student stu) {
int iStore =-1;
		
		try {
			con = DbConnection.getConnect();
			st = con.createStatement();
			// for statement query is different than prepared statement
			 String qry = "insert into student(rno,stname, email, class,gender,marks)values("+stu.getRno()+",'"+stu.getStName()+"','"+stu.getEmail()+"','"+stu.getClassName()+"','"+stu.getGender()+"',"+stu.getMarks()+")";
			 iStore=st.executeUpdate(qry);
			
		} catch (Exception e) {
			System.out.println("Data registration exception using Statment " +e);
		}
		
		return iStore;
		
	}




	public static ResultSet retrieveAllData() { // result set store and keeps data with it
		try {
			con = DbConnection.getConnect();
			st = con.createStatement();
			String qry ="Select * from student ";
			rst = st.executeQuery(qry);  // select query is executed with the help of statement so st.execute qry
			                             // as data is stored in result set we will make it equal to rst.
			
			
			
		} catch (Exception e) {
			System.out.println("Data not retrieved "+ e);
		}
		
		return rst;
	}




	public static ResultSet retrieveByEmailId(String email) {
		
		try {
			con = DbConnection.getConnect();
			st = con.createStatement();
			String qry = "Select * from student where email ='"+email+"'";
			rst = st.executeQuery(qry);		
			
			System.out.println(qry);
			
		} catch (Exception e) {
			System.out.println("Data not retrieved" + e);
		}
		
		return rst;
	}




	public static boolean deleteData() {
		
		int iStore = -1;
	
		try { 
			
			con = DbConnection.getConnect();
			st = con.createStatement();
			String qry = "delete from student";
			 iStore = st.executeUpdate(qry);			
			if (iStore>0) {
				return true;
			}
				
		} catch (Exception e) {
			System.out.println("Connection error." + e);
		}
		
		return false;
	}




	public static boolean deleteByRollNo(int rno) {
		
		int iStore =-1;
		  try {
			  con = DbConnection.getConnect();
			  st = con.createStatement();
				String qry = "delete from student where rno =" + rno;
				 iStore = st.executeUpdate(qry);			
				if (iStore>0) {
					return true;
				}
					
			} catch (Exception e) {
				System.out.println("Connection error." + e);
			}
			  
			  
			
		
		
		
		return false;
	}


	public static boolean updateDataByRollNo(int rno) {
		int iStore =-1;
		try {
			con = DbConnection.getConnect();
			st = con.createStatement();
			String qry ="select * from student where rno ="+rno;
			rst = st.executeQuery(qry);
			System.out.println(qry);
			
			if(rst.next()) {
				Scanner in = new Scanner(System.in);
				in.nextLine();
				System.out.println("Please enter the updated name");
				String stname = in.nextLine();
				System.out.println("Please enter the updated emil");
				String email = in.next();
				System.out.println("Please enter the updated class");
				String className = in.next();
				System.out.println("Please enter the updated gender");
				String gender = in.next();
				System.out.println("Please enter the updated marks");
				int marks = in.nextInt();
				
				String qry1 = "Update student set stname =?,email =?,class=?,gender=?,marks=? where rno=?";
				pst = con.prepareStatement(qry1);
				
			  
			    pst.setString(1,stname);
			    pst.setString(2,email);
			    pst.setString(3,className);
			    pst.setString(4,gender);
			    pst.setInt(5,marks);
			    pst.setInt(6,rno);
			    
			    iStore = pst.executeUpdate();
			    if (iStore>0) 
			    	return true;
			}
			else {
				System.out.println("Data not found");
			}
		} catch (Exception e) {
			System.out.println("connection error" + e);
		}
		
		return false;
	}

}
