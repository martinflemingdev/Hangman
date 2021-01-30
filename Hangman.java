package Hangman;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman{

	// create Gameword object to generate targetWord
	public static Gameword wordArray = new Gameword();
	
	//declare class variables
	public static String targetWord;
	public static String targetWordInProgress;
	public static List<String> guessedLetters;
	public static int guesses;
	
	//create class instances to begin game
	public static Scanner scanner = new Scanner(System.in);
	public static String answer = "y";
	
	public static void main(String[] args) {
		while (answer.equals("y")) {
			//set default values
			guesses = 0;
			targetWord = wordArray.getRandomWord().toLowerCase();
			targetWordInProgress = targetWord.replaceAll("\\S", "_");
			guessedLetters = new ArrayList<>();
			//start game
			printGallows();
			playHangman();
			System.out.println("Play again? (y)es or (n)o");
			answer = scanner.next().toLowerCase();
		} System.out.println("Thanks for playing! :-) Created by Martin Fleming 1.31.2021");
		scanner.close();
	}
		
		public static void playHangman() {
			while (guesses < 6 && targetWordInProgress.contains("_")) {
				System.out.println("Guess a letter in this word and press enter!");
				System.out.println(targetWordInProgress.toUpperCase().replace("", " ").trim());
				String letter = scanner.next().toLowerCase();
				while (letter.length() > 1) {
					System.out.println("Please only enter 1 letter and press enter!");
					letter = scanner.next().toLowerCase();
				}
				guessedLetters.add(letter);
				guess(letter);
				System.out.print("Letters guessed: ");
				for (String guess : guessedLetters) {
					System.out.print(guess.toUpperCase() + " ");
				} System.out.println("");
			} 
		}

//		
//	}
	
	public static void guess(String letter) {
		String inProgress = "";
		for (int i = 0; i < targetWord.length(); i++) {
				if (targetWord.charAt(i) == letter.charAt(0)) {
					inProgress += letter.charAt(0);
				} else if (targetWordInProgress.charAt(i) != '_') {
					inProgress += targetWord.charAt(i);
				} else if (targetWordInProgress.charAt(i) == '_'){
					inProgress += "_";
				}
		} if (targetWordInProgress.equals(inProgress)) { 
				guesses++;
				printGallows();
		} else {
			targetWordInProgress = inProgress;
		}
		if (targetWordInProgress.equals(targetWord)) {
			System.out.println("You have guessed the word! It was " + targetWord.toUpperCase()
			+ "! Congratulations!");
		}
	}
	
	public static void printGallows() {
		if (guesses==0) {
			System.out.println("*************Welcome to Hangman*************");
			System.out.println("  +---+");
			System.out.println("  |   |");
			System.out.println("  |");
			System.out.println("  |");
			System.out.println("  |");
			System.out.println("  |");
			System.out.println("=========");
		}
		if (guesses==1) {
			System.out.println("Your guess was wrong, try a different letter!");
			System.out.println("  +---+");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |");
			System.out.println("  |");
			System.out.println("  |");
			System.out.println("=========");
		}
		if (guesses==2) {
			System.out.println("Your guess was wrong, try a different letter!");
			System.out.println("  +---+");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |   |");
			System.out.println("  |");
			System.out.println("  |");
			System.out.println("=========");
		}
		if (guesses==3) {
			System.out.println("Your guess was wrong, try a different letter!");
			System.out.println("  +---+");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |  /|");
			System.out.println("  |");
			System.out.println("  |");
			System.out.println("=========");
		}
		if (guesses==4) {
			System.out.println("Your guess was wrong, try a different letter!");
			System.out.println("  +---+");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |  /|\\");
			System.out.println("  |");
			System.out.println("  |");
			System.out.println("=========");
		}
		if (guesses==5) {
			System.out.println("Your guess was wrong, try a different letter!");
			System.out.println("  +---+");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |  /|\\");
			System.out.println("  |  /");
			System.out.println("  |");
			System.out.println("=========");
		}
		if (guesses==6) {
			System.out.println("Game Over! The word was: " + targetWord.toUpperCase());
			System.out.println("  +---+");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |  /|\\");
			System.out.println("  |  / \\");
			System.out.println("  |");
			System.out.println("=========");
		}
	}
}
