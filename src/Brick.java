import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


public abstract class Brick extends RectangularGameObject {

    protected boolean broken;



    public Brick(double x, double y, double width, double height, Color color) {
        super(x, y, width, height, color);

        broken = false;
    }

    public boolean isBroken(){
        return this.broken;
    }

    public void breakThis() {
        broken = true;
        this.shape.setVisible(false);
    }


}
