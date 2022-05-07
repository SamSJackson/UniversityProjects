package ds.basic.samjackson.structures;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	
	private class Node {
		private int value;
		private Node next;
		private Node prev;
		
		public Node(int value) {
			this.value = value;
			this.next = null;
			this.prev = null;
		}
		
		@Override
		public String toString() {
			return this.value + "";
		}
	}
	
	public DoublyLinkedList() {
		this.head = null;
	}
	
	// O(1) constant time
	public void insertHead(int value) {
		Node x = new Node(value);
		x.next = this.head;
		if (this.head != null) {
			this.head.prev = x;
		}
		this.head = x;
		if (this.tail == null) {
			this.tail = x;
		}
	}
	
	// O(1) constant time
	public void insertTail(int value) {
		if (this.head == null) {
			insertHead(value);
			return;
		}
		Node x = new Node(value);
		this.tail.next = x;
		x.prev = this.tail;
		this.tail = x;
	}
	
	// O(1) constant time due to prev pointer	
	public Node popTail() {
		Node x = null;
		if (this.head == null) {
			return x;
		} else if (this.head.next == null) {
			x = this.head;
			this.tail = null;
			this.head = null;
			return x;
		}
		x = this.tail;
		this.tail = this.tail.prev;
		this.tail.next = null;
		return x;
	}
	
	// O(1) constant time
	public Node popHead() {
		Node x = this.head;
		if (x == null) { 
			return x;
		}
		if (this.head.next != null) {
			this.head = x.next;
			this.head.prev = null;
			if (this.head.next == null) {
				this.tail = this.head;
			}
		} else {
			this.head = null;
			this.tail = null;
		}
		return x;
	}
	
	public void printLinkedList() { 
		Node x = this.head;
		System.out.print("[ ");
		while (x != null) {
			System.out.print(x + " ");
			x = x.next;
		}
		System.out.println("]");
	}
}
