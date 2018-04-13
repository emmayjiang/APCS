public class Shape {

	boolean filled;
	String color;

	public Shape() {
		filled = true;
		color = "green";
	}

	public Shape(boolean f, String c) {
		filled = f;
		color = c;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean f) {
		filled = f;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String c) {
		color = c;
	}

	public String toString() {
		String str = "A shape with color of " + color + " and ";
		if (!filled) {
			str += "not ";
		}
		str += "filled.";
		return str;
	}
}