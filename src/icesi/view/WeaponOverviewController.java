package icesi.view;

import icesi.MainApp;
import icesi.model.Weapon;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class WeaponOverviewController {

	 @FXML
	 private TableView<Weapon> weaponTable;
	 @FXML
	 private TableColumn<Weapon, String> weaponsColumn;
	 
	 @FXML
	 private Label stringTypeLabel;
	 @FXML
	 private Label typeLabel;
	 @FXML
	 private Label ammunitionAmountLabel;
	 @FXML
	 private Label hurtLabel;
	 @FXML
	 private Label sizeWeaponsLabel;
	
	private MainApp mainApp;
	
	public WeaponOverviewController() {
	}
	
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
    
    @FXML
    private void handleReloadWeapon() {
    	System.out.println("I'm reloading");
    }
    
    @FXML
    private void handleDropWeapon() {
    	mainApp.removeWeaponFromStack();
    	showWeaponDetails(mainApp.getWeaponFromStack());
    }
    
    private void collectWeapon(Weapon weapon) {
    	mainApp.addWeaponToTheStack(weapon);
    }
	
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    	weaponsColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStringType()));
       	showWeaponDetails(null);
        weaponTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> collectWeapon(newValue));
        weaponTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showWeaponDetails(newValue));
    }
    
    public void initDefaultWeapon(Weapon weapon) {
    	this.showWeaponDetails(weapon);
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        weaponTable.setItems(mainApp.getWeaponData());
    }

	public MainApp getMainApp() {
		return mainApp;
	}
	
}
