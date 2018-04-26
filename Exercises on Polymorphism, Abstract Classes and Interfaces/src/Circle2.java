
public class Circle2 implements GeometricObject {
	// Private variable
	private double radius = 1;

	// Constructor
	public Circle2(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}

	// Implement methods defined in the interface GeometricObject
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
}