import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public abstract class RectangularGameObject extends GameObject implements Collidable {
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

    // gerer colision a faire...

   // getShape retourne un Rectangle ici
    public Rectangle getShape(){
        return (Rectangle)this.shape;
    }

    // pas sur que c'est juste!!!
    @Override
    public void setX(double x) {
        this.x=x;
        ((Rectangle)this.shape).setX(x);
    }

    // pas sur que c'est juste!!!
    @Override
    public void setY(double y) {
        this.y=y;
        ((Rectangle)this.shape).setY(y);
    }

    public boolean collideLeft(Ball ball) { // collision avec le côté gauche du rectangle
        // Vérifie si la balle est à gauche du rectangle et si elle touche le côté gauche
        return ball.getX() + ball.getRadius() >= getShape().getX()
                && ball.getX() - ball.getRadius() <= getShape().getX();
    }

    public boolean collideRight(Ball ball) { // collision avec le côté droit du rectangle
        // Vérifie si la balle est à droite du rectangle et si elle touche le côté droit
        return ball.getX() - ball.getRadius() <= getShape().getX() + getShape().getWidth()
                && ball.getX() + ball.getRadius() >= getShape().getX() + getShape().getWidth();
    }

    public boolean collideTop(Ball ball) { // collision avec le dessus du rectangle
        // Vérifie si la balle est en haut du rectangle et si elle touche le dessus
        return ball.getY() + ball.getRadius() >= getShape().getY()
                && ball.getY() - ball.getRadius() <= getShape().getY();
    }

    public boolean collideBottom(Ball ball) { // collision avec le dessous du rectangle
        // Vérifie si la balle est en bas du rectangle et si elle touche le dessous
        return ball.getY() - ball.getRadius() <= getShape().getY() + getShape().getHeight()
                && ball.getY() + ball.getRadius() >= getShape().getY() + getShape().getHeight();
    }

    @Override
    public boolean collideWith(Ball ball) {


        return collideLeft(ball) || collideRight(ball) || collideTop(ball) || collideBottom(ball);

    }

    public void onCollisionWith(Ball ball){


        if (collideLeft(ball) || collideRight(ball))
            ball.switchVx();

        if (collideTop(ball) || collideBottom(ball))
            ball.switchVy();

    }

}
