package com.readcollin0.yahtzee.categories;

import com.readcollin0.yahtzee.util.Die;

public class ScoreBasicNumber extends PointCategory {

	private final int number;
	
	public ScoreBasicNumber(int num) {
		this.number = num;
	}
	
	@Override
	public boolean checkSet(Die[] dice) {
		return true;
	}

	@Override
	public int setScore(Die[] dice) {
		score = 0;
		for (Die die : dice) {
			if (die.getLastRoll() == number) {
				score += number;
			}
		}
		return score;
	}

}
