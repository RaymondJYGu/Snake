import comp127graphics.*;
import comp127graphics.events.Key;

import java.util.ArrayList;
import java.util.List;

public class SnakeHead extends Rectangle {

    private Ellipse eye;
    private SnakeBody snakeBody;

    private final double SNAKE_SPEED = 1;

    private double dx;
    private double dy;
    private double x;
    private double y;
    private Point previousPosition;
    private String currentDirection = "none";

    public SnakeHead(double x, double y, double width, double height) {
        super(x, y, width, height);
        setFilled(true);
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.previousPosition = getPosition();
        snakeBody = new SnakeBody(getCenter().getX() - width, getY(), width, height);
    }

    public void moveSnake() {
        checkBoundaries();
        setPreviousPosition(getPosition());
        snakeBody.bodyMove(this);
        x = x + (dx * SNAKE_SPEED);
        y = y + (dy * SNAKE_SPEED);
        this.setPosition(x, y);

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
            if (event.getKey() == Key.UP_ARROW && !(currentDirection.equals("down"))){
                moveUp();  // change direction to upwards when the key goes down
                currentDirection = "up";
            }
            if (event.getKey() == Key.DOWN_ARROW && !(currentDirection.equals("up"))) {
                moveDown();  // change direction to downwards when the key goes down
                currentDirection = "down";
            }
            if (event.getKey() == Key.LEFT_ARROW && !(currentDirection.equals("right"))) {
                moveLeft();  // change direction to left when the key goes down
                currentDirection = "left";
            }
            if (event.getKey() == Key.RIGHT_ARROW && !(currentDirection.equals("left"))) {
                moveRight();  // change direction to right when the key goes down
                currentDirection = "right";
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

    public void snakeGrow() {
        snakeBody.grow();
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

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public Point getPreviousPosition() {
        return previousPosition;
    }

    public void setPreviousPosition(Point previousPosition) {
        this.previousPosition = previousPosition;
    }

    public GraphicsGroup getSnakeBodyGroup() {
        return snakeBody.getSnakeBody();
    }
}