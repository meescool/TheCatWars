package players;

public class Barbarian extends MurachPlayer {
	
	/**
	 * Default constructor
	 */
	public Barbarian() {
		super();
		playerClass = "Barbarian";
		name = "Barbarian";
		luck = 1;
		health = 10;
		special = "Body Slam";
		gear = "Iron Suit";
	}

	/**
	 * override method that overrides the DungeonPlayer name
	 */
	@Override
	public String toString() {
		return playerClass;
	}
	
	@Override
	public String special (int attackSuccess) {
		String attackResult = null;
		switch (attackSuccess) {
		case 1:
		case 2:
			attackResult = special + " was really bad";
			break;
		case 3:
		case 4:
			attackResult = special + " was O.K.";
			break;
		case 5:
		case 6:
			attackResult = special + " was really good!";
			break;
		}
		return attackResult;
	}
	
	@Override 
	public void special() {
		System.out.print(" ");
	}
	
}


