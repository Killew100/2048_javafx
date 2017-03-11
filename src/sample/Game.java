package sample;
import java.util.Random;
import java.util.ArrayList;

/**
 * Created by Lauri Kukk on 11-Mar-17.
 */
public class Game {
    private int[][] gameBoard;

    public Game(int num){
        gameBoard = new int[num][num];
    }

    public Integer getgameBoardLength(){
        return this.gameBoard.length;
    }
    public void printArray() {
        for (int[] i: gameBoard){
            for (int y: i){
                System.out.print(" " + Integer.toString(y) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void addNewNumbers() {
        Random random = new Random();
        ArrayList<Integer> emptyX = new ArrayList<>();
        ArrayList<Integer> emptyY = new ArrayList<>();
        for (int x = 0; x < getgameBoardLength(); x++){
            for (int y = 0; y < getgameBoardLength(); y++){
                if (gameBoard[x][y] == 0){
                    emptyX.add(x);
                    emptyY.add(y);
                }
            }
        }
        int choice = random.nextInt(emptyX.size());
        int numberChooser = random.nextInt(10);
        int newNum = 1;
        if (numberChooser == 0){
            newNum = 2;
        }
        int X = emptyX.get(choice);
        int Y = emptyY.get(choice);
        gameBoard[X][Y] = newNum;
    }

}
