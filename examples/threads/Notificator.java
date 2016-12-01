package pl.codeme.examples.threads;

public class Notificator implements Runnable {

	SharedResource myresource;

	public Notificator(SharedResource myresource) {
		this.myresource = myresource;
	}

	@Override
	public void run() {
		synchronized (myresource) {
			System.out.println("Notificator wchodzi w sekcję synchronized");

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			myresource.notify();
			
			System.out.println("Notificator kończy sekcję synchronized");
		}
		
	}
}
