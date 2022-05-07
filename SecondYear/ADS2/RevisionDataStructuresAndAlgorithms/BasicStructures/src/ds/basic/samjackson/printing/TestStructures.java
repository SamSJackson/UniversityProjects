package ds.basic.samjackson.printing;

import ds.basic.samjackson.structures.BinarySearchTree;
import ds.basic.samjackson.structures.DoublyLinkedList;
import ds.basic.samjackson.structures.Heap;
import ds.basic.samjackson.structures.LinkedList;

public class TestStructures {
	
	private static void swap(int[] S, int i, int j) {
		int temp = S[i];
		S[i] = S[j];
		S[j] = temp;
	}
	
	private static int locateMax(int[] S, int upb) {
		int maxNumIndex = 0;
		for (int i=0; i < upb; i++) {
			if (S[i] > S[maxNumIndex]) 
				maxNumIndex = i;
		}
		return maxNumIndex;
	}
	
	public static void selectionSort(int[] S) {
		int n = S.length;
		for (int i=n; i > 0 ; i--) {
			int maxIndex = locateMax(S, i);
			swap(S, maxIndex, i-1);
		}
	}
	
	public static void printArray(int[] S) { 
		System.out.print("[ ");
		for (int num : S) { 
			System.out.print(num + " ");	
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		int[] base_array = {30, 40, 24, 58, 48, 26, 11, 13, 36};
		LinkedList linkedlist = new LinkedList();
		BinarySearchTree bst = new BinarySearchTree();
		DoublyLinkedList ddlinkedlist = new DoublyLinkedList();
		bst.insert(base_array);
		bst.printPreOrder();
		bst.printInOrder();
		bst.printPostOrder();
		
//		printArray(base_array);
//		selectionSort(base_array);
//		printArray(base_array);
		
	}	
}
