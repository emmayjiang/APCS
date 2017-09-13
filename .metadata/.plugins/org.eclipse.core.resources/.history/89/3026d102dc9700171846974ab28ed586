
public class Main {
	
	/**
	 * Make a class proposition constant that takes a string and stores
	 * Make a class called logical sentence that can take in logical sentences and proposition constants
	 * Make a class called negation that takes in a logical sentence and negates it
	 * Truth assignment class basically has one method called put(constant, Boolean) that sets the constant to true or false
	 * Evaluate is a method inside logical sentence that takes in a truth assignment
	 */
	public static void main(String[] args) {
		
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		LogicalSentence l3 = new Negation(l1);
		LogicalSentence l4 = new Negation(l3);
		LogicalSentence l5 =  new Conjunction(l3, new Negation(l4));

		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b,true);
		ta1.put(a, false); 
		System.out.println(l5.evaluate(ta1));
		System.out.println(legal("a&"));
		System.out.println(findMatch("a(b)", 0));

		String[] pc = {"p"};
		truthTable(pc);
	}
}
