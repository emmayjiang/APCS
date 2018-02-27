
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementation of Priority Queue.
 */
public class PriorityQueue<E extends Comparable<E>> extends AbstractQueue<E> {

	ArrayList<E> priorities;

	public PriorityQueue() {
		priorities = new ArrayList<E>();
	}

	/**
	 * Adds an element to the queue.
	 */
	@Override
	public boolean offer(E e) {
		if (priorities.size() == 0) {
			priorities.add(0, e);
			return true;
		}

		for (int i = 0; i < priorities.size(); i++) {
			if (((Comparable<E>) priorities.get(i)).compareTo(e) > 0) {
				priorities.add(i, e);
				return true;
			}
		}

		priorities.add(e);
		return true;
	}

	/**
	 * Finds the first object in the queue.
	 */
	@Override
	public E peek() {
		if (priorities.size() == 0) {
			return null;
		}
		return priorities.get(0);
	}

	/**
	 * Finds the first object in the queue and deletes it.
	 */
	@Override
	public E poll() {
		if (priorities.size() == 0) {
			return null;
		}
		E temp = priorities.get(0);
		priorities.remove(0);
		return temp;
	}

	/**
	 * Creates an iterator for the queue.
	 */
	@Override
	public Iterator<E> iterator() {
		return new PriorityIterator(this);
	}

	/**
	 * Returns the size of the queue.
	 */
	@Override
	public int size() {
		return priorities.size();
	}

	public static void main(String[] args) {
		PriorityQueue<Integer> test = new PriorityQueue<Integer>();

		test.offer(5);
		test.offer(2);
		test.offer(3);
		test.offer(1);
		test.offer(77);
		
		test.poll();

		Iterator<Integer> i = test.iterator();

		while (i.hasNext()) {
			System.out.println(((PriorityIterator) i).getCurrent().get(0));
			i.next();
		}
	}
}
