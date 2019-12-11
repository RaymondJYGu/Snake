import comp127graphics.CanvasWindow;
import comp127graphics.FontStyle;
import comp127graphics.GraphicsText;
import comp127graphics.Image;


public class Gameplay {


    protected static final int CANVAS_WIDTH = 1310; //the specific size of the canvas is to fit the grass picture size
    protected static final int CANVAS_HEIGHT = 667; //fit the grass picture size
    protected static final double SNAKE_SQUARE = CANVAS_WIDTH * 0.025;
    protected static final int HEIGHT_FOOD_LIMIT = 800; //even w/ 200, spawn wrong
    protected static final int WIDTH_FOOD_LIMIT = 500;
    private CanvasWindow canvas;
    private Image background = new Image(0, 0, "grass.jpg");
    private Board board;

    private SnakeHead head;
    private ScoreBoard scoreBoard;


    public Gameplay() {
        canvas = new CanvasWindow("Snake!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.add(background);
        board = new Board();
        board.makeFood(canvas, Math.random() * 100,
                Math.random() * 100);
        head = new SnakeHead(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.5,
                SNAKE_SQUARE, SNAKE_SQUARE);
        canvas.add(head);
        canvas.add(head.getSnakeBodyGroup());
        scoreBoard = new ScoreBoard(CANVAS_WIDTH - 310, 50, 300, 100);
        canvas.add(scoreBoard);
        canvas.add(scoreBoard.getLabel());

        canvas.animate(() -> {
            if (head.isGameOver()) {
                gameOver();
            }
            head.moveSnake();
            board.foodEaten(head, canvas, scoreBoard);
        });

        head.checkKeyboardInput(canvas);
    }

    private void gameOver() {
        canvas.removeAll();
        GraphicsText gameOverLabel = new GraphicsText();
        gameOverLabel.setFont(FontStyle.ITALIC, CANVAS_HEIGHT * 0.025);
        gameOverLabel.setText("GAME OVER. THANKS FOR PLAYING!");
        gameOverLabel.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.5);
        canvas.add(gameOverLabel);
    }


    public static void main(String[] args) {
        new Gameplay();
    }
}