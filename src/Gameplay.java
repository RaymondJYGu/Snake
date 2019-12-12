import comp127graphics.CanvasWindow;
import comp127graphics.FontStyle;
import comp127graphics.GraphicsText;
import comp127graphics.Image;
import comp127graphics.ui.Button;


public class Gameplay {


    protected static final int CANVAS_WIDTH = 1310;
    protected static final int CANVAS_HEIGHT = 667;
    protected static final int GRASS_WIDTH = 1000; //the specific size of the canvas is to fit the grass picture size
    protected static final int GRASS_HEIGHT = 667; //fit the grass picture size
    protected static final double SNAKE_SQUARE = CANVAS_WIDTH * 0.025;
    private CanvasWindow canvas;
    private Image background = new Image(0, 0, "grass.jpg");
    private Board board;
    Button easyButton;
    Button difficultbutton;
    private SnakeHead head;
    private ScoreBoard scoreBoard;


    public Gameplay() {
        canvas = new CanvasWindow("Snake!", CANVAS_WIDTH, CANVAS_HEIGHT);
        head = new SnakeHead(GRASS_WIDTH * 0.5, GRASS_HEIGHT * 0.5,
                SNAKE_SQUARE, SNAKE_SQUARE);
        scoreBoard = new ScoreBoard(CANVAS_WIDTH - 310, 50, 300, 100);
        board = new Board();
        easyButton = new Button("Easy");
        difficultbutton = new Button("Difficult");
        easyButton.setPosition(Gameplay.GRASS_WIDTH,300);
        difficultbutton.setPosition(Gameplay.GRASS_WIDTH + easyButton.getBounds().getWidth(),300);



        canvas.add(easyButton);
        canvas.add(difficultbutton);
        canvas.add(background);
        board.makeFood(canvas, Math.random() * 800, Math.random() * 500);
        canvas.add(head);
        canvas.add(head.getSnakeBodyGroup());
        canvas.add(scoreBoard);
        canvas.add(scoreBoard.getLabel());

        head.checkKeyboardInput(canvas);
        easyButton.onClick(()-> head.setSnakeSpeed(5));
        difficultbutton.onClick(()-> head.setSnakeSpeed(10));

        canvas.animate(() -> {

            if (head.isGameOver()) {
                gameOver();
            }
            head.moveSnake();
            board.foodEaten(head, canvas, scoreBoard);
        });
    }

    private void gameOver() {
        canvas.removeAll();
        GraphicsText gameOverLabel = new GraphicsText();
        gameOverLabel.setFont(FontStyle.ITALIC, CANVAS_HEIGHT * 0.025);
        gameOverLabel.setText("GAME OVER. THANKS FOR PLAYING! WOULD YOU LIKE TO PLAY AGAIN?");
        gameOverLabel.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.5);
        canvas.add(gameOverLabel);
        canvas.add(easyButton);
        canvas.add(difficultbutton);
        easyButton.setPosition(CANVAS_WIDTH * 0.35, CANVAS_HEIGHT * 0.6);
        difficultbutton.setPosition(CANVAS_WIDTH * 0.55, CANVAS_HEIGHT * 0.6);
    }


    public static void main(String[] args) {
        new Gameplay();
    }
}