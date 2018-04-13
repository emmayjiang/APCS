
public class Point3D extends Point2D {

	private float z;

	public Point3D(float x, float y, float z) {
		super(x, y);
		this.setZ(z);
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public void setXYZ(float x, float y, float z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public float[] getXYZ() {
		float[] arr = new float[3];
		arr[0] = getX();
		arr[1] = getY();
		arr[2] = getZ();
		return arr;
	}
	
	public String toString() {
		return "(" + Float.toString(getX()) + "," + Float.toString(getY()) + "," + Float.toString(getZ()) + ")";
	}
}
