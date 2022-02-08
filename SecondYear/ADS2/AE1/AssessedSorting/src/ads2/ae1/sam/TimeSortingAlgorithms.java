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
	
	public static long timeArray(int[] inputArray, int numberOfRuns) {
		long[] times = new long[numberOfRuns];
		long averageTime, time, newTime;
		
		int[] copiedArray = Arrays.copyOf(inputArray, inputArray.length);
		
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.quickSortMedianOfThree(inputArray, 0, inputArray.length-1);
			times[i] = System.currentTimeMillis() - time;
			copiedArray = Arrays.copyOf(inputArray, inputArray.length);
		}
		averageTime = meanAverage(times);
		return averageTime;
	}

	
	private static long runInsertion(int[] inputArray, int numberOfRuns) throws InterruptedException {
		long[] standardInsertionSortTimings = new long[numberOfRuns];
		long standardInsertionTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.insertionSort(unsortedArray, 0, inputArray.length-1);
			standardInsertionTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				throw new InterruptedException("Array not sorted: Insertion Sort");
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardInsertionSortTimings[i] = standardInsertionTime; 
		}
		return meanAverage(standardInsertionSortTimings);
	}
	
	private static long runMerge(int[] inputArray, int numberOfRuns) throws InterruptedException {
		long[] standardMergeSortTimings = new long[numberOfRuns];
		long standardMergeTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.mergeSort(unsortedArray, 0, inputArray.length-1);
			standardMergeTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				throw new InterruptedException("Array not sorted: Merge sort");
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardMergeSortTimings[i] = standardMergeTime; 
		}
		return meanAverage(standardMergeSortTimings);
	}
	
	private static long runStandardQuicksort(int[] inputArray, int numberOfRuns) throws InterruptedException {
		long[] standardQuicksortSortTimings = new long[numberOfRuns];
		long standardQuicksortTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.quickSort(unsortedArray, 0, inputArray.length-1);
			standardQuicksortTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				throw new InterruptedException("Array not sorted: Standard Quicksort");
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardQuicksortSortTimings[i] = standardQuicksortTime; 
		}
		return meanAverage(standardQuicksortSortTimings);
	}
	
	private static long runQuicksortInsertion(int[] inputArray, int numberOfRuns, int k) throws InterruptedException {
		long[] standardQuicksortInsertionSortTimings = new long[numberOfRuns];
		long standardQuicksortInsertionTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.quickSortInsertion(unsortedArray, 0, inputArray.length-1, k);
			standardQuicksortInsertionTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				throw new InterruptedException("Array not sorted: Quicksort-Insertion");
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardQuicksortInsertionSortTimings[i] = standardQuicksortInsertionTime; 
		}
		return meanAverage(standardQuicksortInsertionSortTimings);
	}
	
	private static long runQuicksortMedian(int[] inputArray, int numberOfRuns) throws InterruptedException {
		long[] standardQuicksortMedianSortTimings = new long[numberOfRuns];
		long standardQuicksortMedianTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.quickSortMedianOfThree(unsortedArray, 0, inputArray.length-1);
			standardQuicksortMedianTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				throw new InterruptedException("Array not sorted: Quicksort Median-of-Three");
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardQuicksortMedianSortTimings[i] = standardQuicksortMedianTime; 
		}
		return meanAverage(standardQuicksortMedianSortTimings);
	}
	
	private static long runQuicksortThreeWay(int[] inputArray, int numberOfRuns) throws InterruptedException {
		long[] standardQuicksortThreeWaySortTimings = new long[numberOfRuns];
		long standardQuicksortThreeWayTime, time;
		
		int[] unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
		for (int i=0; i < numberOfRuns; i++) {
			time = System.currentTimeMillis();
			Algorithms.quickSortThreeWay(unsortedArray, 0, inputArray.length-1);
			standardQuicksortThreeWayTime = System.currentTimeMillis() - time;
			if (!check(TestAlgorithms.testIfSorted(unsortedArray))) {
				throw new InterruptedException("Array not sorted: Three-Way Quicksort");
			}
			unsortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			standardQuicksortThreeWaySortTimings[i] = standardQuicksortThreeWayTime; 
		}
		return meanAverage(standardQuicksortThreeWaySortTimings);
	}
	
	
	public static void compareAlgorithms(int[] inputArray, int numberOfRuns, int k) throws InterruptedException {
		long standardQuicksortAverage=-1, insertionQuicksortAverage=-1;
		long medianQuicksortAverage=-1, threeWayQuicksortAverage=-1;
		long insertionSortAverage=-1, mergeSortAverage=-1;

		try {
			standardQuicksortAverage = runStandardQuicksort(inputArray, numberOfRuns);
			insertionQuicksortAverage = runQuicksortInsertion(inputArray, numberOfRuns, k);
			medianQuicksortAverage = runQuicksortMedian(inputArray, numberOfRuns);
			threeWayQuicksortAverage = runQuicksortThreeWay(inputArray, numberOfRuns);
			//insertionSortAverage = runInsertion(inputArray, numberOfRuns);
			mergeSortAverage = runMerge(inputArray, numberOfRuns);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Size: " + inputArray.length);
		System.out.println("Standard Insertion Sort: " + insertionSortAverage + "ms");
		System.out.println("Standard Merge Sort: " + mergeSortAverage + "ms");
		System.out.println("Standard Quicksort: " + standardQuicksortAverage + "ms");
		System.out.println("Insertion Quicksort (k=" + k + "): " + insertionQuicksortAverage + "ms");
		System.out.println("Median Quicksort: " + medianQuicksortAverage + "ms");
		System.out.println("3-Way Partition Quicksort: " + threeWayQuicksortAverage + "ms");
		System.out.println("----------------------------------------------------");
	}
}
