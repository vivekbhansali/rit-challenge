import java.util.ArrayList;
import java.util.List;

/** Copyrights 2016: Vivek Bhansali
 * Project Name: CostCutting
 * Package Name: 
 * 
 */

/**
 * @author vhb
 * Mar 7, 2016
 * Functions.java
 *
 *
 */
public class Functions {

	public List<List<Transaction>> compareTransactionsToMeanByCategory(List<Transaction> transactionObjects, List<Category> categoryObjects) {
		
		List<List<Transaction>> aboveMeanTransactions = new ArrayList<List<Transaction>>();
		ArrayList<Transaction> tempTransaction;
		
		for(Category category : categoryObjects) {
			tempTransaction = new ArrayList<Transaction>();
			String categoryName = category.getCategoryName();
			double categoryMean = category.getCategoryMean();
			for(Transaction transaction : transactionObjects) {
				String transactionCategoryName = transaction.getCategory();
				double transactionAmount = transaction.getAmount();
				if(categoryName.equals(transactionCategoryName)) {
					if(transactionAmount > categoryMean) {
						category.setAboveMeanTransactions();
						tempTransaction.add(transaction);
					}
				}
			}
			if(!tempTransaction.isEmpty())
				aboveMeanTransactions.add(tempTransaction);
		}
		return aboveMeanTransactions;
	}
}
