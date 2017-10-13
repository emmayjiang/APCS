
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Hivolts extends JFrame {

	public boolean playerturn;
	public boolean won;
	public boolean ended;
	public boolean started;

	public Board bohred;
	public Display onscreen;
	public KeyListener keyl;
	public int counter;

	/**
	 * Constructor for the Hivolts Class.
	 * 
	 * @param bohred
	 *            the JFrame associated with the game
	 */
	public Hivolts(Board bohred) {
		playerturn = true;
		started = false;
		ended = false;
		this.bohred = bohred;
		counter = 0;
		keyl = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) { // overrides for how to respond when certain keys are pressed
				int key = e.getKeyCode();
				if (playerturn == true) {
					if (key == KeyEvent.VK_S) { // SIT STILL
					} else {
						bohred.getBoard()[bohred.player.getY()][bohred.player.getX()].removeEntity();
						// removes player temporarily from the board
						if (e.getKeyCode() == KeyEvent.VK_J) { // JUMP
							bohred.dropPlayer();
							// randomly place player in an empty space
						} else if (key == KeyEvent.VK_Q) { // UP LEFT
							bohred.player.change(3);
							bohred.player.change(2);

						} else if (key == KeyEvent.VK_W) { // UP
							bohred.player.change(3);

						} else if (key == KeyEvent.VK_E) { // UP RIGHT
							bohred.player.change(1);
							bohred.player.change(3);

						} else if (key == KeyEvent.VK_A) { // LEFT
							bohred.player.change(2);

						} else if (key == KeyEvent.VK_D) { // RIGHT
							bohred.player.change(1);

						} else if (key == KeyEvent.VK_Z) { // DOWN LEFT
							bohred.player.change(2);
							bohred.player.change(4);

						} else if (key == KeyEvent.VK_X) { // DOWN
							bohred.player.change(4);

						} else if (key == KeyEvent.VK_C) { // DOWN RIGHT
							bohred.player.change(1);
							bohred.player.change(4);
						}
					}

					playerturn = false;

					if (bohred.collisions()) { // checks for collisions
						won = false;
						ended = true;
						paintScreen(2); // game lost if there are collisions
					} else {
						paintScreen(3); // if not, update board
						mhoTurn(); // allow the mhos to move
					}

				}
			}

			// other overrides from the interface KeyListener

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

		};

	};

	/**
	 * Method to repaint the display.
	 * 
	 * @param type
	 *            integer signifying type of display (0) title (1) lose (2) win (3)
	 *            in-game
	 */
	public void paintScreen(int type) {
		onscreen.setNum(type);
		onscreen.repaint();
	}

	/**
	 * Method to allow the Mhos to move. Go through all 144 cells, looking for the
	 * mhos, moving them to their preferred spot. Then checking if there are any
	 * left, and bringing up the appropriate displays in response.
	 */
	public void mhoTurn() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				Cell[][] positions = bohred.getBoard();
				Entity moving = positions[i][j].contained;
				if (moving instanceof Mho && ((Mho) moving).checkMoved == false) { // checks to see if the cell contains
																					// a mho, and whether that mho has
																					// been moved or not
					((Mho) moving).turn(j, i);
					((Mho) moving).checkMoved = true;
					positions[i][j].removeEntity(); // removes the mho after it has been moved

					if ((((Mho) moving).getY() == bohred.player.getY())
							&& (((Mho) moving).getX() == bohred.player.getX())) { // if the next square is not a
																					// fence or player
						won = false;
						ended = true;
						paintScreen(2);
						return;

					}
					if (!(positions[((Mho) moving).getY()][((Mho) moving).getX()].contained instanceof Fence)) {

						positions[((Mho) moving).getY()][((Mho) moving).getX()].addEntity(moving); // add mho to that
																									// square
					}
				}
			}
		}

		int mcounter = 0;
		for (int i = 0; i < 12; i++) { // resets checkMoved boolean for next turn
			for (int j = 0; j < 12; j++) {
				Cell[][] positions = bohred.getBoard();
				Entity moving = positions[i][j].contained;
				if (moving instanceof Mho) {
					((Mho) moving).checkMoved = false;
					mcounter++;	//counts number of mhos
				}
			}
		}
		System.out.println("Mhos left: " + mcounter);
		if (mcounter == 0) { // if there is more than one mho
			paintScreen(1); // win screen
			return;
		}
		playerturn = true;	//next turn
		paintScreen(3);		//update game display
	}

	/**
	 * Returns the KeyListener associated with this instance of hivolts.
	 * 
	 * @return
	 */
	public KeyListener eavesdrop() {
		return keyl;
	}

	public static void main(String[] args) {

		Board bohred = new Board();
		Dimension size = new Dimension(650, 750);
		bohred.setBackground(Color.BLACK);
		bohred.setMinimumSize(size);
		bohred.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);

		Hivolts hi = new Hivolts(bohred);

		Display screen = new Display(0, hi);
		screen.setNum(0);
		screen.setBackground(Color.BLACK);
		screen.addKeyListener(hi.eavesdrop());
		screen.setFocusable(true);
		screen.requestFocusInWindow();
		hi.onscreen = screen;
		bohred.add(screen);
		bohred.pack();
		screen.setVisible(true);
		hi.paintScreen(0);

		bohred.setVisible(true);

	}
}
