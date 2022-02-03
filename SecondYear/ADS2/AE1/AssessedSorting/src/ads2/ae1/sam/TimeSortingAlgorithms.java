package ads2.ae1.sam;

import java.util.Arrays;

public class TimeSortingAlgorithms {
	// Class for testing speed of algorithms
	// Try to make this semi-elegant.
	
	private static long meanAverage(long[] inputArray) {
		long outputResult = inputArray[0];
		for (int i=1; i < inputArray.length; i++) {
			outputResult += inputArray[i];
		}
		outputResult /= inputArray.length;
		return outputResult;
	}
	
	
	public static void compareAlgorithms(int[] inputArray, int numberOfRuns) {
		long[] standardQuicksort = new long[numberOfRuns];
		long[] insertionQuicksort = new long[numberOfRuns];
		long[] medianQuicksort = new long[numberOfRuns];
		long[] threeWayQuicksort = new long[numberOfRuns];
		long[] standardInsertionSort = new long[numberOfRuns];
		long[] standardMergeSort = new long[numberOfRuns];
		
		long standardQuicksortAverage, insertionQuicksortAverage;
		long medianQuicksortAverage, threeWayQuicksortAverage;
		long insertionSortAverage, mergeSortAverage;
		
		long standardQuicksortTime, insertionQuicksortTime;
		long medianQuicksortTime, threeWayQuicksortTime;
		long insertionSortTime, mergeSortTime;
	
		long time; 
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.quickSort(unsortedArray, 0, inputArray.length-1);
			standardQuicksortTime = System.currentTimeMillis() - time;
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			time = System.currentTimeMillis();
			Algorithms.quickSortInsertion(unsortedArray, 0, inputArray.length-1, 5);
			insertionQuicksortTime = System.currentTimeMillis() - time;
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			time = System.currentTimeMillis();
			Algorithms.quickSortMedianOfThree(unsortedArray, 0, inputArray.length-1);
			medianQuicksortTime = System.currentTimeMillis() - time;
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			time = System.currentTimeMillis();
			Algorithms.quickSortThreeWay(unsortedArray, 0, inputArray.length-1);
			threeWayQuicksortTime = System.currentTimeMillis() - time;
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			time = System.currentTimeMillis();
			Algorithms.insertionSort(unsortedArray, 0, inputArray.length-1);
			insertionSortTime = System.currentTimeMillis() - time;
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			time = System.currentTimeMillis();
			Algorithms.mergeSort(unsortedArray, 0, inputArray.length-1);
			mergeSortTime = System.currentTimeMillis() - time;
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardQuicksort[i] = standardQuicksortTime;
			insertionQuicksort[i] = medianQuicksortTime;
			medianQuicksort[i] = medianQuicksortTime;
			threeWayQuicksort[i] = threeWayQuicksortTime;
			standardInsertionSort[i] = insertionSortTime;
			standardMergeSort[i] = mergeSortTime;
		}
		standardQuicksortAverage = meanAverage(standardQuicksort);
		insertionQuicksortAverage = meanAverage(medianQuicksort);
		medianQuicksortAverage = meanAverage(medianQuicksort);
		threeWayQuicksortAverage = meanAverage(threeWayQuicksort);
		insertionSortAverage = meanAverage(standardInsertionSort);
		mergeSortAverage = meanAverage(standardMergeSort);
		
		
		System.out.println("Size: " + inputArray.length);
		System.out.println("Standard Insertion Sort: " + insertionSortAverage + "ms");
		System.out.println("Standard Merge Sort: " + mergeSortAverage + "ms");
		System.out.println("Standard Quicksort: " + standardQuicksortAverage + "ms");
		System.out.println("Insertion Quicksort: " + insertionQuicksortAverage + "ms");
		System.out.println("Median Quicksort: " + medianQuicksortAverage + "ms");
		System.out.println("3-Way Partition Quicksort: " + threeWayQuicksortAverage + "ms");
		System.out.println("----------------------------------------------------");
	}
}
