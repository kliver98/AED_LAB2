package icesi.model;


import collection.List;
import interfaces.IQueue;

public class Server {
	private IQueue<Player> server;
	public Server() {
		server = new List<Player>();

	}
	public IQueue<Player> getServer() {
		return server;
	}

	public void setServer(IQueue<Player> server) {
		this.server = server;
	}

	public void fillServer(int amountPlayers) {
		for (int i = 0; i < amountPlayers; i++) {
			server.offer(new Player());
		}
	}

}