
public class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle() {
		
	}

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}
	
	public Rectangle(double width, double length, String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.length = length;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getArea() {
		return length * width;
	}
	
	public double getPerimeter() {
		return length * 2 + width * 2;
	}
	
	public String toString() {
		return "Rectangle with Length: " + length + "; Width: " + width + "; Area: " + getArea() + "; Perimeter: " + getPerimeter() + super.toString();
	}
}
