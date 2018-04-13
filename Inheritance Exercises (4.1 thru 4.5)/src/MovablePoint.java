
public class MovablePoint extends Point {
	
	private float xSpeed;
	private float ySpeed;
	
	public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
		super(x,y);
		this.setxSpeed(xSpeed);
		this.setySpeed(ySpeed);
	}
	
	public MovablePoint(float xSpeed, float ySpeed) {
		super();
		this.setxSpeed(xSpeed);
		this.setySpeed(ySpeed);
	}

	public MovablePoint() {
		super();
		this.setxSpeed(0);
		this.setySpeed(0);
	}

	public float getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}

	public float getySpeed() {
		return ySpeed;
	}

	public void setySpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public float[] getSpeed() {
		float[] arr = new float[2];
		arr[0] = xSpeed;
		arr[1] = ySpeed;
		return arr;
	}
	
	@Override
	public String toString() {
		return super.toString() + ",speed=(" + Float.toString(xSpeed) + "," + Float.toString(ySpeed) + ")";
	}
	
	public MovablePoint move() {
		MovablePoint m = new MovablePoint();
		setX(getX() + xSpeed);
		setY(getY() + ySpeed);
		return m;
	}

}
