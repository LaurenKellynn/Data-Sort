package cop2805;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

///////////////////////////////////////////////////////
///writtenBy: Lauren Kellynn						///
///date: 09/20/22									///
///purpose: to practice file I/O 					///
///////////////////////////////////////////////////////

public class homeworkFour {

	public static void main(String[] args) {
	
		List<Double> contents = ReadFile("data.txt");
		Collections.sort(contents);
		WriteFile(contents, "data-sorted.txt");
	}
	
	public static List<Double> ReadFile(String path){
		Path file = FileSystems.getDefault().getPath("/Users/lauren/Desktop/Back 2 School/Advanced Java/Eclipse/homeworkOne", path);
		List<Double> doubleList = new ArrayList<Double>();
		
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine() ) {
				String data = reader.nextLine();
				doubleList.add(Double.parseDouble(data));;
			}reader.close(); 
			} catch (IOException e) {
				e.printStackTrace();
				}		
		return doubleList;
	}	
	
	public static void WriteFile(List<Double> data, String file){
		File sorted = new File(file);
		
		try {
			PrintWriter output = new PrintWriter(sorted);
			output.println(data);
			output.close();
			} catch (IOException ex) {
				System.out.printf("ERROR");
			}
	}
}
