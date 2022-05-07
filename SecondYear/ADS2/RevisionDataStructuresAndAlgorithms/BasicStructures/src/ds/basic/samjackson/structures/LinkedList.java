package ds.basic.samjackson.structures;

public class LinkedList {
	private Node head;
	private Node tail;
	
	private class Node {
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
		
		@Override
		public String toString() {
			return this.value + "";
		}
	}
	
	public LinkedList() {
		this.head = null;
	}
	
	// O(1) constant time
	public void insertHead(int value) {
		Node x = new Node(value);
		x.next = this.head;
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
		this.tail = x;
	}
	
	// O(n) constant time since need to traverse list to find second last element
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
		
		Node second_last = this.head;
		while (second_last.next.next != null) {
			second_last = second_last.next;
		}
		x = second_last.next;
		this.tail = second_last;
		second_last.next = null;
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
