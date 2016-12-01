package pl.codeme.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesExample {

	public static void main(String[] args) {
		Properties props;
//		props = System.getProperties();
		props = new Properties();
		
		try {
			props.load(new FileInputStream("konfiguracja.properties"));
		} catch (IOException ex) {
		}
		
		Set<String> keys = props.stringPropertyNames();
		
		for(String key : keys) {
			System.out.println(key + ": " + props.getProperty(key));
		}
	}

}
