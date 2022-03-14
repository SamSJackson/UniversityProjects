

// Note that this queue is min-priority queue	
public class BinaryTreeQueue {
	
	private Node root;
	
	private class Node { 
		private int key;
		private Node left, right;
		private int size;
		
		public Node(int key, int size) {
			this.key = key;
			this.size = size;
			this.left = null;
			this.right = null;
		}
		
		@Override
		public String toString() {
			return this.key + "";
		}
		
	}
	public BinaryTreeQueue() {
		root = null;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	
	// Operation is O(n) for left/right-skewed trees
	public void insert(int key) {
		Node z = new Node(key, 2);
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
	public int min() {
		Node x = this.root;
		while (x.left != null) 
			x = x.left;
		return x.key;
	}
	
	// Removing a leaf is a O(1) constant operation 
	// operation remains O(n) due to finding minimum
	public int extract_min() {
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
		return x.key;
	}
	
	public void printTree(Node node, String prefix) {
		if(node == null) 
			return;
		System.out.println(prefix + " + " + node.key);
		printTree(node.left , prefix + " ");
		printTree(node.right , prefix + " ");
	 }
}
