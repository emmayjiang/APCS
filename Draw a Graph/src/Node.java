
public class Node {
	
	private int id;
	private int x;
	private int y;
	
	public Node(int identifier, int x, int y) {
		id = identifier;
		this.x = x;
		this.y = y;
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
}
