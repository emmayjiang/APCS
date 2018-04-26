
public class ResizableCircle extends Circle2 implements Resizable {
 
   // Constructor
   public ResizableCircle(double radius) {
      super(radius);
   }
 
   // Implement methods defined in the interface Resizable
   @Override
   public double resize(int percent) {
	   setRadius(getRadius() * percent / 100);
	   return getRadius() * percent;
   }
}