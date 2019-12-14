import comp127graphics.CanvasWindow;
import comp127graphics.FontStyle;
import comp127graphics.GraphicsText;
import comp127graphics.Image;
import comp127graphics.ui.Button;


/**
 * Authors:
 * Shalu Patel
 * Nate Gorjance
 * Gu Jingyao
 */


public class Gameplay {
    protected static final int CANVAS_WIDTH = 1310;
    protected static final int CANVAS_HEIGHT = 667;
    protected static final int GRASS_WIDTH = 1000; //the specific size of the canvas is to fit the grass picture size
    protected static final int GRASS_HEIGHT = 667; //fit the grass picture size
    protected static final double SNAKE_SQUARE = CANVAS_WIDTH * 0.025;

    private CanvasWindow canvas;
    private Image background = new Image(0, 0, "grass.jpg");
    private Board board;
    private Button easyButton;
    private Button difficultButton;
    private SnakeHead head;
    private ScoreBoard scoreBoard;
    private Button yesButton;
    private Button noButton;
    private GraphicsText currentDifficulty;

    /**
     * Creates the object that handles running the game in an infinite loop
     */
    public Gameplay() {
        canvas = new CanvasWindow("Snake!", CANVAS_WIDTH, CANVAS_HEIGHT);
        resetGame();
        animate();
    }

    /**
     * Deletes the current active round of Snake and then creates a new one
     */
    public void resetGame() {
        canvas.removeAll();

        canvas.add(background);

        board = new Board();
        board.makeFood(canvas, Math.random() * 800, Math.random() * 500);

        head = new SnakeHead(GRASS_WIDTH * 0.5, GRASS_HEIGHT * 0.5,
                SNAKE_SQUARE, SNAKE_SQUARE);
        canvas.add(head);
        canvas.add(head.getSnakeBodyGroup());

        scoreBoard = new ScoreBoard(CANVAS_WIDTH - 305, 50, 300, 100);
        canvas.add(scoreBoard);
        canvas.add(scoreBoard.getLabel());

        currentDifficulty = new GraphicsText();
        currentDifficulty.setText("Current Difficulty: Easy");
        canvas.add(currentDifficulty);
        currentDifficulty.setCenter(scoreBoard.getCenter().getX(), scoreBoard.getCenter().getY() + currentDifficulty.getHeight() + 10);

        easyButton = new Button("Easy");
        easyButton.setPosition(scoreBoard.getCenter().getX() - 100, 300);
        canvas.add(easyButton);

        difficultButton = new Button("Difficult");
        difficultButton.setPosition(scoreBoard.getCenter().getX() + 10, 300);
        canvas.add(difficultButton);

        yesButton = new Button("Yes!");
        noButton = new Button("Nope.");

        functionality();
    }

    /**
     * handles the listeners for buttons and keyboard presses during the current active round of Snake
     */
    public void functionality() {
        head.checkKeyboardInput(canvas);

        easyButton.onClick(() -> {
            head.setSnakeSpeed(5);
            currentDifficulty.setText("Current Difficulty: Easy");
        });

        difficultButton.onClick(() -> {
            head.setSnakeSpeed(10);
            currentDifficulty.setText("Current Difficulty: Difficult");
        });

        yesButton.onClick(this::resetGame);
        noButton.onClick(() -> canvas.closeWindow());
    }

    /**
     * Handles the canvas animating function separate from the single round aspect of the game.
     * This prevents calling animate multiple times as it is not removed ever from the current canvas
     */
    public void animate() {
        canvas.animate(() -> {
            if (head.isGameOver()) {
                gameOver();
            }
            head.moveSnake();
            board.foodEaten(head, canvas, scoreBoard);
        });
    }

    /**
     * Creates the Game Over splash screen to handle resetting into a new game or exiting the application
     */
    private void gameOver() {
        canvas.removeAll();
        GraphicsText gameOverLabel = new GraphicsText();
        gameOverLabel.setFont(FontStyle.ITALIC, CANVAS_HEIGHT * 0.025);
        gameOverLabel.setText("GAME OVER. THANKS FOR PLAYING! WOULD YOU LIKE TO PLAY AGAIN?");
        gameOverLabel.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.5);
        canvas.add(gameOverLabel);
        canvas.add(yesButton);
        canvas.add(noButton);
        yesButton.setPosition(CANVAS_WIDTH * 0.35, CANVAS_HEIGHT * 0.6);
        noButton.setPosition(CANVAS_WIDTH * 0.55, CANVAS_HEIGHT * 0.6);
    }

    public static void main(String[] args) {
        new Gameplay();
    }
}