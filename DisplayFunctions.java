import java.io.PrintWriter;
import java.util.List;

/** Copyrights 2016: Vivek Bhansali
 * Project Name: BankStatementAnalysis
 * Package Name: 
 * 
 */

/**
 * @author vhb
 * Mar 9, 2016
 * DisplayFunctions.java
 *
 *
 */
public class DisplayFunctions {

	public void displayAboveMeanTransactions(List<List<Transaction>> list, PrintWriter write) {
		
		for(int i=0; i < 5; i++) {
			
			int index = 0;
			write.println("\nAbove Mean Expenses for Category: "+list.get(i).get(0).getCategory());
			while(index < list.get(i).size()) {
				write.println(list.get(i).get(index));
				index++;
			}
		}
	}
}
