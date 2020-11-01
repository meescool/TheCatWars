package players;

/**
 * This interface contains attacks that are physical that are available to all
 * the players
 * 
 * @author Marce
 * @version v3
 * @since 2019.03.18
 *
 */
public interface PhyAttacks {

	/**
	 * this default method is for outputting the level of success of the punch
	 * attack
	 * 
	 * @param attackSuccess sets the attack that the player chose
	 * @return String returns the result of the attack
	 */
	public default String punchKickAttack(int attackSuccess) {

//		String points = "\n\t You gained " + attackSuccess + " points";

		String attackResults = "Punch Kick had no effect";

		switch (attackSuccess) {
		case 1:
		case 2:
			attackResults = "Your punch kick had little effect on your enemy";
			break;
		case 3:
		case 4:
			attackResults = "Your punch kick dealt a good amount of damage!";
			break;
		case 5:
		case 6:
			attackResults = "Excellent punch kick!";
			break;
		}
		return attackResults;
	}

	/**
	 * this default method is for outputting the level of success of the slap attack
	 * 
	 * @param attackSuccess sets the attack that the player chose
	 * @return String attackResults returns the result of the attack
	 */
	public default String slapAttack(int attackSuccess) {


		String attackResults = "Slap had no effect";

		switch (attackSuccess) {
		case 1:
		case 2:
			attackResults = "Your slap had little effect on your enemy";
			break;
		case 3:
		case 4:
			attackResults = "Your slap dealt a good amount of damage!";
		case 5:
		case 6:
			attackResults = "Excellent slap!";
		}
		return attackResults;
	}

}
