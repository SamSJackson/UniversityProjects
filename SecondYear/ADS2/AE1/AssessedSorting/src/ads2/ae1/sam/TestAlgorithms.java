package ads2.ae1.sam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestAlgorithms {
	// Print functions
	private static void consoleOutput(String msg) {
		System.out.println(msg);
	}
	
	private static void consoleOutput(boolean msg) { 
		if (msg) {
			consoleOutput("true");
		} else {
			consoleOutput("false");
		}
	}
	
	// Helper functions
	private static int[] readFile(Path path) throws IOException {
		List<String> allLines = Files.readAllLines(path);
		int[] outputList = new int[allLines.size()];
		int i = 0;
		for (String number : allLines) {
			outputList[i] = Integer.parseInt(number);
			i += 1;
		}
		return outputList;
	}
	
	private static Path[] getPaths() {
		Path path_10 = Paths.get("../DataSets/int10.txt");
		Path path_50 = Paths.get("../DataSets/int50.txt");
		Path path_100 = Paths.get("../DataSets/int100.txt");
		Path path_1000 = Paths.get("../DataSets/int1000.txt");
		Path path_20k = Paths.get("../DataSets/int20k.txt");
		Path path_500k = Paths.get("../DataSets/int500k.txt");
		Path path_big = Paths.get("../DataSets/intBig.txt");
		Path path_dutch = Paths.get("../DataSets/dutch.txt");
		Path[] allPaths = {path_10, path_50, path_100, path_1000, path_20k, path_500k, path_big, path_dutch};
		return allPaths;
	}
	
	public static boolean testIfSorted(int[] inputArray) {
		for (int i=1; i < inputArray.length; i++) {
			if (inputArray[i] < inputArray[i-1]) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean testRunQuicksort() throws IOException {
		Path[] allPaths = getPaths();
		for (Path path : allPaths) {
			int[] integerArray = readFile(path);
			TimeSortingAlgorithms.compareAlgorithms(integerArray, 10, 5);
		}
		return true;
	}
	
	private static boolean testQuicksort(Path path) throws IOException { 
		int[] integerArray = readFile(path);
		Algorithms.quickSort(integerArray, 0, integerArray.length-1);
		return testIfSorted(integerArray);
	}
	
	private static boolean testQuicksortInsertion(Path path, int k) throws IOException { 
		int[] integerArray = readFile(path);
		Algorithms.quickSortInsertion(integerArray, 0, integerArray.length-1, k);
		return testIfSorted(integerArray);
	}
	
	private static boolean testQuicksortMedianOfThree(Path path) throws IOException { 
		int[] integerArray = readFile(path);
		Algorithms.quickSortMedianOfThree(integerArray, 0, integerArray.length-1);
		return testIfSorted(integerArray);
	}
	
	private static boolean testQuicksortThreeWayPartition(Path path) throws IOException { 
		int[] integerArray = readFile(path);
		Algorithms.quickSortThreeWay(integerArray, 0, integerArray.length-1);
		return testIfSorted(integerArray);
	}
	
	private static boolean testInsertion(Path path) throws IOException { 
		int[] integerArray = readFile(path);
		Algorithms.insertionSort(integerArray, 0, integerArray.length-1);
		return testIfSorted(integerArray);
	}
	
	private static boolean testMerge(Path path) throws IOException { 
		int[] integerArray = readFile(path);
		Algorithms.mergeSort(integerArray, 0, integerArray.length-1);
		return testIfSorted(integerArray);
	}
	
	// Testing to make sure that everything is working
	public static void main(String[] args) throws IOException {
		// All paths
		Path[] allPaths = getPaths();
		// First index is array size 10, each consequent index contains larger array.
		// Except last index contains dutch (duplicates for three-way)
		
		// All tests
		/* Individual test */
		boolean sorted = false;
		// sorted = testQuicksort(allPaths[0]);
		// sorted = testQuicksortInsertion(allPaths[0], 5); // Last parameter is size of subarrays
		// sorted = testQuicksortMedianOfThree(allPaths[0]);
		// sorted = testQuicksortThreeWayPartition(allPaths[0]);
		// sorted = testInsertion(allPaths[0]);
		// sorted = testMerge(allPaths[0]);
		//consoleOutput(sorted);
		
		
		/* Time all (except insertion unless commented in */
		// Comment in insertion with line 124, 128 in TimeSortingAlgorithm
		
		testRunQuicksort();
		consoleOutput("Finished all testing.");
	}
}
