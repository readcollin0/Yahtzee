package com.readcollin0.yahtzee.util;

public class Display {
	public static void displayNums(Die[] dice, boolean[] held) {
		numDisplayRow();
		numDisplayInnerRow();
		for (int i=0; i<8; i++) {
			String str = "";
			for (Die die : dice) {
				str += ("|  " + AsciiNumbers.numbers.get(die.getLastRoll())[i] + "  ");
			}
			str += ("|");
			System.out.println(str);
		}
		for (boolean hold : held) {
			System.out.print("|");
			if (hold) {
				System.out.print("     Held     ");
			} else {
				System.out.print("              ");
			}
		}
		System.out.println("|");
		
		numDisplayInnerRow();
		numDisplayRow();
	}
	
	private static void numDisplayRow() {
		for (int i=0; i<76; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
	
	private static void numDisplayInnerRow() {
		for (int i=0; i<5; i++) {
			System.out.print("|              ");
		}
		System.out.println("|");
	}
	
	public static void clearScreen() {
		for (int i=0; i<50; i++) {
			System.out.println("");
		}
	}
}
