
public class TestingDS {
	
	// 2b)
	// Operation time of O(n log n)
	public static String connectRopes(int[] nRopes) {
		// N ropes of different length
		// Need to connect to form a single rope with minimum cost
		// Cost of connecting two ropes is sum of their lengths
		ArrayQueue arrQueue = new ArrayQueue(nRopes.length*2);
		for (int num : nRopes) {
			arrQueue.insert(num);
		}
		int cost = 0;
		String stringSequence = "";
		while (arrQueue.size() > 1) {
			int firstRope = arrQueue.extract_min();
			int secondRope = arrQueue.extract_min();
			cost += firstRope + secondRope;
			arrQueue.insert(firstRope + secondRope);
			stringSequence += firstRope + " + " + secondRope + ", ";
			
		}
		return stringSequence + "\nRope connection cost: " + cost;
	}
	
	
	public static void main(String[] args) {
		
//		BSTConstantQueue bst2 = new BSTConstantQueue();
		// Case 1:
//		bst2.insert(4);
//		bst2.printTree();
//		System.out.println(bst2.extract_min() + "\n");
//		bst2.printTree();
		
		// Case 2:
//		bst2.insert(6);
//		bst2.insert(4);
//		bst2.insert(8);
//		bst2.printTree();
//		System.out.println(bst2.extract_min() + "\n");
//		bst2.printTree();
		
		// Case 3:
//		bst2.insert(10);
//		bst2.insert(15);
//		bst2.printTree();
//		System.out.println(bst2.extract_min() + "\n");
//		bst2.printTree();
		
		// Case 4:
//		bst2.insert(20);
//		bst2.insert(10);
//		bst2.insert(30);
//		bst2.insert(15);
//		bst2.insert(13);
//		bst2.printTree();
//		System.out.println(bst2.extract_min() + "\n");
//		bst2.printTree();
		
		// Case 5:
//		bst2.insert(20);
//		bst2.insert(40);
//		bst2.insert(30);
//		bst2.insert(25);
//		bst2.printTree();
//		System.out.println(bst2.extract_min() + "\n");
//		bst2.printTree();
		
		
		
		// Part 2b)
		int[] nRopes = new int[] {4, 8, 3, 1, 6, 9, 12, 7, 2};
		String ropesCost = TestingDS.connectRopes(nRopes);
		System.out.println(ropesCost);
		
	}

}
