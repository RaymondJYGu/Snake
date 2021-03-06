import comp127graphics.FontStyle;
import comp127graphics.GraphicsText;
import comp127graphics.Rectangle;

public class ScoreBoard extends Rectangle {
    int score = 0;
    private double x;
    private double y;
    private GraphicsText label;
    protected final double scoreBoardWidth;

    /**
     * Creates a scoreboard, with labels of words and numbers, to keep track of the scores.
     *
     * @param x      is the horizon position of the scoreboard
     * @param y      is the vertical position of the scoreboard
     * @param width  is the width of the scoreboard
     * @param height is the height of the scoreboard
     */

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

    /**
     * Set the text of the label
     */

    public void pointScored() {
        score++;
        label.setText("Score: " + score);
    }

    /**
     * return the label created.
     */

    public GraphicsText getLabel() {
        return label;
    }
}