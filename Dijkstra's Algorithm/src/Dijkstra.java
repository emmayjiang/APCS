
import java.util.ArrayList;

/**
 * Implements Dijkstra's Algorithm, as defined by Wikipedia (https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm):
 * 1. Mark all nodes unvisited. Create a set of all the unvisited nodes called the unvisited set.
 * 2. Assign to every node a tentative distance value: set it to zero for our initial node and to infinity for all other nodes. Set the initial node as current.
 * 3. For the current node, consider all of its unvisited neighbors and calculate their tentative distances through the current node. Compare the newly calculated tentative distance to the current assigned value and assign the smaller one. For example, if the current node A is marked with a distance of 6, and the edge connecting it with a neighbor B has length 2, then the distance to B through A will be 6 + 2 = 8. If B was previously marked with a distance greater than 8 then change it to 8. Otherwise, keep the current value.
 * 4. When we are done considering all of the neighbors of the current node, mark the current node as visited and remove it from the unvisited set. A visited node will never be checked again.
 * 5. Move to the next unvisited node with the smallest tentative distances and repeat the above steps which check neighbors and mark visited.
 * 6. If the destination node has been marked visited (when planning a route between two specific nodes) or if the smallest tentative distance among the nodes in the unvisited set is infinity (when planning a complete traversal; occurs when there is no connection between the initial node and remaining unvisited nodes), then stop. The algorithm has finished.
 * 7. Otherwise, select the unvisited node that is marked with the smallest tentative distance, set it as the new "current node", and go back to step 3.
 * 
 * @author Emma Jiang
 */
public class Dijkstra {

	public ArrayList<Boolean> visited;
	public ArrayList<Integer> distances;
	public ArrayList<Integer> visitedNodes;

	private Graph graph;
	private Node start;

	/**
	 * Constructor for Dijkstra's Algorithm
	 * 
	 * @param inputGraph	the given graph
	 * @param inputNode		the starting node
	 */
	public Dijkstra(Graph inputGraph, Node inputNode) {
		graph = inputGraph;
		start = inputNode;

		int points = graph.getGraph().size();
		visited = new ArrayList<Boolean>();
		visitedNodes = new ArrayList<Integer>();
		distances = new ArrayList<Integer>();

		for (int i = 0; i < points; i++) {
			if (i == start.getId()) {
				distances.add(0);
			} else {
				distances.add(Integer.MAX_VALUE);
			}
		}

		for (int i = 0; i < points; i++) {
			if (i == start.getId()) {
				visited.add(true);
			} else {
				visited.add(false);
			}
		}

		for (int i = 0; i < points; i++) {
			if (i == start.getId()) {
				visitedNodes.add(-1);
			} else {
				visitedNodes.add(0);
			}
		}
	}

	/**
	 * Finds the node that is the closest to the current selected node.
	 * 
	 * @param node
	 * @return the id of the closest node
	 */
	public int closestNeighbor(int node) {
		ArrayList<ArrayList<Integer>> neighbors = graph.getGraph().get(node);
		int min = Integer.MAX_VALUE;
		int index = -1;

		for (int i = 0; i < neighbors.size(); i++) {
			int n = neighbors.get(i).get(0) - 1;
			//searches only unvisited nodes
			if (visited.get(n) == false) {
				//sets distance to distance found
				distances.set(n, Math.min(distances.get(n), (neighbors.get(i).get(1) - 1 + distances.get(node))));
				//checks if distance is less than overall shortest distance
				if (distances.get(n) < min) {
					min = neighbors.get(i).get(1) - 1;
					index = i;
				}
			}
		}

		//adds node to to visitedNodes
		visitedNodes.set(neighbors.get(index).get(0) - 1, node);
		return neighbors.get(index).get(0) - 1;
	}

	/**
	 * Signals when the last node is reached (all nodes are visited)
	 * 
	 * @return id of last node reached
	 */
	public int reachLastNode() {
		int i = start.getId();
		int next = 0;
		//finds shortest path through all nodes
		while (getUnvisited() > 0) {
			visited.set(i, true);
			next = closestNeighbor(i);
			i = next;
		}
		return next;
	}

	/**
	 * Returns the amount of nodes that have yet to be visited
	 * 
	 * @return number of unvisited nodes
	 */
	public int getUnvisited() {
		int counter = 0;
		for (int i = 0; i < visited.size(); i++) {
			//counts unvisited nodes
			if (visited.get(i) == false) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Trace the route taken from a given node to the given starting node of the algorithm
	 * 
	 * @param last	id of node
	 * @return		the list of nodes traveled
	 */
	public ArrayList<Integer> getPreviousList(int last) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(start.getId());
		//trace the route
		while (last != start.getId()) {
			//adds the node if it was visited
			for (int i = 0; i < visitedNodes.size(); i++) {
				if (visitedNodes.get(i) == last) {
					last = i;
					list.add(1, i);
				}
			}
		}
		return list;
	}

	/**
	 * Finds the shortest distance through all nodes in the graph
	 * 
	 * @return	the distance
	 */
	public int findShortestDistance() {
		ArrayList<Integer> path = getPreviousList(reachLastNode());
		int length = 0;
		for (int i = 0; i < path.size() - 1; i++) {
			int k = 0;
			for (int j = 0; j < graph.getGraph().get(path.get(i)).size(); j++) {
				//find the distance between the nodes
				if (graph.getGraph().get(path.get(i)).get(j).get(0) == path.get(i + 1)) {
					k = j;
				}
			}
			length += graph.getGraph().get(path.get(i)).get(k).get(1);
		}
		return length;
	}
	
	public static void main(String[] args) {
		//creates test case using the test case listed on Wikipedia (https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)
		ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<ArrayList<ArrayList<Integer>>>();
		// {{2, 7}, {3, 9}, {6, 14}}
		ArrayList<Integer> n02 = new ArrayList<Integer>();
		n02.add(2);
		n02.add(7);
		ArrayList<Integer> n03 = new ArrayList<Integer>();
		n03.add(2);
		n03.add(9);
		ArrayList<Integer> n06 = new ArrayList<Integer>();
		n06.add(6);
		n06.add(14);
		ArrayList<ArrayList<Integer>> n0 = new ArrayList<ArrayList<Integer>>();
		n0.add(n02);
		n0.add(n03);
		n0.add(n06);
		graph.add(n0);
		// {{1, 7}, {3, 10}, {4, 15}}
		ArrayList<Integer> n11 = new ArrayList<Integer>();
		n11.add(1);
		n11.add(7);
		ArrayList<Integer> n13 = new ArrayList<Integer>();
		n13.add(3);
		n13.add(10);
		ArrayList<Integer> n14 = new ArrayList<Integer>();
		n14.add(4);
		n14.add(15);
		ArrayList<ArrayList<Integer>> n1 = new ArrayList<ArrayList<Integer>>();
		n1.add(n11);
		n1.add(n13);
		n1.add(n14);
		graph.add(n1);
		// {{1, 9}, {2, 10}, {4, 11}, {6, 2}}
		ArrayList<Integer> n21 = new ArrayList<Integer>();
		n21.add(1);
		n21.add(9);
		ArrayList<Integer> n22 = new ArrayList<Integer>();
		n22.add(2);
		n22.add(10);
		ArrayList<Integer> n24 = new ArrayList<Integer>();
		n24.add(4);
		n24.add(11);
		ArrayList<Integer> n26 = new ArrayList<Integer>();
		n26.add(6);
		n26.add(2);
		ArrayList<ArrayList<Integer>> n2 = new ArrayList<ArrayList<Integer>>();
		n2.add(n21);
		n2.add(n22);
		n2.add(n24);
		n2.add(n26);
		graph.add(n2);
		// {{2, 15}, {3, 11}, {5, 6}}
		ArrayList<Integer> n32 = new ArrayList<Integer>();
		n32.add(2);
		n32.add(15);
		ArrayList<Integer> n33 = new ArrayList<Integer>();
		n33.add(3);
		n33.add(11);
		ArrayList<Integer> n35 = new ArrayList<Integer>();
		n35.add(5);
		n35.add(6);
		ArrayList<ArrayList<Integer>> n3 = new ArrayList<ArrayList<Integer>>();
		n3.add(n32);
		n3.add(n33);
		n3.add(n35);
		graph.add(n3);
		// {{4, 6}, {6, 9}}
		ArrayList<Integer> n44 = new ArrayList<Integer>();
		n44.add(4);
		n44.add(6);
		ArrayList<Integer> n46 = new ArrayList<Integer>();
		n46.add(6);
		n46.add(9);
		ArrayList<ArrayList<Integer>> n4 = new ArrayList<ArrayList<Integer>>();
		n3.add(n44);
		n3.add(n46);
		graph.add(n4);
		// {{1, 14}, {3, 2}, {5, 9}}
		ArrayList<Integer> n51 = new ArrayList<Integer>();
		n51.add(1);
		n51.add(14);
		ArrayList<Integer> n53 = new ArrayList<Integer>();
		n53.add(3);
		n53.add(2);
		ArrayList<Integer> n55 = new ArrayList<Integer>();
		n55.add(5);
		n55.add(9);
		ArrayList<ArrayList<Integer>> n5 = new ArrayList<ArrayList<Integer>>();
		n5.add(n51);
		n5.add(n53);
		n5.add(n55);
		graph.add(n5);
		Graph g = new Graph(graph);
		Node node = new Node(1);
		Dijkstra d = new Dijkstra(g, node);
		System.out.print("Shortest distance: " + d.findShortestDistance());
	}
}
