import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Copyrights 2016: Vivek Bhansali
 * Project Name: CostCutting
 * Package Name: 
 * 
 */

/**
 * @author vhb
 * Mar 2, 2016
 * Main.java
 *
 *
 */
public class FileRead {
	
	//public static List<List<String>> data = new ArrayList<List<String>>();
	
	public static void write(List<List<String>> data) {
		for(int i=0; i < data.size(); i++) {
			for(int j=0; j < data.get(i).size(); j++) {
				System.out.print("| " + data.get(i).get(j) + " | ");
			}
			System.out.println();
		}
	}
	
	public static List<List<String>> read(String file, List<List<String>> data) throws FileNotFoundException {
		
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
		try {
			String line;
			while ((line = br.readLine()) != null) {
				data.add(parse(line));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) 
					br.close();
			} catch (IOException Exception) {
				Exception.printStackTrace();
			}
		}
		
		return data;
	}
	
	public static ArrayList<String> parse(String line) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		if (line != null) {
			String[] splitData = line.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					result.add(splitData[i].trim());
				}
			}
		}
		
		return result;
	}
	
	/*public static void main(String[] args) throws FileNotFoundException {
		
		//String file = "/Users/vivekbhansali/Documents/workspace/CostCutting/bin/Test.txt";
		String file = "/Users/vivekbhansali/Documents/workspace/CostCutting/bin/transactions-person-A.csv";
		
		data = read(file,data);
		write(data);
	}*/
}
