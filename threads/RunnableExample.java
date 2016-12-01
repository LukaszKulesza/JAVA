package pl.codeme.examples.threads;

class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Jestem watkiem");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Przerwano mnie!");
		}
		System.out.println("Koniec ze mną!");
	}
}

public class RunnableExample {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		
		Thread th = new Thread(myThread, "Oto mój pierwszy wątek");
		th.start();
		
		while(th.isAlive()) {
			System.out.println("Wątek " + th.getName() + " jeszcze działa");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Koniec programu");
			
	}

}
