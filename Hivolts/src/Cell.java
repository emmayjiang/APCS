
/**
 * Cell is a method that stores entities, as well as the sizes of each cell of the board.
 */
public class Cell {

	final int CELL_LENGTH = 50;
	public Entity contained;
	public int xco; // x coordinate of the top left corner of the cell
	public int yco; // y coordinate of the top left corner of the cell
	public int index1;
	public int index2;

	public Cell(int index1, int index2) {
		this.index1 = index1;
		this.index2 = index2;
		xco = 25 + (index2 * CELL_LENGTH);
		yco = 50 + (index1 * CELL_LENGTH);
	}
	
	/**
	 * Removes the entity contained inside the cell.
	 */
	public void removeEntity() {
		contained = null;
	}
	
	/**
	 * Adds an entity to a Cell.
	 * @param entity
	 */
	public void addEntity(Entity entity) {
		contained = entity;
	}
	
	/**
	 * Returns the contained entity.
	 */
	public Entity getContained() {
		return contained;
	}
	
	/**
	 * Gets the x coordinate of the cell.
	 */
	public int getX() {
		return xco;
	}

	/**
	 * Gets the y coordinate of the cell.
	 */
	public int getY() {
		return yco;
	}
}
