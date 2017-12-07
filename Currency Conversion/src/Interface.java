
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Interface extends JFrame {
	
	public Interface(Display display) {
		
	}

	public static void main(String[] args) {

		Display display = new Display();
		Dimension size = new Dimension(650, 750);
		display.setBackground(Color.BLACK);
		display.setMinimumSize(size);
		display.setDefaultCloseOperation(Display.EXIT_ON_CLOSE);

		Interface hi = new Interface(display);

		Display screen = new Display(0, hi);
		screen.setBackground(Color.BLACK);
		screen.setFocusable(true);
		screen.requestFocusInWindow();
		hi.onscreen = screen;
		display.add(screen);
		display.pack();
		screen.setVisible(true);
		hi.paintScreen(0);

		display.setVisible(true);

	}
}