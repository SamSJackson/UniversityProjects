package ads2.ae1.sam;

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
	
	public static void compareQuickSortAlgorithms(int[] inputArray, int numberOfRuns) {
		long[] standardQuicksort = new long[numberOfRuns];
		long[] insertionQuicksort = new long[numberOfRuns];
		long[] medianQuicksort = new long[numberOfRuns];
		long[] threeWayQuicksort = new long[numberOfRuns];
		
		long standardQuicksortAverage, insertionQuicksortAverage;
		long medianQuicksortAverage, threeWayQuicksortAverage;
		
		long standardQuicksortTime, insertionQuicksortTime;
		long medianQuicksortTime, threeWayQuicksortTime;
	
		long time; 
		
		for (int i=0; i < numberOfRuns; i++) {
			int[] unsortedArrayStandard = inputArray;
			int[] unsortedArrayInsertion = inputArray;
			int[] unsortedArrayMedian = inputArray;
			int[] unsortedArrayQuicksort = inputArray;
			
			/*
			time = System.nanoTime();
			Algorithms.quickSort(inputArray, 0, inputArray.length-1);
			standardQuicksortTime = System.nanoTime() - time;
			*/
			/*
			time = System.nanoTime();
			Algorithms.quickSortInsertion(inputArray, 0, inputArray.length-1, 10);
			insertionQuicksortTime = System.nanoTime() - time;
			*/
			time = System.nanoTime();
			Algorithms.quickSortMedianOfThree(inputArray, 0, inputArray.length-1);
			medianQuicksortTime = System.nanoTime() - time;
			
			time = System.nanoTime();
			Algorithms.quickSortThreeWay(inputArray, 0, inputArray.length-1);
			threeWayQuicksortTime = System.nanoTime() - time;
			
			//standardQuicksort[i] = standardQuicksortTime;
			//insertionQuicksort[i] = medianQuicksortTime;
			medianQuicksort[i] = medianQuicksortTime;
			threeWayQuicksort[i] = threeWayQuicksortTime;
		}
		//standardQuicksortAverage = meanAverage(standardQuicksort);
		//insertionQuicksortAverage = meanAverage(medianQuicksort);
		medianQuicksortAverage = meanAverage(medianQuicksort);
		threeWayQuicksortAverage = meanAverage(threeWayQuicksort);
		
		//System.out.println("Size: " + inputArray.length + " Standard Quicksort: " + standardQuicksortAverage);
		//System.out.println("Size: " + inputArray.length + " Insertion Quicksort: " + insertionQuicksortAverage);
		System.out.println("Size: " + inputArray.length + " Median Quicksort: " + medianQuicksortAverage);
		System.out.println("Size: " + inputArray.length + " 3-Way Partition Quicksort: " + threeWayQuicksortAverage);
	}
}
