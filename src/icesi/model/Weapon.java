package icesi.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
	private IntegerProperty type;
	/**
	 * Attribute that represents the string type of the weapon;
	 */
	private final StringProperty stringType;
	/**
	 * Attribute that represents the ammunition amount of the weapon<br>
	 */
	private IntegerProperty ammunitionAmount;
	/**
	 * Attribute that represents how much hurt makes the weapon<br>
	 */
	private IntegerProperty hurt;
	//RELATIONS 
	
	/**
	 * Construct a Weapon by default<br>
	 * With name equals to AX, ammunitionAmount to 0, and hurt equals to 5<br>
	 */
	public Weapon() {
		this(AX);
	}
	
	/**
	 * Construct a Weapon and put the ammunitonAmount and hurt depending to the type of weapon<br>
	 * @param name
	 */
	public Weapon(int type) {
		this.type = new SimpleIntegerProperty(type);
		ammunitionAmount = new SimpleIntegerProperty(0);
		hurt = new SimpleIntegerProperty(0);
		stringType = new SimpleStringProperty("");
		if (type==AX) {
			ammunitionAmount = new SimpleIntegerProperty(120);
			hurt = new SimpleIntegerProperty(DAMAGE-5);
			stringType.setValue("AX");
		}else if(type == GUN) {
			ammunitionAmount = new SimpleIntegerProperty(20);
			hurt = new SimpleIntegerProperty(DAMAGE);
			stringType.setValue("GUN");
		}else if (type == RIFLE) {
			ammunitionAmount = new SimpleIntegerProperty(150);
			hurt= new SimpleIntegerProperty(DAMAGE*3);
			stringType.setValue("RIFLE");
		}else if(type == SNIPER) {
			ammunitionAmount = new SimpleIntegerProperty(10);
			hurt= new SimpleIntegerProperty(DAMAGE*3);
			stringType.setValue("SNIPER");
		}
	}
 
	//GETTER AND SETTER METHODS 
	
	public IntegerProperty getType() {
		return type;
	}

	public void setType(IntegerProperty type) {
		this.type = type;
	}

	public IntegerProperty getAmmunitionAmount() {
		return ammunitionAmount;
	}

	public void setAmmunitionAmount(IntegerProperty ammunitionAmount) {
		this.ammunitionAmount = ammunitionAmount;
	}

	public IntegerProperty getHurt() {
		return hurt;
	}

	public void setHurt(IntegerProperty hurt) {
		this.hurt = hurt;
	}

	public StringProperty getStringType() {
		return stringType;
	}

}
