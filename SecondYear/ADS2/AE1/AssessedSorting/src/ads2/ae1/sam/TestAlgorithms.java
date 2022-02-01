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
		Path path_10 = Paths.get("../int10.txt");
		Path path_50 = Paths.get("../int50.txt");
		Path path_100 = Paths.get("../int100.txt");
		Path path_1000 = Paths.get("../int1000.txt");
		Path path_20k = Paths.get("../int20k.txt");
		//Path path_500k = Paths.get("int500k.txt");
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
			Algorithms.quickSort(integerArray, 0, integerArray.length - 1);
			if (!testIfSorted(integerArray))
				return false;
		}
		return true;
	}
	
	private static void testOneSort(Path path) throws IOException { 
		int[] integerArray = readFile(path);
		Algorithms.quickSortInsertion(integerArray, 0, integerArray.length-1, 4);
	}
	
	// Testing to make sure that everything is working
	public static void main(String[] args) throws IOException {
		Path path_10 = Paths.get("../int10.txt");
		testOneSort(path_10);
	}
}
