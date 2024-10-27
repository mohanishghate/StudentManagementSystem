package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>();// initialization of courses

		}
	}

	private boolean validateStudentId(String studentId) {
		String studentIdRegex = "S-\\d+$";// S-\\d+$ d means digit or S-[0-9]+$
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid student ID...Use the format Eg.S-1232");
			return false;
		}
	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course) && validateCourseName(course)) {

				courses.add(course);
				System.out.println("Student is enrolled to " + course + " successfully");

			} else {
				System.err.println("Student is already enrolled to " + course + "course");

			}
		}

	}

	public void printStudentInfo() {
		System.out.println("==========Student Information==========");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Enrolled For: " + courses);
	}

	// Validation
	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid age !!! Student age needs to be in between 19 and 35");
			return false;
		}
	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);

		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid name!! Please enter alphabets only");
			return false;
		}
	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps")) {
			return true;
		} else {

			System.err.println("Invalid courseName!! Please select courses from the list!![Java,DSA,Devops]");
			return false;
		}
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

}
