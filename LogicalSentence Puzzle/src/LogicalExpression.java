
public class LogicalExpression {
	
	static PropositionConstant a = new PropositionConstant("a");
	static PropositionConstant b = new PropositionConstant("b");
	static LogicalSentence logicA = new LogicalSentence(a);
	static LogicalSentence logicB = new LogicalSentence(b);
	
	static TruthAssignment ta1 = new TruthAssignment();
	static boolean[] array = {new Conjunction(logicA, logicB).evaluate(ta1), new Disjunction(logicA, logicB).evaluate(ta1)};
	
	public LogicalExpression() {
		
	}
	
	public static contingent() {
		
	}
	
	public static void main(String[] args) {
		ta1.put(b, true);
		ta1.put(a, false); 
	}

}
