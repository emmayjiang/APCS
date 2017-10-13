
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;

public class Board extends JFrame {

	Cell[][] positions; // the whole board

	Image mhoimg = new ImageIcon("resources/dog.png").getImage();
	Image playerimg = new ImageIcon("resources/cat.png").getImage();
	Image fenceimg = new ImageIcon("resources/fence.png").getImage();

	public Player player;

	// CONSTRUCTORS & INITIALIZERS
	/**
	 * Creates a 12x12 2D Array of Cells.
	 */
	public Board() {
		positions = new Cell[12][12];
		for (int y = 0; y < 12; y++) { // creates a cell for every position of the board
			for (int x = 0; x < 12; x++) {
				Cell jail = new Cell(x, y);
				positions[y][x] = jail;
			}
		}
	}

	/**
	 * Randomly places 20 fences and 12 mhos into the field. Places fences along the 44 cells of the perimeter.
	 */
	public void FenceandMho() {
		// Clean the 2D array
		for (int i = 0; i < 12; i++) {
			for (int j=0; j< 12; j++) {
				positions[i][j].removeEntity();
			}
		}

		// create a proxy 1D array for easy randomization
		Entity[] proxy = new Entity[100];

		// initialize the array with 20 fences
		for (int i = 0; i < 20; i++) {
			proxy[i] = new Fence(this);
		}
		// initialize the array with 32 fences

		for (int j = 20; j < 32; j++) {
			proxy[j] = new Mho(this);
		}

		// randomize the array
		for (int l = 0; l < 20; l++) {
			int r = (int) (Math.random() * 100);
			Entity temp = proxy[l];
			proxy[l] = proxy[r];
			proxy[r] = temp;
		}

		for (int m = 20; m < 32; m++) {
			int s = (int) (Math.random() * 100);
			Entity temp = proxy[m];
			proxy[m] = proxy[s];
			proxy[s] = temp;
		}

		for (int i = 0; i < 12; i++) {
			for (int k = 0; k < 12; k++) {
				if (i == 0 || k == 0 || i == 11 || k == 11) {
					Fence add = new Fence(this);
					positions[i][k].addEntity(add); // creates fences along the perimeter
				} else {
					// put fence & mho array back into board array
					int corr = 10 * (k - 1) + (i - 1);
					if (corr < 100 && proxy[corr] != null) {
						positions[i][k].addEntity(proxy[corr]);
					}
				}
			}
		}

	}

	// PLAYER INTERACTIONS
	/**
	 * Randomly places a new player inside the field.
	 */
	public void startPlayer() {
		ArrayList<Cell> vacant = new ArrayList<Cell>();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				if (positions[i][j].contained == null) {
					vacant.add(positions[i][j]);
				}
			}
		}
		int r = (int) (Math.random() * vacant.size());
		Player boi = new Player(this);
		vacant.get(r).addEntity(boi);
		player = boi;
		player.setLocation(vacant.get(r));
		//System.out.println(vacant.get(r));
	}

	/**
	 * Takes the player in the board and randomly drops it elsewhere.
	 */
	public void dropPlayer() {
		ArrayList<Cell> vacant = new ArrayList<Cell>();	//new ArrayList to store empty cells
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				if (positions[i][j].contained == null) {
					vacant.add(positions[i][j]);			//check board for empty cells to add
				}
			}
		}
		int r = (int) (Math.random() * vacant.size());	//randomly generate an index
		vacant.get(r).addEntity(player);					//add the player into the index
		player.setLocation(vacant.get(r));				//update the player's stored location
	}

	/**
	 * Checks to make sure that the player does not collide with a Fence or a Mho.
	 * @return boolean true if collided with other entity; false if not
	 */
	public boolean collisions() {

		if (positions[player.getY()][player.getX()].contained instanceof Fence) {
			return true;
		}
		if (positions[player.getY()][player.getX()].contained instanceof Mho) {
			return true;
		} else {
			positions[player.getY()][player.getX()].addEntity(player);
			return false;
		}
	}

	/**
	 * Method to paint the board. An image is drawn based off the cell an entity contains.
	 * @param g the Graphics needed for painitng
	 */
	public void paintBoard(Graphics g) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				Cell next = positions[j][i];
				if (next.contained instanceof Fence) {
					g.drawImage(fenceimg, next.getX(), next.getY(), null);	//paint fence
				} else if (next.contained instanceof Mho) {
					g.drawImage(mhoimg, next.getX(), next.getY(), null);		//paint mho
				} else if (next.contained instanceof Player) {
					g.drawImage(playerimg, next.getX(), next.getY(), null);	//paint player
				} 
			}
		}
	}

	// GETTERS AND SETTERS
	/**
	 * Gets the 2D array of cells stored in board.
	 * @return
	 */
	public Cell[][] getBoard() {
		return positions;
	}

}
