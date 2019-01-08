package com.readcollin0.yahtzee.util;

import java.util.Random;

public class Die {
	
	private int lastNum, min, max;
	private Random random = new Random();
	
	public Die(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public int roll() {
		lastNum = random.nextInt(max - min + 1) + min;
		return this.lastNum;
	}
	
	public int getLastRoll() {
		return lastNum;
	}
	
}
