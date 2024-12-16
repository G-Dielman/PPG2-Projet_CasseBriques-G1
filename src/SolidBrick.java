import javafx.scene.paint.Color;

public class SolidBrick extends Brick{
    protected int hits;
    static Color DEFAULT_COLOR = Color.DARKGREEN;

    public SolidBrick(double x, double y, double width, double height) {
        super(x, y, width, height, DEFAULT_COLOR);
        this.hits = 0;
    }

    @Override
    public void onCollisionWith(Ball ball) {
        super.onCollisionWith(ball);
        hits ++;
         if (hits == 1) setColor(Color.GREEN);
         if (hits == 2) setColor(Color.GREENYELLOW);
         if(hits == 3) breakThis();
    }
}