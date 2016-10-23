/**
 * @author Jarred Morris
 * Interface to represent a Map abstract data type. This is essentially a
 * dictionary, being a bijective mapping keys of type K to values of type V.
 * @param <K> the type of the keys stored in this mapping
 * @param <V> the type of the values stored in this mapping
 **/
public interface Map<K,V> {

	/**
	 * Retrieve the value associated to the given key in this mapping.
	 * @param key the key which maps to the value is to be retrieved
	 * @return the value of type V that this key corresponds to in the Map, or
	 * null if there is no corresponding value
	 **/
	public V get(K key);

	/**
	 * Insert a value into the map, associated with the given key. If the given
	 * key is already mapped to some value in the map then this value is replaced
	 * @param key the key associated with the value to be placed into the map
	 * @param value the value associated to the given key
	 * @return true if there was not already an associated value for this key in
	 * the map, false if this key is already mapped to some value
	 **/
	public boolean put(K key, V value);

	/**
	 * Retrieve an array of all of the values in this map, duplicates should be
	 * included. Note that to avoid generic array creation, the array is of type
	 * Object[] rather than of type V[]. Hence casting may be required in some
	 * uses.
	 * @return an array of all the values present in this map
	 **/
	public Object[] getValuesArray();

	/**
	 * @return the number of key values pairs in the mapping
	 **/
	public int size();

	/**
	 * Remove all entries from the map; such that no key is associated to any
	 * value
	 **/
	public void clear();

	/**
	 * @return an Iterator over the key value pairings in this map. Note that
	 * the order in which iteration occurs is not explicitly defined
	 **/
	public Iterator<Map.Entry<K,V>> iterator();

	/**
	 * @author Jarred Morris
	 * Class to represent an entry in this map; a key value pair.
	 * @param <K> the type of the keys stored in this mapping
	 * @param <V> the type of the values stored in this mapping
	 **/
	public final class Entry<K,V> {
		private K key;
		private V value;

		/**
		 * Constructor for this class, assigns each paramater to the class variables
		 * @param key the key associated to the corresponding value
		 * @param value the value to be associated to the key
		 **/
		protected Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Default constructor calls the super class Constructor
		 **/
		private Entry() {
			super();
		}

		/** Retrieve the key from this pair
		 * @return the key in this entry of type K
		 **/
		public K getKey() {
			return key;
		}

		/** Retrieve the value from this pair
		 * @return the value in this entry of type V
		 **/
		public V getValue() {
			return value;
		}

		/** Set the key in this pair
		 * @param key the value to set the key attribute to
		 **/
		public void setKey(K key) {
			this.key = key;
		}

		/** Set the value in this pair
		 * @param value the object to set the value attribute to
		 **/
		public void setValue(V value) {
			this.value = value;
		}
	}
}
