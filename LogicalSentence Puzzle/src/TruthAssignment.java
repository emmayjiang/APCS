
public class TruthAssignment {
	
	private boolean truthVal;
	
	private PropositionConstant[] pc;
	private boolean[] tv;
	
	private int i = 0;

	public TruthAssignment() {
		
	}
	/**
	 * Stores each proposition constant and their truth value in an array
	 * 
	 * @param propC		The proposition constant
	 * @param truthVal	The truth value of the constant
	 */
	public void put(PropositionConstant propC, boolean truthVal) {
		this.truthVal = truthVal;
		
		i++;
		
		//creates new, longer arrays, to store the information
		PropositionConstant[] pc = new PropositionConstant[i];
		boolean[] tv = new boolean[i];
		
		//fills the new array with values from old array
		for (int j = 0; j < i-1; j++) {
			pc[j] = this.pc[j];
			tv[j] = this.tv[j];
		}
		
		//adds the new values to the new array
		pc[i-1] = propC;
		tv[i-1] = truthVal;
		
		//sets new array as the array stored in the class
		this.pc = pc;
		this.tv = tv;
	}
	
	/**
	 * Gets the truth value of a certain constant.
	 */
	public boolean get() {
		return truthVal;
	}
	
}
