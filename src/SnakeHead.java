import comp127graphics.Ellipse;
import comp127graphics.Rectangle;

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
        //boundaries
        if (this.getX() < 0) { //left
            setDx(0);
            //die method
        }
        if (this.getX() + Gameplay.SNAKE_SQUARE > Gameplay.CANVAS_WIDTH) { //right
            setDx(0);
        }
        if (this.getY() < 0) { //top
            setDy(0);
        }
        if (this.getY() + Gameplay.SNAKE_SQUARE > Gameplay.CANVAS_HEIGHT) { //bottom
            setDy(0);
        }

        x = x + (dx * .1);
        y = y + (dy * .1);

        this.setCenter(x, y);
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
