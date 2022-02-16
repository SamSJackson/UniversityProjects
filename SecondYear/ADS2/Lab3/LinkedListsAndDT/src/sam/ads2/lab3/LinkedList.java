package sam.ads2.lab3;

public class LinkedList<Item> {
	private Node<Item> head;
	
	private static class Node<Item> {
		private Item key;
		private Node<Item> next;
		
	}
	
	public LinkedList() {
		head = null;
	}
	
	public LinkedList(Node<Item> head) { 
		this.head = head;
	}
	
	public LinkedList(Node<Item> head, Node<Item> next) {
		this.head = head;
		this.head.next = next;
	}
	
	public Item getKey() {
		return head.key;
	}
	
	public Node<Item> getNext() {
		return head.next;
	}
	
	public void setNext(Node<Item> node) {
		head.next = node;
	}
	
}
