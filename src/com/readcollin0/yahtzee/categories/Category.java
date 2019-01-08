package com.readcollin0.yahtzee.categories;

public enum Category {
	ONES("Ones", true),
	TWOS("Twos", true),
	THREES("Threes", true),
	FOURS("Fours", true),
	FIVES("Fives", true),
	SIXES("Sixes", true),
	THREE_OF_A_KIND("Three of a Kind"),
	FOUR_OF_A_KIND("Four of a Kind"),
	FULL_HOUSE("Full House"),
	SMALL_STRAIGHT("Small Straight"),
	LARGE_STRAIGHT("Large Straight"),
	YAHTZEE("YAHTZEE!"),
	CHANCE("Chance");
	
	public String name;
	public boolean isBasic;
	
	Category(String name, boolean isBasic) {
		this.name = name;
		this.isBasic = isBasic;
	}
	
	Category(String name) {
		this.name = name;
		this.isBasic = false;
	}
	
}
