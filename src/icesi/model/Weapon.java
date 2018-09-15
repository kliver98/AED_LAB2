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
		 * Attribute that represents the string type of the weapon;
		 */
		private String stringType;
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
			this(AX);
			ammunitionAmount = 0;
		}
		
		/**
		 * Construct a Weapon and put the ammunitonAmount and hurt depending to the type of weapon<br>
		 * @param name
		 */
		public Weapon(int type) {
			this.type = type;
			ammunitionAmount = 0;
			hurt = 0;
			stringType = "";
			if (type==AX) {
				ammunitionAmount = 120;
				hurt = DAMAGE-5;
				stringType= "AX";
			}else if(type == GUN) {
				ammunitionAmount = 20;
				hurt = DAMAGE;
				stringType = "GUN";
			}else if (type == RIFLE) {
				ammunitionAmount = 150;
				hurt= DAMAGE*3;
				stringType = "RIFLE";
			}else if(type == SNIPER) {
				ammunitionAmount = 10;
				hurt= DAMAGE*3;
				stringType = "SNIPER";
			}

		}
		//GETTER AND SETTER METHODS 



		public int getType() {

			return type;

		}

	//hola

		public void setType(int type) {

			this.type = type;

		}



		public String getStringType() {

			return (stringType);

		}



		public void setStringType(String stringType) {

			this.stringType = stringType;

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
