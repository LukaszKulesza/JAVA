package pl.codeme.examples;

import java.io.Serializable;

public class Family implements Serializable {

	public Human father, mother;
	
	public transient Human child;
}
