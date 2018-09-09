package model;

public class Weapon {
	
	//CONSTANTS
	
	public static int AX  =1;
	public static int GUN  =2;
	public static int RIFLE = 3;
	public static int SNIPER = 4;
	//ATTRIBUTES
	private int name;
	private int ammunitionAmount;
	private int hurt;
	
	//RELATIONS 
	
	//********   BUILD METHODS   ******
	
	//FIRST BUILD METHOD 
	public Weapon() {
		 name =1;
		 ammunitionAmount = 0;	 
		 hurt = 5;
	}
	
	//SECOND BUILD METHOD
	public Weapon(int name ) {
		if(name ==2) {
			ammunitionAmount = 20;
			hurt = 10;
		}else if (name ==3) {
			ammunitionAmount = 150;
			hurt= 30;
		}else if(name == 4) {
			ammunitionAmount = 10;
			hurt= 60;
		}
	}
 
	//GETTER AND SETTER METHODS 
	
	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
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
