package sample;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {
    private Stage stage;
    private Button buttonBack = new Button("Back");
    private Integer boardSize = 4;
    private boolean change = false;
    Game game;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;


        primaryStage.setTitle("2048");

        primaryStage.setScene(MenuScene());

        primaryStage.show();
    }
    public Scene MenuScene(){
        Button buttonStart = new Button("Start");
        Button buttonScore = new Button("Score");
        Button buttonSettings = new Button("Settings");
        Button buttonInstructions = new Button("Instructions");
        Button buttonExit = new Button("Exit");
        stage.setResizable(false);
        stage.sizeToScene();
        buttonStart.setOnAction(event -> stage.setScene(GameScene()));
        buttonScore.setOnAction(event -> stage.setScene(ScoreScene()));
        buttonSettings.setOnAction(event -> stage.setScene(SettingsScene()));
        buttonInstructions.setOnAction(event -> stage.setScene(InstructionsScene()));
        buttonExit.setOnAction(event -> Platform.exit());

        // A Pane is created
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(5);
        root.getChildren().addAll(buttonStart, buttonScore, buttonSettings, buttonInstructions, buttonExit);

        return new Scene(root, 600, 800);
    }

    public Scene GameScene(){
        game = new Game(boardSize);
        game.printArray();

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 800);
        GridPane gridPane = new GridPane();
        final int[][][] board = {game.getGameBoard()};
        StackPane [][] sp = new StackPane [boardSize][boardSize];
        for (int col = 0; col < boardSize; col++) {
            for (int row = 0; row < boardSize; row++) {
                Rectangle square = new Rectangle();
                Label text = new Label();
                sp[col][row] = new StackPane();
                sp[col][row].getChildren().addAll(square, text);
                if (board[0][col][row] != 0){
                    text.setText(Integer.toString(board[0][col][row]));
                }
                text.setTextFill(Color.WHITE);


                gridPane.add(sp[col][row], row, col);
                square.widthProperty().setValue(500 / boardSize);
                square.heightProperty().setValue(500 / boardSize);
            }
        }
        root.setCenter(gridPane);
        root.setBottom(buttonBack);
        buttonBack.setOnAction(event -> stage.setScene(MenuScene()));
        scene.setOnKeyPressed(event -> {

            switch (event.getCode()) {
                case UP:
                    game.pushUp();
                    break;
                case DOWN:
                    game.pushDown();
                    break;
                case LEFT:
                    game.pushLeft();
                    break;
                case RIGHT:
                    game.pushRight();
                    break;
                default:
                    break;
            }
            game.addNewNumbers();
            board[0] = game.getGameBoard();
            for (int col = 0; col < boardSize; col++) {
                for (int row = 0; row < boardSize; row++) {
                    sp[row][col].getChildren().remove(1);
                    Label text = new Label();
                    if (board[0][row][col] != 0) {
                        text.setText(Integer.toString(board[0][row][col]));
                    } else {
                        text.setText("");
                    }
                    text.setTextFill(Color.WHITE);
                    sp[row][col].getChildren().add(text);
                }
            }
            game.printArray();
        });


        return scene;
    }

    public Scene  ScoreScene(){
        //https://coronalabs.com/blog/2013/12/10/tutorial-howtosavescores/
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(5);
        Scene scene = new Scene(root, 600, 800);
        root.getChildren().add(buttonBack);
        buttonBack.setOnAction(event -> stage.setScene(MenuScene()));
        return scene;
    }

    public Scene SettingsScene(){
        Button button4 = new Button("4x4");
        button4.setOnAction(event -> boardSize = 4);
        Button button6 = new Button("6x6");
        button6.setOnAction(event -> boardSize = 6);
        Button button8 = new Button("8x8");
        button8.setOnAction(event -> boardSize = 8);
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(5);
        Scene scene = new Scene(root, 600, 800);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(button4, button6, button8);
        hBox.setSpacing(5);
        root.getChildren().addAll(hBox,buttonBack);
        hBox.setAlignment(Pos.CENTER);
        buttonBack.setOnAction(event -> stage.setScene(MenuScene()));
        return scene;

    }
    public Scene InstructionsScene(){
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(5);
        Label instructions = new Label("2048 - HOW TO PLAY?"
        + "\nThe objective of the game is to get the number 2048 using additions of the number two and its multiples."
        + "\nYou will have a grid of 16/36/64 tiles."
        + "\nTwo numbers will be given: usually two number ones, maybe number two."
        + "\nMove up or down, left or right trying to join two equal numbers."
        + "\nWhen two equal numbers are in touch, they will add up."
        + "\nIf we are run out of equal numbers on our grid, or we can not put them in touch,\n the game will provide us another one or a two so we can keep on playing."
        + "\nIf there are no free tiles on our grid, the game ends."
        + "\nBy adding numbers, we get higher numbers and we can approach to 2048, which is the goal of the game.");

        Scene scene = new Scene(root, 600, 800);
        root.getChildren().addAll(instructions, buttonBack);
        buttonBack.setOnAction(event -> stage.setScene(MenuScene()));
        return scene;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
