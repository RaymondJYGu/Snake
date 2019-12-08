import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsObject;
import comp127graphics.Rectangle;

public class SnakeBody extends Rectangle {
    private GraphicsObject[] body;

    public SnakeBody(double x, double y, double width, double height, int numberOfSegments) {
        super(x, y, width, height);
        setFilled(true);
        body = new GraphicsObject[numberOfSegments];

        generateSnakeBody();
    }

    public void generateSnakeBody() {
        for(int i = 0; i < body.length; i++)
        {
            body[i]= new Rectangle(10,10,10,10);
            body[i].setPosition(50,50+i*10);
        }
    }


    public void bodyMove(double x, double y) {
        for (int i = 0; i > body.length - 1; i++) {
            body[i+1].setPosition(body[i].getPosition().getX(), body[i].getPosition().getY());
        }
        body[0].setPosition(x, y);
    }





}