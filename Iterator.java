/**
 * @author Jarred Morris
 * Interface to represent a means of iterating over a collection of objects of
 * type T
 * @param <T> type of elements in the collection to be iterated over
 **/
public interface Iterator<T> {

	/**
	 * @return true if there are still elements to be iterated over, false otherwise
	 **/
	public boolean hasNext();

	/**
	 * @return the next value in the collection being iterated over
	 **/
	public T next();

	/** Remove the current element from the underlying collection
	 * @return true if element was removed, false otherwise
	**/
	public boolean remove();
}
