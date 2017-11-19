
/**
 * This program has three methods, each of which correspond to one sorting method: bubblesort, insertion sort, and selection sort.
 * Each method takes in an array of integers and returns the sorted array.
 */
public class ThreeSorts {

	public ThreeSorts() {

	}

	/**
	 * Sorts a from least to greatest value using bubble sort.
	 * This method pushes the largest value to the end by swapping values.
	 * 
	 * @param a		the original array
	 * @return		the sorted array
	 */
	public static int[] bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {				//loops through the entire array
			for (int j = 0; j < a.length - i - 1; j++) {	//makes sure everything before current element is in order
				if (a[j] > a[j + 1]) {
					int value = a[j];
					a[j] = a[j + 1];
					a[j + 1] = value;
				}
			}
		}
		
		return a;
	}
	
	/**
	 * Sorts a from least to greatest value using insertion sort.
	 * This method take the leftmost of the unsorted group and inserts it by swapping into the sorted list.
	 * 
	 * @param a		the original array
	 * @return		the sorted array
	 */
	public static int[] insertionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
        {
            int pivot = a[i + 1];			//declares a[i + 1] as pivot point
            int j = i;
            while (j >= 0 && a[j] > pivot)	//checks the values before the pivot for a larger number, and switches
            {
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1] = pivot;
        }
        
        return a;
	}

	/**
	 * Sorts a from least to greatest value using selection sort.
	 * This method finds the smallest element in the unsorted portion and swap it with the first in unsorted.
	 * @param a		the original array
	 * @return		the sorted array
	 */
	public static int[] selectionSort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			int minIndex = i;
			for (int j = i; j < a.length; j++) {	//find the index of smallest value in unsorted
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			int value = a[minIndex];				//swap smallest value with first unsorted value
			a[minIndex] = a[i];
			a[i] = value;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		int[] a = { 10, 9, 9, 6, 7, 8, 3, 2, 4, 1 };
		
		for (int i = 0; i < bubbleSort(a).length; i++) {
			System.out.print(bubbleSort(a)[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < insertionSort(a).length; i++) {
			System.out.print(insertionSort(a)[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < selectionSort(a).length; i++) {
			System.out.print(selectionSort(a)[i] + " ");
		}
	}
}
