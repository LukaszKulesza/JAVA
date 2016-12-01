package pl.codeme.tictactoe.game;

public class Player {
	private String name;
	
	private char sign;

	public Player(String name, char sign) {
		super();
		this.name = name;
		this.sign = sign;
	}

	public String getName() {
		return name;
	}

	public char getSign() {
		return sign;
	}
}
