import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends GameObject {
    private double vx;
    private double vy;
    private double radius;
    private static final Color DEFAULT_COLOR = Color.BLUE;

    // Constructeur, methodes ....

    public Ball(double x,double y, double vx, double vy,double radius){
        super( x,y,new Circle(x,y,radius),DEFAULT_COLOR );
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;

    }
}
