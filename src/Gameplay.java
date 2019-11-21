import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsGroup;
import comp127graphics.Image;
import javafx.scene.SceneAntialiasing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay {


    protected static final int CANVAS_WIDTH = 800;
    protected static final int CANVAS_HEIGHT = 600;
    protected static final double SNAKE_SQUARE = CANVAS_WIDTH * 0.025;
    private CanvasWindow canvas;
    private Image background = new Image(0,0, "grass.jpg");

    private SnakeHead head;



public Gameplay(){
    canvas = new CanvasWindow("Snake!", CANVAS_WIDTH, CANVAS_HEIGHT);
    canvas.add(background);

    head = new SnakeHead(CANVAS_WIDTH*0.5,CANVAS_HEIGHT*0.5,
            SNAKE_SQUARE, SNAKE_SQUARE);
    canvas.add(head);
    canvas.onMouseMove(event ->
    {
        head.headMove();
    });
 //   canvas.getWindowFrame().addKeyListener(new KeyListener() {
//        @Override
//        public void keyTyped(KeyEvent keyEvent) {
//            System.out.println("Gameplay.keyTyped");
//            int key = keyEvent.getKeyCode();
//
//            if (key == KeyEvent.VK_LEFT) {
//                dx = -1;
//            }
//
//            if (key == KeyEvent.VK_RIGHT) {
//                dx = 1;
//            }
//
//            if (key == KeyEvent.VK_UP) {
//                dy = -1;
//            }
//
//            if (key == KeyEvent.VK_DOWN) {
//                dy = 1;
//            }
//        }
//
//        @Override
//        public void keyPressed(KeyEvent keyEvent) {
//            System.out.println("Gameplay.keyPressed");
//        }
//
//        @Override
//        public void keyReleased(KeyEvent keyEvent) {
//            System.out.println("Gameplay.keyReleased");
//        }
//    });
}







    public static void main(String[] args) {
    new Gameplay();
    }
}
