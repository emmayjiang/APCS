
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This project is a program that will prompt for a text document to be
 * uploaded, and then, using the exception handlers, the text inside the
 * document will be turned into one String, which will then be printed. In order
 * to prevent file name errors, I will use Scanner for the user to type in the
 * name of their file.
 * 
 * The job of this project was to prove the understanding of the vocabulary
 * words presented to us. First, and most obviously, my code makes use of try,
 * catch, finally, in order to catch any errors that may occur when running the
 * code. It catches one error: one, a compile time error, which causes the error
 * "File not Found." It also catches IO exceptions. Another kind of error is a
 * run time error, which is not handled by the code. The try / catch / finally
 * block is used as exception handling and therefore error correction code.
 * 
 * Currently, with the code, there may be several errors that may happen. For
 * example, there is nothing limiting the size of the string - what if something
 * is inputed is too large? There is nothing that handles that in the code.
 * Also, after every line break, I have code that adds a space to separate the
 * two lines. But this doesn't take into account if there was already a space
 * after each line, which would lead to double spaces.
 * 
 * The method fileName() uses scanner in order to allow the person running the
 * code to input the name of the file they wish to convert to a string. The
 * method run(), which is called in Main, uses the result of fileName() as its
 * parameters, since it uses a try, catch, finally block to catch file not found
 * exceptions and IO exceptions. A buffered file reader is used to check each
 * line for text and add them to the string.
 * 
 * There were no huge challenges I had to face in the making of this code. Most
 * of the code was completed already from our exercises, but I made many
 * modifications to it for this exercise, including adding Scanner for inputting
 * file name, and allowing for the text file to be converted into a String.
 * 
 * I would like to thank my Harker summer camp Advanced Programming instructor
 * for teaching me about using Scanner, so I could quickly and easily implement
 * it for this project.
 */
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
