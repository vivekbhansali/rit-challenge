import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
	public static List<Transaction> transactionObjects = new ArrayList<Transaction>();
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		System.out.println("Lets go on Terminal...\n");
		
		PrintWriter write = new PrintWriter("output.txt","UTF-8");
		
		write.println();
		write.println("BANK STATEMENT ANALYSIS\n");
		
		String file = "/Users/vivekbhansali/Documents/workspace/Files/transactions-person-A.csv";
	
		CatergoryFunctions categoryFunction = new CatergoryFunctions();
		Functions function = new Functions();
		DisplayFunctions displayFunction = new DisplayFunctions();
		
		// Read CSV File
		data = FileRead.read(file,data);
		
		// Display the contents of CSV file 
		//FileRead.write(data);
	
		createTransactionObjects();
		categoryFunction.iterateTransactionObjects(transactionObjects);
		
		// Display the general info transactions by categories
		categoryFunction.displayInfo(write);
				
		// Display the count of transactions by categories
		categoryFunction.displayCounts(write);
		
		// Display the count of transactions by categories
		categoryFunction.displayAmount(write);
		
		// Display the mean for categories
		categoryFunction.displayMean(write);
		
		List<List<Transaction>> aboveMeanTransactions = function.compareTransactionsToMeanByCategory(transactionObjects, categoryFunction.categoryObjects);
		displayFunction.displayAboveMeanTransactions(aboveMeanTransactions, write);
		
		write.close();
		
		System.out.println("That's it for now! Check output.txt");
	}
	
	public static void createTransactionObjects() {
		
		for(int i=0; i<data.size(); i++) {
			Transaction newTransaction = new Transaction();
			newTransaction.put(data.get(i).get(0), data.get(i).get(1), Double.parseDouble(data.get(i).get(2)));
			transactionObjects.add(newTransaction);
		}		
	}
}
