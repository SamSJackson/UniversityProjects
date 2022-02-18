package sam.ads2.lab3;

public class Algorithms {
	
	
	public static void main(String[] args) {
		int[] array = new int[] {3,2,5,6,7,1};
		LinkedList listA = new LinkedList();
		for (int num : array) {
			listA.insertAtHead(num);
		}
		listA.printLinkedList(listA.head);
		listA.mergeSort(listA.head);
		listA.printLinkedList(listA.head);
	}
}
