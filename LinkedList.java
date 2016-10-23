/**
 * @inheritDoc
 * Provides a linked list implementation for the Link interface.
 **/
public class LinkedList<E> implements List<E> {

	private LinkedListNode<E> head; //the front of the list
	private LinkedListNode<E> tail; //the end of the list
	private int size; //no. of elements in the list

	/**
	 * Class to represent a node in this linked list, including the value
	 * represented by this node and pointers to its predecessor and successor
	 **/
	private class LinkedListNode<E> {
		private E value; //the value in this node
		private LinkedListNode<E> previous; //node predecessor
		private LinkedListNode<E> next; //node successor

		/**
		 * Constructor takes in a value and references to successor and predecessor
		 * @param value the value contained in this node
		 * @param previous the predecessor to this node
		 * @param next the successor to this node
		 **/
		private LinkedListNode(E value, LinkedListNode<E> previous, LinkedListNode<E> next) {
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
	}

	/**
	 * An implementation of Iterator strictly for this data structure
	 **/
	private class LinkedListIterator<E> implements Iterator<E> {
		private LinkedListNode<E> current; //the current node in the iteration
		private int position; //position (index within the list)

		/**
		 * Constructor takes in node and where within the list that represents
		 * @param current node to begin iterator at
		 * @param position where within the list that the current param represents
		 **/
		private LinkedListIterator(LinkedListNode<E> current, int position) {
			this.current = current;
			this.position = position;
		}

		/** @inheritDoc **/
		public boolean hasNext() {
			return current != null; //if current is null then there are no more elements in list
		}

		/** @inheritDoc **/
		public E next() {
			if (!hasNext()) {
				return null;
			}
			// if we have a next element, get this element, move current node to
			// point to it and increment position counter
			E result = current.value;
			current = current.next;
			position++;
			return result;
		}

		/** @inheritDoc **/
		public boolean remove() {
			if (current == null) {
				//can't remove null element
				return false;
			}
			if (current.previous == null) {
				//current is the head of the list, set to null
				current = null;
				return true;
			}
			if (current.next == null) {
				//current is both head and tail, so set to null
				current.previous.next = null;
				return true;
			}
			//there are elements before and after current, so we remove current by
			// setting its predecessor to point towards its successor
			current.previous.next = current.next;
			return true;
		}
	}

	/**
	 * Default constructor sets head, tail to null and size to 0
	 **/
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/** @inheritDoc **/
	public int size() {
		return size;
	}

	/** @inheritDoc **/
	public boolean add(E element) {
		//create a new node with the value of element, point to no predecessor
		// or successor *yet*
		LinkedListNode<E> node = new LinkedListNode<E>(element, null, null);

		if (head == null || tail == null) {
			//empty list, so new node becomes both head and tail of list
			head = node;
			tail = node;
		} else if (head.next == null) {
			//singleton list, so new node becomes tail of list, successor to head
			head.next = node;
			node.previous = head;
			tail = node;
		} else {
			//list has two or more elements, simply add it to the tail, then set
			//the tail to this new node
			tail.next = node;
			node.previous = tail;
			tail = node;
		}
		size++; //no. of elts has increased by 1
		return true;
	}

	/** @inheritDoc **/
	public E get(int index) {
		if (index < 0 || index >= size) {
			//invalid index, return null
			return null;
		}
		//Index surely corresponds to a value, so we walk through until we find it
		LinkedListNode<E> temp = head;
		while (index > 0) {
			//walk through decrementing index until it htis zero; this is desired
			//position within the list
			temp = temp.next;
			index--;
		}
		//check temp is not null, if it is return null, else return the node's value
		if (temp == null) {
			return null;
		}
		return temp.value;
	}

	/** @inheritDoc **/
	public boolean isEmpty() {
		return (size == 0);
	}

	/** @inheritDoc **/
	public Object[] toArray() {
		//Use the iterator to walk through list, adding each element to the array
		Object[] result = new Object[size];
		Iterator<E> it = iterator();
		int i = 0;
		while (it.hasNext()) {
			result[i] = it.next();
			i++; //increment counter
		}
		return result;
	}

	/** @inheritDoc **/
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	/** @inheritDoc **/
	public String toString() {
		//walk through list manually and add elements to output string
		LinkedListNode<E> current = head;
		String result = "[";
		while (current != null) {
			result += current.value + ",";
			current = current.next;
		}
		result += "]";
		return result;
	}

	/** @inheritDoc **/
	public Iterator<E> iterator() {
		return new LinkedListIterator<E>(head, 0);
	}
}
