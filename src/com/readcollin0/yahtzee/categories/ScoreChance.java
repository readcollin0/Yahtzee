package com.readcollin0.yahtzee.categories;

import com.readcollin0.yahtzee.util.Die;

public class ScoreChance extends PointCategory {
	
	@Override
	public boolean checkSet(Die[] dice) {
		return true;
	}
	
	@Override
	public int setScore(Die[] dice) {
		for (Die die : dice) {
			score += die.getLastRoll();
		}
		return score;
	}
	
}
