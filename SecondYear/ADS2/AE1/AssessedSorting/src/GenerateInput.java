import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import ads2.ae1.sam.Algorithms;
import ads2.ae1.sam.TestAlgorithms;
import ads2.ae1.sam.TimeSortingAlgorithms;

public class GenerateInput {
	
	
	static Scanner readInput = new Scanner(System.in);
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
			System.out.println(arrayToWrite.length);
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
		
		
		Path path_20k = Paths.get("int20k.txt");
		Path path_1000 = Paths.get("int1000.txt");
		Path path_500k = Paths.get("int500k.txt");
		Path path_100k = Paths.get("int100k.txt");
		Path path_50k = Paths.get("int50k.txt");
		int[] massiveInput = createArray(20000);
		int[] integerArray = TestAlgorithms.readFile(path_20k);
		
		
		System.out.println("Size: " + massiveInput.length);
		averageTimeStandard = TimeSortingAlgorithms.timeArray(integerArray, 100);
		averageTimeSlow = TimeSortingAlgorithms.timeArray(massiveInput, 100);
		System.out.println("DONE STANDARD");
		System.out.println("Standard array: " + averageTimeStandard + "ns");
		System.out.println("Slow array: " + averageTimeSlow + "ns");
		
		
		

	}
}
