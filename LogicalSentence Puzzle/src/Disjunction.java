
public class Disjunction extends LogicalSentence {
	
	private LogicalSentence l1;
	private LogicalSentence l2;

	public Disjunction(LogicalSentence l1, LogicalSentence l2) {
		this.l1 = l1;
		this.l2 = l2;
	}
	
	public boolean evaluate(TruthAssignment truthVal) {
		boolean retVal = l1.evaluate(truthVal) || l2.evaluate(truthVal);
		
		return retVal;
	}
}
