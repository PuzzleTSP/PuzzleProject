import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuUI extends Application {

	private Scene menu, puzzle1;

	public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    	primaryStage.setFullScreen(true);
        primaryStage.setTitle("PPPP");


        //Menu scene
        Label label1= new Label("Main Menu");
        Button button1= new Button("Type 1 Puzzle");
        button1.setOnAction(e -> {primaryStage.setScene(puzzle1); primaryStage.setTitle("Puzzle1");});
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        menu= new Scene(layout1, 300, 250);


        //Puzzle1 scene
        Label label2 = new Label("Puzzle 1");
        puzzle1 = new Scene(label2, 300, 250);

       primaryStage.setScene(menu);
       primaryStage.show();
    }
}
