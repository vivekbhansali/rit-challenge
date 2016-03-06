
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
public class Counter {
  
	private int count; // Current value
  
	// Constructors for the Counter class.
	public Counter() {
		count = 0; 
	}

	// Increment the counter by 1
	public void increment() {
		count++;
	}
  
	// Decrement the counter by 1
	public void decrement() {
		count--;
	}

	// Return the value of a Counter.
	public int getValue() {
		return count;
	}
  
	// Reset a Counter to a 0.
	public void resetToZero() {
		count = 0;
	}
  
	// Reset a Counter to a given value, as long as it's legal.
	public void reset(int value) {
		count = value;
	}
	
}