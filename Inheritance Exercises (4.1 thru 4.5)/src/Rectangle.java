
public class Rectangle extends Shape {

	double width;
	double length;

	public Rectangle() {
		super();
		width = 1.0;
		length = 1.0;
	}

	public Rectangle(double w, double l) {
		super();
		width = w;
		length = l;
	}

	public Rectangle(boolean f, String c, double w, double l) {
		super(f, c);
		width = w;
		length = l;
	}

	public double getArea() {
		return width * length;
	}

	public double getPerimeter() {
		return 2 * (width + length);
	}

	public String toString() {
		String str = "A rectangle with width=" + width + " and length=" + length + " which is a subclass of ";
		str += super.toString();
		return str;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double r) {
		width = r;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double r) {
		length = r;
	}

}