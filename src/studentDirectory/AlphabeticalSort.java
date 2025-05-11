package studentDirectory;

import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class AlphabeticalSort {

	public static void alphabeticalSort(LinkedList<Student> studentList) {
		
		Student temp;
		int n = studentList.size();
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(studentList.get(i).getName().compareTo(studentList.get(j).getName()) > 0 ) {
					
					temp = studentList.get(i);
					studentList.set(i, studentList.get(j));
					studentList.set(j,  temp);
				}
			}
		}
		
		LocalDate today = LocalDate.now();
		String filename = "studentDirectory" + today + ".txt";
		
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
