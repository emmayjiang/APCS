
/**
 * Base class of Entity that is used to refer to Mhos and Players.
 */
public class Entity {
	
	Board bohred;
	public int x;
	public int y;

	public Entity(Board chess) {
		bohred = chess;
	}
}
