
import java.util.ArrayList;

public class Node {
	
	private int id;
	private int x;
	private int y;
	private ArrayList<Node> neighbors;
	private ArrayList<Integer> dist;
	
	/**
	 * Constructor used in Part 1
	 */
	public Node(int identifier, int x, int y) {
		id = identifier;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor used in Part 2
	 */
	public Node(int identifier) {
		id = identifier;
		neighbors = new ArrayList<Node>();
		dist = new ArrayList<Integer>();
	}
	
	public int getId() {
		return id - 1;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int n) {
		x = n;
	}
	
	public void setY(int n) {
		y = n;
	}
	
	public ArrayList<Node> getNeighbors() {
		return neighbors;
	}
	
	public ArrayList<Integer> getDist() {
		return dist;
	}
	
	public void newNeighbor(Node n, int dist) {
		neighbors.add(n);
		this.dist.add(dist);
	}
}
