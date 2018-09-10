package icesi;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import icesi.model.Weapon;
import icesi.model.WeaponListWrapper;
import icesi.view.RootLayoutController;
import icesi.view.WeaponOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static final String APP_NAME = "Fortnite - Visual Test";
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ObservableList<Weapon> weaponData = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle(APP_NAME);

        // Set the application icon.
//        this.primaryStage.getIcons().add(new Image("file:resources/images/icon_main.png"));

        initRootLayout();
        showWeaponOverview();
	}
	
    public MainApp() {
        // Add some sample data
    	weaponData.add(new Weapon());
    	weaponData.add(new Weapon(2));
    	weaponData.add(new Weapon());
    	weaponData.add(new Weapon(1));
    	weaponData.add(new Weapon(1));
    	weaponData.add(new Weapon(2));
    	weaponData.add(new Weapon(3));
    	weaponData.add(new Weapon(1));
    	weaponData.add(new Weapon(2));
    	weaponData.add(new Weapon(1));
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
    
    public void setWeaponFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle(APP_NAME + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle(APP_NAME);
        }
    }
    
    public void loadWeaponDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(WeaponListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            WeaponListWrapper wrapper = (WeaponListWrapper) um.unmarshal(file);

            weaponData.clear();
            weaponData.addAll(wrapper.getPersons());

            // Save the file path to the registry.
            setWeaponFilePath(file);

        } catch (Exception e) { // catches ANY exception
//            Dialogs.create()
//                    .title("Error")
//                    .masthead("No se pudo cargar el archivo desde:\n" + file.getPath())
//                    .showException(e);
        }
    }
    
    public void savePersonDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(WeaponListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            WeaponListWrapper wrapper = new WeaponListWrapper();
            wrapper.setWeapons(weaponData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setWeaponFilePath(file);
        } catch (Exception e) { // catches ANY exception
//            Dialogs.create().title("Error")
//                    .masthead("Could not save data to file:\n" + file.getPath())
//                    .showException(e);
        }
    }

	public static void main(String[] args) {
		launch(args);
	}
}
