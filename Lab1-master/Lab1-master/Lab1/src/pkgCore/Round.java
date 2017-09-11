package pkgCore;

import java.util.LinkedList;

public class Round {

	private int ComeOutScore;
	private eGameResult eGameResult;
	private LinkedList<Roll> rolls = new LinkedList<Roll>();

	public Round() {
		/*
		 * 
		 * Brandon Gilbert, Madeline Smith, Michelle Seifert, Steven Landes
		 */
		rolls.add(new Roll());
		
		ComeOutScore = rolls.getFirst().getScore();
		
		switch(ComeOutScore) {
		case 2: case 3: case 12:
			eGameResult = eGameResult.CRAPS;
			break;
		case 7: case 11:
			eGameResult = eGameResult.NATURAL;
			break;
		default:
			eGameResult = eGameResult.POINT;
			break;
		}
		
		if (eGameResult == eGameResult.POINT) {
			do {
				rolls.add(new Roll());
			} while ((rolls.getLast().getScore() != 7) && (rolls.getLast().getScore() != ComeOutScore));
			
			if (rolls.getLast().getScore() == 7) {
				eGameResult = eGameResult.SEVEN_OUT;
			}
		}
	}

	public int RollCount() {
		return rolls.size();
	}

}
