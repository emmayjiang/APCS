import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Most of the code for this Exercise came from the website. The code now can handle exceptions.
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/QandE/questions.html
 */
public class Exercise2 {

	public Exercise2() {
		
	}
	
	/**
	 * This method can now compile, following the exercise's instructions.
	 */
	public static void cat(File file) {
	    RandomAccessFile input = null;
	    String line = null;

	    try {
	        input = new RandomAccessFile(file, "r");
	        while ((line = input.readLine()) != null) {
	            System.out.println(line);
	        }
	        return;
        } catch(FileNotFoundException fnf) {
            System.err.println("File: " + file + " not found.");
        } catch (IOException io) {
            System.err.println(io.toString());
	    } finally {
	        if (input != null) {
	        	try {
	        		input.close();
	        	} catch (IOException io) {
	        		System.err.println(io.toString());
	        	}
	        }
	    }
	}

}
