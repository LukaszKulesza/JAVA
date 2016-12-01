package pl.codeme.tictactoe.view;

import pl.codeme.examples.screen.UnicodeFrames2;
import pl.codeme.tictactoe.game.Board;
import pl.codeme.tictactoe.game.Point;

public class Renderer {

	public void renderBoard(Board board) {
		int x, y;
		
		Point screen[][] = board.getBoard();
		
		// rysujemy górną linię
		System.out.print(UnicodeFrames2.LEFT_UPPER);
		
        for (x=0; x<screen[0].length; x++) {
        	System.out.print(UnicodeFrames2.HORIZONTAL_LINE);
        	if (x+1<screen[0].length) {
        		System.out.print(UnicodeFrames2.UPPER_CROSS);
        	}
        }

		System.out.print(UnicodeFrames2.RIGHT_UPPER);
		System.out.println();
		
		// rysujemy zawartość tabeli
		for (y=0; y<screen.length; y++) {
			
			//  rysujemy zawartość wiersza

			// pierwszy znak - ramka
			System.out.print(UnicodeFrames2.VERTICAL_LINE);
			
			// pozostałe znaki - zawartość tabeli oddzielona separatorem
			for(x=0; x<screen[y].length; x++) {
				if (screen[y][x]==null) { 
					System.out.print(' ');
				} else {
					System.out.print(screen[y][x].getOwner().getSign());
				}
				
        		System.out.print(UnicodeFrames2.VERTICAL_LINE);
			}
			
			System.out.println();
			
			// jeśli to nie jest ostatnia linia z danymi
			// to rysujemy linię oddzialającą
			if (y+1<screen.length) {
				System.out.print(UnicodeFrames2.LEFT_CROSS);

				for(x=0; x<screen[y].length; x++) {
					System.out.print(UnicodeFrames2.HORIZONTAL_LINE);
					
					// separator
		        	if (x+1<screen[y].length) {
		        		System.out.print(UnicodeFrames2.CROSS);
		        	}
				}
				System.out.print(UnicodeFrames2.RIGHT_CROSS);
				System.out.println();
			}
		}

		// rysujemy dolną linię
		System.out.print(UnicodeFrames2.LEFT_BOTTOM);
		
        for (x=0; x<screen[0].length; x++) {
        	System.out.print(UnicodeFrames2.HORIZONTAL_LINE);
        	if (x+1<screen[0].length) {
        		System.out.print(UnicodeFrames2.BOTTOM_CROSS);
        	}
        }

		System.out.print(UnicodeFrames2.RIGHT_BOTTOM);
		System.out.println();
	
	}
}
