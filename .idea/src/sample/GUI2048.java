package sample;

/**
 * Created by Lauri Kukk on 11-Mar-17.
 */
public class GUI2048 {
    public static void main(String[] args) {
        Game g = new Game(2);
        g.printArray();
        for (int x = 0; x < 4; x++){
            g.addNewNumbers();
            g.printArray();
        }
    }
}
