package pl.codeme.examples.threads;

public class Competition {

	private final int distance = 1000;
	private final int minSleep = 100;
	private final int maxSleep = 500;
	private final int minRand = 5;
	private final int maxRand = 10;
	private final int competitorNo = 10;
	
	Thread[] competitors;
	
	public static void main(String[] args) {
		Competition prog = new Competition();
		
		prog.startProg();
	}

	private void startProg() {
		competitors = new Thread[this.competitorNo];
		int i;
		
		for (i=0; i<competitors.length; i++) {
			Competitor competitor = new Competitor(
				"Gracz " + i,
				this.distance,
				this.minSleep,
				this.maxSleep, 
				this.minRand,
				this.maxRand
			);
			competitors[i] = new Thread(competitor);
		}

		for (i=0; i<competitors.length; i++) {
			competitors[i].start();
		}

		int finished = 0;
		
		while (finished < 3) {
			finished = 0;
			for (i=0; i<competitors.length; i++) {
				if (!competitors[i].isAlive()) {
					finished++;
				}
			}
		}

		for (i=0; i<competitors.length; i++) {
			if (competitors[i].isAlive()) {
//				competitors[i].interrupt();
				try {
					competitors[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
