package icesi.model;

import collection.*;
import interfaces.*;

public class Fornite {

	private Robot robot;

	private IQueue<Player> rookieLevelPlayers;
	private IQueue<Player> mediumLevelPlayers;
	private IQueue<Player> expertLevelPlayers;
	
	private  IQueue<Player>[] pings;
	private Server server;
	private int games;

	public Fornite() {
		server = new Server();
		robot = new Robot();
		games = 0;
		rookieLevelPlayers = new List<Player>();
		mediumLevelPlayers = new List<Player>();
		expertLevelPlayers = new List<Player>();
		pings = new List[9];
		pings[0] = new List<Player>();
		pings[1] = new List<Player>();
		pings[2] = new List<Player>();
		pings[3] = new List<Player>();
		pings[4] = new List<Player>();
		pings[5] = new List<Player>();
		pings[6] = new List<Player>();
		pings[7] = new List<Player>();
		pings[8] = new List<Player>();

	}
 
	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public void increaseGames() {
		games++;
	}

	public void fillLevels(Player player) {
		double probabilityWin = player.probabilityWin(robot.getRanking());
		if (probabilityWin >= 0.240) {
				typePing(player, 6,7, 8);
			expertLevelPlayers.offer(player);
		} else if(probabilityWin < 0.240 && probabilityWin > 0.053) {
				typePing(player, 3,4, 5);
			mediumLevelPlayers.offer(player);
		} else if (probabilityWin < 0.053) {
			typePing(player, 0,1, 2);
			rookieLevelPlayers.offer(player);
		}
	}
	
	public void typePing(Player player, int a, int b, int c) {
		if(player.getPing() < 200) {
			pings[a].offer(player);
		}else if (player.getPing() > 200 && player.getPing() < 500) {
			pings[b].offer(player);
		}else {
			pings[c].offer(player);
		}
	}

	public void checkQueue(IQueue queue) {
		double operationAmount = (double) queue.size() / 100;
		int amountToStart = (int) operationAmount;
		double x = Math.floor(operationAmount);
		double y = operationAmount - x;
		double d = y * 100;
		int amountToWait = (int) d;
		while (queue.size() > amountToWait) {
			queue.poll();
		}
	}

	public void analyzeServerPlayers() {
		while(server.getServer().size()>0) {
			fillLevels(server.getServer().poll());
		}
	}
	
	public void setupFornite(int generateServer) {
		if (generateServer == 0) {
			server.fillServer(10);
			analyzeServerPlayers();
			for (int i = 0; i < pings.length; i++) {
				checkQueue(pings[i]);
			}
		}
	}

}
