import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Ball extends GameObject {
    private double vx;
    private double vy;
    private double Radius;
    private static Color DEFAULT_COLOR = Color.BLUE;

    // Constructeur, methodes ....

    public Ball(double x,double y, double vx, double vy,double radius){
        // il fait appel au constructeur du GameObject et il lui passe Un Circle pour le Shape
        super( x,y,new Circle(x,y,radius),DEFAULT_COLOR );
        this.vx = vx;
        this.vy = vy;
        this.Radius = radius;

    }

    public double getRadius(){
        return this.Radius;
    }



    @Override
    public void setX(double x) {
        this.x=x;
        // il met à jour la position du cercle en x
        ((Circle)this.shape).setCenterX(x);
    }

    @Override
    public void setY(double y) {

        this.y=y;
        //il met à jour la position du cercle en y
        ((Circle)this.shape).setCenterY(y);
    }

    @Override
    public Circle getShape() {
        return (Circle)this.shape ;
    }
    //
    public void move(){
        this.x += this.vx;
        this.y += this.vy;
        setX(this.x);      // mise à jour de la position du cercle en x
        setY(this.y);       // mise à jour de la position du cercle en y
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
