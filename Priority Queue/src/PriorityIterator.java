
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Iterator for Priority Queue.
 */
public class PriorityIterator<E> implements Iterator<E> {

	public ArrayList<E> current;

	public PriorityIterator(PriorityQueue q) {
		current = (ArrayList<E>) q.priorities.clone();
	}

	/**
	 * Checks if there is another element in the queue.
	 */
	@Override
	public boolean hasNext() {
		if (current.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Goes to the next element in the queue, deleting the one before it.
	 */
	@Override
	public E next() {
		current.remove(0);
		if (hasNext()) {
			return current.get(0);
		}
		return null;
	}

	/**
	 * Gets the position in the iterator.
	 */
	public ArrayList<E> getCurrent() {
		return current;
	}
}