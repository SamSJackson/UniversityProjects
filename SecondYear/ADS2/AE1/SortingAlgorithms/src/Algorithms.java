

public class Algorithms {
	
	private static int left(int i) {
		return (2 * i) + 1;
	}
	private static int right(int i) {
		return (2 * i) + 2;
	}
	
	private static void swap(int[] inputArray, int firstIndex, int secondIndex) {
		int temp = inputArray[firstIndex];
		inputArray[firstIndex] = inputArray[secondIndex];
		inputArray[secondIndex] = temp;
	}
	
	private static int min(int n, int m) {
		return n < m ? n : m;
	}
	
	public static void printArray(int[] inputArray) {
		System.out.print("[ ");
		for (int i=0; i < inputArray.length; i++) { 
			System.out.print(inputArray[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public static void printArray(long[] inputArray) {
		System.out.print("[ ");
		for (int i=0; i < inputArray.length; i++) { 
			System.out.print(inputArray[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public static int[] insertionSortOverload(int[] inputArray, int p, int r) {
		int key, j;
		for (int i=p+1; i <= r; i++) {
			key = inputArray[i];
			j = i - 1;
			while (j >= p && inputArray[j] > key) {
				inputArray[j+1] = inputArray[j];
				j -= 1;
			}
			inputArray[j+1] = key;
		}
		return inputArray;
	}

	public static int[] insertionSort(int[] inputArray) {
		int key, j;
		for (int i=1; i <= inputArray.length-1; i++) {
			key = inputArray[i];
			j = i - 1;
			while (j >= 0 && inputArray[j] > key) {
				inputArray[j+1] = inputArray[j];
				j -= 1;
			}
			inputArray[j+1] = key;
		}
		return inputArray;
	}
	
	public static int[] reverseInsertionSort(int[] inputArray) {
		int key, j;
		for (int i=0; i <= inputArray.length-1; i++) {
			key = inputArray[i];
			j = i - 1;
			while (j >= 0 && inputArray[j] < key) {
				inputArray[j+1] = inputArray[j];
				j -= 1;
			}
			inputArray[j+1] = key;
		}
		return inputArray;
	}
	
	public static int[] selectionSort(int[] inputArray) {
		int n = inputArray.length;
		int key, index;
		for (int i=0; i < n; i++) {
			key = inputArray[i];
			index = i;
			for (int j=i+1; j < n; j++) {
				if (inputArray[j] < key) {
					key = inputArray[j];
					index = j;
				}
			}
			inputArray[index] = inputArray[i];
			inputArray[i] = key;
		}
		
		return inputArray;
	}
	
	public static int[] reverseSelectionSort(int[] inputArray) {
		int n = inputArray.length;
		int key, index;
		for (int i=0; i < n; i++) {
			key = inputArray[i];
			index = i;
			for (int j=i+1; j < n; j++) {
				if (inputArray[j] > key) {
					key = inputArray[j];
					index = j;
				}
			}
			inputArray[index] = inputArray[i];
			inputArray[i] = key;
		}
		
		return inputArray;
	}
	
	private static int[] merge(int[] inputArray, int p, int q, int r) {
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
		return inputArray;
	}
	
	public static int[] mergeInsertionSort(int[] inputArray, int p, int r) {
		int q;
		int n = inputArray.length;
		if (p < r) {
			q = (p + r)/2;
			if (q <= 10) {
				insertionSortOverload(inputArray, p, r);
			} else {
				mergeSort(inputArray, p, q);
				mergeSort(inputArray, q+1, r);
			}
			merge(inputArray, p, q, r);
		}
		return inputArray;
	}
	
	public static int[] mergeSortIterative(int[] inputArray) {
		int n = inputArray.length;
		int currentSize, leftStart;
		int mid, rightEnd;
		for (currentSize=1; currentSize < n; currentSize = currentSize*2) {
			for (leftStart=0; leftStart < n; leftStart += currentSize*2) {
				mid = min(leftStart+currentSize-1, n-1);
				rightEnd = min(leftStart+(2*currentSize)-1, n-1);
				merge(inputArray, leftStart, mid, rightEnd);
			}
		}
		
		return inputArray;
	}
	
	public static int[] mergeSort(int[] inputArray, int p, int r) {
		int q;
		if (p < r) {
			q = (p+r)/2;
			mergeSort(inputArray, p, q);
			mergeSort(inputArray, q+1, r);	
			merge(inputArray, p, q, r);
		}
		return inputArray;
	}
	
	private static int partition(int[] inputArray, int p, int r) {
		int pivotValue = inputArray[r];
		// Bottom part of partition (numbers less than pivot)
		// Must be p-1 for the case that no values are less than pivot.
		int i = p-1;
		for (int j=p; j < r; j++) {
			if (inputArray[j] <= pivotValue) {
				i++;
				swap(inputArray, i, j);
			}
		}
		swap(inputArray, i+1, r);
		return i+1;
	}
	
	public static void quickSort(int[] inputArray, int p, int r) {
		if (p < r) {
			int q = partition(inputArray, p, r);
			quickSort(inputArray, p, q-1);
			quickSort(inputArray, q+1, r);

		}
	}
	
	private static void maxHeapify(int[] inputArray, int index, int n) {
		// n = numberOfElements
		int largest;
		int l = left(index);
		int r = right(index);
		if (l < n && inputArray[l] > inputArray[index])
			largest = l;
		else 
			largest = index;
		if (r < n && inputArray[r] > inputArray[largest]) 
			largest = r;
		if (largest != index) {
			swap(inputArray, index, largest);
			maxHeapify(inputArray, largest, n);
		}
	}
	
	private static void buildMaxHeap(int[] inputArray) {
		int n = inputArray.length;
		for (int i=(n/2)-1; i >= 0; i--) {
			maxHeapify(inputArray, i, n);
		}
	}
	
	public static void heapSort(int[] inputArray) {
		int n = inputArray.length;
		buildMaxHeap(inputArray);
		int s = n;
		for (int i=n-1; i >= 1; i--) {
			swap(inputArray, 0, i);
			s--;
			maxHeapify(inputArray, 0, s);
		}
	}
}
