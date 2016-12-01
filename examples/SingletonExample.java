package pl.codeme.examples;

public class SingletonExample {

	private static SingletonExample myObj = null;
	
	private SingletonExample() {
		System.out.println("Tworzę instancję");
	}

	public static SingletonExample getSingleton() {
		if (myObj == null) {
			myObj = new SingletonExample();
		}
		
		return myObj;
	}
}