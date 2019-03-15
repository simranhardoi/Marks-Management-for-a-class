package com.jasjot.application.app.main;

import java.sql.ResultSet;
import java.util.Scanner;

import com.jasjot.application.app.entities.Student;
import com.jasjot.application.app.service.Controller;

public class MainClass {
    private	 Scanner inputKeyboard;
    Student stu;
    
	public MainClass() {
		
		inputKeyboard = new Scanner(System.in);
		
		//storeData();
    	//storeDataUsingStatement();
		//retrieveAllData();
		//retrieveByEmailId();
		//deleteData();
		//deleteByRollNo();
		updateDataByRollNo();
		
	
		
	}
		
   private void updateDataByRollNo() {
	   
	   boolean status = Controller.updateDataByRollNo(1);
	   
	   if (status) {
			System.out.println("Requetsed data got updated successfully. ");
		}
		
		else {
			System.out.println("Data not updated");
		}
		
		
	}

private void deleteByRollNo() {
	   boolean status = Controller.deleteByRollNo(1);
		
		if (status) {
			System.out.println("Requetsed data got deleted. ");
		}
		
		else {
			System.out.println("Data not deleted");
		}
		
	}

private void deleteData() {
		boolean status = Controller.deleteData();
		
		if (status) {
			System.out.println("Requetsed data got deleted. ");
		}
		
		else {
			System.out.println("Data not deleted");
		}
		
	}

private void retrieveByEmailId() {
		 try {
			 ResultSet rst = Controller.retrieveByEmailId("jasjot@gmail.com");
			 System.out.println("rno  stname  email  class  gender  marks");
			 if (rst.next()) {
				 System.out.print(rst.getInt(1)+" "+rst.getString(2)+" "+ rst.getString(3)+" "+ rst.getString(4)+" "+ rst.getString(5)+" "+rst.getInt(6));
				   System.out.println();
				 
			 }
			
		} catch (Exception e) {
			System.out.println(e);
		}
	   
	 
		
	}

private void retrieveAllData() {
	   
	   try {
		
		   ResultSet rst = Controller.retrieveAllData();
		   
		   System.out.println("rno  stname  email  class  gender  marks");
		   while (rst.next()) {
			   
			   System.out.print(rst.getInt(1)+" "+rst.getString(2)+" "+ rst.getString(3)+" "+ rst.getString(4)+" "+ rst.getString(5)+" "+rst.getInt(6));
			   System.out.println();
		   }
		   
	} catch (Exception e) {
		System.out.println(e);
		
	}
		
	}

private void storeDataUsingStatement() {
		
		stu = new Student();
		System.out.println("Enter rno:");
	    stu.setRno(inputKeyboard.nextInt());
	    
	    inputKeyboard.nextLine();
		System.out.println("Enter stName:");
		stu.setStName(inputKeyboard.nextLine());
		
			
		System.out.println("Enter email:");
		stu.setEmail(inputKeyboard.next());
		
		System.out.println("Enter className:");
		stu.setClassName(inputKeyboard.next());
		
		System.out.println("Enter gender:");
		stu.setGender(inputKeyboard.next());
		
		System.out.println("Enter marks:");
		stu.setMarks(inputKeyboard.nextInt());
		
	    int iStore = Controller.storeDataUsingStatement(stu);
		if (iStore>0) {
			System.out.println("Data stored in db - application.");
		}
		else {
			System.out.println("data is not stored in db - application.");
		}
		
		
	}

private void storeData() {
		
		stu = new Student();
		System.out.println("Enter rno:");
	    stu.setRno(inputKeyboard.nextInt());
	    
	    
	    inputKeyboard.nextLine();
		System.out.println("Enter stName:");
		stu.setStName(inputKeyboard.nextLine());
		
			
		System.out.println("Enter email:");
		stu.setEmail(inputKeyboard.next());
		
		System.out.println("Enter className:");
		stu.setClassName(inputKeyboard.next());
		
		System.out.println("Enter gender:");
		stu.setGender(inputKeyboard.next());
		
		System.out.println("Enter marks:");
		stu.setMarks(inputKeyboard.nextInt());
		
	    int iStore = Controller.storeData(stu);
		if (iStore>0) {
			System.out.println("Data stored in db - application.");
		}
		else {
			System.out.println("data is not stored in db - application.");
		}
		
	}




	public static void main(String[] args) {
		MainClass mc = new MainClass ();
	}

}
