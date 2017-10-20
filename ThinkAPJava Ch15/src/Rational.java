
/**
 * Exercise 4 of ThinkAPJava Chapter 15
 */
public class Rational {

	private int numerator;
	private int denominator;

	/**
	 * Write a constructor that takes no arguments and that sets the numerator to 0 and denominator to 1.
	 */
	public Rational() {
		numerator = 0;
		denominator = 1;
	}

	/**
	 * Write a second constructor for your class that takes two arguments and that uses them to initalize the instance variables.
	 */
	public Rational(int num, int denom) {
		numerator = num;
		denominator = denom;
	}

	/**
	 * Write a method called negate that reverses the sign of a rational number. This method should be a modifier, so it should return void. Add lines to main to test the new method.
	 */
	public void negate() {
		numerator = 0 - numerator;
		denominator = 0 - denominator;
	}

	/**
	 * Write a method called invert that inverts the number by swapping the numerator and denominator. Add lines to main to test the new method.
	 */
	public void invert() {
		int num = numerator;
		int denom = denominator;
		denominator = num;
		numerator = denom;
	}

	/**
	 * Write a method called toDouble that converts the rational number to a double (floating-point number) and returns the result.
	 * This method is a pure function; it does not modify the object. As always, test the new method.
	 */
	public double toDouble() {
		return (double) (numerator / denominator);
	}

	/**
	 * Write a modifier named reduce that reduces a rational number to its lowest terms by finding the greatest common divisor (GCD) of the numerator and denominator and dividing through.
	 * This method should be a pure function; it should not modify the instance variables of the object on which it is invoked. To find the GCD, see Exercise 10).
	 */
	public void reduce() {
		int numerator = this.numerator;
		int denominator = this.denominator;
		int gcd = 1;

        for(int i = 1; i <= numerator && i <= denominator; ++i)
        {
            if(numerator % i==0 && denominator % i==0)
                gcd = i;
        }
		
        Rational rat = new Rational(numerator/gcd, denominator/gcd);
        
        rat.printRational();
	}
	
	/**
	 * Write a method called add that takes two Rational numbers as arguments and returns a new Rational object. The return object should contain the sum of the arguments.
	 * There are several ways to add fractions. You can use any one you want, but you should make sure that the result of the operation is reduced so that the numerator
	 * and denominator have no common divisor (other than 1).
	 * @param r1
	 * @param r2
	 * @return
	 */
	public Rational add(Rational r1, Rational r2) {
		int denominator = r1.denominator * r2.denominator;
		int numerator = (r1.numerator * r2.denominator) + (r2.numerator * r1.denominator);
		
		int gcd = 1;

        for(int i = 1; i <= numerator && i <= denominator; ++i)
        {
            if(numerator % i==0 && denominator % i==0)
                gcd = i;
        }
		
        Rational rat = new Rational(numerator/gcd, denominator/gcd);
        
        return rat;
	}

	/**
	 * Write a method called printRational that takes a Rational object as an argument and prints it in some reasonable format.
	 */
	public void printRational() {
		System.out.println(this.numerator + "/" + this.denominator);
	}

	/**
	 * Write a main method that creates a new object with type Rational, sets its instance variables to some values, and prints the object.
	 */
	public static void main(String[] args) {
		Rational r = new Rational();
		r.numerator = 10;
		r.denominator = 9;
		r.printRational();
		r.negate();
		r.printRational();
		r.invert();
		r.printRational();
		r.numerator = 27;
		r.denominator = 9;
		System.out.print(r.add(r, r).numerator + "/" + r.add(r, r).denominator);
	}
}
