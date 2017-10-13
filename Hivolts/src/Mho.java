
/**
 * The class for the Mho Entity.
 */
public class Mho extends Entity {

	
	public int x;
	public int y;
	private boolean checkFence = true;
	public boolean checkMoved = false;

	public Mho(Board bohred) {
		super(bohred);
	}

	/**
	 * Causes the Mho to check through all of its possible moving algorithms, which will be described before their methods.
	 * 
	 * @param x		the starting x coordinate of the Mho
	 * @param y		the starting y coordinate of the Mho
	 */
	public void turn(int x, int y) {
		this.x = x;
		this.y = y;
		if (!checkHorizontal()) {
			if (!checkVertical()) {
				if (!checkDiagonal()) {
					if (!checkDistance()) {
						if (checkFence) {
							checkFence = false;
							turn(x, y);
						}
					}
				}
			}
		}
	}

	/**
	 * Checks the horizontal:
	 * 		If you are directly vertical or hortizontal to a Mho, the Mho MUST move directly towards you one square.
	 * 		If this results in the Mho landing on an electric fence, the Mho is removed from the board.
	 * 		If it lands on an empty square, it remains on the board.
	 * 
	 * @return	true if moved
	 */
	public boolean checkHorizontal() {
		for (int i = 0; i < 12; i++) {
			if (bohred.getBoard()[y][i].contained instanceof Player) {		//checks for player on its horizontal
				if (this.x > i) {		//moving methods
					this.x -= 1;
				} else if (this.x < i) {
					this.x += 1;
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks the vertical:
	 * 		If you are directly vertical or hortizontal to a Mho, the Mho MUST move directly towards you one square.
	 * 		If this results in the Mho landing on an electric fence, the Mho is removed from the board.
	 * 		If it lands on an empty square, it remains on the board.
	 * 
	 * @return	true if moved
	 */
	public boolean checkVertical() {
		for (int i = 0; i < 12; i++) {
			if (bohred.getBoard()[i][x].contained instanceof Player) {		//checks for player on its vertical
				if (this.y > i) {		//moving methods
					this.y -= 1;
				} else if (this.y < i) {
					this.y += 1;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * If the Mho is not directly horizontal or vertical from you:
	 * 		Check diagonally
	 * 
	 * @return	true if moved
	 */
	public boolean checkDiagonal() {
		int x = this.x;
		int y = this.y;
		for (int i = 0; i < 12; i++) { 
			for (int j = 0; j < 12; j++) {
				if (bohred.getBoard()[i][j].contained instanceof Player) {		//checks diagonal for player
					if (this.x > j) {		//move
						x = x - 1;
					} else {
						x = x + 1;
					}
					if (this.y > i) {
						y = y - 1;
					} else {
						y = y + 1;
					}
					if (!checkFence || !(bohred.getBoard()[y][x].contained instanceof Fence)) {	//decides whether or not to check for fence collisions
						this.x = x;
						this.y = y;
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * If the Mho is not directly horizontal or vertical from you:
	 * 		Check distance from player to determine if it should move horizontally or vertically
	 * 
	 * @return	true if moved
	 */
	public boolean checkDistance() {
		int x = this.x;
		int y = this.y;
		for (int i = 0; i < 12; i++) { 
			for (int j = 0; j < 12; j++) {
				if (bohred.getBoard()[i][j].contained instanceof Player) {		//checks for distance from player horizontally and vertically
					if (Math.abs(x - j) >= Math.abs(y - i)) {
						if (this.x > j) {		//move
							this.x -= 1;
						} else if (this.x < j) {
							this.x += 1;
						}
					} else {
						if (this.y > i) {
							this.y -= 1;
						} else if (this.y < i) {
							this.y += 1;
						}
					}
					if (!checkFence || !(bohred.getBoard()[y][x].contained instanceof Fence)) {		//decides whether or not to check for fence collisions
						this.x = x;
						this.y = y;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Gets the x coordinate of the Player.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Gets the y coordinate of the Player.
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Sets the x coordinate of the Player.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the y coordinate of the Player.
	 */
	public void setY(int y) {
		this.y = y;
	}
}