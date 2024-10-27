package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	private static List<Student> studentList;
	private static Scanner sc;
	
	public static void main(String[] args) {
		System.out.println("*********Student Management System*********");
		studentList=new ArrayList<Student>();
		sc= new Scanner(System.in);
		
	while(true) {
	
		System.out.println("*********Welcome*********");
		System.out.println("Select an option");
		System.out.println("1.Register a student");
		System.out.println("2.Find a student with studentId");
		System.out.println("3.List all student information");
		System.out.println("4.List student information in sorted order");
		System.out.println("5.Exit"); 
		int option=sc.nextInt();
		switch(option) {
			case 1:enrollStudent(sc);
				   break;
			case 2:findStudentById(sc);
				   break;
			case 3:printAllStudentData();
					break;
			case 4:sortByName();
					break;
			case 5:exit();
					break;
			default:System.out.println("Invalid option selected..Enter between 1 to 5");
		
		}
	}
	}

	private static void exit() {
	System.exit(0);
		
	}

	private static void printAllStudentData() {
		if(studentList.size()>0)
		{
			System.out.println("--------Printing all student data---------");
			for (Student student : studentList) {
				student.printStudentInfo();
			}
		}
		else
		{
			System.err.println("Student list is empty! No student record found");
		}
		
	}

	private static void findStudentById(Scanner sc2) {
		Student studenFound = null;
		System.out.println("Enter the student id");
		String studentId=sc2.next();
		try
		{
			studenFound=studentList.stream().filter(student->student.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(()->new RuntimeException("No Data found"));
		}
		catch(Exception e)
		{
			System.err.println("Student with ID "+studentId+" not found");
		}
		
		studenFound.printStudentInfo();
		
	}

	private static void enrollStudent(Scanner sc2) {
		System.out.println("Enter the student name");
		String studentName=sc2.next();
		
		System.out.println("Enter the student age");
		int studentAge=sc2.nextInt();
		
		System.out.println("Enter the student id");
		String studentId=sc2.next();
		
		Student newStudent= new Student(studentName,studentAge,studentId);
		studentList.add(newStudent);
		
		
		while(true)
		{
			System.out.println("Enter the course to be enrolled..type Done to exit");
			String courseName=sc2.next();
			if(courseName.equalsIgnoreCase("done"))
			{
				break;
			}
			newStudent.enrollCourse(courseName);
		}
		newStudent.printStudentInfo();
	}

	private static void sortByName() {
	
		Comparator<Student> studentNameComparator=(o1,o2)->o1.getName().compareTo(o2.getName());
		/*Comparator<Student> studentNameComparator=new Comparator<Student>()
		{
					@Override
					public int compare(Student o1, Student o2) {
						// TODO Auto-generated method stub
						return o1.getName().compareTo(o2.getName());
					}
			
		};*/
		Collections.sort(studentList,studentNameComparator);
		printAllStudentData();
	}

	public static Student findStudentById(String studentId)
	{
		Student result = null;
		try
		{
			result=studentList.stream().filter(x->x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(()->new RuntimeException("No Data found"));
		}
		catch(Exception e)
		{
			System.err.println("Student with ID "+studentId+" not found");
		}
		
		return result;
	}
}
