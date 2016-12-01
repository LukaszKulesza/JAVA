package pl.codeme.tictactoe.game;

import pl.codeme.tictactoe.game.exceptions.FieldOccupiedException;

public class Board {
	private Point board[][];

	Board (int x, int y) {
		board = new Point[y][x];
	}

	public void insert(int x, int y, Player player) throws FieldOccupiedException {
		// TODO: wyrzucić odpowiedni wyjątek jeśli pole zajęte!
		board[x][y] = new Point(player);
	}
	
	public Point[][] getBoard() {
		return board;
	}
}
