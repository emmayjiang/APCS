
import java.util.ArrayList;

public class Vocab14 {

	public Vocab14() {

	}

	/**
	 * Represents an union in code.
	 */
	public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int e : a) {
			result.add(e);
		}

		for (int e : b) {
			result.add(e);
		}

		return result;
	}

	/**
	 * Represents an intersection in code.
	 */
	public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int e : a) {
			for (int f : b) {
				if (e == f) {
					result.add(e);
				}
			}
		}

		return result;
	}

	/**
	 * Finds set difference
	 */
	public static ArrayList<Integer> setDifference(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		result = union(a, b);

		result.removeAll(intersection(a, b));

		return result;
	}

	/**
	 * Limit
	 * 
	 * polynomials must be written with monomials in descending order
	 * 
	 * there must be spaces between terms and operators
	 * 
	 * if the monomial doesn't contain a power of x, write x^1 to avoid errors
	 * 
	 * if no coefficient, write coefficient as 1 to avoid errors
	 * 
	 * String a: top of fraction
	 * 
	 * String b: bottom of fraction
	 */
	public static Double limit(String a, String b) {
		int coefficientA = 0;
		int coefficientB = 0;
		int powerA = 0;
		int powerB = 0;
		int xLocateA = 0;
		int xLocateB = 0;

		for (int i = 1; i < a.length(); i++) {
			if (a.substring(i, i + 1).equals("x")) {
				coefficientA = Integer.parseInt(a.substring(0, i));
				xLocateA = i;
				break;
			}
		}
		for (int j = 0; j < a.length(); j++) {
			if (a.substring(j, j + 1).equals(" ")) {
				powerA = Integer.parseInt(a.substring(xLocateA + 2, j));
				break;
			}
		}

		for (int i = 1; i < b.length(); i++) {
			if (b.substring(i, i + 1).equals("x")) {
				coefficientB = Integer.parseInt(b.substring(0, i));
				xLocateB = i;
				break;
			}
		}
		for (int j = 0; j < b.length(); j++) {
			if (b.substring(j, j + 1).equals(" ")) {
				powerB = Integer.parseInt(b.substring(xLocateB + 2, j));
				break;
			}
		}

		if (powerA > powerB) {
			return Double.POSITIVE_INFINITY;
		} else if (powerA == powerB) {
			return (double) (coefficientA / coefficientB);
		} else {
			return (double) 0;
		}
	}

	/**
	 * l'hopital's rule
	 * 
	 * only works for lim -> 0, lim -> inf, lim -> -inf
	 * 
	 * only works for monomials with x as the variable
	 * 
	 * if the monomial doesn't contain a power of x, write x^1 to avoid errors
	 * 
	 * if no coefficient, write coefficient as 1 to avoid errors
	 */
	public static String lHopitalRule(String a, String b) {
		int coefficientA = 0;
		int coefficientB = 0;
		int powerA = 0;
		int powerB = 0;

		for (int i = 1; i < a.length(); i++) {
			if (a.substring(i, i + 1).equals("x")) {
				coefficientA = Integer.parseInt(a.substring(0, i));
			}
		}

		powerA = b.length() - 1;

		for (int i = 1; i < b.length(); i++) {
			if (b.substring(i, i + 1).equals("x")) {
				coefficientB = Integer.parseInt(b.substring(0, i));
			}
		}

		powerB = b.length() - 1;

		coefficientA = coefficientA * powerA;
		powerA = powerA - 1;

		coefficientB = coefficientB * powerB;
		powerB = powerB - 1;

		return coefficientA + " x ^ " + powerA + " / " + coefficientB + " x ^ " + powerB;
	}

	/**
	 * Calculates standard deviation
	 */
	public static Double standardDeviation(ArrayList<Integer> values) {
		int sum = 0;
		double finalsum = 0;

		for (int i : values) {
			sum += i;
		}

		for (int i = 0; i < values.size(); i++) {
			finalsum += Math.pow((values.get(i) - (sum / (values.size()))), 2);
		}

		return Math.sqrt(finalsum / (values.size()));
	}

	/**
	 * Calculates binomial coefficient for a given (n,k)
	 */
	public static int binomialCoefficient(int n, int k) {
		if (k > n - k) {
			k = n - k;
		}

		int b = 1;

		for (int i = 1, m = n; i <= k; i++, m--) {
			b = b * m / i;
		}

		return b;
	}

	public static void pr(Object o) {
		System.out.print(o);
	}

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a1.add(54);
		a1.add(34);
		a1.add(234);
		a1.add(1235);
		a1.add(244);
		a2.add(534);
		a2.add(34);
		a2.add(2124);
		a2.add(15);
		a2.add(234);

		for (int e: union(a1, a2)) pr (e + " ");
		
		pr("\n");

		for (int e: intersection(a1, a2)) pr (e + " ");
		
		pr("\n");

		for (int e : setDifference(a1, a2)) pr(e + " ");
		
		pr("\n");

		pr(limit("5x^2 + 3x", "4x^2 + 4x"));
		
		pr("\n");

		pr(lHopitalRule("5x^2", "4x^2"));
		
		pr("\n");

		pr(standardDeviation(a1));
		
		pr("\n");

		pr(binomialCoefficient(5,3));
	}

}
