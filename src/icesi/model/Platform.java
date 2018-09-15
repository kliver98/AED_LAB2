package icesi.model;

public class Platform {

	//CONSTANTS
	/**
	 * Constant that represents the platform for Microsoft users<br>
	 */
	public static final String MICROSOFT = "Microsoft";
	/**
	 * Constant that represents the platform for Nintendo users<br>
	 */
	public static final String NINTENDO = "Nintendo";
	/**
	 * Constant that represents the platform for PlayStation users<br>
	 */
	public static final String PLAYSTATION = "PlayStation";
	
	
	String typePlatform;
	public Platform( String typePlatform) {
		 this.typePlatform = typePlatform;
		
	}
	public String getTypePlatform() {
		return typePlatform;
	}
	public void setTypePlatform(String typePlatform) {
		this.typePlatform = typePlatform;
	}
	
	
}
