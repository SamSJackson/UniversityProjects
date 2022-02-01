import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestSortingAlgorithms {
	
	
	// Need to read input from text files, get all numbers and put into list
	public static int[] readFile(Path path) throws IOException {
		List<String> allLines = Files.readAllLines(path);
		int[] outputList = new int[allLines.size()];
		int i = 0;
		for (String number : allLines) {
			outputList[i] = Integer.parseInt(number);
			i += 1;
		}
		return outputList;
	}
	
	public static boolean testIfSorted(int[] inputArray) {
		for (int i=1; i < inputArray.length; i++) {
			if (inputArray[i] < inputArray[i-1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void testRun(Path[] pathInputs) throws IOException {	
		for (Path path : pathInputs) {
			int[] integerArray = readFile(path);
			Algorithms.quickSort(integerArray, 0, integerArray.length - 1);
			System.out.println(testIfSorted(integerArray));
			//TimeSortingAlgorithms.generateMergeCompareTimings(integerArray, 1000);
			//TimeSortingAlgorithms.generateTimings(integerArray, 10000);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Path path_10 = Paths.get("int10.txt");
		Path path_50 = Paths.get("int50.txt");
		Path path_100 = Paths.get("int100.txt");
		Path path_1000 = Paths.get("int1000.txt");
		Path path_20k = Paths.get("int20k.txt");
		//Path path_500k = Paths.get("int500k.txt");
		Path[] allPaths = {path_10, path_50, path_100, path_1000, path_20k};
		
		testRun(allPaths);
		
	}
	
	
}
