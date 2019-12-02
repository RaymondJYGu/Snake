import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsGroup;
import comp127graphics.Image;
import javafx.scene.SceneAntialiasing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay {


    protected static final int CANVAS_WIDTH = 800;
    protected static final int CANVAS_HEIGHT = 600;
    protected static final double SNAKE_SQUARE = CANVAS_WIDTH * 0.1;
    private CanvasWindow canvas;
    private Image background = new Image(0,0, "grass.jpg");

    private SnakeHead head;



public Gameplay(){
    canvas = new CanvasWindow("Snake!", CANVAS_WIDTH, CANVAS_HEIGHT);
    canvas.add(background);

    head = new SnakeHead(CANVAS_WIDTH*0.5,CANVAS_HEIGHT*0.5,
            SNAKE_SQUARE, SNAKE_SQUARE);
    canvas.add(head);
    canvas.animate(() ->
            head.moveSnake());


//    canvas.onMouseMove(event ->
//    {
//        head.moveSnake((event.getPosition().getX()), event.getPosition().getY());
//    });
    canvas.getWindowFrame().addKeyListener(new KeyListener() {
        @Override
        /**
         * @Author: code taken from https://stackoverflow.com/questions/10876491/how-to-use-keylistener
         */
        public void keyTyped(KeyEvent keyEvent) {System.out.println("Gameplay.keyTyped"); }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            System.out.println("Gameplay.keyPressed");
            int key = keyEvent.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                head.setDx(-1);
                head.setDy(0);
            }

            if (key == KeyEvent.VK_RIGHT) {
                head.setDx(1);
                head.setDy(0);
            }

            if (key == KeyEvent.VK_UP) {
                head.setDx(0);
                head.setDy(-1);
            }

            if (key == KeyEvent.VK_DOWN) {
                head.setDx(0);
                head.setDy(1);
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            System.out.println("Gameplay.keyReleased");
        }
    });
}







    public static void main(String[] args) {
    new Gameplay();
    }
}
