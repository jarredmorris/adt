/**
 * A class to sort an array of elements of type T
 * @param <T> the type of the elements being sorted
 */
public class MergeSort<T> implements Sort<T> {

	private T[] collection; //the collection to be sorted
	private Comparator<T> comparator; //comparator being used to sort against

	/**
	 * Constructor takes in array to be sorted and the comparator to sort it
	 * against
	 * @param collection array to be sorted
	 * @param comparator comparator to sort the array against
	 */
	public MergeSort(T[] collection, Comparator<T> comparator) {
		this.collection = collection;
		this.comparator = comparator;
	}

	/**
	 * @inheritDoc
	 */
	public void sort() {
		sort(0, collection.length - 1); //sort entire array
	}

	/**
	 * Takes in the array indices in which to perform the sort in, inclusive.
	 * @param lo the lower bound (inclusive)
	 * @param hi the higher bound (inclusive)
	 */
	private void sort(int lo, int hi) {
		if (hi > lo) { //have more than 1 element, so must sort it!
			int mid = (lo + hi) / 2; //midpoint

			//recursively sort each half
			sort(lo, mid);
			sort(mid + 1, hi);
			merge(lo, mid, hi); //combine the two sorted lists

		} // else we have the base case: a list of length 1 is already sorted!
	}

	/**
	 * Combines the two sublists between indices lo, mid and hi.
	 * @param lo the lower bound (inclusive)
	 * @param mid the point at which the two sublists are split at
	 * @param hi the higher bound (inclusive)
	 */
	private void merge(int lo, int mid, int hi) {
		//We use two pointers to merge the lists in O(n) time
		int i = lo;
		int j = mid + 1;
		int k = 0;
		List<T> sortedSublist = new LinkedList<T>(); //sorted list to add to in order
		int length = hi + 1 - lo;

		//Walk through each list with two pointers, comparing elements and adding
		// to the sorted sublist!
		while (i <= mid && j <= hi) {
			if (comparator.compare(collection[i], collection[j]) < 0) {
				sortedSublist.add(collection[i]);
				i++;
			} else { //the other list had the smaller (or equal) element!
				sortedSublist.add(collection[j]);
				j++;
			}
		}

		while (i <= mid) { //walk through rest of first subarray
			sortedSublist.add(collection[i]);
			i++;
		}
		while (j <= hi) { //walk through rest of second subarray
			sortedSublist.add(collection[j]);
			j++;
		}

		//iterate over the sorted list and insert into our array
		for (k = 0; k < length; k++) {
			collection[lo + k] = sortedSublist.get(k);
			//offset by lo because that is the start of the subarray!
		}
	}
}
