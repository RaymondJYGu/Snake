import comp127graphics.Ellipse;
import comp127graphics.Rectangle;

public class SnakeHead extends Rectangle {

    private Ellipse eye;


    public SnakeHead(double x, double y, double width, double height) {
        super(x, y, width, height);
        setFilled(true);


    }

    public void moveSnake(double newX, double newY) {
        this.setPosition(newX, newY);
        if (this.getX() < 0) {
            this.setPosition(0, newY);
        } else if (this.getX() + Gameplay.SNAKE_SQUARE > Gameplay.CANVAS_WIDTH) {
            this.setPosition(Gameplay.CANVAS_WIDTH - Gameplay.SNAKE_SQUARE, newY);
        }
        else if (this.getY() + Gameplay.SNAKE_SQUARE < 0){
            this.setPosition(newX, 0);
        }
        else if (this.getY() + Gameplay.SNAKE_SQUARE > Gameplay.CANVAS_HEIGHT){
            this.setPosition(newX, Gameplay.CANVAS_HEIGHT-Gameplay.SNAKE_SQUARE);
        }
    }
}
