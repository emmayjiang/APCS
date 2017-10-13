/**
 * Contains a method that implement exponentiation using successive squaring.
 * 
 * This project's only requirement was that it implements exponentiation using successive squaring, which is done via the method calculate().
 * 
 * There are no errors. The code is described in comments throughout the method.
 * 
 * Acknowledgements: The equation used for successive squaring was taken from the Wikipedia page.
 */
public class Exponentiation {

	public static int calculate(int x, int y) {
		if (y < 0) {
			return calculate(1 / x, -y);				// checks if y is negative, as squaring things is different for negative numbers.
		} else if (y == 0) {
			return 1;									//checks if the power is 0, because it will always be 1
		} else if (y == 1) {
			return x;									//checks if the power is 1, because it will always be the original number
		} else if (y % 2 == 0) {
			return calculate(x * x, y / 2);				//following the method given by Wikipedia for even numbers
		} else if (y % 2 == 1) {
			return x * calculate(x * x, (y - 1) / 2);	//following the method given by Wikipedia for odd numbers
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.print(calculate(5, 2));
	}

}
