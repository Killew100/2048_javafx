package sample;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // A new button is created
        Button button = new Button();

        // Text is added to the previously created button
        button.setText("Click here to print 'Hello World'");

        // This code sets an action to said button
        // Now on a button click "Hello World" is printed to the console
        button.setOnAction(event -> System.out.println("Hello World"));

        // A Pane is created
        StackPane root = new StackPane();

        // The button is added to the pane
        root.getChildren().add(button);

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
