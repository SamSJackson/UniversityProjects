import java.util.NoSuchElementException;

public class BSTConstantQueue {
	
	private Node root;
	private Node[] smallestNodes = new Node[2];
	private int numberOfNodes;
	
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
	
	public BSTConstantQueue() {
		root = null;
	}
	
	private void resize(int length) {
		Node[] newArray = new Node[length];
		for (int i=0; i < this.smallestNodes.length; i++) {
			newArray[i] = this.smallestNodes[i];
		}
		this.smallestNodes = newArray;
	}

	// O(n^2) operation time
	private void insertSort() {
		int n = this.numberOfNodes;
		for (int i=1; i < n; ++i) {
			Node node = this.smallestNodes[i];
			int j = i - 1;
			while (j >= 0 && this.smallestNodes[j].key < node.key) {
				this.smallestNodes[j+1] = this.smallestNodes[j];
				j--;
			}
			this.smallestNodes[j+1] = node;
		}
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

	// O(1) constant operation
	public Node min() {
		if (isEmpty()) throw new NoSuchElementException("Empty BST");
		return this.smallestNodes[numberOfNodes-1];
	}

	// O(1) constant operation
	public Node extract_min() {
		Node x = min();
		numberOfNodes--;
		// Node is root, no left child
		if (x == this.root) {
			if (x.right == null) {
				this.root = null;
			// Root contains right subtree
			} else {
				this.root = this.root.right;
				this.root.p = null;
			}
		// Smallest element left subtree
		} else {
			// No right subtree
			if (x.right == null) {
				x.p.left = null;
			// Smallest element contains right subtree
			} else {
				x.p.left = x.right;
				x.right.p = x.p;
			}
		}
		return x;
	}
	
	// O(n^2) operation time
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
		} else if (z.key < y.key) {
			y.left = z;
		} else { 
			y.right = z;	
		}
		
		// Add to list of all smallest nodes
		this.smallestNodes[numberOfNodes++] = z;
		// Resize array if needed
		if (numberOfNodes == smallestNodes.length - 1) {
			resize(smallestNodes.length*2);
		}
		// Reverse sorted, smallest at end.
		insertSort();
	}
	
	public void printTree() {
		printTree(this.root, "");
	 }
	
	private void printTree(Node node, String prefix) {
		if(node == null) 
			return;
		
		System.out.println(prefix + " + " + node.key);
		printTree(node.left , prefix + " ");
		printTree(node.right , prefix + " ");
	 }
}
