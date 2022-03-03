import java.util.NoSuchElementException;

public class BinarySearchTree {
	private Node root;
	
	private static class Node {
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
	}
	public BinarySearchTree() {
		root = null;
	}
	
	public boolean checkBST(Node x) {
		if (x != null) {
			if (x.left != null) {
				if (x.key > x.left.key) {
					checkBST(x.left);
				} else {
					return false;
				}
			}
			if (x.right != null) {
				if (x.right != null) {
					if (x.key < x.right.key) {
						checkBST(x.right);
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void inOrder(Node x) {
		if (x != null) { 
			inOrder(x.left);
			System.out.print(x.key + " ");
			inOrder(x.right);
		}
	}
	
	public void preOrder(Node x) { 
		if (x != null) {
			System.out.println(x.key);
			preOrder(x.left);
			preOrder(x.right);
		}
	}
		
	public void postOrder(Node x) {
		if (x != null) {
			postOrder(x.left);
			postOrder(x.right);
			System.out.println(x.key);
		}
	}
	
	private void transplant(Node u, Node v) {
		if (u.p == null) {
			this.root = v;
		} else if (u == u.p.left) {
			u.p.left = v;
		} else {
			u.p.right = v;
		}
		if (v != null) {
			v.p = u.p;
		}
	}
	
	private void rotateLeft(Node x) {
		Node y = x.right;
		x.right = y.left;
		if (y.left != null) {
			y.left.p = x;
		}
		y.p = x.p;
		if (x.p == this.root.p) {
			this.root = y;
		} else if (x == x.p.left) {
			x.p.left = y;
		} else {
			x.p.right = y;
		}
		y.left = x;
		x.p = y;
	}
	
	public void rotateRight(Node x) {
		Node y = x.left;
		x.left = y.right;
		if (y.right != null) {
			y.right.p = x;
		}
		y.p = x.p;
		if (x.p == this.root.p) {
			this.root = y;
		} else if (x == x.p.right) {
			x.p.right = y;
		} else {
			x.p.left = y;
		}
		y.right = x;
		x.p = y;
	}
	
	public Node search(Node x, int k) {
		if (x == null || k == x.key) {
			return x;
		} else if (k < x.key) {
			return search(x.left, k);
		} else {
			return search(x.right, k);
		}
	}
	
	public Node min(Node x) {
		while (x.left != null) {
			min(x.left);
		} 
		return x;
	}
	
	public Node max(Node x) {
		while (x.right != null) {
			max(x.right);
		}
		return x;
	}
	
	public void insert(Node z) {
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
	}
	
	public void insertRoot(Node z) {
		return;
	}
	
	public void delete(Node z) {
		if (z.left == null) {
			transplant(z,z.right);
		} else if (z.right == null) {
			transplant(z,z.left);
		} else {
			Node y = min(z.right);
			if (y.p != z) {
				transplant(y,y.right);
				y.right = z.right;
				y.right.p = y;
			}
			transplant(z,y);
			y.left = z.left;
			z.left.p = y;	
		}
	}
	
	 public static void printTree(Node node, String prefix)
	 {
	    if(node == null) return;

	    System.out.println(prefix + " + " + node.key);
	    printTree(node.left , prefix + " ");
	    printTree(node.right , prefix + " ");
	 }
	
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node sevenNode = new Node(7,2);
		Node threeNode = new Node(3,1);
		Node fourNode = new Node(4,1);
		Node sixNode = new Node(6,0);
		Node twelveNode = new Node(12,1);
		Node fifteenNode = new Node(15,0);
		bst.insert(sevenNode);
		bst.insert(threeNode);
		bst.insert(fourNode);
		bst.insert(sixNode);
		bst.insert(twelveNode);
		bst.insert(fifteenNode);
		printTree(bst.root, "");
		bst.rotateLeft(threeNode);
		System.out.println();
		printTree(bst.root, "");
		boolean isBST = bst.checkBST(bst.root);
		System.out.println(isBST);
	}
}

