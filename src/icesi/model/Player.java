package icesi.model;

import interfaces.IStack;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import collection.List;

public class Player {
	
	
	//CONSTANTS
	//ATTRIBUTES
	/**
	 * Attribute that represents the ranking of the player<br>
	 */
	private int ranking;
	/**
	 * Attribute that represents user's nickname<br>
	 */
	private  String nickName;
	/**
	 * Attribute that represents the ping that user has to the server<br>
	 */
	private int ping;
	/**
	 * Attribute that represents the platform where the user is connected<br>
	 */
	private String platform;
	/**
	 * Attribute that represents the weapons that user have been collected<br>
	 */
	private IStack<Weapon> weapons;
	//RELATIONS
	
	/**
	 * Construct a Player with the specified nickName<br>
	 * @param nickName of the user<br>
	 */
	public Player() {
		fillArrayNames();
		weapons = new List<Weapon>();
		this.nickName = nameRandomPlayer(nameRandom());
		this.ranking = rankingRandom();
		this.platform = randomPlatformOnline();
		this.ping = generatePing();
		initDefault();
	}
	
	private void initDefault() {
		weapons.push(new Weapon());
	}
	
	//GETTER AND SETTER METHODS
	
	public void modificarR(int x) {
		ranking =x;
	}
	public int getRanking() {
		return ranking;
	}
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public long getPing() {
		return ping;
	}
	
	public void setPing(int ping) {
		this.ping = ping;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public IStack<Weapon> getWeapons() {
		return weapons;
	}
	
	public void setWeapons(IStack<Weapon> weapons) {
		this.weapons = weapons;
	}
	
	public void increaseRanking() {
		ranking+=50;
	}
	public void increaseRanking(int kills) {
		ranking +=5*kills;
	}
	public double probabilityWin(double RankingEnemy) {
		return 1/(1+Math.pow(10, (RankingEnemy-ranking)/400));
	}
	public int nameRandom() {
		return (int) (Math.random() * 161);
	}
	public int rankingRandom() {
		return (int) (Math.random() * 2100);
	}
	public String nameRandomPlayer(int nameRandom) {
		return fillArrayNames().get(nameRandom);
	}

	public String randomPlatformOnline(){
		Random random  = new Random();
		int randomPlatform = random.nextInt(4-0)+0;
		String[] platforms = {Platform.MACOS,Platform.MICROSOFT,Platform.PLAYSTATION, Platform.XBOX};
		return platforms[randomPlatform];
	}
	
	public int generatePing() {
		Random c =  new Random();
		int generatePing = c.nextInt(1000-1)+1
				;
		return generatePing;
	}

	
	public ArrayList<String> fillArrayNames() {
		ArrayList<String> namesPlayers = new ArrayList<String>();
		String names = "";
		try {
			String bfRead = "";
			String temp = "";
			BufferedReader bf = new BufferedReader(new FileReader("playerNames.txt"));
			try {
				while ((bfRead = bf.readLine()) != null) {
		namesPlayers.add(bfRead);
				}

	names = temp;
} catch (IOException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	}

} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return namesPlayers;
}
	
}
