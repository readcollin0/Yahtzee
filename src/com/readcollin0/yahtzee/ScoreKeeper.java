package com.readcollin0.yahtzee;

import com.readcollin0.yahtzee.categories.*;
import com.readcollin0.yahtzee.util.Die;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreKeeper {
	private HashMap<Category, PointCategory> categories = new HashMap<Category,PointCategory>();
	
	public ScoreKeeper() {
		categories.put(Category.ONES, new ScoreBasicNumber(1));
		categories.put(Category.TWOS, new ScoreBasicNumber(2));
		categories.put(Category.THREES, new ScoreBasicNumber(3));
		categories.put(Category.FOURS, new ScoreBasicNumber(4));
		categories.put(Category.FIVES, new ScoreBasicNumber(5));
		categories.put(Category.SIXES, new ScoreBasicNumber(6));
		categories.put(Category.THREE_OF_A_KIND, new ScoreSameThree());
		categories.put(Category.FOUR_OF_A_KIND, new ScoreSameFour());
		categories.put(Category.FULL_HOUSE, new ScoreFullHouse());
		categories.put(Category.SMALL_STRAIGHT, new ScoreSmallStraight());
		categories.put(Category.LARGE_STRAIGHT, new ScoreLargeStraight());
		categories.put(Category.YAHTZEE, new ScoreYahtzee());
		categories.put(Category.CHANCE, new ScoreChance());
	}
	
	public List<Category> getUnused() {
		ArrayList<Category> unused = new ArrayList<Category>();
		for (Category cat : categories.keySet()) {
			if (!categories.get(cat).isUsed() || categories.get(cat).isYahtzee()) unused.add(cat);
		}
		
		return unused;
	}
	
	public boolean use(Die[] dice, Category cat) {
		if (categories.get(cat).isYahtzee()) {
			if (categories.get(cat).isUsed()) {
				if (!categories.get(cat).checkSet(dice)) {
					return false;
				}
			}
		}
		if (categories.get(cat).checkSet(dice)) {
			int score = categories.get(cat).setScore(dice);
			System.out.printf("You got a score of %d%n Total Score %d%n", score, getTotalScore());
			Yahtzee.game.scanner.nextLine();
			return true;
		} else {
			System.out.println("Invalid usage, no score will result. Continue? (Y/n)");
			String in = Yahtzee.game.scanner.nextLine();
			if (in.toLowerCase().equals("n")) {
				return false;
			} else {
				categories.get(cat).invalidUse();
				return true;
			}
		}
	}
	
	public int getTotalScore() {
		int score = 0;
		for (PointCategory cat : categories.values()) {
			score += cat.getScore();
		}
		return score;
	}
	
	public PointCategory getCategory(Category cat) {
		return categories.get(cat);
	}
	
}