package players;

/**
 * This interface defines the two basic actions available to the players
 * @author Cole Sommer
 *
 */
public interface Actions {
	
	/**
	 * This method will control the looting mechanics
	 */
	void loot();
	
	/**
	 * This method will control the fighting mechanics
	 */
	void fight();
	
}
