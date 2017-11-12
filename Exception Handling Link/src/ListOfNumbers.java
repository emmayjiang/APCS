/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

import java.io.*;
import java.util.Vector;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ListOfNumbers {
    private Vector<Integer> vector;
    private static final int SIZE = 10;

    /**
     * Rewritten to include support for vectors instead of a list
     */
    public ListOfNumbers () {
    	vector = new Vector<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            vector.addElement(new Integer(i));

        this.readList("textfile.txt");
        this.writeList();
    }
    
    /**
     * Reads the list of numbers given in the text file, converts them to integers,
     * and prints them while appending them to a vector.
     * 
     * @param textFile		the text file with the list of numbers
     */
    public void readList(String textFile) {
        String line = "";
        
        try {
        	File file = new File(textFile);
			FileReader fileReader = new FileReader(textFile);					//makes a file reader
			BufferedReader bufferedReader = new BufferedReader(fileReader);	
			while ((line = bufferedReader.readLine()) != null) {				//checks so that it doesn't read an empty line
				Integer i = new Integer(Integer.parseInt(line));				//converts string to integer
				vector.addElement(i);											//appends to vector
				System.out.println(i);
			}
			fileReader.close();
        } catch(FileNotFoundException fnf) {
            System.err.println("File: " + textFile + " not found.");
        } catch (IOException io) {
            System.err.println(io.toString());
        }
    }
    
    /**
     * Original method given in ListOfNumbers.java
     */
    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));
        
            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + vector.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void main(String[] args) {
    	new ListOfNumbers();
    }
    
}