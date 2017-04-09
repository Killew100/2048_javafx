package sample;
import java.util.Random;
import java.util.ArrayList;

/**
 * GUI.
 * Created by Lauri Kukk on 11-Mar-17.
 */
class Game {
    private int num;
    private int[][] gameBoard;

    public int getPoints() {
        return points;
    }

    private int points = 0;

    Game(int num){
        this.num = num;
        gameBoard = new int[num][num];
    }

    private Integer getgameBoardLength(){
        return this.gameBoard.length;
    }
    void printArray() {
        for (int[] i: gameBoard){
            for (int y: i){
                System.out.print(" " + Integer.toString(y) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void addNewNumbers() {
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

    void pushUp(){
        System.out.println("UP");
        boolean[] alreadyCombined = new boolean[this.num];
        for(int y = 0; y < this.num; y++){
            for(int x = 1; x < this.num; x++){
                if (gameBoard[x][y] != 0){
                    int value = gameBoard[x][y];
                    int X = x - 1;
                    while((X >= 0) && (gameBoard[X][y] == 0)) {
                        X--;
                    }
                    if (X == -1){
                        gameBoard[0][y] = value;
                        gameBoard[x][y] = 0;
                    } else if (gameBoard[X][y] != value){
                        gameBoard[X+1][y] = value;
                        gameBoard[x][y] = 0;
                    } else {
                        if(alreadyCombined[X]){
                            gameBoard[X+1][y] = value;
                            gameBoard[x][y] = 0;
                        } else {
                            gameBoard[X][y] *= 2;
                            points += gameBoard[X][y];
                            alreadyCombined[X] = true;
                            gameBoard[x][y] = 0;
                        }
                    }
                }
            }
        }
    }

    void pushDown(){
        System.out.println("DOWN");
        boolean[] alreadyCombined = new boolean[this.num];
        for(int y = 0; y < this.num; y++){
            for(int x = this.num - 2; x > -1; x--){
                if (gameBoard[x][y] != 0){
                    int value = gameBoard[x][y];
                    int X = x + 1;
                    while((X <= this.num - 1) && (gameBoard[X][y] == 0)) {
                        X++;
                    }
                    if (X == this.num){
                        gameBoard[this.num - 1][y] = value;
                        gameBoard[x][y] = 0;
                    } else if (gameBoard[X][y] != value){
                        gameBoard[X-1][y] = value;
                        gameBoard[x][y] = 0;
                    } else {
                        if(alreadyCombined[X]){
                            gameBoard[X-1][y] = value;
                            gameBoard[x][y] = 0;
                        } else {
                            gameBoard[X][y] *= 2;
                            points += gameBoard[X][y];
                            alreadyCombined[X] = true;
                            gameBoard[x][y] = 0;
                        }
                    }
                }

            }
        }
    }
    void pushLeft(){
        System.out.println("LEFT");
        boolean[] alreadyCombined = new boolean[this.num];
        for(int x = 0; x < this.num; x++){
            for(int y = 1; y < this.num; y++){
                if (gameBoard[x][y] != 0){
                    int value = gameBoard[x][y];
                    int Y = y - 1;
                    while((Y >= 0) && (gameBoard[x][Y] == 0)) {
                        Y--;
                    }
                    if (Y == -1){
                        gameBoard[x][0] = value;
                        gameBoard[x][y] = 0;
                    } else if (gameBoard[x][Y] != value){
                        gameBoard[x][Y + 1] = value;
                        gameBoard[x][y] = 0;
                    } else {
                        if(alreadyCombined[Y]){
                            gameBoard[x][Y + 1] = value;
                            gameBoard[x][y] = 0;
                        } else {
                            gameBoard[x][Y] *= 2;
                            points += gameBoard[x][Y];
                            alreadyCombined[Y] = true;
                            gameBoard[x][y] = 0;
                        }
                    }
                }

            }
        }
    }

    void pushRight(){
        System.out.println("RIGHT");
        boolean[] alreadyCombined = new boolean[this.num];
        for(int x = 0; x < this.num; x++){
            for(int y = this.num - 2; y > -1; y--){
                if (gameBoard[x][y] != 0){
                    int value = gameBoard[x][y];
                    int Y = y + 1;
                    while((Y <= this.num - 1) && (gameBoard[x][Y] == 0)) {
                        Y++;
                    }
                    if (Y == this.num){
                        gameBoard[x][this.num - 1] = value;
                        gameBoard[x][y] = 0;
                    } else if (gameBoard[x][Y] != value){
                        gameBoard[x][Y - 1] = value;
                        gameBoard[x][y] = 0;
                    } else {
                        if(alreadyCombined[Y]){
                            gameBoard[x][Y - 1] = value;
                            gameBoard[x][y] = 0;
                        } else {
                            gameBoard[x][Y] *= 2;
                            points += gameBoard[x][Y];
                            alreadyCombined[Y] = true;
                            gameBoard[x][y] = 0;
                        }
                    }
                }

            }
        }
    }

}
