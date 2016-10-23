/**
 * @inheritDoc
 * Provides a hashtable implementation for the Map interface.
 * Maintains O(1) access times (on average) and O(n) in the worst case
 **/
 public class HashMap<K,V> implements Map<K,V> {

	private List<Map.Entry<K,V>>[] buckets; //array of linked lists
	private int size; //the number of elements in this map

	/**
	 * Default constructor creates bucket array of size 127; larger primes are
	 * used because they decrease the probability of collissions
	 **/
	public HashMap() {
		this(127);
	}

	/**
	 * Constructor with a given bucket array size
	 * @param length the length to initialise the bucket array to
	 **/
	public HashMap(int length) {
		buckets = (LinkedList<Map.Entry<K,V>>[]) (new LinkedList[length]);
		for (int i = 0; i < length; i++) {
			 //instantiate each bucket to a new list
			buckets[i] = new LinkedList<Map.Entry<K,V>>();
		}
		size = 0; //initially we have no entries in the map
	}

	/** @inheritDoc **/
	public V get(K key) {
		// First hash the key to get a value in [0, buckets.length - 1]
		// This corresponds to the containing bucket, then walk through with an
		// iterator over the entries in this bucket
		Iterator<Map.Entry<K,V>> it = buckets[hash(key)].iterator();
		while (it.hasNext()) {
			Map.Entry<K,V> next = it.next();
			if (next.getKey().equals(key)) {
				//if this key equals the input we've found out value, so return
				return next.getValue();
			}
		}
		// the key is not associated to any value in this map
		return null;
	}

	/** @inheritDoc **/
	public boolean put(K key, V value) {
		// hash the key to find the bucket this value should be placed into, then
		// we check if it is already mapped to a value
		List<Map.Entry<K,V>> bucket = buckets[hash(key)];
		Iterator<Map.Entry<K,V>> it = bucket.iterator();
		while (it.hasNext()) {
			Map.Entry<K,V> next = it.next();
			if (next.getKey().equals(key)) {
				next.setValue(value);
				return false;
				//key was already mapped, so we change value and return false
			}
		}
		// no corresponding value to this key, so add it to this bucket
		bucket.add(new Map.Entry<K,V>(key, value));
		size++;
		return true;
	}

	/**
	 * Return an integer digest of the input key
	 * @param key the key to be hashed
	 * @return an integer value in [0, buckets.length - 1] that represents the
	 * hash of the input ket
	 **/
	private int hash(K key) {
		int hash = key.hashCode() % buckets.length;
		if (hash < 0) {
			hash = -hash;
		}
		return hash;
	}

	/** @inheritDoc **/
	public Object[] getValuesArray() {
		if (size == 0) { //no elements, so return null
			return null;
		}
		//create array of size of no. of elements in this map
		Object[] result = new Object[size];
		int j = 0;
		for (int i = 0; i < buckets.length; i++) {
			//iterate over bucket array, and then iterate over each bucket for its elements
			Iterator<Map.Entry<K,V>> it = buckets[i].iterator();
			while (it.hasNext()) {
				result[j] = it.next().getValue();
				j++; //increment counter
			}
		}
		return result;
	}

	/** @inheritDoc **/
	public int size() {
		return size;
	}

	/** @inheritDoc
	 * Creates a new (empty) buckets array and returns no. of elements to zero **/
	public void clear() {
		//
		buckets = (LinkedList<Map.Entry<K,V>>[])(new LinkedList[size]);
		size = 0;
	}

	/** IMPLEMENTATION NOT PROVIDED FOR PROTECTION PURPOSES **/
	public Iterator<Map.Entry<K,V>> iterator() {
		System.err.println("IMPLEMENTATION NOT PROVIDED FOR PROTECTION PURPOSES");
		return null;
	}
}
