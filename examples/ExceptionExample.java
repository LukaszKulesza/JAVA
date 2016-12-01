package pl.codeme.examples;

import pl.codeme.examples.exceptions.MyException;
import pl.codeme.examples.exceptions.ParentException;

public class ExceptionExample {

	public static void main(String[] args) {
		try {
			try {
				tryException();
			} catch (ParentException e) {
				System.out.println("Dzię - ku - je - my!");
				throw e;
			}
			System.out.println("a co z tym???");
		} catch (Exception ex) {
			System.out.println("Zło, ale cóż możemy poradzić...");
		}
	}
	
	private static void tryException() throws ParentException {
		try {
//			int i = 10/1;
//			
//			int a[] = new int[10];
//			a[11] = 1;
			
//			throw new MyException("Marek");
			
			throw new ParentException();
//			System.out.println("Ostatnia linia sekcji try");
		} catch (ArithmeticException ex) {
			System.out.println("Nie psuj ("+ ex.getMessage() + ")");
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Problem z indeksem tablicy");
		} catch (RuntimeException ex) {
			System.out.println("Stało się cos grubego, czego nie przewidzieliśmy");
			System.out.println(ex);
		} catch (MyException ex) {
			System.out.println("Hurra!");
			System.out.println("Ale " + ex.getExceptionCreator() + " jest zły i psuj!");
		} finally {
			System.out.println("Ratunku albo i nie ratunku!");
		}
		
		System.out.println("Program wykonał sie poprawnie");
	}

}
