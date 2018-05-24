
import java.util.Scanner;

public class Search {

	public Search() {
	}

	/**
	 * Checks user input.
	 */
	public static String input() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		return input;
	}

	/**
	 * Checks if a string is made of all numbers.
	 * 
	 * @param str
	 *            input string
	 */
	public static boolean isNumeric(String str) {
		try {
			int n = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Makes everything in the String lowercase.
	 * 
	 * @param str
	 *            input string
	 */
	public static String removeCaps(String str) {
		return str.toLowerCase();
	}

}
