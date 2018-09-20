package icesi.model;

public class Platform {

	//CONSTANTS
	public static final String MICROSOFT = "microsoft";
	public static final String MACOS = "macos";
	public static final String XBOX = "xbox";
	public static final String PLAYSTATION = "playstation";
	

	int amountPlayerOnline;
	
	public Platform() {
		 this.amountPlayerOnline = 0;
	}
	public int getAmountPlayerOnline() {
		return amountPlayerOnline;
	}
	public void setAmountPlayerOnline(int amountPlayerOnline) {
		this.amountPlayerOnline = amountPlayerOnline;
	}
	
}

