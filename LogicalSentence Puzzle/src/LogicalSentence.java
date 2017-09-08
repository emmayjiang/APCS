/**
 * Contains the method legalSentence, which determines whether it represents a legal propositional logic sentence.
 * A logical sentence is:
 * 1) a simple sentence, which is simply a propositional constant
 * 2) a logical sentence that begins with ~ and is followed by a legal propositional logic sentence.
 * 3) a logical sentence that begins with a logical sentence, is followed by a logical operator, and ends with a logical sentence.
 * Note: "" is not a legal sentence.
 * 
 * The legalSentence method goes and checks through all the different combinations where a logical sentence could turn out to not be legal,
 * and then if it is discovered that there is something that goes against a logical sentence, the method will return false.
 * 
 * The major challenges I encountered was that there were so many combinations of mistakes that could happen that I had to test many sentences until
 * I was sure I had caught most if not all of them.
 * 
 * This method does not account for paranthesis.
 * 
 * @author Emma Jiang
 * @version 8/15/2017
 *
 */
public class LogicalSentence {
	
	/**
	 * A method that tests if a string is a legal logical sentence.
	 * 
	 * @param str	the input string
	 * @return		true: is a legal logical sentence
	 * 				false: is not a legal logical sentence
	 */
	public static boolean legalSentence(String orgStr) {
		//removes spaces
		String str = removeSpace(orgStr);
		
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
}
