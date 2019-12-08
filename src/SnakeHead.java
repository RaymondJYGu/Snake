import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import comp127graphics.Rectangle;
import comp127graphics.events.Key;

public class SnakeHead extends Rectangle {

    private Ellipse eye;


    private final double SNAKE_SPEED = 1;

    private double dx;
    private double dy;
    private double x;
    private double y;

    public SnakeHead(double x, double y, double width, double height) {
        super(x, y, width, height);
        setFilled(true);
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
    }

    public void moveSnake() {
        checkBoundaries();
        x = x + (dx * SNAKE_SPEED);
        y = y + (dy * SNAKE_SPEED);

        this.setCenter(x, y);
    }

    public void moveLeft(){
        setDx(-1);
        setDy(0);
    }

    public void moveRight(){
        setDx(1);
        setDy(0);
    }

    public void moveUp(){
        setDx(0);
        setDy(-1);
    }

    public void moveDown(){
        setDx(0);
        setDy(1);
    }

    public void checkKeyboardInput(CanvasWindow canvas) {
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.UP_ARROW) {
                moveUp();  // change direction to upwards when the key goes down
            }
            if (event.getKey() == Key.DOWN_ARROW) {
                moveDown();  // change direction to downwards when the key goes down
            }
            if (event.getKey() == Key.LEFT_ARROW) {
                moveLeft();  // change direction to left when the key goes down
            }
            if (event.getKey() == Key.RIGHT_ARROW) {
                moveRight();  // change direction to right when the key goes down
            }
        });
    }

    public void checkBoundaries() {
        if (this.getX() < 0) { //left
            setDx(0);
            setDy(0);
            //die method
        }
        if (this.getX() + Gameplay.SNAKE_SQUARE > Gameplay.CANVAS_WIDTH) { //right
            setDx(0);
            setDy(0);
        }
        if (this.getY() < 0) { //top
            setDx(0);
            setDy(0);
        }
        if (this.getY() + Gameplay.SNAKE_SQUARE > Gameplay.CANVAS_HEIGHT) { //bottom
            setDx(0);
            setDy(0);
        }
    }

    public double getSNAKE_SPEED() {
        return SNAKE_SPEED;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }


}