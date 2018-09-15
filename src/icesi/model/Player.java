package icesi.model;

import interfaces.IStack;
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
	private long ping;
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
	public Player(String nickName) {
		ranking = 0;
		weapons = new List<Weapon>();
	}
	
	public void chargeWeaponsOfTest() {
		weapons.push(new Weapon());
		for (int i = 1; i < 10; i++) {
			int val = (i%4)+1;
			if ( val<2 )
				val = 2;
			weapons.push(new Weapon(val));
		}
	}
	
	//GETTER AND SETTER METHODS
	
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

	public void setPing(long ping) {
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

}
