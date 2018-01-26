
import java.util.ArrayList;

public class MedianFinder {

	static ArrayList<Integer> orgArray;

	public MedianFinder() {

	}

	public static void findMedian(ArrayList<Integer> array) {
		if (array.size() == 0) {
			System.out.print("0"); // checks for empty array
		} else {
			partition(array); // starts the partitioning to get the median
		}
	}

	public static void partition(ArrayList<Integer> array) {
		if ((array.size() <= orgArray.size() / 2 + 1) || (array.size() <= orgArray.size() / 2 - 1)) {
			System.out.println(array.get(array.size() - 1)); // prints the median
		} else {

			int n = array.get(array.size() - 1); // sets pivot point

			ArrayList<Integer> left = new ArrayList<Integer>();
			ArrayList<Integer> right = new ArrayList<Integer>();

			for (int i = 0; i < array.size(); i++) { // partitions
				if (array.get(i) >= n) {
					right.add(array.get(i)); // moves smaller to the right
				} else {
					left.add(array.get(i)); // moves larger to the left
				}
			}

			if (right.equals(array)) {
				right.remove(right.size() - 1); // checks for equal array
				partition(right);
			} else if (right.size() < left.size()) { // median is in left array
				partition(left); // partition left side
			} else if (right.size() >= left.size()) { // median is in right array
				partition(right); // partition right side
			}
		}
	}

	public static void main(String[] args) {
		orgArray = new ArrayList<Integer>();
		orgArray.add(3);
		orgArray.add(130);
		orgArray.add(16);
		orgArray.add(28);
		orgArray.add(213623423);
		findMedian(orgArray);
	}
}
