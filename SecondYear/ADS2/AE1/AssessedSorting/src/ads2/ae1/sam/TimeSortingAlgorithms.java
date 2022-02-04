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
	
	private static boolean check(boolean test) {
		if (test) { 
			return true;
		} else {
			System.out.println("NOT SORTED");
			return false;
		}
	}
	
	private static long runInsertion(int[] inputArray, int numberOfRuns) {
		long[] standardInsertionSortTimings = new long[numberOfRuns];
		long standardInsertionTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.insertionSort(unsortedArray, 0, inputArray.length-1);
			standardInsertionTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				break;
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardInsertionSortTimings[i] = standardInsertionTime; 
		}
		return meanAverage(standardInsertionSortTimings);
	}
	
	private static long runMerge(int[] inputArray, int numberOfRuns) {
		long[] standardMergeSortTimings = new long[numberOfRuns];
		long standardMergeTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.mergeSort(unsortedArray, 0, inputArray.length-1);
			standardMergeTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				break;
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardMergeSortTimings[i] = standardMergeTime; 
		}
		return meanAverage(standardMergeSortTimings);
	}
	
	private static long runStandardQuicksort(int[] inputArray, int numberOfRuns) {
		long[] standardQuicksortSortTimings = new long[numberOfRuns];
		long standardQuicksortTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.quickSort(unsortedArray, 0, inputArray.length-1);
			standardQuicksortTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				break;
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardQuicksortSortTimings[i] = standardQuicksortTime; 
		}
		return meanAverage(standardQuicksortSortTimings);
	}
	
	private static long runQuicksortInsertion(int[] inputArray, int numberOfRuns, int k) {
		long[] standardQuicksortInsertionSortTimings = new long[numberOfRuns];
		long standardQuicksortInsertionTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.quickSortInsertion(unsortedArray, 0, inputArray.length-1, k);
			standardQuicksortInsertionTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				break;
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardQuicksortInsertionSortTimings[i] = standardQuicksortInsertionTime; 
		}
		return meanAverage(standardQuicksortInsertionSortTimings);
	}
	
	private static long runQuicksortMedian(int[] inputArray, int numberOfRuns) {
		long[] standardQuicksortMedianSortTimings = new long[numberOfRuns];
		long standardQuicksortMedianTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.quickSortMedianOfThree(unsortedArray, 0, inputArray.length-1);
			standardQuicksortMedianTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				break;
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardQuicksortMedianSortTimings[i] = standardQuicksortMedianTime; 
		}
		return meanAverage(standardQuicksortMedianSortTimings);
	}
	
	private static long runQuicksortThreeWay(int[] inputArray, int numberOfRuns) {
		long[] standardQuicksortThreeWaySortTimings = new long[numberOfRuns];
		long standardQuicksortThreeWayTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.quickSortThreeWay(unsortedArray, 0, inputArray.length-1);
			standardQuicksortThreeWayTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				break;
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardQuicksortThreeWaySortTimings[i] = standardQuicksortThreeWayTime; 
		}
		return meanAverage(standardQuicksortThreeWaySortTimings);
	}
	
	
	public static void compareAlgorithms(int[] inputArray, int numberOfRuns, int k) {
		long standardQuicksortAverage, insertionQuicksortAverage;
		long medianQuicksortAverage, threeWayQuicksortAverage;
		long insertionSortAverage, mergeSortAverage;

		standardQuicksortAverage = runStandardQuicksort(inputArray, numberOfRuns);
		insertionQuicksortAverage = runQuicksortInsertion(inputArray, numberOfRuns, k);
		medianQuicksortAverage = runQuicksortMedian(inputArray, numberOfRuns);
		threeWayQuicksortAverage = runQuicksortThreeWay(inputArray, numberOfRuns);
		//insertionSortAverage = runInsertion(inputArray, numberOfRuns);
		mergeSortAverage = runMerge(inputArray, numberOfRuns);
		
		System.out.println("Size: " + inputArray.length);
		//System.out.println("Standard Insertion Sort: " + insertionSortAverage + "ms");
		System.out.println("Standard Merge Sort: " + mergeSortAverage + "ms");
		System.out.println("Standard Quicksort: " + standardQuicksortAverage + "ms");
		System.out.println("Insertion Quicksort (k=" + k + ") :" + insertionQuicksortAverage + "ms");
		System.out.println("Median Quicksort: " + medianQuicksortAverage + "ms");
		System.out.println("3-Way Partition Quicksort: " + threeWayQuicksortAverage + "ms");
		System.out.println("----------------------------------------------------");
	}
}
