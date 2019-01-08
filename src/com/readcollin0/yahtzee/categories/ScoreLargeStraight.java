package com.readcollin0.yahtzee.categories;

import com.readcollin0.yahtzee.util.Die;
import com.readcollin0.yahtzee.util.Utils;

import java.util.ArrayList;

public class ScoreLargeStraight extends PointCategory {

	@Override
	public boolean checkSet(Die[] dice) {

		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (Die die : dice) {
			nums.add(die.getLastRoll());
		}

		return Utils.checkForContains(nums, new Integer[][]{{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}});
	}
	
	@Override
	public int setScore(Die[] dice) {
		this.score = 40;
		return 40;
	}
	
}
