package pl.codeme.examples.screen;

public class DemoScreen {

	private static void print(char[][] screen) {
		int x, y;
		
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
				if (screen[y][x]==0) { 
					System.out.print(' ');
				} else {
					System.out.print(screen[y][x]);
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
	
	public static void main(String[] args) {
		char ekran[][];
		int wyskosc = 5;
		int szerokosc = 10;
		
		ekran = new char[wyskosc][szerokosc];

		ekran[1][1] = 'C';
		ekran[0][2] = 'o';
		ekran[1][3] = 'd';
		ekran[0][4] = 'e';
		ekran[1][5] = ':';
		ekran[0][6] = 'M';
		ekran[1][7] = 'E';

		print(ekran);
	}

}
