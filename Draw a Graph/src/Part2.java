
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * Draws a graph
 * 
 * @author Emma Jiang
 */
public class Part2 extends JFrame {
	
	private ArrayList<Node> nodes;
	private ArrayList<Integer> used;

	/**
	 * Initializes the JFrame
	 * 
	 * @param n		ArrayList of nodes
	 */
	public Part2(ArrayList<Node> n) {
		nodes = n;
		used = new ArrayList<Integer>();
		setSize(1000, 1000);
		setBackground(Color.WHITE);
		repaint();
	}
	
	/**
	 * Paints the nodes and edges between nodes.
	 */
	public void paint(Graphics g) {
		int n = 0;
		
		//puts node 0 at the origin
		nodes.get(0).setX(0);
		nodes.get(0).setY(0);
		
		for (int i = 1; i < nodes.size(); i++) {
			Node current = nodes.get(i);
			for (int j = 0; j < current.getNeighbors().size(); j++) {
				//use distance from node 0 to determine distance of neighboring nodes
				if (current.getNeighbors().get(j).equals(nodes.get(0))) {
					current.setX(randomize() * 10);
					current.setY(current.getDist().get(j));
					n = j;
				}
			}
			//place other nodes randomly
			if (n == 0) {
				current.setX(randomize() * 10);
				current.setY(randomize() * 10);
			}
			n = 0;
		}

		//draws edges
		for (int i = 0; i < nodes.size(); i++) {
			for (int j = 0; j < nodes.get(i).getDist().size(); j++) {
				addEdge(g, nodes.get(i).getDist().get(j), nodes.get(i), nodes.get(i).getNeighbors().get(j));
			}
		}
		
		//draws nodes
		for (int i = 0; i < nodes.size(); i++) {
			addPoint(g, nodes.get(i));
		}
	}
	
	/**
	 * Chooses a random integer between 1-15 that hasn't been chosen before.
	 */
	public int randomize() {
		int n = (int) (Math.random() * 15) + 1;
		for (int i = 0; i < used.size(); i++) {
			if (used.get(i) == n && used.size() < 15) {
				randomize();
			}
		}
		used.add(n);
		return n;
	}
	
	/**
	 * Adds a node to the graph
	 * 
	 * @param g		Graphics
	 * @param n		Node to be added
	 */
	public void addPoint(Graphics g, Node n) {
		g.setColor(Color.RED);
		int x = n.getX() * 5 + 100;
		int y = n.getY() * 5 + 100;
		g.fillOval(x - 5, y - 5, 20, 20);
	}
	
	/**
	 * Adds an edge to the graph
	 * 
	 * @param g		Graphics
	 * @param n1	Starting node for edge
	 * @param n2	Ending node for edge
	 */
	public void addEdge(Graphics g, int dist, Node n1, Node n2) {
		g.setColor(Color.BLACK);
		
		int x1 = n1.getX() * 5 + 100;
		int x2 = n2.getX() * 5 + 100;
		int y1 = n1.getY() * 5 + 100;
		int y2 = n2.getY() * 5 + 100;
		
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(20 - (dist/5)));
        g2.draw(new Line2D.Float(x1, y1, x2, y2));
	}

	public static void main(String[] args) {
		ArrayList<Node> arr = new ArrayList<Node>();
		
		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		
		n0.newNeighbor(n1, 53);
		n0.newNeighbor(n2, 92);
		n1.newNeighbor(n2, 43);
		n1.newNeighbor(n3, 59);
		n2.newNeighbor(n3, 87);
		
		arr.add(n0);
		arr.add(n1);
		arr.add(n2);
		arr.add(n3);
		
		Part2 p = new Part2(arr);
		p.setDefaultCloseOperation(p.EXIT_ON_CLOSE);
		p.setVisible(true);
	}
}