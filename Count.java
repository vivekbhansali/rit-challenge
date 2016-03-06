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
public class Count {
	
	Counter food = new Counter();
	Counter travel = new Counter();
	Counter shopping = new Counter();
	Counter entertainment = new Counter();
	Counter utilities = new Counter();
	Counter misc = new Counter();
	Counter none = new Counter();
	
	public void iterate(List<List<String>> data) {
		
		for (int i=0; i<data.size(); i++) {
			checkCounts(data.get(i).get(1));
		}
	}
	
	public void checkCounts(String description) {
		// TODO: Add more keywords to categorize all transactions
		
		//food - Pattern: '{name} {number}'
		/*if ( description.toLowerCase().contains("pizza") || description.toLowerCase().contains("italian") ||
				description.toLowerCase().contains("cafe") || description.toLowerCase().contains("market") )*/ 
		if(!checkUpperCase(description) && description.matches("^.*?\\d$")){
			System.out.println("Category:Food:: " + description);
			food.increment();
		} else {
				
			//travel - MOBILE GAS, CHEVRON, UBER, SHELL
			if ( description.toLowerCase().contains("uber") || description.toLowerCase().contains("gas") ||
					description.toLowerCase().contains("shell") || description.toLowerCase().contains("chevron") ) {
				System.out.println("Category:Travel:: " + description);
				travel.increment();
			} else {
			
				//shopping
				if ( description.toLowerCase().contains("walmart") || description.toLowerCase().contains("target") ||
						description.toLowerCase().contains("nordstrom") || description.toLowerCase().contains("amazon") ) {
					System.out.println("Category:Shopping:: " + description);
					shopping.increment();
				} else {
				
					//entertainment - ADY*Netflix
					if ( description.toLowerCase().contains("netflix") || description.toLowerCase().contains("cinema") ||
							description.toLowerCase().contains("movies") || description.toLowerCase().contains("theatre") ) {
						System.out.println("Category:Entertainment:: " + description);
						entertainment.increment();
					} else {
					
						//utilities - FIRSTSERVICE, PAYPAL
						if ( description.toLowerCase().contains("rent") || description.toLowerCase().contains("paypal") ||
								description.toLowerCase().contains("firstservice") ) {
							System.out.println("Category:Utilities:: " + description);
							utilities.increment();
						} else {
						
							//misc
							if ( description.toLowerCase().contains("atm") ) {
								System.out.println("Category:Miscellaneous:: " + description);
								misc.increment();
							} else {
								System.out.println("Not categorized:: " + description);
								none.increment();
							}
						}
					}
				}
			}
		}
	}
	
	public void displayCounts() {
		
		int total = food.getValue() + travel.getValue() + shopping.getValue() + 
				entertainment.getValue() + utilities.getValue() + misc.getValue();
		System.out.println("Total Categorized Transactions: " + total);
		System.out.println("Total Uncategorized Transactions: " + none.getValue() + "\n");
		
		System.out.println("***** Categorizing Transactions *****");
		System.out.println("Food: " + food.getValue());
		System.out.println("Travel: " + travel.getValue());
		System.out.println("Shopping: " + shopping.getValue());
		System.out.println("Entertainment: " + entertainment.getValue());
		System.out.println("Utilities: " + utilities.getValue());
		System.out.println("Miscellaneous: " + misc.getValue());	
	}
	
	public static boolean checkUpperCase(String string) {
		boolean upperCase = string.equals(string.toUpperCase());
		return upperCase;
	}
}
