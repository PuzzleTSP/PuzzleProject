package puzzle;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import puzzle.view.MainMenuController;

public class PuzzleLauncher extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Puzzle Launcher");
        this.primaryStage.setFullScreen(true);
		
        initRootLayout();
        
        showMainMenu();
	}
	
	public void initRootLayout() {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PuzzleLauncher.class.getResource("view/RootDisplay.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showMainMenu() {
		try {
			// Load main menu
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PuzzleLauncher.class.getResource("view/MainMenu.fxml"));
            BorderPane mainMenu = (BorderPane) loader.load();
            
            // Set main menu as center of root
            rootLayout.setCenter(mainMenu);
            
            // Give the controller access to the app
            MainMenuController controller = loader.getController();
            controller.setApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public void setCenterDisplay(Pane newCenter) {
    	rootLayout.setCenter(newCenter);
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}