package players;

/**
 * this class is a subclass of the MurachPlayer class and it sets the Orc
 * player
 * 
 * @author Marce
 * @version v3
 * @since 2019.03.18
 *
 */
public class Orc extends MurachPlayer {

	/**
	 * Default constructor
	 */
	public Orc() {
		super();
		playerClass = "Orc";
		name = "Orc";
		luck = 1;
		health = 8;
		special = "Bone Shatter";
		gear = "Thick Tunic";
	}

	/**
	 * override method that overrides the MurachPlayer name
	 */
	@Override
	public String toString() {
		return playerClass;
	}

	/**
	 * Abstract Override Method this method is for outputting the level of success
	 * of the orc special attack
	 * 
	 * @param attackSuccess sets the attack that the player chose
	 * @return String returns the result of the attack
	 *
	 */
	@Override
	public String special(int attackSuccess) {

		String points = "\n\t You gained " + attackSuccess + " points";
		

		String attackResult = "Oh no!" + special + " had no effect!" + points;

		switch (attackSuccess) {
		case 1:
		case 2:
			attackResult = "Your " + special + " had little effect on your enemy" + points;
			break;
		case 3:
		case 4:
			attackResult = "Your " + special + " dealt a good amount of damage!" + points;
			break;
		case 5:
		case 6:
			attackResult = "Excellent " + special + "!" + points;
			break;
		}
		return attackResult;
	}
	
	@Override
	public void special() {
		System.out.print("");
	}

}
