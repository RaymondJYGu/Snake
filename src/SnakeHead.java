import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsGroup;
import comp127graphics.Point;
import comp127graphics.Rectangle;
import comp127graphics.events.Key;

public class SnakeHead extends Rectangle {

    private SnakeBody snakeBody;

    private double snakeSpeed = 5;
    private double dx;
    private double dy;
    private double x;
    private double y;
    private Point previousPosition;
    private String currentDirection = "none";
    private boolean gameOver = false;

    /**
     * This creates the SnakeHead object
     *
     * @param x      the x position to create the object at
     * @param y      the y position to create the object at
     * @param width  the width of the bounding Rectangle that is SnakeHead
     * @param height the height of the bounding Rectangle that is SnakeHead
     */
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

    /**
     * Handles the functionality of checking death conditions (boundaries and touching body)
     * and then moves the SnakeHead according to the current snakeSpeed
     */
    public void moveSnake() {
        checkBoundaries();
        setPreviousPosition(getPosition());
        snakeBody.intersects(this);
        snakeBody.bodyMove(this);
        x = x + (dx * snakeSpeed);
        y = y + (dy * snakeSpeed);
        this.setPosition(x, y);

    }

    /**
     * Creates the limited movement aspect of snake in the cardinal directions
     * This method handles the left/west moving motion
     */
    public void moveLeft() {
        setDx(-1);
        setDy(0);
    }

    /**
     * Creates the limited movement aspect of snake in the cardinal directions
     * This method handles the right/east moving motion
     */
    public void moveRight() {
        setDx(1);
        setDy(0);
    }

    /**
     * Creates the limited movement aspect of snake in the cardinal directions
     * This method handles the up/north moving motion
     */
    public void moveUp() {
        setDx(0);
        setDy(-1);
    }

    /**
     * Creates the limited movement aspect of snake in the cardinal directions
     * This method handles the down/south moving motion
     */
    public void moveDown() {
        setDx(0);
        setDy(1);
    }

    /**
     * This is the keyboard listener handler that checks for user input for movement and then moves accordingly
     *
     * @param canvas the canvas that listens to the keyboard inputs
     */
    public void checkKeyboardInput(CanvasWindow canvas) {
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.UP_ARROW && !(currentDirection.equals("down"))) {
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

    /**
     * Handles the checking for the bounding edges of the snake game
     */
    public void checkBoundaries() {
        if (this.getX() < 0) { //left
            setDx(0);
            setDy(0);
            gameOver = true;
        }
        if (this.getX() + Gameplay.SNAKE_SQUARE > Gameplay.GRASS_WIDTH) { //right
            setDx(0);
            setDy(0);
            gameOver = true;
        }
        if (this.getY() < 0) { //top
            setDx(0);
            setDy(0);
            gameOver = true;
        }
        if (this.getY() + Gameplay.SNAKE_SQUARE > Gameplay.GRASS_HEIGHT) { //bottom
            setDx(0);
            setDy(0);
            gameOver = true;
        }
    }

    /**
     * Calls the grow function to increase the SnakeBody size
     */
    public void snakeGrow() {
        snakeBody.grow();
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

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setSnakeSpeed(double snakeSpeed) {
        this.snakeSpeed = snakeSpeed;
    }
}