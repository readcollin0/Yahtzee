package com.readcollin0.yahtzee.categories;

import com.readcollin0.yahtzee.util.DiceCounts;
import com.readcollin0.yahtzee.util.Die;

public class ScoreFullHouse extends PointCategory {
	
	@Override
	public boolean checkSet(Die[] dice) {
		DiceCounts counts = new DiceCounts(dice);
		boolean worksTwo = false;
		boolean worksThree = false;
		
		for (int count : counts.getCounts()) {
			if (count == 2) worksTwo = true;
			if (count == 3) worksThree = true;
		}
		
		return worksTwo && worksThree;
	}

	@Override
	public int setScore(Die[] dice) {
		this.score = 25;
		return 25;
	}

}
