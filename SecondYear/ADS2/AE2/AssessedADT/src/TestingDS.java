
public class TestingDS {
	
	public static void main(String[] args) {
		int[] arr = new int[]{15, 12, 10, 17, 4, 1, 11, 7, 9, 20, 8};
		ArrayQueue arrQueue = new ArrayQueue(arr.length);
		arrQueue.build_heap(arr);
		arrQueue.printArray();
		
		ArrayQueue qGuy = new ArrayQueue(6);
		qGuy.insert(3);
		qGuy.insert(4);
		qGuy.insert(2);
		qGuy.printArray();
		qGuy.extract_min();
		qGuy.printArray();
		
	}

}
