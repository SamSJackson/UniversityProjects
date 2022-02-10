package ads2.ae1.sam;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GenerateInput {
	
	
	static Scanner readInput = new Scanner(System.in);
	static Random rand = new Random();
	// Class that is created in order 
	// to define an algorithm that will generate inputs that will cause 
	// Median of three quicksort to run worst case.
	
	// Worst case for median of three is where it reduces the number of elements as little as possible.
	
	// AKA I need the middle element to be the same as the the last element of the array.
	private static boolean makeFile(String filename) {
		try {
			File outputFile = new File(filename);
			if (outputFile.createNewFile()) {
				System.out.println("File created: " + filename);
				return true;
			} else {
				System.out.println(filename + " already exists");
				return false;
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return false;
	}
	
	private static int[] createRandomArray(int numberOfElements) {
		if (numberOfElements < 0) {
			throw new IllegalArgumentException("Must be a positive number of elements");
		}
		int[] outputArray = new int[numberOfElements];
		for (int i=0; i < numberOfElements; i++) {
			outputArray[i] = rand.nextInt(numberOfElements);
		}
		return outputArray;
	}
	
	private static int[] createArray(int numberOfElements) { 
		if (numberOfElements < 0) { 
			throw new IllegalArgumentException("Must be a positive number of elements");
		}
		int[] numbersArray = new int[numberOfElements];
		int maxNum = numberOfElements;
		int endPointer = numberOfElements-1;
		for (int i=0; i < numberOfElements/2; i++) {
			numbersArray[i] = maxNum--;
			numbersArray[endPointer--] = maxNum--;
		}
		return numbersArray;
	}

	
	public static void generateOutput(int numberOfElements, String filename) throws IOException {
		while (!makeFile(filename)) {
			System.out.println("Please make sure to pick an available name.");
			filename = readInput.nextLine() + ".txt";
		}
		try {
			FileWriter writeToFile = new FileWriter(filename);
			int[] arrayToWrite = createArray(numberOfElements);
			for (int i=0; i < numberOfElements; i++) {
				if (i == numberOfElements-1) {
					writeToFile.write(arrayToWrite[i] + "");
				} else {
					writeToFile.write(arrayToWrite[i] + "\n");
				}
			}
			writeToFile.close();
			System.out.println("WRITTEN");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		long averageTimeSlow = -1, averageTimeStandard = -1;
		
		/* TO CREATE TEXT FILE AND PATH */
		// generateOutput("insertName.txt");
		// Path path_insertName = Paths.get("insertName.txt");
		
		
		// May not have int30k and int40k, was going to submit with files, but txt files not accepted.
		// So I made a function to return random arrays of desired size
		Path path_20k = Paths.get("int20k.txt");
		// Path path_30k = Paths.get("int30k.txt");
		// Path path_40k = Paths.get("int40k.txt");
		Path path_1000 = Paths.get("int1000.txt");
		
		// Pick array size for 'massiveInput' and align with 'integerArray'
		int[] massiveInput = createArray(20000);
		// Only four options really, anything us will crash.
		// Any of the path options, pass them as parameters.
		// Then run the remaining.
		int[] integerArray = TestAlgorithms.readFile(path_20k);
		// int[] integerArray = createRandomArray(30000);
		// int[] integerArray = createRandomArray(40000);
			
		
		// Can improve the accuracy by running the tests more times (second parameter in timeArray)
		System.out.println("Size: " + massiveInput.length);
		averageTimeStandard = TimeSortingAlgorithms.timeArray(integerArray, 10);
		averageTimeSlow = TimeSortingAlgorithms.timeArray(massiveInput, 10);
		System.out.println("Standard array: " + averageTimeStandard + " ns");
		System.out.println("Slow array: " + averageTimeSlow + " ns");
	}
}
