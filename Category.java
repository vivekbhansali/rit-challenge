
/** Copyrights 2016: Vivek Bhansali
 * Project Name: CostCutting
 * Package Name: 
 * 
 */

/**
 * @author vhb
 * Mar 5, 2016
 * Category.java
 *
 *
 */
public class Category {
  
	private int categoryCount;
	private String categoryName;
	private double categoryAmount;
	private double categoryMean;
	private boolean hasAboveMeanTransactions;
  
	// Constructors for the Category class.
	public Category() {
		categoryCount = 0; 
		categoryName = "defaultCategoryName";
		categoryAmount = 0;
		categoryMean = 0;
		hasAboveMeanTransactions = false;
	}
	
	public Category(String name) {
		categoryCount = 0; 
		categoryName = name;
		categoryAmount = 0;
		categoryMean = 0;
		hasAboveMeanTransactions = false;
	}

	// Return the count of a particular category.
	public int getCategoryCount() {
		return categoryCount;
	}
	
	// Return the name of a particular category.
	public String getCategoryName() {
		return categoryName;
	}
	
	// Return the total amount of a particular category.
	public double getCategoryAmount() {
		return Math.round((categoryAmount * 100D)/100D);
	}
	
	// Increment the count by 1
	public void incrementCategoryCount() {
		categoryCount++;
	}
  
	// Decrement the count by 1
	public void decremenCategoryCount() {
		categoryCount--;
	}

	// Reset a count to 0 for a particular category
	public void resetCategoryCountToZero() {
		categoryCount = 0;
	}
  
	// Reset the count to a given value, as long as it's legal.
	public void resetCategoryCount(int value) {
		categoryCount = value;
	}
	
	public void addAmount(double value) {
		categoryAmount = categoryAmount + value;
	}
	
	public double getCategoryMean() {
		categoryMean = (categoryAmount/categoryCount);
		categoryMean = Math.round((categoryMean * 100D) / 100D);
		return categoryMean;
	}
	
	public boolean hasAboveMeanTransactions() {
		return hasAboveMeanTransactions;
	}
	
	public void setAboveMeanTransactions() {
		hasAboveMeanTransactions = true;
	}
	
}