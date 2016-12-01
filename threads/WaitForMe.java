package pl.codeme.examples.threads;

public class WaitForMe implements Runnable {

	SharedResource res;
	
	public WaitForMe(SharedResource res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		synchronized(res) {
			System.out.println("WaitForMe wchodzi w sekcje synchronized");

			try {
				res.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("WaitForMe kończy sekcje synchronized");
		}
	}

}
