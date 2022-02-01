package ads2.ae1.sam;

public class Algorithms {
	/* Algorithms to implement:
	 * 
	 * quickSort (primary, 3-way, median-of-three) 
	 * insertionSort
	 * mergeSort
	 * Algorithm of O(n^2)
	 */
	
	// Print functions
	public static void printArray(int[] inputArray) {
		System.out.print("[ ");
		for (int i=0; i < inputArray.length; i++) {
			System.out.print(inputArray[i] + " ");
		}
		System.out.print("]" + '\n');
	}
	
	// helper functions
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	
	// quickSort algorithms & helpers
	private static int partitionRightMost(int[] inputArray, int p, int r) {
		int pivot = inputArray[r];
		int i = p-1;
		for (int j=p; j < r; j++) {
			if (inputArray[j] <= pivot) {
				i++;
				swap(inputArray, i, j);
			}
		}
		swap(inputArray, i+1, r);
		return i+1;
	}
	
	public static void quickSort(int[] inputArray, int p, int r) {
		if (p < r) {
			int q = partitionRightMost(inputArray, p, r);
			quickSort(inputArray, p, q-1);
			quickSort(inputArray, q+1, r);
		}
	}
	
	public static void quickSortInsertion(int[] inputArray, int p, int r, int k) {
		quickSortInsertionSubarrays(inputArray, p, r, k);
		insertionSort(inputArray);
	}
	
	public static void quickSortInsertionSubarrays(int[] inputArray, int p, int r, int k) {
		// (p-r) is size of subarray
		if ((r-p) < k)
			return;
		if (p < r) {
			int q = partitionRightMost(inputArray, p, r);
			quickSortInsertionSubarrays(inputArray, p, q-1, k);
			quickSortInsertionSubarrays(inputArray, q+1, r, k);
		}
	}
	
	// insertion algorithm
	public static void insertionSort(int[] inputArray, int p, int r) {
		int j, key;
		for (int i=p+1; i <= r; i++) {
			key = inputArray[i];
			j = i - 1;
			while (j >= p && inputArray[j] > key) {
				inputArray[j+1] = inputArray[j];
				j -= 1;
			}
			inputArray[j+1] = key;
		}
	}
	
	public static void insertionSort(int[] inputArray) {
		int j, key;
		for (int i=1; i < inputArray.length; i++) {
			key = inputArray[i];
			j = i - 1;
			while (j >= 0 && inputArray[j] > key) {
				inputArray[j+1] = inputArray[j];
				j -= 1;
			}
			inputArray[j+1] = key;
		}
	}
}
