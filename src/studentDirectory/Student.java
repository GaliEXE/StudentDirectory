package studentDirectory;

import java.util.Scanner;
import java.util.LinkedList;

public class Student {

	/**
	 * Initialize Class Variables
	 */
	String name;
	String address;
	double gpa;

	/**
	 * Student Object For List
	 * @param name Student's Name
	 * @param address Student's Address
	 * @param gpa Student's GPA
	 */
	public Student(String name, String address, double gpa) {
		this.name = name;
		this.address = address;
		this.gpa = gpa;
	}
	
	/**
	 * @return Student Object As A String
	 */
	public String toString() {
		return "Name: " + name + " |Address: " + address + " |GPA: " + gpa;
	}
	
	/**
	 * Name Getter Function
	 * @return student name
	 */
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
				/**
				 * Will Check If The Person Wishes To Save by checking if SAVE is typed in the student field
				 */
				if(studentName.equals("SAVE")) {
					runDataEntry = false;
					System.out.println("Saving Directory To File!");
					/**
					 * Will Sort The Student List Alphabetically and Print To File
					 */
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
				/**
				 * Will Catch Number Format Error If GPA Input Is Not A Number.
				 */
			} catch(NumberFormatException e) {
				System.out.println("Invalid Data Format Numbers Only" + e);
			}
		}
		
	}
	
	/**
	 * Validates GPA by checking if GPA entered is above 4.0 or below 0 which would be invalid GPA's
	 * If GPA Entered wasn't a number will be caught by NumberFormatException in the try/catch block.
	 * @param studentGPA Student's GPA
	 * @return If Valid Returns True If Not Returns False
	 */
	public static boolean validateGPA(double studentGPA) {
		if(studentGPA < 0 || studentGPA > 4.0) {
			return false;
		} else {
			return true;
		}
	}
}
