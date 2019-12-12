import comp127graphics.FontStyle;
import comp127graphics.GraphicsText;
import comp127graphics.Rectangle;


public class ScoreBoard extends Rectangle {
    int score = 0;
    private double x;
    private double y;
    private GraphicsText label;


    protected final double scoreBoardWidth;

    public ScoreBoard(double x, double y, double width, double height) {
        super(x, y, width, height);
        scoreBoardWidth = width;
        this.x = x;
        this.y = y;
        label = new GraphicsText();
        label.setFont(FontStyle.BOLD, 50);
        label.setText("Score: 0");
        label.setPosition(x + 50, y + 50);
    }

    public void someoneScored() {
        score++;
        label.setText("Score: " + score);
    }

    public GraphicsText getLabel() {
        return label;
    }
}