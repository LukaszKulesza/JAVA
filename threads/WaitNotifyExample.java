package pl.codeme.examples.threads;

public class WaitNotifyExample {

	public static void main(String[] args) {
		SharedResource res = new SharedResource();

		WaitForMe wfm = new WaitForMe(res);
		Notificator nfm = new Notificator(res);

		Thread th1 = new Thread(wfm);
		Thread th2 = new Thread(nfm);
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
			System.out.println("Koniec programu");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
