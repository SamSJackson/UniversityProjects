
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	
	// Need to read in file.
	// For each line, look for occurences of given word.
	// Just remove all punctuation in string.
	// Loop over line
	
	private static int readFile(File file, String word) {
		int count = 0;
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				String regexData = data.replaceAll("\\p{Punct}", "");
				String[] splitData = regexData.split(" ");
				for (String foundWord : splitData) { 
					if (foundWord.equalsIgnoreCase(word)) count++;
				}
			}			
			return count;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static void main(String[] args) {
		Rectangle rec = new Rectangle();
		Rectangle squ = new Square();
		rec.setHeight(5);
		rec.setWidth(5);
		squ.setWidth(6);
		System.out.println(rec);
		System.out.println(squ);
	}
	
}
