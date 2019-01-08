package com.readcollin0.yahtzee.categories;

import com.readcollin0.yahtzee.util.DiceCounts;
import com.readcollin0.yahtzee.util.Die;

public class ScoreSameThree extends PointCategory {

	@Override
	public boolean checkSet(Die[] dice) {
		DiceCounts counts = new DiceCounts(dice);
		
		for (int i=1; i<=6; i++) {
			if (counts.getCount(i) >= 3) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int setScore(Die[] dice) {
		for (Die die : dice) {
			score += die.getLastRoll();
		}
		return score;
	}
	
}
