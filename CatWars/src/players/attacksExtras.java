package players;

public interface attacksExtras{
	
	public default String hitAttack(int attackSuccess) {

		String attackResult = null;
		switch (attackSuccess) {
		case 1:
		case 2:
			attackResult = "That was a bad hit.";
			break;
		case 3:
		case 4:
			attackResult = "That was a O.K. hit.";
			break;
		case 5:
		case 6:
			attackResult = "That was an amazing hit.";
			break;
		}
		return attackResult;
	}
	
	public default String kickAttack(int attackSuccess) {
		String attackResult = null;
		switch (attackSuccess) {
		case 1:
		case 2:
			attackResult = "That was a bad kick.";
			break;
		case 3:
		case 4:
			attackResult = "That was a O.K. kick.";
			break;
		case 5:
		case 6:
			attackResult = "That was an amazing kick.";
			break;
		}
		return attackResult;
	}
	
	public default String punchAttack(int attackSuccess ) {
		String attackResult = null;
		switch (attackSuccess) {
		case 1:
		case 2:
			attackResult = "That was a bad punch.";
			break;
		case 3:
		case 4:
			attackResult = "That was a O.K. punch.";
			break;
		case 5:
		case 6:
			attackResult = "That was an amazing punch.";
			break;
		}
		return attackResult;
	}

}
