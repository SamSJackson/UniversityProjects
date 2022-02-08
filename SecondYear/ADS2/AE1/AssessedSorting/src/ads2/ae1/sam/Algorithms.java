package ads2.ae1.sam;

import java.util.Arrays;

public class Algorithms {
	/* Algorithms to implement:
	 * 
	 * quickSort (primary // DONE, insertion method // DONE,  3-way, median-of-three // DONE) 
	 * insertionSort // DONE
	 * mergeSort // DONE
	 * Algorithm of O(n^2) // DONE IN GenerateInput.java
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
	
	private static void merge(int[] inputArray, int p, int q, int r) {
		int n_1 = q - p + 1;
		int n_2 = r - q;
		int[] L = new int[n_1+1];
		
		// L = [p, ... , q]
		for (int i=0; i < n_1; i++) {
			L[i] = inputArray[p+i];
		}
		int[] R = new int[n_2+1];
		
		// R = [q+1, ... , r]
		for (int i=0; i < n_2; i++) {
			R[i] = inputArray[q + i + 1];
		}
		
		L[n_1] = Integer.MAX_VALUE;
		R[n_2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k=p; k <= r; k++) {
			if (L[i] <= R[j]) {
				inputArray[k] = L[i++];
			} else {
				inputArray[k] = R[j++];
			}
		}
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
	
	// Returning the indices of the subarray of equal pivots
	private static int[] partitionThreeWay(int[] inputArray, int p, int r) {
		// Want to return the indices of the subarray of equal pivots
		int lessThan = p;
		int greaterThan = r;
		int i = p;
		int pivot = inputArray[r];
		while (i <= greaterThan) {
			if (inputArray[i] < pivot) {
				swap(inputArray, i, lessThan);
				lessThan++;
				i++;
			} else if (inputArray[i] > pivot) {
				swap(inputArray, i, greaterThan);
				greaterThan--;
			} else {
				i++;
			}
		}
		return new int[] {lessThan, greaterThan};
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
			int[] pivotPoints = partitionThreeWay(inputArray, p, r);
			int startPivot = pivotPoints[0];
			int endPivot = pivotPoints[1];
			quickSortThreeWay(inputArray, p, startPivot-1);
			quickSortThreeWay(inputArray, endPivot+1, r);
		}
	}
	
	public static void quickSortMedianOfThree(int[] inputArray, int p, int r) {
		if (p < r) {
			medianOfThree(inputArray, p, r);
			int q = partition(inputArray, p, r);
			quickSortMedianOfThree(inputArray, p, q-1);
			quickSortMedianOfThree(inputArray, q+1, r);
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
	
	public static void mergeSort(int[] inputArray, int p, int r) {
		int q;
		if (p < r) {
			q = (p + r) / 2;
			mergeSort(inputArray, p, q);
			mergeSort(inputArray, q+1, r);
			merge(inputArray, p, q, r);
		}
	}
}
