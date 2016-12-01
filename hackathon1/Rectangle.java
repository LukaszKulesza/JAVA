package pl.codeme.hackathon1;

public class Rectangle {
	Screen scr;
	
	public static void main(String[] args) {
		Rectangle rc = new Rectangle();
	}

	private Rectangle() {
		scr = new Screen(50, 30);
		rectInRect(29, 10, 6, 9);
		scr.printScreen();
	}
	
	private void rectInRect(int outerWidth, int innerWidth, int posX, int posY) {
		drawRectangle(0, 0, outerWidth);
		drawRectangle(posX, posY, innerWidth);
	}
	
	private void drawRectangle(int startX, int startY, int width) {
		int i;
		
		for (i=0; i<=width; i++) {
			scr.draw(startX+0, startY+i, '*');
			scr.draw(startX+i, startY+0, '*');
			scr.draw(startX+width, startY+i, '*');
			scr.draw(startX+i, startY+width, '*');
		}
	}
}
