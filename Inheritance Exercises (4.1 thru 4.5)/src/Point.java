
public class Point {

	private float x;
	private float y;

	public Point(float x, float y) {
		this.setX(x);
		this.setY(y);
	}

	public Point() {
		setX(0);
		setY(0);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setXY(float x, float y) {
		this.setX(x);
		this.setY(y);
	}

	public float[] getXY() {
		float[] arr = new float[2];
		arr[0] = x;
		arr[1] = y;
		return arr;
	}

	@Override
	public String toString() {
		return "(" + Float.toString(x) + "," + Float.toString(y) + ")";
	}
}
