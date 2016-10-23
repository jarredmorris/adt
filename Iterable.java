/**
 * @author Jarred Morris
 * Interface for a collection that can be iterated over
 * @type <T> the type of the elements in the underlying collection
 **/
public interface Iterable<T> {

	/**
	 * Gets an iterator over this collection
	 * @return an iterator over this collection
	 **/
	public Iterator<T> iterator();
}
