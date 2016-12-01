package pl.codeme.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CollectionExample {

	public static void main(String[] args) {

		System.out.println("List example");
		listExample();
		
		System.out.println("\n\nHash example");
		hashExample();
	}

	private static void hashExample() {
		HashMap hm = new HashMap();
		hm.put("h1", "ha jeden");
		hm.put("h4", "ha jeden");
		hm.put("6666s", "ha jeden");
		
		System.out.println(hm.get("h1"));
		
		Set ks = hm.keySet();
		Object allKeys[] = ks.toArray();
		
		int i;
		for(i=0; i<allKeys.length; i++) {
			System.out.println(allKeys[i]);
		}
	}
	
	private static void listExample() {
		ArrayList<String> myList = new ArrayList<String>();

		myList.add("Marek");
		myList.add("Zegarek");
		myList.add("Zbyszek");
		
		System.out.println("Klasyczny for");
		int i;
		for (i=0; i<myList.size(); i++) {
			System.out.println(myList.get(i));
		}
		// petla for each
		System.out.println("Konstrunkcja z \":\"");
		for(String e: myList) {
			System.out.println(e);
		}
		// iterator iteruje po kolejnych wierszach 
		System.out.println("Explicite iterator");
		Iterator it = myList.iterator();
		while(it.hasNext()) {
			System.out.println((String) it.next());
		}

	}
}
