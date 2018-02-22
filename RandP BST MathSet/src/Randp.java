
import java.util.ArrayList;

public class Randp {
	private ArrayList<Integer> nums;
	private int numsLeft;

	public Randp(int n) {
		initNums(n);
	}

	/**
	 * Initializes an ArrayList of the numbers to be generated.
	 */
	private void initNums(int n) {
		nums = new ArrayList<Integer>();
		for (int i = 0; i < n + 1; i++) {
			nums.add(i);
		}
		numsLeft = n + 1;
	}

	/**
	 * Randomly generates a number based on what has not yet generated.
	 */
	public int nextInt() {
		// Math.random() should never be called more than once
		// when this method is called. Recursion is not allowed.
		if (numsLeft > 1) {
			int length = nums.size() - 1;
			int random = (int) (Math.random() * length + 1);
			int answer = nums.get(random);
			nums.remove(random);
			numsLeft = numsLeft - 1;
			return answer;
		} else if (numsLeft == 1) {
			return nums.get(0);
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int x;
		Randp rand = new Randp(6);
		x = rand.nextInt(); // randomly returns 5
		System.out.println(x);
		x = rand.nextInt(); // randomly returns 2
		System.out.println(x);
		x = rand.nextInt(); // randomly returns 6
		System.out.println(x);
		x = rand.nextInt(); // randomly returns 4
		System.out.println(x);
		x = rand.nextInt(); // randomly returns 1
		System.out.println(x);
		x = rand.nextInt(); // randomly returns 3
		System.out.println(x);
		x = rand.nextInt(); // returns 0
		System.out.println(x);
		x = rand.nextInt(); // returns 0
		System.out.println(x);
	}
}