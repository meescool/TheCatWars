package monsters;

public class GiantBug extends Monster{
	
	public GiantBug() {
		super();
		monsterName = "Giant Bug";
		about = "BIG, super big bug that is scary";
		special = "Venom Bite";
		health = 4;
		coins = 6;
	}

	@Override
	public String special(int attackSuccess, Object player) {
		String damageDealt = "\n\t" + player + " lost " + attackSuccess + "hp";
		
		String attackResult = "No effect on " + player + "!";
		return attackResult;
	}
	

}
