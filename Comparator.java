/**
 * @author Jarred Morris
 * Interface to represent a means of comparing two objects of the same type E.
 * These can be passed to a Sort type in order to define the actual sort order,
 * and even for control of the sorting order in sorted data structure.
 * @param <T> type of elements to be compared by this Comparator
 **/
public interface Comparator<T> {

	/**
	 * Compares e1 and e2 for their order. These parameters need not implement
	 * the Comparable interface so long as the implementation provides a means
	 * for comparison.
	 *
	 * Note that if zero is returned it suggests that e1.equals(e2) evaluates to
	 * true, and so on for the converse (by transitivity) but this is not
	 * strictly required.
	 *
	 * @param e1 The first element (of type E) for comparison
	 * @param e2 The second element (of type E) for comparison
	 *
	 * @return a negative integer if the first argument is strictly less than the
	 * second, zero if the objects the same in the ordering, or a positive
	 * integer otherwise.
	 */
	public int compare(T e1, T e2);
}
