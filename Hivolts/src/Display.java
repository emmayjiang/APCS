
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The display class stores information about the title frame, game over frame, and the win frame, along with the buttons that accompany them.
 */
public class Display extends JPanel {

	public int num;
	Hivolts hi;
	Display self;

	public Display(int num, Hivolts lo) {
		this.num = num;
		hi = lo;
		setBackground(Color.BLACK);
		self = this;
	}

	Image titleimg = new ImageIcon("resources/title.png").getImage();
	Image loseimg = new ImageIcon("resources/game over.png").getImage();
	Image winimg = new ImageIcon("resources/win.png").getImage();
	Image restartimg = new ImageIcon("resources/restart.png").getImage();
	Image startimg = new ImageIcon("resources/start.png").getImage();

	/**
	 * Repaints each screen depending on what the value of num is.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (num == 0) {
			paintTitle(g);

		} else if (num == 1) {
			paintWin(g);

		} else if (num == 2) {
			paintLost(g);

		} else if (num == 3) {
			this.setFocusable(true);
			paintGame(g);
			hi.counter++;
		}
	}

	/**
	 * Paints the game.
	 */
	public void paintGame(Graphics g) {
		if (hi.counter == 0) {			//begins the game by painting the fence, mho, and player
			hi.bohred.FenceandMho();
			hi.bohred.startPlayer();
		}
		hi.bohred.setResizable(false);
		hi.bohred.paintBoard(g);
	}

	/**
	 * Paints the title frame and the start button
	 */
	public void paintTitle(Graphics g) {

		g.drawImage(titleimg, 0, 0, null);

		ImageIcon start = new ImageIcon(startimg); //creates the start button using the image
		JButton button = new JButton(start);
		add(button);
		button.setLocation(350, 400);
		button.setSize(200, 100);
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {		//detect when button is pressed
			
			@Override
			public void actionPerformed(ActionEvent e) {	//button commands
				if (!(hi.started)) {
					hi.started = true;

					hi.bohred.remove(self);
					hi.onscreen.validate();
					
					Display game = new Display(3, hi); 		//display the game
					hi.onscreen = game;
					hi.bohred.add(game);
					hi.bohred.pack();

					game.addKeyListener(hi.eavesdrop());	//keylistener for player
					game.setFocusable(true);
					game.requestFocusInWindow();

					game.setVisible(true);
					hi.bohred.setVisible(true);

				}
			}
		});
		button.setVisible(true);
	}

	/**
	 * Paints the restart button on the win / game over screen.
	 */
	public void restartButton(Graphics g) {
		ImageIcon restart = new ImageIcon((restartimg));
		JButton button = new JButton(restart);				//creates the button

		add(button);
		button.setLocation(350, 400);
		button.setSize(250, 100);
		button.setOpaque(true);
		button.setFocusable(false);
		
		
		button.addActionListener(new ActionListener() {		//detect when button is pressed
			@Override
			public void actionPerformed(ActionEvent e) {	//button commands
				hi.playerturn = true;						//stops the game
				hi.started = false;
				hi.ended = false;
				hi.counter = 0;
				
				self.remove(button);
				hi.paintScreen(3);
			}
		});
		
		button.setVisible(true);

	}

	/**
	 * Paints the screen that shows up upon winning the game.
	 */
	public void paintWin(Graphics g) {
		
		g.drawImage(winimg, 0, 0, null);
		restartButton(g);
		
	}

	/**
	 * Paints the screen that shows up upon losing the game
	 */
	public void paintLost(Graphics g) {
		
		g.drawImage(loseimg, 0, 0, null);
		restartButton(g);
		
	}

	/**
	 * Allows for num to be set.
	 */
	public void setNum(int n) {
		num = n;
	}

}
