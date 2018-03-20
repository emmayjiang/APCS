
public class Phrase {
	
	private String currentPhrase;
	
	public Phrase(String p) {
		currentPhrase = p;
	}
	
	/** Returns the index of the nth occurrence of str in the current phrase;
	 * returns -1 if the nth occurrence does not exist.
	 * Precondition: str.length() > 0 and n > 0
	 * Postcondition: the current phrase is not modified
	 */
	public int findNthOccurrence(String str, int n) {
		int counter = 0;
		int length = str.length() - 1;
		for (int i = 0; i < currentPhrase.length() - length; i++) {
			if (currentPhrase.substring(i, i+str.length()).equals(str)) {
				counter++;
				if (counter == n) {
					return i;
				}
			}
		}
		return -1;
	}
	
	/** Modifies the current phrase by replacing the nth occurrence of str with repl.
	 * If the nth occurrence does not exist, the current phrase is unchanged.
	 * Precondition: str.length() > 0 and n > 0
	 */
	public void replaceNthOccurrence(String str, int n, String repl) {
		int index = findNthOccurrence(str, n);
		if (index != -1) {
			currentPhrase = currentPhrase.substring(0, index) + repl + currentPhrase.substring(index + str.length(), currentPhrase.length());
		}

	}
	
	/** Returns the index of the last occurrence of str in the current phrase;
	 * returns -1 if str is not found.
	 * Precondition: str.length() > 0
	 * Postcondition: the current phrase is not modified.
	 */
	public int findLastOccurrence(String str) {
		for (int i = currentPhrase.length(); i > 0; i--) {
			if (currentPhrase.substring(i - str.length(), i).equals(str)) {
				return i - str.length() - 2;
			}
		}
		return -1;
	}
	
	/** Returns a strong containing the current phrase */
	public String toString() {
		return currentPhrase;
	}
	
	public static void main(String[] args) {
		Phrase phrase = new Phrase("A cat ate late.");
		phrase.replaceNthOccurrence("at", 1, "rane");
		System.out.println(phrase.toString());
		System.out.println(phrase.findLastOccurrence("at"));
	}
}
