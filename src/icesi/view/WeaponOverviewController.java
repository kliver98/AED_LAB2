package icesi.view;

import icesi.MainApp;
import icesi.model.Weapon;
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
    }
    
    @FXML
    private void handleShootWeapon() {
    	System.out.println("I'm shooting");
    }
    
    @FXML
    private void handleReloadWeapon() {
    	System.out.println("I'm reloading");
    }
    
    @FXML
    private void handleDropWeapon() {
    	mainApp.removeWeaponFromStack();
    	Weapon weapon = mainApp.getWeaponFromStack();
    	showWeaponDetails(weapon);
    }
    
    private void collectWeapon(Weapon weapon) {
    	//Code to add the weapon into the stack
    	mainApp.addWeaponToTheStack(weapon);
    	System.out.println(mainApp.getActualPlayer().getWeapons().size());
    	System.out.println("Hey! It works");
    }
	
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        weaponsColumn.setCellValueFactory(cellData -> cellData.getValue().getStringTypeProperty());
        showWeaponDetails(null);
        weaponTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showWeaponDetails(newValue));
        weaponTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> collectWeapon(newValue));
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        weaponTable.setItems(mainApp.getWeaponData());
    }

	public MainApp getMainApp() {
		return mainApp;
	}
	
}
