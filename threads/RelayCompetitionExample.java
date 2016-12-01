package pl.codeme.examples.threads;

import java.util.concurrent.ThreadLocalRandom;

class Stick {
	public int distance = 0;
	public String name = "";
}

class RelayCompetitor implements Runnable {
	
	Stick stick;
	
	int distance;
	int minSleep;
	int maxSleep;
	int minRand;
	int maxRand;
	
	String name;
	
	public RelayCompetitor(Stick stick, String name, int distance, int minSleep, int maxSleep, int minRand, int maxRand) {
		this.stick = stick;
		this.name = name;
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
		this.minRand = minRand;
		this.maxRand = maxRand;
	}

	@Override
	public void run() {
		while (stick.distance < distance) {
			synchronized (stick) {
				stick.distance = stick.distance + randInt(minRand, maxRand);
			}
			System.out.println(name + " biegne już " + stick.distance);
			try {
				Thread.sleep(randInt(minSleep, maxSleep));
			} catch (InterruptedException e) {
				System.out.println(name + " przerwano mnie!");
				return;
			}
		}
		
		System.out.println(name + " skończyłem! Druzyna " + stick.name + " wygrywa!") ;
	}

	public String toString() {
		return name + " przebieglem " + distance;
	}
	
	private int randInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

}

public class RelayCompetitionExample {

	private static final int distance = 1000;
	private static final int minSleep = 100;
	private static final int maxSleep = 500;
	private static final int minRand = 5;
	private static final int maxRand = 10;
	private static final int competitorNo = 10;
	
	
	public static void main(String[] args) {
		RelayCompetitionExample prog = new RelayCompetitionExample();

		Stick stick1 = new Stick();
		stick1.name = "Druzyna 1";
		Stick stick2 = new Stick();
		stick2.name = "Druzyna 2";
		
		RelayCompetitor p1 = getCompetitor("p1", stick1);
		RelayCompetitor p2 = getCompetitor("p2", stick1);

		RelayCompetitor p3 = getCompetitor("p3", stick2);
		RelayCompetitor p4 = getCompetitor("p4", stick2);
		
		Thread[] players = new Thread[4];
		players[0] = new Thread(p1);
		players[1] = new Thread(p2);
		players[2] = new Thread(p3);
		players[3] = new Thread(p4);
		
		int i;
		for (i=0; i<players.length; i++) {
			players[i].start();
		}

		for (i=0; i<players.length; i++) {
			try {
				players[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static RelayCompetitor getCompetitor(String player, Stick stick) {
		return new RelayCompetitor(
			stick,
			"Gracz " + player,
			distance,
			minSleep,
			maxSleep, 
			minRand,
			maxRand
		);
	}
}
