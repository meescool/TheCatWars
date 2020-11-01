package players;

/**
 * This is the class that stores the Thief subclass
 * @author Cole Sommer
 * @version 1.0
 * @since 3/23/19
 */
public class Thief extends MurachPlayer {

	public Thief() {
		super();
		playerClass = "Thief";
		luck = 2;
		points = 0;
		health = 5;
		about = "Thief: Starts with 2 luck. Able to increase luck.";
		special = "Increase luck by 1";
		gear = "none";
	}
	
	@Override
	public void special() {
		luck = luck + 1;
		System.out.println("Your luck has gone up by one" + "\n" +"You now have " + luck + " luck");
		System.out.println("********************************************************");
	}
	
	/**
	 * override method that overrides the MurachPlayer name
	 */
	@Override
	public String toString() {
		return playerClass;
	}

	@Override
	public String special(int attackSuccess) {
		// TODO Auto-generated method stub
		String special ="You don't have a special attack, but you can increase your Luck!";
		return special;
	}



	
}