import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public abstract class RectangularGameObject extends GameObject {
    protected double width; // largeur
    protected double height; // hauteur

    // constructeur
    public RectangularGameObject(double x, double y, double width, double height, Color color) {
        // Appelle le constructeur de GameObject avec un Rectangle
        super(x, y, new Rectangle(x, y, width, height), color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width; // retourne la largeur
    }

    public double getHeight() {
        return height; // retourne la hauteur
    }

    // gerer colision a daire...



}
