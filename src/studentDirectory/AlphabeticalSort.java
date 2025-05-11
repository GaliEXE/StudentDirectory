package studentDirectory;

import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class AlphabeticalSort {

	public static void alphabeticalSort(LinkedList<Student> studentList) {
		
		Student temp;
		int n = studentList.size();
		
		/**
		 * Alphabetically Sorts Student Names And Reorders Them To Be In Alphabetical Order.
		 */
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(studentList.get(i).getName().compareTo(studentList.get(j).getName()) > 0 ) {
					
					temp = studentList.get(i);
					studentList.set(i, studentList.get(j));
					studentList.set(j,  temp);
				}
			}
		}
		
		/**
		 * Dynamic File Name Will Add The Date The File Was Created In Its Name
		 */
		LocalDate today = LocalDate.now();
		String filename = "studentDirectory" + today + ".txt";
		
		/**
		 * Writes Student Objects To File As Strings
		 */
		try(FileWriter writer = new FileWriter(filename)){
			
			for(int i = 0; i < n; i++) {
				String stringToGet = studentList.get(i).toString();
				writer.write(stringToGet + "\n");
			}
			
			System.out.println("File Successfully Saved To " + filename);
		} catch (IOException e) {
			System.out.println("An Error Occured While Writing To File! " + e);
		}
				
	}
}
