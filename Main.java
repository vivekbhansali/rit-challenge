import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/** Copyrights 2016: Vivek Bhansali
 * Project Name: CostCutting
 * Package Name: 
 * 
 */

/**
 * @author vhb
 * Mar 5, 2016
 * Main.java
 *
 *
 */
public class Main {
	
	public static List<List<String>> data = new ArrayList<List<String>>();
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		//String file = "/Users/vivekbhansali/Documents/workspace/CostCutting/bin/Test.txt";
		String file = "transactions-person-A.csv";
		
		FileRead fr = new FileRead();
		Count c = new Count();
		
		// Read CSV File
		data = fr.read(file,data);
		
		// Display the contents of CSV file 
		//fr.write(data);
		
		// Iterate over description part and categorize the transaction
		c.iterate(data);
		
		// Display the transactions according to categories
		System.out.println("***** Categorizing Transactions *****");
		c.displayCounts();
	}

}
