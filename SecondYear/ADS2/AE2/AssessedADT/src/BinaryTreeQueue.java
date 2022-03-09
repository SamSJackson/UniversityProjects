

// Note that this queue is min-priority queue	
public class BinaryTreeQueue {
	
	public Node root;
	
	private class Node { 
		private int key;
		private Node left, right, p;
		private int size;
		
		public Node(int key, int size) {
			this.key = key;
			this.size = size;
			this.left = null;
			this.right = null;
			this.p = null;
		}
		
		@Override
		public String toString() {
			return this.key + "";
		}
		
	}
	public BinaryTreeQueue() {
		root = null;
	}
	
	
	// Operation is O(n) for left/right-skewed trees
	public void insert(int key) {
		Node z = new Node(key, 2);
		Node y = null;
		Node x = this.root;
		while (x != null) {
			y = x;
			if (z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		z.p = y;
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
		Node x = this.root;
		while (x.left != null) 
			x = x.left;
		return x;
	}
	
	// Removing a leaf is a O(1) constant operation so operation remains O(n) due to finding min
	public int extract_min() {
		Node x = min();
		if (x.p != null && x.p.left == x) {
			x.p.left = null;
		} else if (x.p == null && x.right != null) {
			x.right.p = null;
			this.root = x.right;
		} else {
			this.root = null;
		}
		
		return x.key;
	}
	
		
	public static void printTree(Node node, String prefix) {
		if(node == null) 
			return;
		
		System.out.println(prefix + " + " + node.key);
		printTree(node.left , prefix + " ");
		printTree(node.right , prefix + " ");
	 }

}
