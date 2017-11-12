Introduction
This code is for the exercises for Exception handling.

How this fulfills / does not fulfill the specification
It does exactly what the code is supposed to do, and has the exact same printout as the solutions.

Explanation of current errors (or anything that falls short of project specifications) and how you might fix them
None

Overview of the code explaining, in broad strokes, the structure of it
The only two changes I made for Exercise 1 (ListOfNumbers.java) is that I changed the constructor to support a vector instead of a List,
because of that specific project specification, and I also added a readList() method which used StringBuffer to read the file and convert each line into an integer, and then
prints it as well as appends it to the vector.
For Exercise 2, all I did was add Exception handlers so that the code would compile.

Discussion of major challenges encountered in the process of making the code
I didn't know how to scan a text document, so I searched it up online, found StringBuffer, took some time to research how to use it, and implemented it.

Acknowledgements (who helped you, what resources you used etc.)
Code taken from: https://docs.oracle.com/javase/tutorial/essential/exceptions/QandE/questions.html
