/**
 * A class to sort an array of elements of type T
 * @param <T> the type of the elements being sorted
 */
public class QuickSort<T> implements Sort<T> {

	private T[] collection; //the collection to be sorted
	private Comparator<T> c; //comparator being used to sort against

	/**
	 * Constructor takes in array to be sorted and the comparator to sort it
	 * against
	 * @param collection array to be sorted
	 * @param comparator comparator to sort the array against
	 */
	public QuickSort(T[] collection, Comparator<T> comparator) {
		this.collection = collection;
		this.c = comparator;
	}

	/** @inheritDoc **/
	public void sort() {
		sort(0, collection.length - 1);
	}

	/** Sort the sublist between the two paramaters (inclusive)
	* @param lo the lower bound on the sublist to sort
	* @param hi the upper bound on the sublist to sort
	**/
 	private void sort(int lo, int hi) {
		if (hi > lo) { //sublist is length > 1, sort quicksort!
			int pivot = partition(lo, hi); //partition and get pivot index

			//now sort each half of the list
			sort(lo, pivot - 1);
			sort(pivot + 1, hi);
		} //else sublist is length 1 so is already sorted
	}

	/**
	 * Picks the pivot as the first element in the sublist and then partitions
	 * the list around this pivot, returning the index of the pivot at the end
	 * @param lo the lower bound on the sublist to partition
	 * @param hi the upper bound on the sublist to partition
	 * @return the index of the pivot
	 **/
	private int partition(int lo, int hi) {
		T pivot = collection[lo]; //pick first element in sublist as pivot
		int i = lo + 1;

		//walk through list, moving less than pivot to left of it in the list and
		// vice versa
		for(int j = lo + 1; j <= hi; j++){
			if (c.compare(pivot, collection[j]) > 0) {
				T tmp = collection[j];
				collection[j] = collection[i];
				collection[i] = tmp;
				i++;
			}
		}

		//pivot needs to be at location i-1 for this part of list of be partitioned
		i--;
		collection[lo] = collection[i];
		collection[i] = pivot;

		return i; //return index of pivot
	}
}
