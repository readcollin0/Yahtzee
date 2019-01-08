package com.readcollin0.yahtzee.util;

public class DiceCounts {
	private int[] counts = {0,0,0,0,0,0};
	
	public DiceCounts(Die[] dice) {
		for (Die die : dice) {
			counts[die.getLastRoll()-1] += 1;
		}
	}
	
	public int getCount(int num) {
		return counts[num - 1];
	}
	
	public int[] getCounts() {
		return counts;
	}
}
