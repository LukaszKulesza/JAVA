package pl.codeme.examples.threads;

import java.util.concurrent.ThreadLocalRandom;

public class Competitor implements Runnable {

	int currentDistance = 0;

	int distance;
	int minSleep;
	int maxSleep;
	int minRand;
	int maxRand;
	
	String name;
	
	public Competitor(String name, int distance, int minSleep, int maxSleep, int minRand, int maxRand) {
		this.name = name;
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
		this.minRand = minRand;
		this.maxRand = maxRand;
	}

	@Override
	public void run() {
		while (currentDistance < distance) {
			currentDistance += randInt(minRand, maxRand);
			System.out.println(name + " biegne już " + currentDistance);
			try {
				Thread.sleep(randInt(minSleep, maxSleep));
			} catch (InterruptedException e) {
				System.out.println(name + " przerwano mnie!");
				return;
			}
		}
		
		System.out.println(name + " skończyłem!") ;
	}

	public String toString() {
		return name + " przebieglem " + distance;
	}
	
	private int randInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}
