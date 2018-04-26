
public class Circle extends Shape {
	private double radius;

	public Circle() {
		
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	
	public String toString() {
		return "Circle with Radius: " + getRadius() + "; Area: " + getArea() + "; Perimeter: " + getPerimeter() + super.toString();
	}
}
