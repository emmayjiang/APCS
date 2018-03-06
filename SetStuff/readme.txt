The objective of the SetStuff project was to eventually implement Dijkstra's Algorithm. The methods included in this class were intended to be helper methods that are needed in order to implement this algorithm.

For this assignment specifically, we were told to take the code that we wrote for SetStuff off Codingbat and into a class, and create code in the main that allowed for the testing of each method.

Currently, all methods work as intended, as they have been tested on CodingBat before their transfer to Eclipse. They have also been tested with various testing cases, and they have all produced the right results.
There are 11 methods included in this class:
1. ret17: a method that returns 17
2. zeroethElement: a method that returns the element at the index 0 of a given array
3. contains: a boolean that checks if an array contains an integer
4. anyContains: checks if any elements are shared between two arrays
5. union: finds and returns the union of two arrays
6. intersect: finds and returns the intersection of two arrays
7. nearesUnvisitedNode: given an array of boolean, integers, and Strings, determine the String of an index that has a false boolean and the smallest integer
8. listify: turns three integers into a list
9. addEdge: take three integers, make them into an ArrayList, and add them into the current ArrayList
10. collectNodes: returns an arraylist that contains the union of all the integers that appear in the first two elements of each arraylist of size three
11. setInfinity: sets all elements of an ArrayList of size n to infinity, except the one at a given index
I changed a few things from Codingbat to Eclipse. I made contains a helper method for anyContains, and did the same for listify for addEdge.

There were no major challenges in the making of the code, aside from a few difficulties encountered when creating and running the testing code in an efficient manner.

I would like to acknowlege Mr. Kuszmaul for helping me when I got confused about ArrayList<Object> and ArrayList<Integer>.