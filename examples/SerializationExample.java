package pl.codeme.examples;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {

	public static void main(String[] args) throws IOException {
		SerializationExample se = new SerializationExample();
		
		se.testSerialize();
		se.testUnserialize();
	}
	
	private void testUnserialize() throws IOException {
		Family family = null;

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("father.serialized"));
		
		try {
			family = (Family)ois.readObject();
		} catch (ClassNotFoundException ex) {
			// todo: zaimplementoważ
		}
		
		System.out.println(family.father);
		System.out.println(family.mother);
		System.out.println(family.child);
	}
	
	private void testSerialize() throws IOException {
		Human father = new Human(61, "Waldek", Sex.MALE);
		Human mother = new Human(55, "Grażynka", Sex.FEMALE);
		Human child = new Human(25, "Brajan", Sex.MALE);
		
		Family family = new Family();
		family.father = father;
		family.mother = mother;
		family.child = child;
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("father.serialized"));
		oos.writeObject(family);
		oos.close();
	}

}
