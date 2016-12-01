package pl.codeme.examples;

import java.io.IOException;

public class GuessNumber {

	private final int minVal = 10;
	private final int maxVal = 27;
	
	public static void main(String[] args) {
		char ch;
		String userNumber = "";
		int guess;
		
		while(true) {
			try {
				userNumber = "";
				
				ch = (char)System.in.read();
				do {
					if (ch == 13 || ch == 10) {
						ch = (char)System.in.read();
						continue;
					}
					userNumber += ch;
					ch = (char)System.in.read();
				} while(System.in.available() > 0);
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Wprowadzona liczba: " + userNumber);
			
			try {
				guess = Integer.valueOf(userNumber);
			} catch (NumberFormatException e) {
				System.out.println("Proszę wprowadzić liczbę całkowitą!");
			}
		}
	}

}
