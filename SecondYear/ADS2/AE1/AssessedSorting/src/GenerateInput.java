import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
	
	
	public static void generateOutput(int numberOfElements, String filename) throws IOException {
		while (!makeFile(filename)) {
			System.out.println("Please make sure to pick an available name.");
			filename = readInput.nextLine() + ".txt";
		}
		try {
			FileWriter writeToFile = new FileWriter(filename);
			writeToFile.write("This is a test.");
			writeToFile.close();
			System.out.println("WRITTEN");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		generateOutput(3, "textfile.txt");
	}
}
