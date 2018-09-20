package test;



import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import icesi.model.Server;
import icesi.model.*;
import junit.framework.TestCase;


public class TestServer extends TestCase {
	private Server server;
	public TestServer() {
		// TODO Auto-generated constructor stub
	}
	
	private void stage1() {
		server = new Server();
	}
	public void testFillServer() {
		stage1();
		int expectedAmount = 199;
		int serverPlayers = 199;
		server.fillServer(199);
		assertTrue(serverPlayers == server.getServer().size());
	}
}
