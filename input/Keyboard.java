package pl.codeme.tictactoe.input;

import java.io.IOException;

public class Keyboard {
	public String readLine() {
		String userInput = "";
		char ch;
		
		try {
			userInput = "";
			
			do {
				ch = (char)System.in.read();
				if (ch != 13 && ch != 10) {
					userInput += ch;
				}
			} while(System.in.available() > 0);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userInput;
	}
	
	public char readChar() {
		char ch = 0;
		
		try {
			ch = (char)System.in.read();
			while(System.in.available()>0) {
				System.in.read();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return ch;
	}
	
	public static void main(String args[]) {
		Keyboard k = new Keyboard();
		System.out.println("Wczytałem: " + k.readLine());
		System.out.println();
	}
}
