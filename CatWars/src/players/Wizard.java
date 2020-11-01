package players;

/**
 * This is the class that stores the Wizard subclass
 * @author Cole Sommer
 * @version 1.0
 * @since 3/23/19
 */
public class Wizard extends MurachPlayer implements Specials {
	
	public Wizard() {
		super();
		playerClass = "Wizard";
		luck = 1;
//		points = 0;
		health = 7;
		about= "Wizard: Starts with 1 luck. Able to heal himself.";
		special = "Increase health by one";
		gear = "Magic Robe";
	}

	@Override
	public String toString() {
		return playerClass;
	}

	@Override
	public String special(int attackSuccess) {
		// TODO Auto-generated method stub
		return "You have no special attack, but you can heal!";
	}
	
	@Override
	public void special() {
		health = health + 1;
		System.out.println("\tYou have healed for one point" + "\n" +"\tYou now have " + health + " health");
		System.out.println("********************************************************");
	}

}
