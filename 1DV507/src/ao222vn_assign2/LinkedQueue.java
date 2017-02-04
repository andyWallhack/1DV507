package ao222vn_assign2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue implements Queue {
	
	private Node first;
	private Node last;
	//Tester maybe removed 
	private int currentSize;
	
	
	/**
	 * Constructor an empty queue
	 */
	public LinkedQueue() {
		this.first = null;
		this.last = null;
		this.currentSize = 0;
	}

	/**
	 * Checks the size of the linked queue
	 * @return size of the queue
	 */
	@Override
	public int size() { return this.currentSize;}

	/**
	 * Check if the queue is empty
	 * @return true if queue is empty
	 */
	@Override
	public boolean isEmpty() {return this.first == null;}
	
	/**
	 * Adding an element last in the queue
	 */
	@Override
	public void enqueue(Object element) {
		//Adding a element last in the queue
		Node newNode = new Node();
		newNode.data = element;
		newNode.previous = this.last;
		
		if(isEmpty()) {this.first = newNode;}
			
		
		if(this.last != null) {this.last.next = newNode;}
		
		this.last = newNode;
		
		//Remember the size of the queue
		this.currentSize++;
	}

	/**
	 * Returns and removes the first object in the queue
	 * @return the first object in the queue
	 */
	@Override
	public Object dequeue() {
		if(isEmpty()) {throw new NoSuchElementException();}
		Object element = this.first.data;
		this.first = this.first.next;
		this.currentSize--;
		return element;
	}
	
	/**
	 * Returns the first element in the queue
	 * @return the first element in the queue
	 */
	@Override
	public Object first() {
		if(isEmpty()) {throw new NoSuchElementException();}
		return this.first.data;
	}

	/**
	 * Returns the last element in the queue
	 * @return the last element in the queue
	 */
	@Override
	public Object last() {
		if(isEmpty()) {throw new NoSuchElementException();}
		return this.last.data;
	}
	
	/**
	 * Returns a new iterator of the object
	 * @return new iterator
	 */
	@Override
	public Iterator<Object> iterator() {return new ObjectIterator();}
	
	
	//Inner class Node
	class Node {
		public Object data;
		public Node next;
		public Node previous;
	}
	
	//Inner class Iterator
	class ObjectIterator implements Iterator<Object> {
		private Node current = first;

		@Override
		public boolean hasNext() {return current != null;}
			

		@Override
		public Object next() {
			Object element = current.data;
			current = current.next;
			return  element;
		} 
	}
}
