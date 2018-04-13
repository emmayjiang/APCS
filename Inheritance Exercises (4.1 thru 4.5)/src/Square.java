
public class Square extends Rectangle {

	public Square() {
		super();
	}

	public Square(double side) {
		super(side, side); // Call superclass Rectangle(double, double)
	}

	public Square(boolean f, String s, double side) {
		super(f, s, side, side); // Call superclass Rectangle(double, double)
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double r) {
		width = r;
		length = r;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double r) {
		length = r;
		width = r;
	}

	public String toString() {
		String tba = "A square with side=" + width + " which is a subclass of ";
		tba += super.toString();
		return tba;
	}
}