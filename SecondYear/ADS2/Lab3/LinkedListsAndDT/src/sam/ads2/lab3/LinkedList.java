package sam.ads2.lab3;

public class LinkedList {
	
	Node head = null;
	
	public static class Node {
		int key;
		Node next;
		
		public Node(int key) {
			this.key = key;
		}
	}
	
	private static Node merge(Node a, Node b) {
		if (a == null) {
			return b;
		} else if (b == null) { 
			return a;
		}
		
		Node x = null;
	
		if (a.key <= b.key) {
			x = a;
			x.next = merge(a.next, b);
		} else { 
			x = b;
			x.next = merge(a, b.next);
		}
		return x;
	}
	
	private static Node[] split(Node head) {
		if (head == null || head.next == null) {
			return new Node[] {head, null};
		}
		Node slow = head;
		Node fast = head.next;
		
		while (fast != null && fast.next != null) { 
			slow = slow.next;
			fast = fast.next.next;
		}
		Node mid = slow.next;
		slow.next = null;
		return new Node[] {head, mid};
	}
	
	public static Node mergeSort(Node a) {
		if (a == null || a.next == null) {
			return a;
		}
		Node[] splitList = split(a);
		Node x = mergeSort(splitList[0]);
		Node y = mergeSort(splitList[1]);
		return merge(x,y);
	}
	
	public void insertAtHead(int key) {
		Node node = new Node(key);
		node.next = head;
		head = node;
	}
	
	public void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.key + " ");
			head = head.next;
		}
		System.out.println();
	}
}
