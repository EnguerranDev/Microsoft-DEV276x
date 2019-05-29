package maze_runner;

import java.util.*;

public class maze_run {
	public static void main(String[] args) {
		// instantiate maze
		Maze myMap = new Maze();
		
		// Run intro
		intro(myMap);
		
		String move;
		boolean can_move;
		int total_moves = 0;
		
		// While not won or not more than 100 moves
		while ((!myMap.didIWin()) && (total_moves<=100)) {
			// Ask user direction
			move = userMove(myMap);
			total_moves = total_moves + 1;
			// Part 2 Warnings
			System.out.print(movesMessage(total_moves));
			// Check if pit
			if (myMap.isThereAPit(move)) {
				navigatePit(myMap, move);
			} else {
			
				// Check if he can move
				can_move = canMove(myMap, move);
				// Do the move
				if (can_move) {
					doMove(myMap, move);
				} else {
					System.out.print("\nSorry, you’ve hit a wall.\n");
				}
			}
		}
		
		// End of game
		if (total_moves>100) {
			System.out.print("\nYSorry, but you didn't escape in time- you lose!\n");
		} else {
			System.out.print("\nCongrats you won! You did it in " + total_moves + " moves\n");
		}
	}
	
	// Show messages to welcome user
	public static void intro(Maze myMap) {
		System.out.print("Welcome to Maze Runner!\nHere is your current position:\n");
		myMap.printMap();
	}
	
	// Ask the user where he wants
	public static String userMove(Maze myMap) {
		Scanner input = new Scanner(System.in);
		System.out.print("Where would you like to move? (R, L, U, D)");
		String move = input.nextLine();
		String arr[] = {"R", "L", "U", "D"};
		boolean test = check_array(move);
		while (test) {
			System.out.print("Where would you like to move? (R, L, U, D)");
			move = input.nextLine();
			test = check_array(move);
		}
		return move;
	}
	
	// Check if can move
	public static boolean canMove(Maze myMap, String move) {
		boolean can = true;
		if (move.equals("D")) {
			can = myMap.canIMoveDown();
		}
		if (move.equals("U")) {
			can = myMap.canIMoveUp();
		}
		if (move.equals("L")) {
			can = myMap.canIMoveLeft();
		}
		if (move.equals("R")) {
			can = myMap.canIMoveRight();
		}
		return can;
	}
	
	// Execute the move
	public static void doMove(Maze myMap, String move) {
		if (move.equals("D")) {
			myMap.moveDown();
		}
		if (move.equals("U")) {
			myMap.moveUp();
		}
		if (move.equals("L")) {
			myMap.moveLeft();
		}
		if (move.equals("R")) {
			myMap.moveRight();
		}
		myMap.printMap();
	}
	
	public static void navigatePit(Maze myMap, String move) {
		System.out.print("\nWatch out! There's a pit ahead, jump it?\n");
		Scanner input2 = new Scanner(System.in);
		String answer = input2.nextLine();
		if ((answer.startsWith("y")) || (answer.startsWith("Y"))) {
			myMap.jumpOverPit(move);
			myMap.printMap();
		} else {
			myMap.printMap();
		}
	}

	public static String movesMessage(int total_moves) {
		if (total_moves == 50) {
			return "Warning: You have made 50 moves, you have 50 remaining before the maze exit closes";
		}
		if (total_moves == 75) {
			return "Alert! You have made 75 moves, you only have 25 moves left to escape.";
		}
		if (total_moves == 90) {
			return "DANGER! You have made 90 moves, you only have 10 moves left to escape!!";
		}
		if (total_moves == 100) {
			return "Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[";
		}
		return "";
	}
	
	public static boolean check_array(String val) {
		if(val.equals("R") || val.equals("L") || val.equals("U") || val.equals("D")) {
			return false;
		}
		return true;
	}
}
