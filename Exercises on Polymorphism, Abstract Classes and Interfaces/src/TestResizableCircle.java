
public class TestResizableCircle {
	public static void main(String[] args) {
		ResizableCircle c1 = new ResizableCircle(5);
		System.out.println("Area: " + c1.getArea());
		System.out.println("Perimeter: " + c1.getPerimeter());
		c1.resize(50);
		System.out.println("Area: " + c1.getArea());
		System.out.println("Perimeter: " + c1.getPerimeter());
	}
}
