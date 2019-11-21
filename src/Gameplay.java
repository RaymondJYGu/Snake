import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsGroup;
import comp127graphics.Image;
import javafx.scene.SceneAntialiasing;

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
        head.moveSnake(event.getPosition().getX(), event.getPosition().getY());
    });

}







    public static void main(String[] args) {
    new Gameplay();
    }
}
