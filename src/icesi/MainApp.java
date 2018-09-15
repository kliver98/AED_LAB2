package icesi;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
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

public class MainApp extends Application {

	public static final String APP_NAME = "Fortnite - Visual Test";
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Weapon> weaponData = FXCollections.observableArrayList();
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
	
	public void removeWeaponFromStack() {
		actualPlayer.getWeapons().pop();
		System.out.println("Size: "+actualPlayer.getWeapons().size());
	}
	
	public Weapon getWeaponFromStack() {
		return actualPlayer.getWeapons().last();
	}
	
	public void addWeaponToTheStack(Weapon weapon) {
		actualPlayer.getWeapons().push(weapon);
	}
	
    public MainApp() {
        // Add some sample data
    	actualPlayer = new Player("Test");
    	actualPlayer.chargeWeaponsOfTest();
    	for (int i = 0; i < 42; i++) {
			weaponData.add(new Weapon((i%3)+2));
		}
    }
	
	public ObservableList<Weapon> getWeaponData() {
		return weaponData;
	}

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
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
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
	
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public File getWeaponFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

	public Player getActualPlayer() {
		return actualPlayer;
	}

	public void setActualPlayer(Player actualPlayer) {
		this.actualPlayer = actualPlayer;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
