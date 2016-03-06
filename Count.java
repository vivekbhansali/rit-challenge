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
	
	public void iterate(List<List<String>> data) {
		
		for (int i=0; i<data.size(); i++) {
			checkCounts(data.get(i).get(1));
		}
	}
	
	public void checkCounts(String description) {
		// TODO: Add more keywords to categorize all transactions
		
		//food
		if ( description.toLowerCase().contains("pizza") || description.toLowerCase().contains("italian") ||
				description.toLowerCase().contains("cafe") || description.toLowerCase().contains("market") ) {
			//System.out.println(description);
			food.increment();
		}
				
		//travel
		if ( description.toLowerCase().contains("uber") || description.toLowerCase().contains("gas") ||
				description.toLowerCase().contains("shell") || description.toLowerCase().contains("flight") ) {
			//System.out.println(description);
			travel.increment();
		}
		
		//shopping
		if ( description.toLowerCase().contains("walmart") || description.toLowerCase().contains("target") ||
				description.toLowerCase().contains("nordstrom") || description.toLowerCase().contains("amazon") ) {
			//System.out.println(description);
			shopping.increment();
		}
		
		//entertainment
		if ( description.toLowerCase().contains("netflix") || description.toLowerCase().contains("cinema") ||
				description.toLowerCase().contains("movies") || description.toLowerCase().contains("theatre") ) {
			//System.out.println(description);
			entertainment.increment();
		}
		
		//utilities
		if ( description.toLowerCase().contains("rent") || description.toLowerCase().contains("internet") ||
				description.toLowerCase().contains("firstservice") || description.toLowerCase().contains("electric") ) {
			//System.out.println(description);
			utilities.increment();
		}
		
		//misc
		if ( description.toLowerCase().contains("atm") || description.toLowerCase().contains("paypal") ) {
			//System.out.println(description);
			misc.increment();
		}
	}
	
	public void displayCounts() {
		
		System.out.println("Food: " + food.getValue());
		System.out.println("Travel: " + travel.getValue());
		System.out.println("Shopping: " + shopping.getValue());
		System.out.println("Entertainment: " + entertainment.getValue());
		System.out.println("Utilities: " + utilities.getValue());
		System.out.println("Miscellaneous: " + misc.getValue());	
	}
}
