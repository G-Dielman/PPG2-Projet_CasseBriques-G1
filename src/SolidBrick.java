import javafx.scene.paint.Color;

public class SolidBrick extends Brick{
    protected int hits;
    static Color DEFAULT_COLOR = Color.DARKGREEN;

    public SolidBrick(double x, double y, double width, double height) {
        super(x, y, width, height, DEFAULT_COLOR);
        this.hits = 0;
    }
}