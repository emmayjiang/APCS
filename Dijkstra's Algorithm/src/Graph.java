
import java.util.ArrayList;

public class Graph {
	
	private ArrayList<ArrayList<ArrayList<Integer>>> arr;
	private ArrayList<Node> path;
	
	public Graph(ArrayList<ArrayList<ArrayList<Integer>>> arr) {
		this.arr = arr;
	}

	public ArrayList<ArrayList<ArrayList<Integer>>> getGraph() {
		return arr;
	}
	
	public void addToPath(Node node) {
		path.add(node);
	}
}
