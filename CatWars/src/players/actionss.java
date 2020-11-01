package players;

public interface actionss {
	
	public default String Loot(int attackSuccess, String attackResult) {

		switch (attackSuccess) {
		case 1:
		case 2:
			attackResult = "That was a bad loot.";
			break;
		case 3:
		case 4:
			attackResult = "That was a O.K. loot.";
			break;
		case 5:
		case 6:
			attackResult = "That was an amazing loot.";
			break;
		}
		return attackResult;
	}

	String special(int attackSuccess, String attackResult);

}
