package icesi.view;

import icesi.MainApp;
import javafx.fxml.FXML;

public class RootLayoutController {

	private MainApp mainApp;
	
	@FXML
    private void handleExit() {
		System.exit(0);
	}
	
	/**
     * Opens an about dialog.
     */
    @FXML
    private void handleHowItWorks() {
        System.out.println("Hi you! Welcome to our app\n"
        		+ "In the left part of this window you'll see a list with a guns"
        		+ "\n\there you can choose which you want to recolect by selecting this."
        		+ "\nIn the right part if this window you'll see three buttons that allow you"
        		+ "\n\tto make actions such as: Shot,Reload and Drop the actual gun."
        		+ "\nAt least in the middle you have information about the weapon you have"
        		+ "\n\tThe name/type of the weapon.\n"
        		+ "\tThe ammount of munition.\n"
        		+ "\tAnd how much hurt this weapon does.");
        System.out.println("In the upper parte of this window you'll see a bar menu that have three options."
        		+ "File will allow you to save the weapons you already have and also charge some other"
        		+ "\n\tconfiguration of weapons previously and close the application"
        		+ "\nSee will allow you to see information of your actual weapon or how many weapons do you have."
        		+ "\nThe last tab it's about: this will show you information of who created the app as well the version and"
        		+ "\n\tAnd how does this app works (This part).");
        System.out.println("Thank you and I'll hope you enjoy this! :)");
    }
	
    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        System.out.println("Created by Kliver \n"
        		+ "App version: 0.9.01\n"
        		+ "Released: September/15/2018\n"
        		+ "*I don't know how to open a windows like a JDialogPane in javaFX*");
    }
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

	public MainApp getMainApp() {
		return mainApp;
	}
	
}
