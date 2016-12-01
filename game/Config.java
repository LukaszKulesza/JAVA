package pl.codeme.tictactoe.game;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private int boardWidth;

	private int boardHeight;

	private int numberOfPlayers;

	private int winRows;
	
	public Config() {
		Properties configProperties = new Properties();

		try {
			configProperties.load(new FileInputStream("konfiguracja.properties"));
		} catch (IOException ex) {
			// todo: implement!
		}

		setConfigFromProperties(configProperties);
	}

	public Config(Properties configProperties) {
		setConfigFromProperties(configProperties);
	}
	
	private void setConfigFromProperties(Properties configProperties) {
		setBoardWidth(Integer.valueOf(configProperties.getProperty("boardWidth", "10")));
		setBoardHeight(Integer.valueOf(configProperties.getProperty("boardHeight", "10")));
		setNumberOfPlayers(Integer.valueOf(configProperties.getProperty("numberOfPlayers", "2")));
		setWinRows(Integer.valueOf(configProperties.getProperty("winRows", "3")));
	}
	
	public int getBoardWidth() {
		return boardWidth;
	}

	public void setBoardWidth(int boardWidth) {
		this.boardWidth = boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public void setBoardHeight(int boardHeight) {
		this.boardHeight = boardHeight;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public int getWinRows() {
		return winRows;
	}

	public void setWinRows(int winRows) {
		this.winRows = winRows;
	}
	
}
