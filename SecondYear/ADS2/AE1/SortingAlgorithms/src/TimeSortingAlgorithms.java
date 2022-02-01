
public class TimeSortingAlgorithms {
	
	private static long meanAverage(long[] inputArray) {
		long outputResult = inputArray[0];
		for (int i=1; i < inputArray.length; i++) {
			outputResult += inputArray[i];
		}
		outputResult /= inputArray.length;
		return outputResult;
	}
	
	public static void generateMergeTimings(int[] inputArray, int numberOfRuns) {
		long[] mergeSortTimings = new long[numberOfRuns];
		long mergeSortAverage, time1;
		
		for (int i=0; i < numberOfRuns; i++) {
			int[] unsortedArrayMerge = inputArray;
			long mergeSortTime;
			
			time1 = System.nanoTime();
			Algorithms.mergeSort(unsortedArrayMerge, 0, inputArray.length-1);
			mergeSortTime = System.nanoTime() - time1;
			
			mergeSortTimings[i] = mergeSortTime;
		}
		mergeSortAverage = meanAverage(mergeSortTimings);
		System.out.println(inputArray.length + " Timing: " + mergeSortAverage);
	}
	
	public static void generateTimings(int[] inputArray, int numberOfRuns) {
		long[] insertionSortTimes = new long[numberOfRuns];
		long[] selectionSortTimes = new long[numberOfRuns];
		long insertionAverage, selectionAverage, time1, time2;
		
		for (int i=0; i < numberOfRuns; i++) {
			int[] unsortedArrayInsertion = inputArray;
			int[] unsortedArraySelection = inputArray;
			long insertionSortTime, selectionSortTime;
			
			time1 = System.nanoTime();
			Algorithms.insertionSort(unsortedArrayInsertion);
			insertionSortTime = System.nanoTime() - time1;
			
			
			time2 = System.nanoTime();
			Algorithms.selectionSort(unsortedArraySelection);
			selectionSortTime = System.nanoTime() - time2;
			
			insertionSortTimes[i] = insertionSortTime;
			selectionSortTimes[i] = selectionSortTime;
		}
		
		insertionAverage = meanAverage(insertionSortTimes);
		selectionAverage = meanAverage(selectionSortTimes);
			
		System.out.println("Insertion sort time: " + insertionAverage + " nanoseconds");
		System.out.println("Selection sort time: " + selectionAverage + " nanoseconds");		
	}
	
	public static void generateMergeCompareTimings(int[] inputArray, int numberOfRuns) {
		long[] mergeSortTimings = new long[numberOfRuns];
		long[] mergeInsertionSortTimings = new long[numberOfRuns];
		long[] mergeSortIterativeTimings = new long[numberOfRuns];
		long mergeSortAverage, mergeInsertionSortAverage,mergeSortIterativeAverage, time;
		long mergeSortTime, mergeInsertionSortTime, mergeSortIterativeTime;
		
		for (int i=0; i < numberOfRuns; i++) {
			int[] unsortedArrayMerge = inputArray;
			int[] unsortedArrayMergeInsertion = inputArray;
			int[] unsortedArrayMergeIterative = inputArray;
			
			time = System.nanoTime();
			Algorithms.mergeSort(unsortedArrayMerge, 0, inputArray.length-1);
			mergeSortTime = System.nanoTime() - time;
			
			time = System.nanoTime();
			Algorithms.mergeInsertionSort(unsortedArrayMergeInsertion, 0, inputArray.length-1);
			mergeInsertionSortTime = System.nanoTime() - time;
			
			time = System.nanoTime();
			Algorithms.mergeSortIterative(unsortedArrayMergeIterative);
			mergeSortIterativeTime = System.nanoTime() - time;
			
			mergeSortTimings[i] = mergeSortTime;
			mergeInsertionSortTimings[i] = mergeInsertionSortTime;
			mergeSortIterativeTimings[i] = mergeSortIterativeTime;
		}
		mergeSortAverage = meanAverage(mergeSortTimings);
		mergeInsertionSortAverage = meanAverage(mergeInsertionSortTimings);
		mergeSortIterativeAverage = meanAverage(mergeSortIterativeTimings);
		System.out.println("Size: " + inputArray.length + " Merge Sort Timing: " + mergeSortAverage);
		System.out.println("Size: " + inputArray.length + " Merge-InsertionSort Timing: " + mergeInsertionSortAverage);
		System.out.println("Size: " + inputArray.length + " Merge Sort Iterative Timing: " + mergeSortIterativeAverage);
	}

}
