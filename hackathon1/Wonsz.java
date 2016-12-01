package pl.codeme.hackathon1;

public class Wonsz {
    Screen scr;
	int direction;
	
	public static void main(String[] args) {
		Wonsz w = new Wonsz();
	}
	
	private Wonsz() {
		scr = new Screen(30, 30);
		direction = 1;
		int length = 25;
		int point[] = new int[2];
		
		point[0] = 0;
		point[1] = 0;
		
		while(length>0) {
			point = drawLine(point[0], point[1], length, direction);
			nextDirection();
			length = length - 2;
		}
		
		scr.printScreen();
	}

	private int[] drawLine(int x, int y, int length, int direction) {
		int i;
		int ret[] = new int[2];
	
		ret[0] = x;
		ret[1] = y;
		
		for(i=0; i<length; i++) {
			switch (direction) {
				case 1: // idziemy w dol
					scr.draw(x, y+i, '*');
					ret[1]++;
					break;
				case 2: // idziemy w prawo
					scr.draw(x+i, y, '*');
					ret[0]++;
					break;
				case 3: // idziemy w gore
					scr.draw(x, y-i, '*');
					ret[1]--;
					break;
				case 4: // idziemy w lewo
					scr.draw(x-i, y, '*');
					ret[0]--;
					break;
			}
		}
		
		return ret;
	}
	
	private void nextDirection() {
		if (direction == 4) {
			direction = 1;
		} else {
			direction++;
		}
	}
}
