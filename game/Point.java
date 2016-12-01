package pl.codeme.tictactoe.game;

public class Point {
	private Player owner = null;

	public Point(Player owner) {
		super();
		this.owner = owner;
	}

	public Player getOwner() {
		return owner;
	}
}
