package com.readcollin0.yahtzee.categories;

import com.readcollin0.yahtzee.util.Die;

public class PointCategory {
	protected int score = -1;
	
	public void invalidUse() {
		this.score = 0;
	}
	
	public boolean checkSet(Die[] dice) {
		return false;
	}

	public int setScore(Die[] dice) {
		this.score = 0;
		return 0;
	}

	public int getScore() {
		if (score == -1) {
			return 0;
		} else {
			return score;
		}
	}

	public boolean isUsed() {
		return score != -1;
	}
	
	public boolean isYahtzee() {
		return false;
	}
}
