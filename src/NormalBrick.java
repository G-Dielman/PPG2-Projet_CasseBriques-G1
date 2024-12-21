import javafx.scene.paint.Color;

public class NormalBrick extends Brick{

    static Color DEFAULT_COLOR = Color.GREENYELLOW;

    public NormalBrick(double x, double y, double width, double height){

        super(x,y,width,height,DEFAULT_COLOR);
    }

    public void onCollisionWith(Ball ball){
        super.onCollisionWith(ball);
        breakThis();
    }
}
