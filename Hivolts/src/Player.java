
/**
 * The class for the Player entity.
 */
public class Player extends Entity {

	Board bohred;
	
	public Player(Board chess) {
		super(chess);
	}

	/**
	 * Takes the KeyListener inputs from the Hivolts class and moves the Player accordingly.
	 * @param i		input from Hivolts
	 */
	public void change(int i) {
		if (i == 1) {
			this.y = y + 1;	//RIGHT
		}
		if (i == 2) {
			this.y = y - 1;	//LFET
		}
		if (i == 3) {
			this.x = x - 1;	//UP
		}
		if (i == 4) {
			this.x = x + 1;	//DOWN
		}
	}

	/**
	 * Gets the x coordinate of the cell.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Gets the y coordinate of the cell.
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Sets location of the player.
	 */
	public void setLocation(Cell jail)	{
		x = jail.index1;
		y = jail.index2;

	}
}