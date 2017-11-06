/**
 * The numbers at the edge of the triangle are all 1, and each number inside the triangle is the sum of the two numbers above it.
 * Write a procedure that computes elements of Pascal's triangle by means of a recursive process.
 */
public class Exercise12 {
	
	public Exercise12(int n) {
	}

	/**
	 * Calculates an element of Pascal's triangle given the row and the element's place in the row.
	 * 
	 * @param i		the row of which the element is from
	 * @param j		where the element is in the row
	 */
	public static int Pascal(int i, int j) {
		if (j == 0 || j == i) {
			return 1;
		} else {
			return Pascal(i - 1, j - 1) + Pascal(i - 1, j);
		}
	}

	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		System.out.println(Pascal (x , y));
	}
}
