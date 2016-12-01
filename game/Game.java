package pl.codeme.tictactoe.game;

import pl.codeme.tictactoe.UserInterface;
import pl.codeme.tictactoe.game.exceptions.GameInvalidCoordinates;

public class Game {
	private Board board;

	private Player players[];
	private Player player;
	private Player p1;

	private int turn;

	private Config config;

	public Game(Config config, Player players[]) {
		this.config = config;
		this.players = players;
		turn = 0;

		board = new Board(config.getBoardWidth(), config.getBoardHeight());
	}

	public void insert(int x, int y) throws GameInvalidCoordinates {
		board.insert(x, y, getCurrentPlayer());// przenosimy do boarda
		nextPlayer();// dodajemy do turna +1
	}

	private void nextPlayer() {
		turn++;
		if (turn == config.getNumberOfPlayers()) {
			turn = 0;
		}
	}

	public Player getCurrentPlayer() {
		return players[turn];
	}

	public Player[] getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}

	public GameStatus getGameState() throws NullPointerException{
		//status wygranaint
		int x = 1;

		for(int i  = 0; i< board.getBoard().length; i++){
			for(int j = 0; j<board.getBoard()[i].length; j++){
	//			Point y3 =
				//zapytac o wartosc domyslna

				if(board.getBoard()[i][j] != null){
				//System.out.println(board.getBoard()[i][j]);
//			char x1=getCurrentPlayer().getSign();
//			char x2=getCurrentPlayer().getSign();

					//warunek na wygrana w poziomie
				
						for(int m= 1; m<= config.getWinRows(); m++)
						{
							System.out.println(board.getBoard()[i+m][j]);
							
							if (i+m>board.getBoard().length){
								System.out.println("nie da sie wykonac out of bounds");
								break;
							}
							//Point y3 = board.getBoard()[i+m][j];
//							else if(x1==x2){
//							System.out.println("udalo sie");
//							x++;
//							
//						}	
					}
					
					//warunek na wygrana w pionie
		/*			for(int m= 1; m< config.getWinRows(); m++){
						if( board.getBoard()[i][j+m] ==  y2){
							x++;
						}else{
							x=1;
							break;
						}
						
					}
					//warunek na wygrana po skosie w dół
					for(int m= 1; m< config.getWinRows(); m++){
						if( board.getBoard()[i+m][j+m]== y2){
							x++;
						}else{
							x=1;
							break;
						}
						
					}
					//warunek na wygrana po skosie w góre
					
					for(int m= 1; m< config.getWinRows(); m++){
						if( board.getBoard()[i+m][j-m] == y2 ){
							x++;
						}else{
							x=1;
							break;
						}
						
					}*/
					
		
				}
				
			}
		}
		//status remis
		int y = 0;
		for(int i  = 0; i< board.getBoard().length; i++){
			for(int j = 0; j>board.getBoard()[i].length; j++){
				if(board.getBoard() != null){
					y++;
				}
			}
		}
		int y1 = config.getBoardHeight()*config.getBoardWidth();
		//warunek na remis
		
		if(y== y1){
			System.out.println("draw");
			return GameStatus.DRAW;
		}
		//warunek na wygrana
		
		else if(x>config.getWinRows()){
			return GameStatus.GAME_OVER;
		}else {
			return GameStatus.IN_PROGRESS;
		}

	}

	public String toString() {
		// TODO: implement
		return "";
	}
}
