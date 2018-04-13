
public class Circle2 extends Shape {
	double radius;

	public Circle2() {
		super();
	}

	public Circle2(double r) {
		super();
		radius = r;
	}

	public Circle2(double r, String c, boolean f) {
		radius = r;
		color = c;
		filled = f;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double r) {
		radius = r;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return Math.PI * radius * 2;
	}

	public String toString() {
		String str = "A circle with radius=" + radius + " which is a subclass of ";
		str += super.toString();
		return str;
	}
}