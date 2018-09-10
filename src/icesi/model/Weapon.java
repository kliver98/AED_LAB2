package icesi.model;

public class Weapon {
	
	//CONSTANTS
	/**
	 * Constant that represents the weapon ax.<br>
	 */
	public static final int AX  = 1;
	/**
	 * Constant that represents the weapon gun.<br>
	 */
	public static final int GUN  = 2;
	/**
	 * Constant that represents the weapon rifle.<br>
	 */
	public static final int RIFLE = 3;
	/**
	 * Constant that represents the weapon sniper.<br>
	 */
	public static final int SNIPER = 4;
	/**
	 * Attribute that represents the damage made by the weapon<br>
	 */
	public static final int DAMAGE = 10;
	//ATTRIBUTES
	/**
	 * Attribute that represents the type of the weapon.<br>
	 */
	private int type;
	/**
	 * Attribute that represents the ammunition amount of the weapon<br>
	 */
	private int ammunitionAmount;
	/**
	 * Attribute that represents how much hurt makes the weapon<br>
	 */
	private int hurt;
	//RELATIONS 
	
	/**
	 * Construct a Weapon by default<br>
	 * With name equals to AX, ammunitionAmount to 0, and hurt equals to 5<br>
	 */
	public Weapon() {
		type =AX;
		 ammunitionAmount = 0;	 
		 hurt = 5;
	}
	
	/**
	 * Construct a Weapon and put the ammunitonAmount and hurt depending to the type of weapon<br>
	 * @param name
	 */
	public Weapon(int type ) {
		this.type = type;
		if(type == GUN) {
			ammunitionAmount = 20;
			hurt = DAMAGE;
		}else if (type == RIFLE) {
			ammunitionAmount = 150;
			hurt= DAMAGE*3;
		}else if(type == SNIPER) {
			ammunitionAmount = 10;
			hurt= DAMAGE*6;
		}
	}
 
	//GETTER AND SETTER METHODS 
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAmmunitionAmount() {
		return ammunitionAmount;
	}

	public void setAmmunitionAmount(int ammunitionAmount) {
		this.ammunitionAmount = ammunitionAmount;
	}

	public int getHurt() {
		return hurt;
	}

	public void setHurt(int hurt) {
		this.hurt = hurt;
	}

}
