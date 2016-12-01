package pl.codeme.examples;

import pl.codeme.examples.queue.CommonQueue;
import pl.codeme.examples.queue.Fifo;
import pl.codeme.examples.queue.MyQueue;

public class DemoQueue {

	public static void main(String[] args) {

		System.out.println(MyQueue.getNoQueues());

		Fifo kolejka = new Fifo("Kolejka 1");
		System.out.println(MyQueue.getNoQueues());

		Fifo kolejka1 = new Fifo("No i druga też");
		System.out.println(Fifo.getNoQueues());
		
		kolejka.push(10);
		kolejka.push(13);
		kolejka.push(7);

		kolejka1.push(6);
		kolejka1.push(1);
		kolejka1.push(88);

		kolejka.print();
		
		// kolejka1 posiada jedynie metody udostępnione przez interfejs CommonQueue
		// dlatego też poniższa linia nie zadziała - metoda print została zdefiniowana w MyQueue, czyli poziom wyżej
		// kolejka1.print();
	}

}
