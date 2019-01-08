package com.readcollin0.yahtzee.actions;

import com.readcollin0.yahtzee.Yahtzee;

public class ActionRoll implements Action {
	
	public ActionRoll() {
	}
	
	@Override
	public void runAction() {
		System.out.println("Good Luck!");
		Yahtzee.game.rollNext();
	}

}
