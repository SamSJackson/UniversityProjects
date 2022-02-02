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
		//Path path_500k = Paths.get("../DataSets/int500k.txt");
		//Path path_big = Paths.get("../DataSets/intBig.txt");
		//Path path_dutch = Paths.get("../DataSets/dutch.txt")
		Path[] allPaths = {path_10, path_50, path_100, path_1000, path_20k};
		return allPaths;
	}
	
	public static boolean testIfSorted(int[] inputArray) {
		for (int i=1; i < inputArray.length; i++) {
			if (inputArray[i] < inputArray[i-1]) {
				consoleOutput("false");
				return false;
			}
		}
		consoleOutput("true");
		return true;
	}
	
	private static boolean testRunQuicksort() throws IOException {
		Path[] allPaths = getPaths();
		for (Path path : allPaths) { 
			int[] integerArray = readFile(path);
			Algorithms.quickSortMedianOfThree(integerArray, 0, integerArray.length - 1);
			if (!testIfSorted(integerArray))
				return false;
		}
		return true;
	}
	
	private static void testOneSort(Path path) throws IOException { 
		int[] integerArray = readFile(path);
		Algorithms.printArray(integerArray);
		Algorithms.quickSortThreeWay(integerArray, 0, integerArray.length-1);
		testIfSorted(integerArray);
		Algorithms.printArray(integerArray);
	}
	
	// Testing to make sure that everything is working
	public static void main(String[] args) throws IOException {
		Path path_10 = Paths.get("../DataSets/int10.txt");
		testOneSort(path_10);
		//testRunQuicksort();
	}
}
