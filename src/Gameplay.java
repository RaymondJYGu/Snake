import comp127graphics.CanvasWindow;
import comp127graphics.Image;
import comp127graphics.events.Key;

import java.util.Random;


public class Gameplay {


    protected static final int CANVAS_WIDTH = 1000; //the specific size of the canvas is to fit the grass picture size
    protected static final int CANVAS_HEIGHT = 667; //fit the grass picture size
    protected static final double SNAKE_SQUARE = CANVAS_WIDTH * 0.1;
    private CanvasWindow canvas;
    private Image background = new Image(0, 0, "grass.jpg");
    private Board board;
    Random random = new Random();

    private SnakeHead head;

    public Gameplay() {
        canvas = new CanvasWindow("Snake!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.add(background);
        board = new Board();
        board.makeFood(canvas,random.nextInt(CANVAS_WIDTH), random.nextInt(CANVAS_HEIGHT)); // fix the border alignment
        head = new SnakeHead(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.5,
                SNAKE_SQUARE, SNAKE_SQUARE);
        canvas.add(head);
        canvas.animate(() ->
                head.moveSnake());

        head.checkKeyboardInput(canvas);
    }


    public static void main(String[] args) {
        new Gameplay();
    }
}