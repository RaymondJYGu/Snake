import comp127graphics.GraphicsGroup;
import comp127graphics.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnakeBody {
    private List<Rectangle> body;
    private GraphicsGroup snakeBody;

    private int redTracker = 255;
    private int blueTracker = 255;
    private String colorProgress = "none";

    public SnakeBody(double x, double y, double width, double height) {
        body = new ArrayList<>();
        snakeBody = new GraphicsGroup();

        for (int i = 0; i < 20; i++) {
            Rectangle firstBody = new Rectangle(x - width / 2, y, width, height);
            firstBody.setFilled(true);
            firstBody.setStroked(false);
            firstBody.setFillColor(chooseColor());
            body.add(firstBody);
            snakeBody.add(firstBody);
        }
    }


    public void bodyMove(SnakeHead head) {
        for (int i = body.size() - 1; i >= 0; i--) {
            if (i == 0) {
                body.get(i).setPosition(head.getPreviousPosition());
            } else {
                body.get(i).setPosition(body.get(i - 1).getPosition());
            }
        }
    }

    public void grow() {
        for (int i = 0; i < 25; i++) {
            Rectangle newBody = new Rectangle(body.get(body.size() - 1).getX(), body.get(body.size() - 1).getY(),
                    body.get(body.size() - 1).getWidth(),
                    body.get(body.size() - 1).getHeight());
            newBody.setFilled(true);
            newBody.setStroked(false);
            newBody.setFillColor(chooseColor());
            body.add(newBody);
            snakeBody.add(newBody);
        }

    }

    private Color chooseColor() {
        if (getRedTracker() > 1 && !(colorProgress.equals("final")
                && !(colorProgress.equals("middle")))) { //at the end, red will be 1
            setRedTracker(getRedTracker() - 2);
            colorProgress = "initial";
        } else if (getBlueTracker() > 1 && getRedTracker() == 1
                && !(colorProgress.equals("final"))) { //at the end, both will be 1
            setBlueTracker(getBlueTracker() - 2);
            colorProgress = "middle";
        } else if ((getBlueTracker() < 255) && (getRedTracker() < 255) &&
                !(colorProgress.equals("none"))) {
            setBlueTracker(getBlueTracker() + 2);
            setRedTracker(getRedTracker() + 2);
            colorProgress = "final";
        }
        return new Color(getRedTracker(), 0, getBlueTracker());
    }

    public void intersects(SnakeHead head) {
        for (int i = 20; i < body.size(); i++) {
            if (head.getBounds().intersects(body.get(i).getBounds())) {
                head.setGameOver(true);
            }
        }
    }

    public GraphicsGroup getSnakeBody() {
        return snakeBody;
    }

    private int getRedTracker() {
        return redTracker;
    }

    private void setRedTracker(int redTracker) {
        this.redTracker = redTracker;
    }

    private int getBlueTracker() {
        return blueTracker;
    }

    private void setBlueTracker(int blueTracker) {
        this.blueTracker = blueTracker;
    }
}