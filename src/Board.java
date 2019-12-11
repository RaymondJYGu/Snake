import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsObject;
import comp127graphics.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    public List<GraphicsObject> foods;
    Random random = new Random();

    private Image appleJuice, apple, banana, chickenSandwich,
            chips, cookieMonster, cookie, frenchFries, juiceBox,
            kale, rice, waterBottle;

    private GraphicsObject currentFood;

    public Board() {
        foods = new ArrayList<>();
        imageRender();
    }

    public List<GraphicsObject> getFoods() {
        return foods;
    }

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
        kale = new Image(0, 0, "foodImages/kaleScaled.png");
        foods.add(kale);
        rice = new Image(0, 0, "foodImages/riceScaled.png");
        foods.add(rice);
        waterBottle = new Image(0, 0, "foodImages/waterBottleScaled.png");
        foods.add(waterBottle);

    }

    /**
     * makes the first food item
     */
    public void makeFood(CanvasWindow canvas, double x, double y) { //change to make sure that it does not
        currentFood = foods.get(random.nextInt(foods.size()));      //spawn outside of bounds and also not on the snake itself
        canvas.add(currentFood, x, y);
        System.out.println(x + "this is x");
        System.out.println(y + "this is y");
    }

    public void foodEaten(SnakeHead head, CanvasWindow canvas, ScoreBoard scoreBoard) {
        if (currentFood.getBounds().intersects(head.getBounds())) {
            canvas.remove(currentFood);
            makeFood(canvas, random.nextInt(Gameplay.CANVAS_WIDTH), random.nextInt(Gameplay.CANVAS_HEIGHT));
            head.snakeGrow();
            scoreBoard.someoneScored();
        }
    }


}
