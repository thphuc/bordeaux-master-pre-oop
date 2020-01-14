package day4;

import java.util.*;

/**
 * @author hainm2
 * Implement the LinkedList 
 */
public class LinkedList<AnyType> implements Iterable<AnyType> {
	private Node<AnyType> headNode;

	/**
	 * Constructs an empty list
	 */
	public LinkedList() {
		headNode = null;
	}

	/**
	 * Returns true if the list is empty
	 *
	 */
	public boolean isEmpty() {
		return headNode == null;
	}

	/**
	 * Inserts a new node at the beginning of this list.
	 *
	 */
	public void addFirst(AnyType item) {
		headNode = new Node<AnyType>(item, headNode);
	}

	/**
	 * Returns the first element in the list.
	 *
	 */
	public AnyType getFirst() {
		if (headNode == null)
			throw new NoSuchElementException();

		return headNode.dataValue;
	}

	/**
	 * Removes the first element in the list.
	 *
	 */
	public AnyType removeFirst() {
		AnyType tmp = getFirst();
		headNode = headNode.nextNode;
		return tmp;
	}

	/**
	 * Inserts a new node to the end of this list.
	 *
	 */
	public void addLast(AnyType item) {
		if (headNode == null)
			addFirst(item);
		else {
			Node<AnyType> tmp = headNode;
			while (tmp.nextNode != null)
				tmp = tmp.nextNode;

			tmp.nextNode = new Node<AnyType>(item, null);
		}
	}

	/**
	 * Returns the last element in the list.
	 *
	 */
	public AnyType getLast() {
		if (headNode == null)
			throw new NoSuchElementException();

		Node<AnyType> tmp = headNode;
		while (tmp.nextNode != null)
			tmp = tmp.nextNode;

		return tmp.dataValue;
	}

	/**
	 * Removes all nodes from the list.
	 *
	 */
	public void clear() {
		headNode = null;
	}

	/**
	 * Returns true if this list contains the specified element.
	 *
	 */
	public boolean contains(AnyType x) {
		for (AnyType tmp : this)
			if (tmp.equals(x))
				return true;

		return false;
	}

	/**
	 * Returns the data at the specified position in the list.
	 *
	 */
	public AnyType get(int pos) {
		if (headNode == null)
			throw new IndexOutOfBoundsException();

		Node<AnyType> tmp = headNode;
		for (int k = 0; k < pos; k++)
			tmp = tmp.nextNode;

		if (tmp == null)
			throw new IndexOutOfBoundsException();

		return tmp.dataValue;
	}

	/**
	 * Returns a string representation
	 *
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (Object x : this)
			result.append(x + " ");

		return result.toString();
	}

	/**
	 * Inserts a new node after a node containing the key.
	 *
	 */
	public void insertAfter(AnyType key, AnyType toInsert) {
		Node<AnyType> tmp = headNode;

		while (tmp != null && !tmp.dataValue.equals(key))
			tmp = tmp.nextNode;

		if (tmp != null)
			tmp.nextNode = new Node<AnyType>(toInsert, tmp.nextNode);
	}

	/**
	 * Inserts a new node before a node containing the key.
	 *
	 */
	public void insertBefore(AnyType key, AnyType toInsert) {
		if (headNode == null)
			return;

		if (headNode.dataValue.equals(key)) {
			addFirst(toInsert);
			return;
		}

		Node<AnyType> prev = null;
		Node<AnyType> cur = headNode;

		while (cur != null && !cur.dataValue.equals(key)) {
			prev = cur;
			cur = cur.nextNode;
		}
		// insert between cur and prev
		if (cur != null)
			prev.nextNode = new Node<AnyType>(toInsert, cur);
	}

	/**
	 * Removes the first occurrence of the specified element in this list.
	 *
	 */
	public void remove(AnyType key) {
		if (headNode == null)
			throw new RuntimeException("cannot delete");

		if (headNode.dataValue.equals(key)) {
			headNode = headNode.nextNode;
			return;
		}

		Node<AnyType> cur = headNode;
		Node<AnyType> prev = null;

		while (cur != null && !cur.dataValue.equals(key)) {
			prev = cur;
			cur = cur.nextNode;
		}

		if (cur == null) {
			System.out.println("cannot delete");
			return;
		}

		// delete cur node
		prev.nextNode = cur.nextNode;
	}

	/**
	 * Returns a deep copy of the list Complexity: O(n^2)
	 */
	public LinkedList<AnyType> copy1() {
		LinkedList<AnyType> twin = new LinkedList<AnyType>();
		Node<AnyType> tmp = headNode;
		while (tmp != null) {
			twin.addLast(tmp.dataValue);
			tmp = tmp.nextNode;
		}

		return twin;
	}

	/**
	 * Returns a deep copy of the list Complexity
	 */
	public LinkedList<AnyType> copy2() {
		LinkedList<AnyType> twin = new LinkedList<AnyType>();
		Node<AnyType> tmp = headNode;
		while (tmp != null) {
			twin.addFirst(tmp.dataValue);
			tmp = tmp.nextNode;
		}

		return twin.reverse();
	}

	/**
	 * Reverses the list Complexity
	 */
	public LinkedList<AnyType> reverse() {
		LinkedList<AnyType> list = new LinkedList<AnyType>();
		Node<AnyType> tmp = headNode;
		while (tmp != null) {
			list.addFirst(tmp.dataValue);
			tmp = tmp.nextNode;
		}
		return list;
	}

	/**
	 * Returns a deep copy of the immutable list It uses a tail reference.
	 */
	public LinkedList<AnyType> copy3() {
		LinkedList<AnyType> twin = new LinkedList<AnyType>();
		Node<AnyType> tmp = headNode;
		if (headNode == null)
			return null;
		twin.headNode = new Node<AnyType>(headNode.dataValue, null);
		Node<AnyType> tmpTwin = twin.headNode;
		while (tmp.nextNode != null) {
			tmp = tmp.nextNode;
			tmpTwin.nextNode = new Node<AnyType>(tmp.dataValue, null);
			tmpTwin = tmpTwin.nextNode;
		}

		return twin;
	}

	private static class Node<AnyType> {
		private AnyType dataValue;
		private Node<AnyType> nextNode;

		public Node(AnyType data, Node<AnyType> next) {
			this.dataValue = data;
			this.nextNode = next;
		}
	}

	public Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	}
	
	private static class MyType{
		public MyType() {
			System.out.println("MyType");
		}
	}
	
	private static class MyType1 extends MyType {
		public MyType1() {
			System.out.println("MyType1");
		}
	}

	private class LinkedListIterator implements Iterator<AnyType> {
		private Node<AnyType> nextNode;

		public LinkedListIterator() {
			nextNode = headNode;
		}

		public boolean hasNext() {
			return nextNode != null;
		}

		public AnyType next() {
			if (!hasNext())
				throw new NoSuchElementException();
			AnyType res = nextNode.dataValue;
			nextNode = nextNode.nextNode;
			return res;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/***** Include the main() for testing and debugging *****/

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("C");
		list.addFirst("C");
		list.addFirst("C");
		list.addFirst("C");
		list.addFirst("C");
		list.addFirst("B");
		list.addFirst("A");
		System.out.println(list);

		LinkedList<String> twin = list.copy3();
		System.out.println(twin);

		System.out.println(list.get(0));

		list.addLast("s");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println();

		for (Object x : list)
			System.out.print(x + " ");
		System.out.println();

		list.insertAfter("e", "ee");
		System.out.println(list);
		System.out.println(list.getLast());

		list.insertBefore("h", "yy");
		System.out.println(list);

		list.remove("p");
		System.out.println(list);
		
		LinkedList<MyType> t = new LinkedList<MyType>();
		t.addFirst(new MyType());
		t.addFirst(new MyType());
		t.addFirst(new MyType1());		
	}
}