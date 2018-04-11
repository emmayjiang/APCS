
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * Draws a graph
 * 
 * @author Emma Jiang
 */
public class Part1 extends JFrame {
	
	private ArrayList<Node> nodes;

	/**
	 * Initializes the JFrame
	 * 
	 * @param n		ArrayList of nodes
	 */
	public Part1(ArrayList<Node> n) {
		nodes = n;
		setSize(1000, 1000);
		setBackground(Color.WHITE);
		repaint();
	}
	
	/**
	 * Paints the nodes and edges between nodes.
	 */
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < nodes.size(); i++) {
			addPoint(g, nodes.get(i));
			if (i > 0) {
				addEdge(g, nodes.get(i-1), nodes.get(i));
			}
		}
	}
	
	/**
	 * Adds a node to the graph
	 * 
	 * @param g		Graphics
	 * @param n		Node to be added
	 */
	public void addPoint(Graphics g, Node n) {
		int x = n.getX() * 10 + 50;
		int y = n.getY() * 10 + 50;
		g.fillOval(x - 5, y - 5, 10, 10);
	}
	
	/**
	 * Adds an edge to the graph
	 * 
	 * @param g		Graphics
	 * @param n1	Starting node for edge
	 * @param n2	Ending node for edge
	 */
	public void addEdge(Graphics g, Node n1, Node n2) {
		int x1 = n1.getX() * 10 + 50;
		int x2 = n2.getX() * 10 + 50;
		int y1 = n1.getY() * 10 + 50;
		int y2 = n2.getY() * 10 + 50;
		g.drawLine(x1, y1, x2, y2);
	}

	public static void main(String[] args) {
		ArrayList<Node> arr = new ArrayList<Node>();
		
		// TEST 1:
		// arr.add(new Node(1, 50, 10));
		// arr.add(new Node(2, 5, 70));
		// arr.add(new Node(3, 38, 20));
		// arr.add(new Node(4, 9, 50));
		// arr.add(new Node(5, 2, 9));

		// TEST 2:
		// arr.add(new Node(1, 23, 24));
		// arr.add(new Node(2, 34, 23));
		// arr.add(new Node(3, 45, 76));
		// arr.add(new Node(4, 56, 4));
		// arr.add(new Node(5, 1, 9));

		// TEST 3:
		// arr.add(new Node(1, 16, 23));
		// arr.add(new Node(2, 27, 87));
		// arr.add(new Node(3, 38, 65));
		// arr.add(new Node(4, 49, 43));
		// arr.add(new Node(5, 61, 32));
		
		Part1 p = new Part1(arr);
		p.setDefaultCloseOperation(p.EXIT_ON_CLOSE);
		p.setVisible(true);
	}

}
