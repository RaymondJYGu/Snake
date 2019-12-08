import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsObject;
import comp127graphics.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnakeBody {
    private List<Rectangle> body;
    private GraphicsGroup snakeBody;

    public SnakeBody(double x, double y, double width, double height) {
        body = new ArrayList<>();
        body.add(new Rectangle(x-width/2, y, width, height));
        snakeBody = new GraphicsGroup();
        addBodyToGroup();
    }

    public void addBodyToGroup() {
        snakeBody.removeAll();
        for (Rectangle rect: body) {
            rect.setFilled(true);
            rect.setFillColor(Color.GREEN);
            snakeBody.add(rect);
        }
    }


    public void bodyMove(SnakeHead head) {
        for (int i = body.size() - 1; i >= 0; i--) {
            if(i == 0) {
                body.get(i).setPosition(head.getPreviousPosition().getX() - head.getWidth(),
                        head.getPreviousPosition().getY());
            } else {
                body.get(i).setPosition(body.get(i-1).getPosition().getX() - Gameplay.SNAKE_SQUARE,
                        body.get(i-1).getPosition().getY());
            }
        }
    }

    public void grow() {
        body.add(new Rectangle(body.get(body.size() - 1).getX(), body.get(body.size() - 1).getY(),
                body.get(body.size() - 1).getWidth(),
                body.get(body.size() - 1).getHeight()));
        addBodyToGroup();
    }

    public GraphicsGroup getSnakeBody() {
        return snakeBody;
    }
}