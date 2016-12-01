package pl.codeme.examples;

import java.io.Serializable;

public class Human implements Serializable {

	private int age;
	protected String name;
	public Sex sex;
	
	public Human(int age, String name, Sex sex) {
		this.age = age;
		this.name = name;
		this.sex = sex;
	}
	
	public boolean isOld() {
		return (age > 60);
	}
	
	public String toString() {
		return "Jestem " + name + " i mam " + age + " lat. Jestem też " + sex + " i jestem z tego dumny!";
	}
}
