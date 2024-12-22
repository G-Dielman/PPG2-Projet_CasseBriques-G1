import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class GameObject {

    // Les attributs
    protected Shape shape;
    protected double x;
    protected double y;
    protected Color color;

    public double getX() { //getter
        return x;
    }

    public abstract void setX(double x); //setter abstrait

    public double getY() { //getter
        return y;
    }

    public abstract void setY(double y); //setter abstrait



    public void setColor(Color color) { //setter
        this.color = color;
        shape.setStroke(Color.RED);
        shape.setFill(color);
    }

    public abstract Shape getShape(); //Getter abstrait



    public GameObject(double x, double y, Shape shape,Color color){ //constructeur
        this.x = x;
        this.y = y;
        this.shape = shape;
        this.shape.setFill(color);
    }

    //Constructeur
    //Cette classe doit contenir au moins un constructeur qui reçoit un Shape, deux doubles x et y et une
    //couleur Color.
    //• Méthodes
    //Veillez à implémenter les accesseurs nécessaires pour les attributs créés ci-dessus. Notez toutefois que les
    //Méthodes setX et setY doivent être abstraites, la façon de définir X et Y étant différente pour les
    //Rectangles et pour les Circles. La méthode getShape() est elle aussi abstraite.
}
