
public class LogicalSentence {
	
	private PropositionConstant propC;
	
	public LogicalSentence() {
		
	}
	
	public LogicalSentence(PropositionConstant a) {
		propC = a;
	}
	
	public static void main(String[] args) {
		
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		LogicalSentence l3 = new Negation(l1);
		LogicalSentence l4 = new Negation(l3);
		LogicalSentence l5 = new Conjunction(l3, new Negation(l4));

		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b, true);
		ta1.put(a, false); 
		System.out.println(l5.evaluate(ta1));
		System.out.println(legal("a&"));
		System.out.println(findMatch("a(b)", 0));

		String[] pc = {"p"};
		truthTable(pc);
	}
	
	/**
	 * Prints a truth table.
	 * NOTE: does not support logical expressions - only propositional constants
	 * 
	 * @param arr
	 */
	public static void truthTable(String[] arr) {
		int length = (int) Math.pow(2, arr.length);
		
		//prints header for truth table
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		
		//number of rows for truth table
		for (int j = 0; j < length; j++) {
			//decides what occupies each row in the table
			for (int n = 1; n <= arr.length; n++) {
				//decides whether to print true or false
				if (((int) (j / Math.pow(2, arr.length - n)) % 2) == 0) {
					System.out.print("T");
				} else {
					System.out.print("F");
				}
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * Returns the truth value of a logical sentence.
	 * 
	 * @param truthVal	the truth assignment of the logical sentence.
	 * @return			if the logical sentence is true / false
	 */
	public boolean evaluate(TruthAssignment truthVal) {
		boolean retVal = truthVal.get();
		
		return retVal;
	}
	
	/**
	 * A method that tests if a string is a legal logical sentence. This method is edited from the assignment LegalSentence.
	 * 
	 * This method does not take into account parenthesis.
	 * 
	 * @param str	the input string
	 * @return		true: is a legal logical sentence
	 * 				false: is not a legal logical sentence
	 */
	public static boolean legal(String str) {
		//removes spaces
		str = removeSpace(str);
		
		//uses findMatch to figure out if parenthesis are legal
		int counter = 0;
			
		//checks for amount of closing parenthesis
		String pString = str.substring(findMatch(str, 0), str.length());
		for (int i = 0; i < pString.length(); i++) {
			if (pString.substring(i, i+1).equals(")")) {
				counter++;
			}
		}
		
		//checks if number of open parenthesis matches the number of closing
		String aString = str.substring(0, findMatch(str,0));
		for (int i = 0; i < aString.length(); i++) {
			if (aString.substring(i, i+1).equals("(")) {
				counter--;
			}
		}
				
		if (counter != 0) {
			return false;
		}
		
		//checks for "" which is an illegal sentence
		if (str.equals("")) {
			return false;
		}
		//checks to make sure it does not end with a logical operator
		if (str.substring(str.length()-1,str.length()).equals("&") || str.substring(str.length()-1,str.length()).equals("|")
				|| str.substring(str.length()-1,str.length()).equals("~")) {
			return false;
		}
		if (str.length() >= 2) {
			 if (str.substring(str.length()-2,str.length()).equals("=>")) {
				 return false;
			}
		}
		if (str.length() >= 3) {
			if (str.substring(str.length()-3,str.length()).equals("<=>")) {
				return false;
			}
		}
		//checks if it begins with any Logical Operator besides "~"
		if (str.substring(0,1).equals("&") || str.substring(0,1).equals("|")) {
			return false;
		}
		if (str.length() >= 2) {
			if (str.substring(0,2).equals("=>")) {
				return false;
			}
		}
		if (str.length() >= 3) {
			if (str.substring(0,3).equals("<=>")) {
				return false;
			}
		}
				
		//checks that there are no cases where two operators are together unless it's "~"
		for (int i = 0; i < str.length()-1; i++)
		{
			if (str.substring(i,i+1).equals("&") || str.substring(i,i+1).equals("|") || str.substring(i,i+1).equals("~")
					|| str.substring(i,i+2).equals("=>") || str.substring(i,i+3).equals("<=>")) {
				if (str.substring(i+1,i+2).equals("&") || str.substring(i+1,i+2).equals("|")) {
					return false;
				}
			}
		}
		
		for (int i = 0; i < str.length()-4; i++)
		{
			if (str.substring(i,i+2).equals("=>")) {
				if (str.substring(i+2,i+3).equals("&") || str.substring(i+2,i+3).equals("|")
						|| str.substring(i+2,i+4).equals("=>") || str.substring(i+2,i+5).equals("<=>")) {
					return false;
				}
			}
		}
		for (int i = 0; i < str.length()-5; i++)
		{
			if (str.substring(i,i+3).equals("<=>")) {
				if (str.substring(i+3,i+4).equals("&") || str.substring(i+3,i+4).equals("|")
						|| str.substring(i+3,i+5).equals("=>") || str.substring(i+3,i+6).equals("<=>")) {
					return false;
				}
			}
		}
		
		//checks that no two letters are next to each other
		for (int i = 0; i < str.length()-1; i++) {
			if (str.substring(i,i+1).compareTo("A") >= 0 && str.substring(i,i+1).compareTo("Z") <= 0) {
				if (str.substring(i+1,i+2).compareTo("A") >= 0 && str.substring(i+1,i+2).compareTo("Z") <= 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * A helper method that removes all spaces inside a string
	 * 
	 * @param str	the input string
	 * @return		the input string without any spaces
	 */
	public static String removeSpace(String str) {
		String str2 = "";
		for (int i = 0; i < str.length(); i++) {
			if (!(str.substring(i, i+1).equals(" "))) {
				str2 = str2 + str.substring(i, i+1);
			}
		}
		return str2;
	}
	
	/**
	 * Returns the index of the rightmost character in the first substring of the argument that is enclosed by matching parenthesis and which contains no parenthesis.
	 * 
	 * @param str	the string that will be checked for parenthesis
	 * @param x		the index of the rightmost letter next to the closing parenthesis
	 * @return		see x
	 */
	public static int findMatch(String str, int x) {
		//checks for the opening parenthesis
		for (int i = 0; i < str.length()-1; i++) {
			if (str.substring(i,i+1).equals("(")) {
				//checks for the closing parenthesis
				for (int j = str.length()-2; j > i; j--) {
					if (str.substring(j,j+1).equals(")")) {
						//checks for any parenthesis within the two parenthesis by calling the method recursively
						str = str.substring(i, j+1);
						x = str.indexOf(")") - 1;
						findMatch(str, x);
					} else {
						return str.indexOf(")") - 1;
					}
				}
			}
		}
		return x;
	}
}
