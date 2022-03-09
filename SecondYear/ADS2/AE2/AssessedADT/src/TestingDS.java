
public class TestingDS {
	
	public static void main(String[] args) {
		int[] arr = new int[]{15, 12, 10, 17, 4, 1, 11, 7, 9, 20, 8};
		ArrayQueue arrQueue = new ArrayQueue(arr.length);
		arrQueue.build_heap(arr);
		arrQueue.printArray();
		
//		ArrayQueue qGuy = new ArrayQueue(6);
//		qGuy.insert(15);
//		qGuy.insert(12);
//		qGuy.insert(10);
//		qGuy.insert(17);
//		qGuy.insert(4);
//		qGuy.insert(1);
//		qGuy.printArray();
//		qGuy.extract_min();
//		qGuy.printArray();
		
//		BinaryTreeQueue bst = new BinaryTreeQueue();
//		bst.insert(1);
//		bst.insert(2);
//		bst.insert(3);
//		bst.printTree(bst.root, "");
//		System.out.println(bst.min());
//		bst.extract_min();
//		bst.printTree(bst.root, "");

		
		
		
		
	}

}
