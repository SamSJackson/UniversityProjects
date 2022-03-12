
public class TestingDS {
	
	public static String createSequence(int[] sequence) {
		String outputSequence = "";
		for (int i=0; i < sequence.length; i = i+2) {
			outputSequence += sequence[i] + " + " + sequence[i+1] + ", "; 
		}
		return outputSequence;
	}
	
	public static String connectingRopes(int[] nRopes) {
		// N ropes of different length
		// Need to connect to form a single rope with minimum cost
		// Cost of connecting two ropes is sum of their lengths
		BinaryTreeConstantQueue priorityQueueBST = new BinaryTreeConstantQueue();
		for (int num : nRopes) {
			priorityQueueBST.insert(num);
		}
		int[] sequence = new int[nRopes.length * 2 - 2];
		int counter = 0, cost = 0;
		while (priorityQueueBST.size() > 1) {
			int firstRope = priorityQueueBST.extract_min();
			int secondRope = priorityQueueBST.extract_min();
			cost += firstRope + secondRope;
			priorityQueueBST.insert(firstRope + secondRope);
			sequence[counter++] = firstRope;
			sequence[counter++] = secondRope;
			priorityQueueBST.printTree(priorityQueueBST.getRoot(), "");
		}
		priorityQueueBST.printTree(priorityQueueBST.getRoot(), "");
		return createSequence(sequence) + cost;
	}
	
	
	
	public static void main(String[] args) {
//		int[] arr = new int[]{15, 12, 10, 17, 4, 1, 11, 7, 9, 20, 8};
//		ArrayQueue arrQueue = new ArrayQueue(arr.length);
//		arrQueue.build_min_heap(arr);
//		arrQueue.printArray();
//		arrQueue.extract_min();
//		arrQueue.printArray();
		
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
//		bst.insert(8);
//		bst.insert(6);
//		bst.insert(7);
//		bst.insert(9);
//		bst.printTree(bst.getRoot(), "");
//		bst.extract_min();
//		bst.printTree(bst.getRoot(), "");
//		bst.extract_min();
//		bst.printTree(bst.getRoot(), "");
//		bst.extract_min();
//		bst.printTree(bst.getRoot(), "");
//		bst.extract_min();
//		bst.printTree(bst.getRoot(), "");
		
		
//		BinaryTreeConstantQueue bst2 = new BinaryTreeConstantQueue();
//		bst2.insert(11);
//		bst2.insert(4);
//		bst2.insert(15);
//		bst2.insert(6);
//		bst2.insert(5);
//		bst2.insert(8);		
//		bst2.printTree(bst2.getRoot(), "");
//		System.out.println(bst2.size(bst2.getRoot()));
//		System.out.println(bst2.extract_min());
//		bst2.printTree(bst2.getRoot(), "");
		
		int[] nRopes = new int[] {6,10,2,11,7,4};
		String ropesCost = TestingDS.connectingRopes(nRopes);
		System.out.println(ropesCost);
		
	}

}
