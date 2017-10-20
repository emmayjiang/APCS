
/**
 * Exercise 2 and 3 of ThinkAPJava Chapter 15
 */
public class Complex {
	
	private int real;
	private int imag;
	
	public Complex() {
		real = 0;
		imag = 0;
	}
	
	/**
	 * Exercise 2:	Transform the following class method into an object method.
	 * 	public static double abs(Complex c) {
	 * 		return Math.sqrt(c.real * c.real + c.imag * c.imag);
	 * 	}
	 */
	public double abs() {
	    return Math.sqrt(real * real + imag * imag);
	}
	
	/**
	 * Exercise 3:   Transform the following object method into a class method.
	 * 	public boolean equals(Complex b) {
	 * 		return(real == b.real && imag == b.imag);
	 * 	}
	 */
	public boolean equals(Complex c, Complex b) {
	    return(c.real == b.real && c.imag == b.imag);
	}
	
	public static void main(String[] args) {
		Complex complex = new Complex();
		complex.abs();
	}
}
