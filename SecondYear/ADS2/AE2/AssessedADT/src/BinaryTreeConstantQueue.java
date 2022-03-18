import java.util.NoSuchElementException;

/* SOLUTION IS BROKEN 
 * ACTUAL SOLUTION:
 * 	CREATE RESIZABLE ARRAY
 * 	INSERT INTO ARRAY AND INSERTION SORT
 * 	MIN IS JUST FIRST ELEMENT OF ARRAY
 * 	EXTRACT_MIN IS POP FIRST ELEMENT OF ARRAY
 * 	THEN EXTRACT_MIN IS A MINE FIELD OF IF-STATEMENTS
 * */

public class BinaryTreeConstantQueue {
	
	private Node root;
	private Node smallest;
	
	private class Node { 
		private int key;
		private Node left, right, p;
		
		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
			this.p = null;
		}
		
		@Override
		public String toString() {
			return this.key + "";
		}
		
	}
	
	public BinaryTreeConstantQueue() {
		root = null;
	}
	
	public boolean isEmpty() { 
		return this.root == null;
	}
	
	public int size() {
		return size(this.root);
	}
	
	public int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			return size(node.left) + 1 + size(node.right);
		}
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	public int min() {
		if (isEmpty()) throw new NoSuchElementException("Empty BST");
		return this.smallest.key;
	}
	
	public int extract_min() {
		Node x = this.smallest;
		if (x == this.root) {
			if (x.right != null) {
				this.root = this.root.right;
				this.smallest = this.root;
			} else {
				this.root = null;
				this.smallest = null;
			}
		} else {
			if (x.right != null) {
				x.p.left = x.right;
				x.right.p = x.p;
				this.smallest = x.p.left;
			} else {
				x.p.left = null;
				this.smallest = x.p;
			}
		}
		return x.key;
	}
	
	public void insert(int key) {
		Node z = new Node(key);
		Node y = null;
		Node x = this.root;
		while (x != null) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		z.p = y;
		if (y == null) {
			this.root = z;
			this.smallest = z;
		} else if (z.key < y.key) {
			y.left = z;
			if (y == smallest) {
				smallest = z;
			}
		} else { 
			y.right = z;	
		}
	}
	
	public void printTree(Node node, String prefix) {
		if(node == null) 
			return;
		
		System.out.println(prefix + " + " + node.key);
		printTree(node.left , prefix + " ");
		printTree(node.right , prefix + " ");
	 }
}
