package pl.codeme.hackathon.snail;

public class Snail {

	private final int screenWidth = 50;
	private final int screenHeight = 50;
	
	private char screen[][];
	
	public static void main(String[] args) {
		Snail snail = new Snail();
	
		Point point = new Point(0, 0);
		int width = 49;
		Direction direction = Direction.DOWN;
		
		while (width > 0) {
			point = snail.line(point, width, direction);
			width += -1;
			direction = snail.nextDirection(direction);
		}
		
		snail.print();
	}
	

	private Direction nextDirection(Direction prevDirection) {
		// lepiej w enumie
		switch (prevDirection) {
			case DOWN:
				return Direction.RIGHT;
			case RIGHT:
				return Direction.UP;
			case UP:
				return Direction.LEFT;
			case LEFT:
				return Direction.DOWN;
		}
		
		return null;
	}
	
	private Point line(Point start, int width, Direction direction) {
		int i, startPoint, stopPoint;
		
		switch (direction) {
			case RIGHT:
				startPoint = start.getX();
				stopPoint = startPoint + width;
				for(i=startPoint; i<stopPoint; i++) { 
					screen[start.getY()][i] = '*';
				}
				start.setX(stopPoint);
				break;
			case LEFT:
				startPoint = start.getX();
				stopPoint = startPoint - width;
				for(i=startPoint; i>stopPoint; i--) { 
					screen[start.getY()][i] = '*';
				}
				start.setX(stopPoint);
				break;
			case DOWN:
				startPoint = start.getY();
				stopPoint = startPoint + width;
				for(i=startPoint; i<stopPoint; i++) { 
					screen[i][start.getX()] = '*';
				}
				start.setY(stopPoint);
				break;
			case UP:
				startPoint = start.getX();
				stopPoint = startPoint - width;
				for(i=startPoint; i>stopPoint; i--) { 
					screen[i][start.getX()] = '*';
				}
				start.setY(stopPoint);
				break;
		}
		
		return start;
	}
	
	private void print() {
		int x, y;
		
		for(y=0; y<screen.length; y++) {
			for (x=0; x<screen[y].length; x++) {
				if (screen[y][x] == 0) {
					System.out.print(' ');
				} else {
					System.out.print(screen[y][x]);
				}
			}
			System.out.println();
		}
	}
	
	private Snail() {
		screen = new char[screenHeight][screenWidth]; 
	}

}
