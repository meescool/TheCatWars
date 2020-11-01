package players;

/**
 * This interface contains attacks from long distance that are available to all
 * the players
 * 
 * @author Marce
 * @version v3
 * @since 2019.03.18
 *
 */
public interface DistAttacks {

	/**
	 * this default method is for outputting the level of success of the slingShot
	 * attack
	 * 
	 * @param attackSuccess sets the attack that the player chose
	 * @return String returns the result of the attack
	 */
	public default String slingShot(int attackSuccess) {

//		String points = "\n\t You gained " + attackSuccess + " points";

		String attackResults = "Slingshot had no effect";

		switch (attackSuccess) {
		case 1:
		case 2:
			attackResults = "Your slingshot had little effect on your enemy";
			break;
		case 3:
		case 4:
			attackResults = "Your slingshot dealt a good amount of damage!";
			break;
		case 5:
		case 6:
			attackResults = "Excellent shot!";
			break;
		}
		return attackResults;

	}

	/**
	 * this default method is for outputting the level of success of the crossBow
	 * attack
	 * 
	 * @param attackSuccess sets the attack that the player chose
	 * @return String returns the result of the attack
	 */
	public default String crossBow(int attackSuccess) {

	//	String points = "\n\t You gained " + attackSuccess + " points";

		String attackResults = "Crossbow had not effect" ;
		switch (attackSuccess) {
		case 1:
		case 2:
			attackResults = "Your crossbow had little effect on your enemy";
			break;
		case 3:
		case 4:
			attackResults = "Your crossbow dealt a good amount of damage!";
			break;
		case 5:
		case 6:
			attackResults = "Excellent shot!";
			break;
		}
		return attackResults;
	}

}
