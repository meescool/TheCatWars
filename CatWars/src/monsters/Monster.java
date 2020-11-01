package monsters;

/**
 * this is used to create the generic monster
 * 
 * @author marce
 * @version v3
 * @since 2019.03.18
 */
public abstract class Monster {

	//Cole
	/**
	 * This stores the name of the monster
	 */
	protected String monsterName;	
	
	
	/**
	 * used to store the monster's special move
	 */
	protected String special;

	//Cole
	/**
	 * This stores the monster description
	 */
	protected String about;
	
	/**
	 * used to store the monster's health
	 */
	protected int health;
	
	/**
	 * used to store the monster's money
	 */
	protected int coins;
	
	/**
	 * used to keep count on the number of 
	 * monsters destroyed
	 */
	private static int playerNo = 0;

	/**
	 * default constructor that increments the number of players
	 */
	public Monster() {
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
	public Monster(String monsterName, String about, String special, int health, int coins) {
		this();
		this.monsterName = monsterName;
		this.about = about;
		this.special = special;
		this.health = health;
		this.coins = coins;
	}
	
	public String getMonsterName() {
		return monsterName;
	}
	
	public String getAbout() {
		return about;
	}
	
	public String getSpecial() {
		return special;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getCoins() {
		return coins;
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
	 * abstract method for getting the success of any attack
	 * 
	 * @param attackSuccess sets the attack the player chose
	 * @return String with the success of the attack
	 */
	public abstract String special(int attackSuccess, Object player);


}