package players;

import java.util.Random;

/**
 * this is used to create the generic player
 * 
 * @author marce
 * @version v3
 * @since 2019.03.18
 */
public abstract class MurachPlayer implements PhyAttacks, DistAttacks, Specials, Actions, attacksExtras, actionsExtra {

	//Cole
	/**
	 * This stores the user's selected class
	 */
	protected String playerClass;	
	
	/**
	 * used to store the player's name
	 */
	protected String name;
	
	/**
	 * used to store the player's gear
	 */
	protected String gear;
	/**
	 * used to store the player's special move
	 */
	protected String special;

	//Cole
	/**
	 * This stores the adventurer description
	 */
	protected String about;
	
	/**
	 * used to store the player's health
	 */
	protected int health;
	
	//Cole
	/**
	 * This stores the player's luck stat
	 */
	protected int luck;

	/**
	 * used to keep count on the number of players
	 * Can use it to determine how many players to be 
	 * in a game in a later edition of the game
	 */
	private static int playerNo = 0;

	/**
	 * used to keep count of souls
	 */
	protected int souls;
	protected int pointTotal;
	
	protected int amountGained;
	
	protected int points;

	/**
	 * default constructor that increments the number of players
	 */
	public MurachPlayer() {
		playerNo++;
	}

	/**
	 * method to get the user that is playing
	 * 
	 * @return Object get the user that is playing
	 */
	public static int getPlayerNo() {
		return playerNo;
	}

	/**
	 * overload constructor that allows settings ALL the player's fields
	 * 
	 * @param name    receives the player's name
	 * @param health  receives the player's health
	 * @param special receives the player's special move
	 */
	public MurachPlayer(String playerClass, String name, String about, String gear, String special, int health, int luck) {
		this();
		this.playerClass = playerClass;
		this.about = about;
		this.name = name;
		this.gear = gear;
		this.special = special;
		this.health = health;
		this.luck = luck;
		
	}
	
	//Cole
	/**
	 * This sets the player's class
	 * @param playerClass The selected class
	 */
	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}
	
	/**
	 * This method returns the player's selected class
	 * @return
	 */
	public String getPlayerClass() {
		return playerClass;
	}
	
	/**
	 * sets this player's name
	 * 
	 * @param name receives the player's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets this player's name
	 * 
	 * @return String this player's name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return about;
	}

	/**
	 * sets this player's health
	 * 
	 * @param health receives the player's health
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * gets this player's health
	 * 
	 * @return Integer this player's health
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * sets the player's gear
	 * 
	 * @param gear receives the player's gear
	 */
	public void setGear(String gear) {
		this.gear = gear;
	}

	/**
	 * gets this player's gear
	 * 
	 * @return String this player's gear
	 */
	public String getGear() {
		return gear;
	}
	
	/**
	 * sets this player's special move
	 * 
	 * @param special receives the player's special move
	 */
	public void setSpecial(String special) {
		this.special = special;
	}

	/**
	 * gets this player's special move
	 * 
	 * @return String this player's special move
	 */
	public String getSpecial() {
		return special;
	}
	
	//Colton
	/**
	 * This method sets the amount of luck the player has
	 * @param luck The luck stat
	 */
	public void setLuck(int luck) {
		this.luck = luck;
	}
	
	/**
	 * This method gets the luck value
	 * @return Returns the amount of stored luck
	 */
	public int getLuck() {
		return luck;
	}
	
	
	

	//Colton
	/**
	 * This is the method that will be overridden by class specific specials
	 */
	public void special() {
		System.out.println("Poof! That wasn't supposed to happen...");
		System.out.println("********************************************************");
	}
	
	
	
	/**
	 * This method is the implemented version of the loot method
	 */
	public void loot() {
		Random rand = new Random();
		amountGained = (luck * (rand.nextInt(3)));
		points = points + amountGained;
		System.out.println("\tYou found " + amountGained + " points!");
		System.out.println("\tYou now have " + points + " points");
		System.out.println("********************************************************");
		
	}
	
	/**
	 * This method is the implemented version of the fight method
	 */
	public void fight() {
		Random rand = new Random();
		
		if (health > 0) {
			if (rand.nextInt(4) > 0) {
				amountGained = (health * (rand.nextInt(11)));
				points = points + amountGained;
				health = health - 1;
				
				System.out.println("\tYou gained " + amountGained + " points!");
				System.out.println("\tYou now have " + points + " points");
			}
			else {
				health = health - 3;
				
				if (health < 0) {
					health = 0;
				}
				
				System.out.println("\tYou lost 3 health, you now have " + health + " left" );
			}
		}
		
		else {
			System.out.println("\tYou are unable to fight");
		}
		
		System.out.println("********************************************************");
	}

	
	
	

	
	
	/**
	 * abstract method for getting the success of any attack
	 * 
	 * @param attackSuccess sets the attack the player chose
	 * @return String with the success of the attack
	 */
	public abstract String special(int attackSuccess);

	/**
	 * this method keeps count of the souls that are added to a player
	 * 
	 * @param soulsTotal sets the amount of souls awarded to a player
	 */
	public void addPoints(int points) {
		this.points += points;
	}

	/**
	 * this method gets the amount of souls that are added to a player
	 * 
	 * @return Integer gets the amount of souls awarded to a player
	 */
	public int getPointsTotal() {
		return points;
	}
	
	public void addSouls(int souls) {
		this.souls += souls;
	}
	
	public int getSoulsTotal() {
		return souls;
	}



}