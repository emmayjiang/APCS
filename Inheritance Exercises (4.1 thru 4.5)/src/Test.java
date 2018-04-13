
public class Test {

	public static void main(String[] args) {

		System.out.println("Test Shape Class:");
		Shape a = new Shape();
		System.out.println(a);
		Shape b = new Shape(false, "purple");
		System.out.println(b);

		System.out.println();
		System.out.println("Test Circle Class:");
		Circle2 c = new Circle2();
		System.out.println(c);
		Circle2 d = new Circle2(6.66);
		System.out.println(d);
		Circle2 e = new Circle2(3.2, "yellow", true);
		System.out.println(e);

		System.out.println();
		System.out.println("Test Rectangle Class:");
		Rectangle f = new Rectangle();
		System.out.println(f);
		Rectangle g = new Rectangle(5.4, 2.3);
		System.out.println(g);
		Rectangle h = new Rectangle(true, "orange", 24.3, 3982.3);
		System.out.println(h);

		System.out.println();
		System.out.println("Test Square Class:");
		Square i = new Square();
		System.out.println(i);
		Square j = new Square(5.4);
		System.out.println(j);
		Square k = new Square(false, "orange", 982.3);
		System.out.println(k);

	}

}