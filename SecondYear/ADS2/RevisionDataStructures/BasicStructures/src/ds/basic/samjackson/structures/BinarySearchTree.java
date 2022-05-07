package ds.basic.samjackson.structures;

public class BinarySearchTree {
	private Node root;
	
	private class Node {
		private int value;
		private Node left;
		private Node right;
		private Node parent;
		private Node successor;
		
		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
			this.parent = null;
			this.successor = null;
		}
		
		@Override
		public String toString() {
			return this.value + "";
		}
	}
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public void insert(int[] values) {
		for (int num : values) {
			insert(num);
		}
	}
	
	public void insert(int value) {
		if (this.root == null) {
			this.root = new Node(value);
			return;
		}
		Node x = this.root;
		Node y = null;
		while (x != null) {
			y = x;
			if (value < x.value) {
				x = x.left;
			} else if (value > x.value){
				x = x.right;
			} else {
				x = null;
			}
		}
		if (value != y.value) {
			Node z = new Node(value);
			if (z.value < y.value) {
				y.left = z;
			} else if (z.value > y.value){
				y.right = z;
			}
			z.successor = inOrderSuccessor(z);
		}
	}
	
	private Node min(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	private Node inOrderSuccessor(Node z) {
		// Root node
		if (z.right != null) {
			return min(z.right);
		}
		Node y = z.parent;
		while (y != null && z == y.right) {
			z = y;
			y = y.parent;
		}
		return y;
	}
	
	public void printInOrder() {
		System.out.println("In order: ");
		System.out.print("[ ");
		printInOrder(this.root);
		System.out.println("]");
	}
	
	public void printInOrder(Node node) {
		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node + " ");
		printInOrder(node.right);
	}
	
	public void printPreOrder() {
		System.out.println("Pre order: ");
		System.out.print("[ ");
		printPreOrder(this.root);
		System.out.println("]");
	}
	public void printPreOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	public void printPostOrder() {
		System.out.println("Post order: ");
		System.out.print("[ ");
		printPostOrder(this.root);
		System.out.println("]");
	}
	
	public void printPostOrder(Node node) {
		if (node == null) { 
			return;
		}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node +  " ");
	}
}
