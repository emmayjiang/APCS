
import java.util.ArrayList;

public class SetStuff {

	public SetStuff() {

	}

	/**
	 * 
	 * Given an integer for the size and an integer for the start node create an
	 * ArrayList of integers whose values are maximal except the entry at the index
	 * of the start, which should be zero.
	 * 
	 * @param n		length of ArrayList
	 * @param start	index that should be 0
	 * @return		ArrayList that is all infinity except at start, where it's 0
	 */
	ArrayList<Integer> setInfinity(int n, int start) {
		int infinity = (int) Double.POSITIVE_INFINITY;
		ArrayList<Integer> pneub = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			pneub.add(infinity);
		}
		pneub.set(start, 0);
		return pneub;
	}

	/**
	 * Take an ArrayList of ArrayLists of size three of integers and return an
	 * ArrayList that contains the union of all the integers that appear in the
	 * first two elements of each ArrayList of size three. To pass the test cases
	 * the returned ArrayList must be in the order elements appear in the argument.
	 * 
	 * @param edgelist	ArrayList of edges
	 * @return			ArrayList of union of integers
	 */
	ArrayList<Integer> collectNodes(ArrayList<ArrayList<Integer>> edgelist) {
		ArrayList<Integer> dank = new ArrayList<Integer>();
		for (int i = 0; i < edgelist.size(); i++) {
			for (int j = 0; j < 2; j++) {
				boolean flag = false;
				for (int k = 0; k < dank.size(); k++) {
					if (dank.get(k) == edgelist.get(i).get(j)) {
						flag = true;
					}
				}
				if (flag == false) {
					dank.add(edgelist.get(i).get(j));
				}
			}
		}
		return dank;
	}

	/**
	 * Take an ArrayList of ArrayLists of integers, and three integers, and make
	 * those three integers into an ArrayList and add that ArrayList to the given
	 * ArrayList and return that.
	 * 
	 * @param graph	original ArrayList
	 * @param a		integer 1
	 * @param b		integer 2
	 * @param c		integer 3
	 * @return		final ArrayList with new edge
	 */
	ArrayList<ArrayList<Object>> addEdge(ArrayList<ArrayList<Object>> graph, int a, int b, int c) {
		graph.add(listify(a,b,c));
		return graph;
	}

	/**
	 * Take three integers and return an arrayList containing them.
	 * Helper method for addEdge.
	 * 
	 * @param a		integer 1
	 * @param b		integer 2
	 * @param c		integer 3
	 * @return		ArrayList with the three integers
	 */
	ArrayList<Object> listify(int a, int b, int c) {
		ArrayList<Object> dank = new ArrayList<Object>();
		dank.add(a);
		dank.add(b);
		dank.add(c);
		return dank;
	}

	/**
	 * Take three arrays, one boolean one integer. and one String. Return the String
	 * at the index of the smallest integer for which the corresponding boolean is
	 * false. Return the empty string if no distances qualify.
	 * 
	 * @param visited	true: has been visited
	 * 					false: has not been visited
	 * @param distance	distance from node
	 * @param nodeName	the node
	 * @return			Node at the index of the smallest distance for which visited is false
	 */
	String nearesUnvisitedNode(boolean[] visited, int[] distance, String[] nodeName) {
		boolean checkFalse = false;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				checkFalse = true;
			}
		}
		if (checkFalse == true) {
			int min = 100000;
			int index = 0;
			for (int i = 0; i < distance.length; i++) {
				if (distance[i] < min) {
					min = distance[i];
					index = i;
				}
			}
			if (visited[index] == false) {
				if (min != 100000) {
					return nodeName[index];
				} else {
					return "";
				}
			} else {
				distance[index] = 100000;
			}
			return nearesUnvisitedNode(visited, distance, nodeName);
		} else {
			return "";
		}
	}

	/**
	 * Returns an array that: 1: Is sorted 2: Has no repeat values 3: Contains any value that is in both a and b
	 * @param a		sorted array 1
	 * @param b		sorted array 2
	 * @return		sorted array of intersections of 1 and 2
	 */
	int[] intersect(int[] a, int[] b) {
		int counter = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					counter++;
				}
			}
		}
		int[] end = new int[counter];
		int counter2 = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					end[counter2] = a[i];
					counter2++;
				}
			}
		}
		return removeDuplicates(end);
	}

	/**
	 * Finds and removes the duplicates in an array
	 * Helper method for intersect
	 * 
	 * @param arr	the array, with duplicates
	 * @return		the array, without duplicates
	 */
	int[] removeDuplicates(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] == arr[j]) {
					for (int k = j + 1; k < size; k++) {
						arr[j] = arr[k];
						j++;
					}
					size--;
					j--;
				}
			}
		}
		int[] end = new int[size];
		for (int i = 0; i < size; i++) {
			end[i] = arr[i];
		}
		return end;
	}

	/**
	 * Finds the union of two arrays
	 * 
	 * @param a		array 1
	 * @param b		array 2
	 * @return		union of two arrays
	 */
	int[] union(int[] a, int[] b) {
		int[] end = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			end[i] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			end[i + a.length] = b[i];
		}
		return end;
	}

	/**
	 * Checks if any elements of a are in b.
	 * 
	 * @param a		array 1
	 * @param b		array 2
	 * @return		true: if there are elements in a and b
	 * 				false: if there are no elements in a and b
	 */
	boolean anyContains(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if (contains(a[i], b)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if an ArrayList contains a
	 * Helper method for anyContains
	 * 
	 * @param a		element to compare
	 * @param ar	array that the element is compared to
	 * @return		true: contains a false: doesn't contain a
	 */
	boolean contains(int a, int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == a) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Take an ArrayList<Integer> and return its zeroth element.
	 * 
	 * @param al	the ArrayList
	 * @return		the ArrayList's zeroeth element
	 */
	Integer zerothElement(ArrayList<Integer> al) {
		return al.get(0);
	}

	/**
	 * Return an ArrayList<Integer> that contains 17.
	 * 
	 * @return		17
	 */
	ArrayList<Integer> ret17() {
		ArrayList<Integer> dank = new ArrayList<Integer>();
		dank.add(17);
		return dank;
	}
	
	void printInt(ArrayList<Integer> arr) {
		System.out.print("\t" + "[ ");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println("]");
	}

	void printObj(ArrayList<Object> arr) {
		System.out.print("\t" + "[ ");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		SetStuff test = new SetStuff();

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);

		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(3);
		b.add(4);

		ArrayList<Object> c = new ArrayList<Object>();
		c.add(1);
		c.add(2);
		c.add(3);

		ArrayList<Object> d = new ArrayList<Object>();
		d.add(2);
		d.add(3);
		d.add(4);

		int[] e = { 2, 3, 4 };
		int[] f = { 3, 5, 6 };
		int[] g = { 5, 6, 7 };

		System.out.println("setInfinity:");
		ArrayList<Integer> si = new ArrayList<Integer>();
		si = test.setInfinity(3, 1);
		test.printInt(si);

		System.out.println("collectNodes:");
		ArrayList<Integer> cn = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> cnCase = new ArrayList<ArrayList<Integer>>();
		cnCase.add(a);
		cnCase.add(b);
		cn = test.collectNodes(cnCase);
		test.printInt(cn);

		System.out.println("addEdge:");
		ArrayList<ArrayList<Object>> ae = new ArrayList<ArrayList<Object>>();
		ArrayList<ArrayList<Object>> aeCase = new ArrayList<ArrayList<Object>>();
		aeCase.add(c);
		aeCase.add(d);
		ae = test.addEdge(aeCase, 5, 6, 7);
		for (int i = 0; i < ae.size(); i++) {
			test.printObj(ae.get(i));
		}

		System.out.println("listify:");
		ArrayList<Object> l = new ArrayList<Object>();
		l = test.listify(1, 2, 3);
		test.printObj(l);
		
		System.out.println("nearesUnvisitedNode:");
		boolean[] distances = {true, false, false};
		String[] nodeNames = {"A", "B", "C"};
		System.out.println("\t" + test.nearesUnvisitedNode(distances, e, nodeNames));
		
		System.out.println("intersect:");
		int[] in = test.intersect(e, f);
		System.out.print("\t" + "[ ");
		for (int i = 0; i < in.length; i++) {
			System.out.print(in[i] + " ");
		}
		System.out.println("]");
		
		System.out.println("union:");
		int[] un = test.union(e, g);
		System.out.print("\t" + "[ ");
		for (int i = 1; i < un.length; i++) {
			System.out.print(un[i] + " ");
		}
		System.out.println("]");
		
		System.out.println("anyContains:");
		if (test.anyContains(e, f)) {
			System.out.println("\ttrue");
		} else {
			System.out.println("\tfalse");
		}
		
		System.out.println("contains:");
		if (test.contains(1, e)) {
			System.out.println("\ttrue");
		} else {
			System.out.println("\tfalse");
		}
		
		System.out.println("zerothElement");
		System.out.println("\t" + test.zerothElement(a));
		
		System.out.println("ret17:");
		test.printInt(test.ret17());
	}
}
