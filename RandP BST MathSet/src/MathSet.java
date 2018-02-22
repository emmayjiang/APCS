
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MathSet implements Set<Object> {

	/**
	 * Find the intersection of two arrays.
	 * @param a	array a
	 * @param b	array b
	 * @return	the intersection
	 */
	public int[] intersect(int[] a, int[] b) {
		int counter = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					counter++;
				}
			}
		}
		int[] arr = new int[counter];
		int counter2 = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					arr[counter2] = a[i];
					counter2++;
				}
			}
		}
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
	 * Find the union of two arrays.
	 * @param a	array a
	 * @param b	array b
	 * @return	the union
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

	// SET INTERFACE AUTO-GENERATED STUBS
	@Override
	public boolean add(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Object> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
