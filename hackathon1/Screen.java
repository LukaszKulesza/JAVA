package pl.codeme.hackathon1;

public class Screen {
	private char screen[][];
	
	public Screen(int x, int y) {
		screen = new char[y][x];
	}
	
	public void draw(int x, int y, char ch) {
		screen[y][x] = ch;
	}

	public void printScreen() {
		int y, x;
		
		for (y=0; y<screen.length; y++) {
			for (x=0; x<screen[y].length; x++ ) {
				if (screen[y][x] == 0) {
					System.out.print(' ');
				} else {
					System.out.print(screen[y][x]);
				}
			}
			System.out.println();
		}
	}
	
	public void clearScreen() {
		int i;
		for (i=0; i<100; i++) {
			System.out.println();
		}
	}
}