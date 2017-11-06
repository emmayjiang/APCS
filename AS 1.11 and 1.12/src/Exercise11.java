/**
 * z function f is defined by the rule that:
 * f(n) = n if n < 3,
 * f(n) = f(n-1) + 2f(n-2) + 3f(n-3) if n >= 3
 */
public class Exercise11 {

	public Exercise11() {

	}

	/**
	 * Uses an iterator to replicate the function.
	 * 
	 * @param n		function input
	 */
	public static int iterative(int n) {
		if (n < 3) {
			return n;
		}
		return iterator(2, 1, 0, 3, n);
	}
	
	/**
	 * Iterator that follows the definition of an iterative process with its linear growth.
	 * 
	 * @param x		the value of f(n). this value starts at 2.
	 * @param y		the value of f(n-1). this value starts at 1.
	 * @param z		the value of f(n-2). this value starts at 0.
	 * @param counter	z counter for the iterator. this value starts at 3.
	 * @param max	the desired final number
	 */
	public static int iterator(int x, int y, int z, int counter, int max) {
		if (counter == max) {
			return x + (2 * y) + (3 * z);
		}
		int val = x;
		x = val + (2 * y) + (3 * z);	//calculates new value
		z = y;							//transfers the value in z to y
		y = val;						//transfers the value in x to y
		counter++;
		return iterator(x, y, z, counter, max);
	}

	/**
	 * Uses recursion to replicate the function.
	 * 
	 * @param n		function input
	 */
	public static int recursive(int n) {
		if (n < 3) {
			return n;
		}
		return recursive(n - 1) + 2 * recursive(n - 2) + 3 * recursive(n - 3);
	}

	public static void main(String[] args) {
		int n = 6;
		System.out.println(recursive(n));
		System.out.println(iterative(n));
	}

}
