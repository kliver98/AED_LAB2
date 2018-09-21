package icesi;

import java.io.IOException;
import java.util.Random;
import icesi.model.Player;
import icesi.model.Weapon;
import icesi.view.RootLayoutController;
import icesi.view.WeaponOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * 
 * @author Kliver Daniel
 *
 */
public class MainApp extends Application {

	/**
	 * Constant that represents the name of the application<br>
	 */
	public static final String APP_NAME = "Fortnite - Visual Test";
	/**
	 * Relation with the Stage of the application<br>
	 */
	private Stage primaryStage;
	/**
	 * Relation with the main layout of the application<br>
	 */
	private BorderPane rootLayout;
	/**
	 * List that represents the data of weapons stored to be recollected<br>
	 */
	private ObservableList<Weapon> weaponData = FXCollections.observableArrayList();
	/**
	 * Relation with the model by the Class Player<br>
	 */
	private Player actualPlayer;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle(APP_NAME);
        
        //App icon
        this.primaryStage.getIcons().add(new Image("file:resources/images/fortnite_1.png"));

        initRootLayout();
        showWeaponOverview();
	}
	
	/**
	 * Method that remove a weapon from the weapons of the actual user<br>
	 */
	public void removeWeaponFromStack() {
		actualPlayer.getWeapons().pop();
	}
	
	/**
	 * Method that returns the last weapon from the actual user<br> 
	 * @return the last weapon recollected by the actual user<br>
	 */
	public Weapon getWeaponFromStack() {
		return actualPlayer.getWeapons().last();
	}
	
	/**
	 * Method that delete the last weapon that actual user recollect<br>
	 * @return the last weapon before delete the last one<br>
	 */
	public Weapon deleteWeaponFromStack() {
		actualPlayer.getWeapons().pop();
		return getWeaponFromStack();
	}
	
	/**
	 * Method that add a weapon to the actual user<br>
	 * @param weapon - the new weapon that user recollect<br>
	 */
	public void addWeaponToTheStack(Weapon weapon) {
		actualPlayer.getWeapons().push(weapon);
	}
	
	/**
	 * Method that return the number of weapons collected<br>
	 * @return number of weapons that user recollected<br>
	 */
	public int sizeOftheStack() {
		return actualPlayer.getWeapons().size();
	}
	
	/**
	 * Construct a new MainApp<br>
	 */
    public MainApp() {
        // Add some sample data
    	actualPlayer = new Player();
    	Random r = new Random();
    	for (int i = 0; i < 42; i++) {
    		int val = r.nextInt(5);
    		if ( val==0 || val == 1 )
    			val += 2;
			weaponData.add(new Weapon(val));
		}
    }
	
    /**
     * Method that returns the weaponData of weapons available to recollectr.nextInt(4)
     * @return weaponData array<br>
     */
	public ObservableList<Weapon> getWeaponData() {
		return weaponData;
	}

	/**
	 * Method that show the WeaponOverview interface<br>
	 */
	public void showWeaponOverview() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/WeaponOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            
            rootLayout.setCenter(personOverview);
            
         // Give the controller access to the main app.
            WeaponOverviewController controller = new WeaponOverviewController();
            controller = loader.getController();
            controller.setMainApp(this);
            controller.initDefaultWeapon(getWeaponFromStack());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Method that initialize the rootLayout of the application<br>
	 */
	public void initRootLayout() {
        try {
        	 // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch(Exception e) {
        }
	}
	
	/**
	 * Method that returns the primaryStage<br>
	 * @return primaryStage of the application<br>
	 */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Method that returns the actualPlayer<br>
     * @return actualPlayer<br>
     */
	public Player getActualPlayer() {
		return actualPlayer;
	}

	/**
	 * Method that initialize automatically the application<br>
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
