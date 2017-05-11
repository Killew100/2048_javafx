package sample;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // A new button is created
        Button buttonStart = new Button("Start");
        Button buttonScore = new Button("Score");
        Button buttonSettings = new Button("Settings");
        Button buttonInstructions = new Button("Instructions");
        Button buttonExit = new Button("Exit");

        // Text is added to the previously created button

        // This code sets an action to said button
        // Now on a button click "Hello World" is printed to the console
        buttonStart.setOnAction(event -> System.out.println("Start"));

        // A Pane is created
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(5);
        // The button is added to the pane
        root.getChildren().addAll(buttonStart, buttonScore, buttonSettings, buttonInstructions, buttonExit);

        // This code creates a new scene with a fixed size of 300x300 pixels
        Scene scene = new Scene(root, 300, 300);

        // This text is shown at the top right-hand corner of the window (stage)
        primaryStage.setTitle("Hello World");

        // The scene is added to the stage
        primaryStage.setScene(scene);

        // This code shows the created application
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
