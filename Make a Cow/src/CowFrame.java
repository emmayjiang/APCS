
import java.awt.*;
import javax.swing.JFrame;

/**
 * Outputs a graphic of a cow.
 * 
 * @author Emma Jiang
 * @version 8/15/17
 *
 */
public class CowFrame extends JFrame {
	private final Color BISQUE = new Color(0xcdb79e);

	public CowFrame() {
		init();
	}

	/**
	 * Creates a canvas for the cow.
	 */
	public void init() {
		setSize(700, 600);
		setBackground(Color.WHITE);
		repaint();
	}

	/**
	 * Constructs the cow
	 */
	public void paint(Graphics g) {
		g.setColor(BISQUE);
		// body of the cow
		g.fillRoundRect(50, 100, 400, 200, 50, 50);
		// head of the cow
		g.setColor(BISQUE);
		g.drawOval(350, 50, 150, 100);
		g.fillOval(350, 50, 150, 100);
		// legs
		g.setColor(BISQUE);
		g.fillRect(75, 300, 50, 150);
		g.fillRect(130, 300, 50, 150);
		g.fillRect(375, 300, 50, 150);
		g.fillRect(320, 300, 50, 150);
		// spots
		g.setColor(Color.BLACK);
		g.fillOval(100, 225, 50, 50);
		g.fillOval(150, 175, 50, 50);
		g.fillOval(200, 125, 50, 50);
		g.fillOval(125, 125, 50, 50);
		g.fillOval(75, 175, 50, 50);
		// eyes
		g.setColor(Color.BLACK);
		g.fillOval(425, 100, 10, 10);
		g.fillOval(475, 100, 10, 10);
		// nose
		g.setColor(Color.PINK);
		g.fillOval(445, 110, 40, 30);
	}
	
	public static void main(String[] args) {
		CowFrame c = new CowFrame();
		c.setDefaultCloseOperation(c.EXIT_ON_CLOSE);
		c.setVisible(true);
	}
}