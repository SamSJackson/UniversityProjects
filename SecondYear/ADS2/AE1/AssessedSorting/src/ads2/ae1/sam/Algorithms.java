package ads2.ae1.sam;

import java.util.Arrays;

public class Algorithms {
	/* Algorithms to implement:
	 * 
	 * quickSort (primary // DONE, insertion method // DONE,  3-way, median-of-three // DONE) 
	 * insertionSort // DONE
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
	
	private static int min(int[] inputArray, int i, int j) {
		return inputArray[i] < inputArray[j] ? i : j;
	}
	
	private static int max(int[] inputArray, int i, int j) {
		return inputArray[i] > inputArray[j] ? i : j;
	}
	
	// quickSort algorithms & helpers
	private static int partition(int[] inputArray, int p, int r) {
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
	
	
	// Returning the start and end points of equal partitions
	private static int[] partitionThreeWay(int[] inputArray, int p, int r) {
		// Picking the pivot to be number at end of index
		// Could even use median of three method here
		int pivot = inputArray[r];
		int i = p + 1;
		int[] outputArray = new int[2];
		
		while (i < p) {
			if (inputArray[i] > pivot) {
				swap(inputArray, i, r--);
			} else if (inputArray[i] < pivot) {
				swap(inputArray, p++, i++);
			} else {
				i++;
			}
		}
		outputArray[0] = p;
		outputArray[1] = r;
		return outputArray;
	}
	
	private static void medianOfThree(int[] inputArray, int low, int high) {
		// Need to find the median of three values.	
		int mid = (high + low) / 2;
		int[] medianArray = {inputArray[low], inputArray[mid], inputArray[high]};
		
		// Sort using insertion (small array) and then pick middle integer.
		insertionSort(medianArray);
		int middleValue = medianArray[1];
		
		// Placing median of three at the end
		
		int temp = inputArray[high];
		inputArray[high] = middleValue;
		if (middleValue == inputArray[low]) {
			inputArray[low] = temp;
		} else if (middleValue == inputArray[mid]) {
			inputArray[mid] = temp;
		}
		
		// This has now made the array pick a pivot that is, at the very least,
		// not the smallest nor largest number.
	}
	
	public static void quickSort(int[] inputArray, int p, int r) {
		if (p < r) {
			int q = partition(inputArray, p, r);
			quickSort(inputArray, p, q-1);
			quickSort(inputArray, q+1, r);
		}
	}
	
	public static void quickSortThreeWay(int[] inputArray, int p, int r) {
		if (p < r) {
			// Use quicksort on two parts, parts less than pivot and greater than pivot
			int[] pivots = partitionThreeWay(inputArray, p, r);
			int startPivot = pivots[0];
			int endPivot = pivots[1];
			System.out.println("Start: " + startPivot + " End: " + endPivot);
			// quickSort, before pivot
			quickSortThreeWay(inputArray, 0, startPivot-1);
			// quickSort, after pivot
			quickSortThreeWay(inputArray, endPivot+1, r);
		}
	}
	
	public static void quickSortMedianOfThree(int[] inputArray, int p, int r) {
		if (p < r) {
			medianOfThree(inputArray, p, r);
			int q = partition(inputArray, p, r);
			quickSort(inputArray, p, q-1);
			quickSort(inputArray, q+1, r);
		}
	}
	
	public static void quickSortInsertion(int[] inputArray, int p, int r, int k) {
		quickSortInsertionSubarrays(inputArray, p, r, k);
		insertionSort(inputArray);
	}
	
	private static void quickSortInsertionSubarrays(int[] inputArray, int p, int r, int k) {
		// (r-p) is size of subarray
		if ((r-p) < k)
			return;
		if (p < r) {
			int q = partition(inputArray, p, r);
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
