
import java.util.ArrayList;
import java.util.function.*;

/**
 * Implements a method that emulates mapcar, which is normally used in LISP languages.
 * In this case, it is used to add five to all numbers in an arraylist.
 */
public class Vocabulary13 {

	//the function
	public static Function<Integer, Integer> lambda = (i) -> i + 5;

	//mapcar: applies the function to all elements of a list
	public static void mapcar(ArrayList<Integer> i) {
		for (Integer j : i) {
			System.out.println(lambda.apply(j));
		}
	}

	public static void main(String[] args) {
		//creates list for testing
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		mapcar(list);
	}
}