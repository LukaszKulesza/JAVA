package pl.codeme.examples.queue;

public abstract class MyQueue implements CommonQueue {
	
	protected int queue[];

	private String name;

	private static int noQueues = 0;
	
	private final int maxQueues = 10;
	
	static {
		System.out.println("Ładuję klasę");
	}
			
	MyQueue(String name) {
		this.name = name;
		this.queue = new int[0];
		System.out.println(this);
		noQueues++;
	}

	public static int getNoQueues() {
		return noQueues;
	}

	public final int getMaxQueues() {
		return maxQueues;
	}

	public String getName() {
		return name;
	}
	
	public void print() {
		System.out.print("Kolejka " + getName() + ":");
		
		int l = 0;

		for(l=0; l<queue.length; l++) {
			System.out.print("" + queue[l] + ' ');
		}
		
		System.out.println();
	}
}
