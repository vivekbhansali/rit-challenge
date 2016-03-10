import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/** Copyrights 2016: Vivek Bhansali
 * Project Name: CostCutting
 * Package Name: 
 * 
 */

/**
 * @author vhb
 * Mar 8, 2016
 * CategoryCount.java
 *
 *
 */
public class CatergoryFunctions {
	
	public List<Category> categoryObjects = new ArrayList<Category>();
	
	Category food = new Category(Constants.CATEGORY_NAME_FOOD);
	Category travel = new Category(Constants.CATEGORY_NAME_TRAVEL);
	Category shopping = new Category(Constants.CATEGORY_NAME_SHOPPING);
	Category entertainment = new Category(Constants.CATEGORY_NAME_ENTERTAINMENT);
	Category utilities = new Category(Constants.CATEGORY_NAME_UTILITIES);
	Category misc = new Category(Constants.CATEGORY_NAME_MISCELLANEOUS);
	Category none = new Category(Constants.CATEGORY_NAME_NONE);
	
	public void iterateTransactionObjects(List<Transaction> tr) {
		
		String category = "";
		for (int i=0; i<tr.size(); i++) {
			category = countCatergories(tr.get(i).getDescription(), tr.get(i).getAmount());
			tr.get(i).setCategory(category);
		}
	}
	
	public String countCatergories(String description, double amount) {
		// TODO: Better categorization
		
		createCategoryObjects();
		
		//food - Pattern: '{name} {number}' 
		if(!checkUpperCase(description) && description.matches("^.*?\\d$")){
			//System.out.println("Category:Food:: " + description);
			food.incrementCategoryCount();
			food.addAmount(amount);
			
		} else {		
			//travel - MOBILE GAS, CHEVRON, UBER, SHELL
			if ( description.toLowerCase().contains("uber") || description.toLowerCase().contains("gas") ||
					description.toLowerCase().contains("shell") || description.toLowerCase().contains("chevron") ) {
				//System.out.println("Category:Travel:: " + description);
				travel.incrementCategoryCount();
				travel.addAmount(amount);
				
			} else {
				//shopping
				if ( description.toLowerCase().contains("walmart") || description.toLowerCase().contains("target") ||
						description.toLowerCase().contains("nordstrom") || description.toLowerCase().contains("amazon") ) {
					//System.out.println("Category:Shopping:: " + description);
					shopping.incrementCategoryCount();
					shopping.addAmount(amount);
					
				} else {
					//entertainment - ADY*Netflix
					if ( description.toLowerCase().contains("netflix") || description.toLowerCase().contains("cinema") ||
							description.toLowerCase().contains("movies") || description.toLowerCase().contains("theatre") ) {
						//System.out.println("Category:Entertainment:: " + description);
						entertainment.incrementCategoryCount();
						entertainment.addAmount(amount);
						
					} else {
						//utilities - FIRSTSERVICE, PAYPAL
						if ( description.toLowerCase().contains("rent") || description.toLowerCase().contains("firstservice") ) {
							//System.out.println("Category:Utilities:: " + description);
							utilities.incrementCategoryCount();
							utilities.addAmount(amount);
							
						} else {
							//misc
							if ( description.toLowerCase().contains("atm") || description.toLowerCase().contains("paypal") ) {
								//System.out.println("Category:Miscellaneous:: " + description);
								misc.incrementCategoryCount();
								misc.addAmount(amount);
								
							} else {
								System.out.println("Not categorized:: " + description);
								none.incrementCategoryCount();
								none.addAmount(amount);
								
								return "None";
							}
							return "Miscellaneous";
						}
						return "Utilities";
					}
					return "Entertainment";
				}
				return "Shopping";
			}
			return "Travel";
		}
		return "Food";
	}
	
	public void displayInfo(PrintWriter write) {
		
		int totalTransactions;
		double totalAmount;
		
		write.println("Total Transactions: " + Main.transactionObjects.size());
		
		totalTransactions = food.getCategoryCount() + travel.getCategoryCount() + shopping.getCategoryCount() + 
				entertainment.getCategoryCount() + utilities.getCategoryCount() + misc.getCategoryCount();
		write.println("Total Categorized Transactions: " + totalTransactions);
		
		write.println("Total Uncategorized Transactions: " + none.getCategoryCount());
		
		totalAmount = food.getCategoryAmount() + travel.getCategoryAmount() + shopping.getCategoryAmount() + 
				entertainment.getCategoryAmount() + utilities.getCategoryAmount() + misc.getCategoryAmount();
		write.println("Total Amount Spent: $" + totalAmount);
	}
	
	public void displayCounts(PrintWriter write) {
		
		write.println();
		write.println("***** Transaction Count per Category *****");
		write.println("Food: " + food.getCategoryCount());
		write.println("Travel: " + travel.getCategoryCount());
		write.println("Shopping: " + shopping.getCategoryCount());
		write.println("Entertainment: " + entertainment.getCategoryCount());
		write.println("Utilities: " + utilities.getCategoryCount());
		write.println("Miscellaneous: " + misc.getCategoryCount());
		write.println("None: " + none.getCategoryCount());
	}
	
	public void displayAmount(PrintWriter write) {
		
		write.println();
		write.println("***** Total Transaction Amount per Category *****");
		write.println("Food: $" + food.getCategoryAmount());
		write.println("Travel: $" + travel.getCategoryAmount());
		write.println("Shopping: $" + shopping.getCategoryAmount());
		write.println("Entertainment: $" + entertainment.getCategoryAmount());
		write.println("Utilities: $" + utilities.getCategoryAmount());
		write.println("Miscellaneous: $" + misc.getCategoryAmount());
		write.println("None: $" + none.getCategoryAmount());
	}
	
	public void displayMean(PrintWriter write) {
		
		write.println();
		write.println("***** Mean amount spent for each Category *****");
		write.println("Food: $" + food.getCategoryMean());
		write.println("Travel: $" + travel.getCategoryMean());
		write.println("Shopping: $" + shopping.getCategoryMean());
		write.println("Entertainment: $" + entertainment.getCategoryMean());
		write.println("Utilities: $" + utilities.getCategoryMean());
		write.println("Miscellaneous: $" + misc.getCategoryMean());
		write.println("None: $" + none.getCategoryMean());
	}
	
	public static boolean checkUpperCase(String string) {
		boolean upperCase = string.equals(string.toUpperCase());
		return upperCase;
	}
	
	public void createCategoryObjects() {
		
		categoryObjects.add(food);
		categoryObjects.add(travel);
		categoryObjects.add(shopping);
		categoryObjects.add(entertainment);
		categoryObjects.add(utilities);
		categoryObjects.add(misc);
		categoryObjects.add(none);
	}
}
