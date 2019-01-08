package com.readcollin0.yahtzee.util;

import com.readcollin0.yahtzee.categories.Category;

import java.util.ArrayList;

public class Utils {
	public static boolean checkForContains(ArrayList<Integer> nums, Integer[][] checkFor) {
		for (Object[] set : checkFor) {
			boolean works = true;
			for (Object item : set) {
				if (!nums.contains(item)) works = false;
			}
			if (works) return true;
		}
		return false;
	}
	
	public static final Category[] BASIC_CATS = {
			Category.ONES,
			Category.TWOS,
			Category.THREES,
			Category.FOURS,
			Category.FIVES,
			Category.SIXES},
	
				LOWER_CATS = {
			Category.THREE_OF_A_KIND,
			Category.FOUR_OF_A_KIND,
			Category.FULL_HOUSE,
			Category.SMALL_STRAIGHT,
			Category.LARGE_STRAIGHT,
			Category.CHANCE};
}
