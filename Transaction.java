/** Copyrights 2016: Vivek Bhansali
 * Project Name: CostCutting
 * Package Name: 
 * 
 */

/**
 * @author vhb
 * Mar 6, 2016
 * Transaction.java
 *
 *
 */
public class Transaction {
	
	//private int ID;
	private String date;
	private String description;
	private double amount;
	private String category = null;
	
	Transaction() {
		date = "";
		description = "";
		amount = 0;
	}
	
	public void put(String date, String description, double amount) {
		this.date = date;
		this.description = description;
		this.amount = amount;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String toString() {
		return this.getDate() + " | " + this.getDescription() + " | " 
	+ this.getAmount() + " | " + this.getCategory();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
