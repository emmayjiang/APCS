
public class Negation extends LogicalSentence {
	
	private LogicalSentence logSen;
	
	public Negation(LogicalSentence logSen) {
		this.logSen = logSen;
	}
	/**
	 * Finds the truth value after a negation is performed.
	 */
	public boolean evaluate(TruthAssignment truthVal) {
		boolean retVal = !logSen.evaluate(truthVal);
		
		return retVal;
	}
}