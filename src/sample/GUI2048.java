package sample;

/**
 * Created by Lauri Kukk on 11-Mar-17.
 */
public class GUI2048 {
    public static void main(String[] args) {
        Game g = new Game(4);
        g.printArray();
        for (int x = 0; x < 3; x++){
            g.addNewNumbers();
            g.printArray();
            g.pushUp();
            g.printArray();
            g.addNewNumbers();
            g.printArray();
            g.pushRight();
            g.printArray();
            g.addNewNumbers();
            g.printArray();
            g.pushDown();
            g.printArray();
            g.addNewNumbers();
            g.printArray();
            g.pushLeft();
            g.printArray();
        }
    }
}
