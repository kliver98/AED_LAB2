package icesi.view;

import icesi.MainApp;
import icesi.model.Weapon;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class WeaponOverviewController {
	
	/**
	 * Attribute that has the table view<br>
	 */
	@FXML
	private TableView<Weapon> weaponTable;
	/**
	 * Attribute that has the columns of the table<br>
	 */
	@FXML
	private TableColumn<Weapon, String> weaponsColumn;
	/**
	 * Attribute that has the Label of type string<br>
	 */
	@FXML
	private Label stringTypeLabel;
	/**
	 * Attribute that has the Label of type integer<br>
	 */
	@FXML
	private Label typeLabel;
	/**
	 * Attribute that has the Label of ammunition<br>
	 */
	@FXML
	private Label ammunitionAmountLabel;
	/**
	 * Attribute that has the Label of hurt<br>
	 */
	@FXML
	private Label hurtLabel;
	/**
	 * Attribute that has the Label of number of weapon<br>
	 */
	@FXML
	private Label sizeWeaponsLabel;
	/**
	 * Relation with the mainApp<br>
	 */
	private MainApp mainApp;
	
	/**
	 * Construct a new WeaponOverviewController<br>
	 */
	public WeaponOverviewController() {
	}
	
	/**
	 * Method that show the weapon details in the window<br>
	 * @param weapon to be shown<br>
	 */
	private void showWeaponDetails(Weapon weapon) {
		if ( weapon!=null ) {
			typeLabel.setText(weapon.getType()+"");
			ammunitionAmountLabel.setText(weapon.getAmmunitionAmount()+"");
			hurtLabel.setText(weapon.getHurt()+"");
			stringTypeLabel.setText(weapon.getStringType()+"");
		} else {
			typeLabel.setText("");
			ammunitionAmountLabel.setText("");
			hurtLabel.setText("");
			stringTypeLabel.setText("");
		}
		if ( mainApp != null ) {
			int size = mainApp.sizeOftheStack();
			sizeWeaponsLabel.setText(size+"");
		}
	}
	
	/**
	 * Method that is enabled with the button of shot weapon<br> 
	 */
	@FXML
	private void handleShotWeapon() {
		Weapon actual = mainApp.getWeaponFromStack();
		int actual_am = actual.getAmmunitionAmount();
		if ( actual_am > 0 ) {
			actual.setAmmunitionAmount(actual_am-1);
		}
		actual_am -= 1;
		if ( actual_am == 0 ) {
			actual = mainApp.deleteWeaponFromStack();
		}
		showWeaponDetails(actual);
	}
	
	/**
	 * Method that is enabled with the button of drop weapon<br> 
	 */
	@FXML
	private void handleDropWeapon() {
		mainApp.removeWeaponFromStack();
		showWeaponDetails(mainApp.getWeaponFromStack());
	}
	
	/**
	 * Method that collect a new Weapon<br>
	 * @param weapon
	 */
	private void collectWeapon(Weapon weapon) {
		mainApp.addWeaponToTheStack(weapon);
	}
	
	/**
	 * Method that initialize the application<br>
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		weaponsColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStringType()));
		showWeaponDetails(null);
		weaponTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> collectWeapon(newValue));
		weaponTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showWeaponDetails(newValue));
	}
	
	/**
	 * Method that initialize the default weapon details<br>
	 * @param weapon to be shown<br>
	 */
	public void initDefaultWeapon(Weapon weapon) {
		this.showWeaponDetails(weapon);
	}
	
	/**
	 * Method that modified the mainApp relation and put the new items<br>
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		weaponTable.setItems(mainApp.getWeaponData());
	}
	
}
