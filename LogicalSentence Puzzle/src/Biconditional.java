
public class Biconditional extends LogicalSentence {
	
	private LogicalSentence l1;
	private LogicalSentence l2;

	public Biconditional(LogicalSentence l1, LogicalSentence l2) {
		this.l1 = l1;
		this.l2 = l2;
	}
	
	public boolean evaluate(TruthAssignment truthVal) {
		boolean retVal = false;
		if (l1.evaluate(truthVal) == l2.evaluate(truthVal)) {
			retVal = true;
		}
		
		return retVal;
	}
}
