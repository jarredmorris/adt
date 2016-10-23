
/**
 * @author Jarred Morris
 * Interface to represent a List abstract data type.
 * @param <E> the type of the elements stored in this list
 **/
public interface List<E> extends Iterable<E> {

	/** Add an element to the end of the list
	 * @param element The element to be added to the tail of the list
	 * @return true if addition was successful, false otherwise
	 **/
	public boolean add(E element);

	/**
	 * Retrieve the element at the given index
	 * @param index The index of the element in the list to be retrieved. Do note
	 * that this data structure is indeed zero-indexed.
	 * @return the element at the given index in the list, or null if the index
	 * is out of range
	 **/
	public E get(int index);

	/**
	 * Returns whether the list has elements or not
	 * @return true if there is one or more element in the list, false otherwise
	 **/
	public boolean isEmpty();

	/**
	 * Returns the number of elements in the list
	 * @return the number of elements in the list
	 **/
	public int size();

	/**
	 * Returns an array representation of this list, ordering is preserved, and
	 * duplicates are included
	 * @return an array of the elements in this list, note that this is of type
	 * Object[] so casting may be required
	 **/
	public Object[] toArray();

	/**
	 * Removes all elements from the list
	 **/
	public void clear();

	/**
	 * Provides a means to iterate over the collection of items in the list
	 * @return an Iterator over the elements in this list
	 **/
	public Iterator<E> iterator();

	/**
	 * Provides a String representation of this list
	 * @return a String representation of this list
	 **/
	public String toString();
}
