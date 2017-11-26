
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Vocabulary11 {

	public Vocabulary11() {

	}

	/**
	 * Uses Scanner to allow the user to input the name of their text file
	 * 
	 * @return	the name of the text file
	 */
	public static String fileName() {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		System.out.println("Enter your file name: ");
		String name = reader.next();
		reader.close();
		
		if (name.substring(name.length()-4).equals(".txt")) {
			return name;
		}
		return name + ".txt";
	}

	/**
	 * Runs the program that compiles all the lines of the text file into a String.
	 * 
	 * @param textFile	Name of the text file
	 * @return			the String containing everything in the file
	 */
	public static String run(String textFile) {
        String line = "";
        String finalLine = "";
        
        try {
        	File file = new File(textFile);
			FileReader fileReader = new FileReader(textFile);					//makes a file reader
			BufferedReader bufferedReader = new BufferedReader(fileReader);	
			while ((line = bufferedReader.readLine()) != null) {				//checks so that it doesn't read an empty line
				finalLine = finalLine + line + " ";								//adds the line to the string, while adding a space after it to separate lines
			}
			fileReader.close();
        } catch(FileNotFoundException fnf) {
            System.err.println("File: " + textFile + " not found.");
        } catch (IOException io) {
            System.err.println(io.toString());
        }
        
        return finalLine;
    }
	
	public static void main(String[] args) {
		System.out.println(run(fileName()));
	}
}
