package pl.codeme.tictactoe.view;

public enum UnicodeFrames2 implements FrameDefinition2 {
	LEFT_UPPER('\u250C', "lewa góra"),
	RIGHT_UPPER ('\u2510', "prawa góra"),
	LEFT_BOTTOM ('\u2514', "lewy dół"),
	RIGHT_BOTTOM ('\u2518', "prawy dół"),
	LEFT_CROSS ('\u251C', "lewy  krzyżyk"),
	RIGHT_CROSS ('\u2524', "prawy krzyżyk"),
	UPPER_CROSS ('\u252C', "górny krzyżyk"),
	BOTTOM_CROSS ('\u2534', "dolny krzyżk"),
	CROSS ('\u253C', "krzyżyk"),
	VERTICAL_LINE ('\u2502', "linia pozioma"),
	HORIZONTAL_LINE ('\u2500', "linia pionowa");
	
	
	private char character;
	private String description;
	
	private UnicodeFrames2(char character, String description) {
		this.character = character;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return "" + character;
	}
}
