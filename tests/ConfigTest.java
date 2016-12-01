package pl.codeme.tictactoe.tests;

import java.util.Properties;

import org.junit.Test;

import junit.framework.TestCase;
import pl.codeme.tictactoe.game.Config;

public class ConfigTest extends TestCase  {
	private Config config;

	protected void setUp() {
		config = new Config(ConfigTest.getTestProperties());
	}
	
	protected void tearDown() {
	}

	@Test
	public void testDefaultProperties() {
		Properties props = new Properties();
		Config config = new Config(props);
		
		assertEquals(config.getBoardHeight(), 3);
		//todo: reszta
	}
	
	@Test
	public void testLoadedProperties() {
		assertEquals(config.getBoardHeight(), 6);
		//todo: reszta
	}
	
	public static Properties getTestProperties() {
		Properties props = new Properties();
		
		props.setProperty("boardWidth", "5");
		props.setProperty("boardHeight", "6");
		props.setProperty("numberOfPlayers", "3");
		props.setProperty("winRows", "3");

		return props;
	}
}