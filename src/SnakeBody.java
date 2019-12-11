import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsObject;
import comp127graphics.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeBody {
    private List<Rectangle> body;
    private GraphicsGroup snakeBody;

    public SnakeBody(double x, double y, double width, double height) {
        body = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            body.add(new Rectangle(x-width/2, y, width, height));
        }
        snakeBody = new GraphicsGroup();
        addBodyToGroup();
    }

    public void addBodyToGroup() { // change color to spectrum, match growth rate
        snakeBody.removeAll();
        for (Rectangle rect: body) {
            rect.setFilled(true);
            int e = new Random().nextInt(255);
            int f = new Random().nextInt(255);
            int j = new Random().nextInt(255);
            rect.setFillColor(new Color(e,f,j));
            snakeBody.add(rect);
        }
    }


    public void bodyMove(SnakeHead head) {
        for (int i = body.size() - 1; i >= 0; i--) {
            if(i == 0) {
                body.get(i).setPosition(head.getPreviousPosition());
            } else {
                body.get(i).setPosition(body.get(i-1).getPosition());
            }
        }
    }

    public void grow() {
        for (int i = 0; i < 25; i++) {
            body.add(new Rectangle(body.get(body.size() - 1).getX(), body.get(body.size() - 1).getY(),
                    body.get(body.size() - 1).getWidth(),
                    body.get(body.size() - 1).getHeight()));
            addBodyToGroup();
            i++;
        }

    }

    public GraphicsGroup getSnakeBody() {
        return snakeBody;
    }
}