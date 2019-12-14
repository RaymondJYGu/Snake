import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsObject;
import comp127graphics.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Creates the board, with a list of Graphicobjects of food pictures.
 */

public class Board {

    public List<GraphicsObject> foods;
    Random random = new Random();

    private Image appleJuice, apple, banana, chickenSandwich,
            chips, cookieMonster, cookie, frenchFries, juiceBox,
            rice, waterBottle;

    private GraphicsObject currentFood;

    public Board() {
        foods = new ArrayList<>();
        imageRender();
    }

    /**
     * Add the pictures to the list and set their initial position to (0,0).
     */

    private void imageRender() {
        appleJuice = new Image(0, 0, "foodImages/applejuiceScaled.png");
        foods.add(appleJuice);
        apple = new Image(0, 0, "foodImages/appleScaled.png");
        foods.add(apple);
        banana = new Image(0, 0, "foodImages/bananaScaled.png");
        foods.add(banana);
        chickenSandwich = new Image(0, 0, "foodImages/chickenSandwichScaled.png");
        foods.add(chickenSandwich);
        chips = new Image(0, 0, "foodImages/chipsScaled.png");
        foods.add(chips);
        cookieMonster = new Image(0, 0, "foodImages/cookieMonsterScaled.png");
        foods.add(cookieMonster);
        cookie = new Image(0, 0, "foodImages/cookieScaled.png");
        foods.add(cookie);
        frenchFries = new Image(0, 0, "foodImages/frenchFriesScaled.png");
        foods.add(frenchFries);
        juiceBox = new Image(0, 0, "foodImages/juiceBoxScaled.png");
        foods.add(juiceBox);
        rice = new Image(0, 0, "foodImages/riceScaled.png");
        foods.add(rice);
        waterBottle = new Image(0, 0, "foodImages/waterBottleScaled.png");
        foods.add(waterBottle);

    }

    /**
     * Make the first food item
     *
     * @param canvas is the place the food is added to
     * @param x      sets horizontal position of the first food item
     * @param y      sets vertical position of the first food item
     */

    public void makeFood(CanvasWindow canvas, double x, double y) {
        currentFood = foods.get(random.nextInt(foods.size()));
        canvas.add(currentFood, x, y);
    }

    /**
     * Test if the food is eaten. If the snake head touches the food,
     * the food disappears and we create another food at a random
     * place on canvas, the snake grows int length and score increases
     *
     * @param head       is the thing that is moving and eating the food
     * @param canvas     is where is everything is shown
     * @param scoreBoard is where the score is changed
     */

    public void foodEaten(SnakeHead head, CanvasWindow canvas, ScoreBoard scoreBoard) {
        if (currentFood.getBounds().intersects(head.getBounds())) {
            canvas.remove(currentFood);
            makeFood(canvas,
                    checkFoodBounds(Math.random() * Gameplay.GRASS_WIDTH - currentFood.getBounds().getWidth()),
                    checkFoodBounds(Math.random() * Gameplay.GRASS_HEIGHT - currentFood.getBounds().getHeight()));
            head.snakeGrow();
            scoreBoard.pointScored();
        }
    }

    /**
     * Make sure it's not out of bound. If it's out of bound,
     * set the position to the initial position 0.
     *
     * @param bound is the x and y position of the food
     * @return the bound of the food object
     */

    public double checkFoodBounds(double bound) {
        if (bound < 0) {
            return 0;
        } else {
            return bound;
        }
    }
}