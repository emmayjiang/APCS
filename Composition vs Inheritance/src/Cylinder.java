
/**
 * In this case, inheritance would be better, because a cylinder is just a 3D circle.
 */
public class Cylinder { // Save as "Cylinder.java"
	private Circle base;
	private double height; // private variable

	// Constructor with default color, radius and height
	public Cylinder() {
		base = new Circle();
		height = 1.0;
	}

	// Constructor with default radius, color but given height
	public Cylinder(double height) {
		super(); // call superclass no-arg constructor Circle()
		this.height = height;
	}

	// Constructor with default color, but given radius, height
	public Cylinder(Circle base, double height) {
		this.base = base; // call superclass constructor Circle(r)
		this.height = height;
	}

	// A public method for retrieving the height
	public double getHeight() {
		return height;
	}

	// A public method for computing the volume of cylinder
	// use superclass method getArea() to get the base area
	public double getVolume() {
		return base.getArea() * height;
	}

	public double getArea() { // in Cylinder class
		return 2 * Math.PI * base.getRadius() * height + 2 * base.getArea();
	}

	public String toString() { // in Cylinder class
		return "Cylinder: " + "height=" + height + ", radius=" + base.getRadius();
	}
}