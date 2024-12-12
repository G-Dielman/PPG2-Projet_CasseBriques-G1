import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Ball extends GameObject {
    private double vx;
    private double vy;
    private double radius;
    private static final Color DEFAULT_COLOR = Color.BLUE;

    // Constructeur, methodes ....

    public Ball(double x,double y, double vx, double vy,double radius){
        // il fait appel au constructeur du GameObject et il lui passe en Circle pour la Shape
        super( x,y,new Circle(x,y,radius),DEFAULT_COLOR );
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;

    }


    @Override
    public void setX(double x) {
        this.x=x;

    }

    @Override
    public void setY(double y) {
        this.y=y;
    }

    @Override
    public Circle getShape() {
        return (Circle)this.shape ;
    }
    //
    public void move(){
        this.x += this.vx;
        this.y += this.vy;
    }

    // changer le signe du vx
    public void switchVx(){
        this.vx = -vx;
    }
    // changer le signe du vx
    public void switchVy(){
        this.vy = -vy;
    }
}
