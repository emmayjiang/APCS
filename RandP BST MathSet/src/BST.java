
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class creates a Binary Search Tree, a binary tree where all elements in
 * its left subtree are less than or equal to to the node, and all the elements
 * in its right subtree are greater than the node.
 * 
 * Average Search Time: O(log n) Best-Case Search Time: O(1) Worst-Case Search
 * Time: O(n) Average Add Time: O(log n) Average Print Time: O(log n)
 */
public class BST<T extends Comparable<T>> {

	private T datum;
	private BST<T> left;
	private BST<T> right;

	public BST(T datum) {
		this.datum = datum;
	}

	// ACCESSOR METHODS
	public T getDatum() {
		return this.datum;
	}

	public BST<T> getLeft() {
		return left;
	}

	public BST<T> getRight() {
		return right;
	}

	// UTILITY METHODS
	public void printTree() {
		if (left != null) {
			left.printTree();
		}
		System.out.print(datum + " ");

		if (right != null) {
			right.printTree();
		}
	}

	public String toString() {
		return "Tree of depth " + depth() + " with root " + datum;
	}

	/**
	 * Finds the depth of the tree, which is the number of nodes from the root to
	 * the farthest leaf. The depth of an empty BST is 0.
	 */
	public int depth() {
		if (datum == null || left == null || right == null) {
			return 0;
		} else {
			int leftCounter = 0;
			int rightCounter = 0;
			leftCounter = left.depth();
			rightCounter = right.depth();
			return Math.max(leftCounter, rightCounter) + 1;
		}
	}

	/**
	 * Inserts a node at the correct place in the tree.
	 */
	public void insert(T datum) {
		if (datum.compareTo(this.datum) >= 0) {
			if (right == null) {
				right = new BST<T>(datum);
			} else {
				right.insert(datum);
			}
		} else {
			if (left == null) {
				left = new BST<T>(datum);
			} else {
				left.insert(datum);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();

		for (int i = 1; i <= 10000; i++)
			arrList.add(i);

		Collections.shuffle(arrList);

		BST<Integer> bt = null;

		for (int num : arrList) {
			if (bt == null) {
				bt = new BST<Integer>(num);
			} else {
				bt.insert(num);
			}
		}

		System.out.println("Depth of the tree: " + bt.depth());
	}
}
