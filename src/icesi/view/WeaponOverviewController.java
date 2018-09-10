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
    	} else {
    		typeLabel.setText("");
    		ammunitionAmountLabel.setText("");
    		hurtLabel.setText("");
    	}
    }
	
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        weaponsColumn.setCellValueFactory(cellData -> cellData.getValue().getStringType());
        showWeaponDetails(null);
        weaponTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showWeaponDetails(newValue));
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        weaponTable.setItems(mainApp.getWeaponData());
    }

	public MainApp getMainApp() {
		return mainApp;
	}
	
}
