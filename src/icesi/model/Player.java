package icesi.model;

public class Player {


	//CONSTANTS
	//ATTRIBUTES
	private int ranking;
	private  String nickName;
	private long ping;
	
	
	//RELATIONS 
	//BUILD METHOD
	
	public Player(String nickName) {
		ranking = 0;	
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
	
	
	
	
	
	
	
	

}
