import java.util.NoSuchElementException;

// Note that this queue is min-priority queue	
public class BSTQueue {
	
	private Node root;
	
	private class Node { 
		private int key;
		private Node left, right;
		
		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
		
		@Override
		public String toString() {
			return this.key + "";
		}
		
	}
	public BSTQueue() {
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
	
	
	// Operation is O(n) for left/right-skewed trees
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
		if (y == null) {
			this.root = z;
		} else if (z.key < y.key) {
			y.left = z;
		} else { 
			y.right = z;	
		}
	}
	
	// Operation is O(n) for worst case in case of only elements on left side
	public Node min() {
		if (isEmpty()) throw new NoSuchElementException("Empty BST");
		return min(this.root);
	}
	
	public Node min(Node x) {
		if (x.left == null) return x;
		return min(x.left);
	}
	
	// Removing a leaf is a O(1) constant operation 
	// operation remains O(n) due to finding minimum
	public Node extract_min() {
		if (isEmpty()) throw new NoSuchElementException("Empty BST");
		Node x = this.root;
		Node parent = null;
		while (x.left != null) {
			parent = x;
			x = x.left;
		}
		if (x == this.root) {
			if (x.right != null) {
				this.root = this.root.right;
			} else {
				this.root = null;
			}
		} else {
			if (x.right != null) {
				parent.left = parent.left.right;
			} else { 
				parent.left = null;
			}
		}
		return x;
	}
	
	public void printTree(Node node, String prefix) {
		if(node == null) 
			return;
		System.out.println(prefix + " + " + node.key);
		printTree(node.left , prefix + " ");
		printTree(node.right , prefix + " ");
	 }
}
