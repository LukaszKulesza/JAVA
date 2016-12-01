package pl.codeme.examples.queue;

public class Fifo extends MyQueue {

	public Fifo(String name) {
		super(name);
	}

	public void push(int x) {
	  int newQueue[] = new int[queue.length+1];

	  int l;

	  // kopiujemy jedną tablicę do drugiej
	  for(l=0;l<queue.length; l++) {
		  newQueue[l] = queue[l];
	  }
	  
	  newQueue[newQueue.length-1] = x;
	  
	  queue = newQueue;
	}

	// Nie uda się zadeklarować, poeniważ metoda ta jest final w getMaxQueues
//	public int getMaxQueues() {
//	  return 0;
//	}
	
	public int pop() {
		int result;
		
		result = queue[0];
		
		int newQueue[] = new int[queue.length-1];
		int i;

		for(i=0; i<newQueue.length; i++) {
			newQueue[i] = queue[i+1];
		}
		
		queue = newQueue;
		
		return result;
	}
}
