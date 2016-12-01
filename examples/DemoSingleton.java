package pl.codeme.examples;

public class DemoSingleton {

	public static void main(String[] args) {
		/*
		SingletonExample s1 = SingletonExample.getSingleton();
		SingletonExample s2 = SingletonExample.getSingleton();

//		SingletonExample s3 = new SingletonExample();
		
		System.out.println(s1);
		System.out.println(s2);
		*/
		
		Person osoba = new Person();
		int wiek = 10;
		
		osoba.setAge(10);
		osoba.setName("Zbyszek");
		
		System.out.println(osoba);
		System.out.println("Wiek " + wiek);
		
		DemoSingleton.czary(osoba, wiek);
		
		System.out.println(osoba);
		System.out.println("Wiek " + wiek);
	}

	private static void czary(Object p, int w) {
		Person czlek;
		czlek = (Person) p;
		czlek.setAge(100);
		w=100;
	}
}
