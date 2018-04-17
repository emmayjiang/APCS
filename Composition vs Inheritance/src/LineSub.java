/**
 * In this case, composition would be better, because  line is not an extension of a point-- a line contains two points.
 */
public class LineSub extends Point {
	// A line needs two points: and end.
	// The point is inherited from its superclass Point.
	// Private variables
	Point end; // Ending point

	// Constructors
	public LineSub(int beginX, int beginY, int endX, int endY) {
		super(beginX, beginY); // construct the Point
		this.end = new Point(endX, endY); // construct the end Point
	}

	public LineSub(Point begin, Point end) { // caller to construct the Points
		super(begin.getX(), begin.getY()); // need to reconstruct the Point
		this.end = end;
	}

	// Public methods
	// Inherits methods getX() and getY() from superclass Point
	public String toString() {
		return "Begin " + toString() + "; End " + end.toString() + "\nLength: " + getLength() + "; Gradient: "
				+ getGradient();
	}

	public Point getBegin() {
		Point begin = new Point(getX(), getY());
		return begin;
	}

	public Point getEnd() {
		return end;
	}

	public void setBegin(int x, int y) {
		setXY(x, y);
	}

	public void setEnd(int x, int y) {
		end.setXY(x, y);
	}

	public int getBeginX() {
		return getX();
	}

	public int getBeginY() {
		return getY();
	}

	public int getEndX() {
		return end.getX();
	}

	public int getEndY() {
		return end.getY();
	}

	public void setBeginX(int x) {
		setX(x);
	}

	public void setBeginY(int y) {
		setY(y);
	}

	public void setY(int x, int y) {
		setXY(x, y);
	}

	public void setEndX(int x) {
		end.setX(x);
	}

	public void setEndY(int y) {
		end.setY(y);
	}

	public void setEndXY(int x, int y) {
		end.setXY(x, y);
	}

	public int getLength() {
		// Length of the line: Math.sqrt(xDiff*xDiff + yDiff*yDiff)
		int xDiff = end.getX() - getX();
		int yDiff = end.getY() - getY();
		return (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}

	public double getGradient() {
		// Gradient in radians: Math.atan2(yDiff, xDiff)
		int xDiff = end.getX() - getX();
		int yDiff = end.getY() - getY();
		return Math.atan2(yDiff, xDiff);
	}
}