package pl.codeme.hackathon1;

import pl.codeme.tictactoe.input.Keyboard;

public class Hangman {

	Screen screen;
	Keyboard input = new Keyboard();
	
	int gameState = 0;
	private final int lastState = 6;
	
	String word;
	char guessedWord[];
	
	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		
		hangman.start();
	}

	private Hangman() {
		screen = new Screen(50, 50);
	}

	private void printGuessedWord() {
		int i;
		
		for(i=0; i<guessedWord.length; i++) {
			if (guessedWord[i] == 0) {
				System.out.print('_');
			} else {
				System.out.print(guessedWord[i]);
			}
		}
	}

	private void printGameScreen() {
		screen.clearScreen();
		
		// todo: odczytać i wyświetlić rysunek z pliku
		System.out.println("PROBA " + gameState + "/" + lastState);
		System.out.print("Wyraz: ");
		printGuessedWord();
	}

	private boolean checkLetter(char ch) {
		int i;
		boolean found = false;
		
		for(i=0; i<word.length(); i++) {
			if (word.charAt(i) == ch) {
				found = true;
				guessedWord[i] = ch;
			}
		}
		
		return found;
	}

	private void start() {
		char ch;
		
		word = "krokus";
		word = word.toUpperCase();
		
		guessedWord = new char[word.length()];
		
		while(gameState < lastState) {
			printGameScreen();

			ch = input.readChar();
			if (checkLetter(ch) ) {
				String tmpWord = new String(guessedWord);
				if (tmpWord.equals(word)) {
					System.out.println("WYGRALES");
					return;
				}
			} else {
				gameState++;
			}
		}

		System.out.println("JESTEŚ MARTWY");
	}
}
