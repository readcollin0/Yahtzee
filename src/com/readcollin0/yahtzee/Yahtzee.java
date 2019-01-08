package com.readcollin0.yahtzee;

import com.readcollin0.yahtzee.actions.Action;
import com.readcollin0.yahtzee.actions.ActionHold;
import com.readcollin0.yahtzee.actions.ActionRoll;
import com.readcollin0.yahtzee.actions.ActionScore;
import com.readcollin0.yahtzee.categories.Category;
import com.readcollin0.yahtzee.util.Die;
import com.readcollin0.yahtzee.util.Display;
import com.readcollin0.yahtzee.util.Utils;

import java.util.HashMap;
import java.util.Scanner;

public class Yahtzee {

	public static Yahtzee game; 
	
	private HashMap<String, Action> choices = new HashMap<String,Action>();
	private Die[] dice = new Die[5];
	private boolean[] held;
	private ScoreKeeper score = new ScoreKeeper();
	public Scanner scanner = new Scanner(System.in);
	private int rolls;
	
	private Boolean scored;
	private Boolean roll;

	public static void main(String[] args) {
	    startGame();
    }

	public static void startGame() {
		game = new Yahtzee();
		game.play();
	}
	
	public Yahtzee() {
		for (int i=0; i<5; i++) {
			dice[i] = new Die(1,6);
		}
	}
	
	private void play() {
		
		while (optionsLeft()) {
			runRound();
		}
		finish();
		
	}
	
	private void finish() {
		Display.clearScreen();
		System.out.printf("You finished!%nFinal Score: %d",score.getTotalScore());
	}

	public void rollNext() {
		this.roll = true;
	}
	
	private void runRound() {
		held = new boolean[] {false, false, false, false, false};
		scored = false;
		rolls = 0;
		while (!scored) {
			roll();
			roll = false;
			while (!roll) {
				Display.clearScreen();
				Display.displayNums(dice, held);
				displayOptions();
				getChoice();
			}
		}
	}
	
	public void scored() {
		this.scored = true;
		this.roll = true;
	}
	
	private void displayOptions() {
		choices.clear();
		for (int index=0; index<dice.length; index++) {
			System.out.printf("h%d: Toggle hold on die %d%n",index+1,index+1);
			choices.put(String.format("h%d", index+1), new ActionHold(index));
		}
		
		System.out.println();
		
		for (int i=1; i<=6; i++) {
			if (!score.getCategory(Utils.BASIC_CATS[i-1]).isUsed()) {
				System.out.printf("%d: Score %s%n", i, Utils.BASIC_CATS[i-1].name);
				choices.put(String.format("%d", i), new ActionScore(Utils.BASIC_CATS[i-1]));
			}
		}
		System.out.println();
		for (int i=1; i<=6; i++) {
			if (!score.getCategory(Utils.LOWER_CATS[i-1]).isUsed()) {
				System.out.printf("s%d: Score %s%n", i, Utils.LOWER_CATS[i-1].name);
				choices.put(String.format("s%d", i), new ActionScore(Utils.LOWER_CATS[i-1]));
			}
		}
		
		System.out.println("y: YAHTZEE!");
		choices.put("y", new ActionScore(Category.YAHTZEE));
		
		System.out.println();
		if (rolls != 3) {
			System.out.println("r: Roll again!");
			this.choices.put("r", new ActionRoll());
		}
		System.out.println();
		
//		choices.put("-- debug --", new ActionDebug());
	}
	
	public void hold(int die) {
		held[die] = !held[die];
	}
	
	public void score(Category cat) {
		if (score.use(dice, cat)) this.scored();
	}
	
	private void getChoice() {
		String choice = scanner.nextLine();
		if (choices.containsKey(choice)) {
			choices.get(choice).runAction();
		} else {
			System.out.println("Invalid Command");
		}
	}
	
	private void roll() {
		for (int i=0; i<5; i++) {
			if (!held[i]) dice[i].roll();
		}
		rolls += 1;
	}
	
	private boolean optionsLeft() {
		if (score.getUnused().size() != 1) {
			return true;
		} else {
			if (score.getCategory(Category.YAHTZEE).isUsed()) {
				return false;
			}
		}
		return false;
	}
	
//	public void debug() {
//		dice[0].lastNum=2;
//		dice[1].lastNum=3;
//		dice[2].lastNum=2;
//		dice[3].lastNum=3;
//		dice[4].lastNum=2;
//	}
}
