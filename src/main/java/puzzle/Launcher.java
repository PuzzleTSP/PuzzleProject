package puzzle;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Launcher extends Application {

    private Stage primaryStage;
    private BorderPane mainDisplay;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Puzzle Launcher");
        this.primaryStage.setFullScreen(true);

        initRootLayout();

//        showPersonOverview();
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Launcher.class.getResource("MainDisplay.fxml"));
            mainDisplay = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(mainDisplay);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    /**
//     * Shows the person overview inside the root layout.
//     */
//    public void showMainDisplay() {
//        try {
//            // Load person overview.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Launcher.class.getResource("view/MainDisplay.fxml"));
//            AnchorPane personOverview = (AnchorPane) loader.load();
//            
//            // Set person overview into the center of root layout.
//            rootLayout.setCenter(personOverview);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}