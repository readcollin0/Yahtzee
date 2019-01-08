package com.readcollin0.yahtzee.util;

import java.util.HashMap;

public class AsciiNumbers {
	public static final String[] one = {	"    /$$   ",  
											"  /$$$$   ",
											" |_  $$   ",
											"   | $$   ",
											"   | $$   ",
											"   | $$   ",
											"  /$$$$$$ ",
											" |______/ "};
	
	public static final String[] two = { 	"  /$$$$$$ ", 
											" /$$__  $$",
											"|__/  \\ $$",
											"  /$$$$$$/",
											" /$$____/ ",
											"| $$      ",
											"| $$$$$$$$",
											"|________/"};
	
	public static final String[] three = {  "  /$$$$$$ ", 
											" /$$__  $$",
											"|__/  \\ $$",
											"   /$$$$$/",
											"  |___  $$",
											" /$$  \\ $$",
											"|  $$$$$$/",
											" \\______/ "};
	
	public static final String[] four = {	" /$$   /$$",
											"| $$  | $$",
											"| $$  | $$",
											"| $$$$$$$$",
											"|_____  $$",
											"      | $$",
											"      | $$",
											"      |__/"};
	
	public static final String[] five = {	" /$$$$$$$ ",
											"| $$____/ ",
											"| $$      ",
											"| $$$$$$$ ",
											"|_____  $$",
											" /$$  \\ $$",
											"|  $$$$$$/",
											" \\______/ "};
	
	public static final String[] six = {	"  /$$$$$$ ", 
											" /$$__  $$",
											"| $$  \\__/",
											"| $$$$$$$ ",
											"| $$__  $$",
											"| $$  \\ $$",
											"|  $$$$$$/",
											" \\______/ "};
	
	public static final HashMap<Integer,String[]> numbers = new HashMap<Integer,String[]>() {
		private static final long serialVersionUID = 8303879042679141418L;
	{
		this.put(1, one);
		this.put(2, two);
		this.put(3, three);
		this.put(4, four);
		this.put(5, five);
		this.put(6, six);
	}};
	
}
