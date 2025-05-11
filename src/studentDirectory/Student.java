package studentDirectory;

import java.util.Scanner;
import java.util.LinkedList;

public class Student {

	
	String name;
	String address;
	double gpa;
	
	public Student(String name, String address, double gpa) {
		this.name = name;
		this.address = address;
		this.gpa = gpa;
	}
	
	public String toString() {
		return "Name: " + name + " |Address: " + address + " |GPA: " + gpa;
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		LinkedList<Student> studentList = new LinkedList<>();
		boolean runDataEntry = true;
		
		System.out.println("Welcome To The Student Database.");
		System.out.println("Please Enter The Required Information");
		System.out.println("When you are finished inputing student data type SAVE in the Student Name field.");
		while(runDataEntry == true) {
			try{
				System.out.println("Student Name:");
				String studentName = scnr.nextLine();
				if(studentName.equals("SAVE")) {
					runDataEntry = false;
					System.out.println("Saving Directory To File!");
					AlphabeticalSort.alphabeticalSort(studentList);
					scnr.close();
				} else {
					System.out.println("Student Address: ");
					String studentAdrs = scnr.nextLine();
					System.out.println("Student GPA: ");
					Double studentGPA = scnr.nextDouble();
					boolean isValidGPA = validateGPA(studentGPA);
					if(isValidGPA == false) {
						throw new IllegalArgumentException("GPA Cannot Be Negative Or Be Above 4.0");
					}
					Student newStudent = new Student(studentName, studentAdrs, studentGPA);
					studentList.add(newStudent);
					scnr.nextLine();
				}
			} catch(NumberFormatException e) {
				System.out.println("Invalid Data Format Numbers Only" + e);
			}
		}
		
	}
	
	public static boolean validateGPA(double studentGPA) {
		if(studentGPA < 0 || studentGPA > 4.0) {
			return false;
		} else {
			return true;
		}
	}
}
