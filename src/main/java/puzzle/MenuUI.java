import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuUI extends Application {

	private Stage stage = null;
	private Scene menu;

	public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    	stage = primaryStage;
    	initialize();

    }

    public void initialize() {
    	stage.setFullScreen(true);
        stage.setTitle("PPPP");


        //Menu scene
        Label label1= new Label("Main Menu");
        Button button1= new Button("Type 1 Puzzle");
        button1.setOnAction(e -> new PuzzleType1(stage));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        menu= new Scene(layout1, 300, 250);

        stage.setScene(menu);
        stage.show();
    }
}
