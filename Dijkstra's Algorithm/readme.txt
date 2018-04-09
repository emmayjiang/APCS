a. Introduction
This program implements Dijkstra's Algorithm for a graph represented by an ArrayList of ArrayLists of ArrayLists of integers, given a starting node. The intent of this algorithm is to find the shortest distance that needs to be traveled in order to get through all nodes in a graph.

b. How this fulfills / does not fulfill the specifications
The specifications of this project was to implement Dijkstra's Algorithm in code as well as answer five other questions.
The answers to the questions are:
1. 43
2. Found in the Node class
3. {{{2, 7}, {3, 9}, {6, 14}}, {{1, 7}, {3, 10}, {4, 15}}, {{1, 9}, {2, 10}, {4, 11}, {6, 2}}, {{2, 15}, {3, 11}, {5, 6}}, {{4, 6}, {6, 9}}, {{1, 14}, {3, 2}, {5, 9}}}
The coded answer can be found in the main method in my Dijkstra class.
4. getPreviousList() should return 1, 3, 6.
5. closestNeighbor(): Finds the node that is the closest to the current selected node.
reachLastNode(): Signals when the last node is reached (all nodes are visited)
getUnvisited(): Returns the amount of nodes that have yet to be visited
findShortestDistance(): Finds the shortest distance through all nodes in the graph

c. Explaination of current errors
As it stands, my code currently contains a few errors that causes issues when the code is run. One of the main issues that confused me when I coded the program was that the numbering of nodes on the graph starts from 1, while ArrayLists begin at 0. In order to fix this problem, I tried to add and subtract 1 whenever fitting, but I was unable to come up with a solution that allowed the program to run properly. However, there shouldn't be a problem with anything else in the code.

d. Overview of code
There were three ArrayLists initialized in the constructor; visited, which is a boolean ArrayList that stores the truth value of whether or not a node was visited, distances, which stores the distances of the nodes, and visitedNodes, which stores the nodes that have been visited.
The method findShortestDistance() called getPreviousList() with the parameters of reachLastNode(), which returns the shortest distance from the starting node through all nodes in the graph. While the method getUnvisited() is greater than 0, that is, there are still unvisited nodes, the method reachLastNode() will call closestNeighbor() to find the closest node and mark it as visited, and the process continues until the last node is reached.

e. Major challenges
As stated above, my code had several errors that couldn't resolved itself because of the whole issue with nodes starting at 1 while ArrayLists started at 0, which made the implementation of the method much more difficult. Creating a test case was also extremely tedious because of the need to initialize an ArrayList of ArrayLists of ArrayLists of integers.

f. Acknowledgements
Wikipedia (https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)
Mr. Kuszmaul's slideshow on Schoology and the presentation, as well as the Codingbat problems provided