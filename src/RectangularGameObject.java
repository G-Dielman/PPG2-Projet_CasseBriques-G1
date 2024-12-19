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

    public boolean collideLeft(Ball ball){      // collision avec le coté gauche du rectangle
        return ball.getX() + ball.getRadius() >= getShape().getX()
                && ball.getX() + ball.getRadius() <= getShape().getX()+getShape().getWidth()
                && ball.getY() <= getShape().getY() + getShape().getHeight()
                && ball.getY() >= getShape().getY();
    }

    public boolean collideRight(Ball ball){                   // collision avec le coté droit du rect
        return ball.getX() - ball.getRadius() <= getShape().getX()
                && ball.getX() - ball.getRadius() >= getShape().getX()+getShape().getWidth()
                && ball.getY() <= getShape().getY() + getShape().getHeight()
                && ball.getY() >= getShape().getY();
    }

    public boolean collideTop(Ball ball){
        return ball.getY() + ball.getRadius() >= getShape().getY() + getShape().getHeight()
                && ball.getY() + ball.getRadius() <= getShape().getY()
                && ball.getX()  <= getShape().getX() + getShape().getWidth()
                && ball.getX() >= getShape().getX();// collision avec le dessus du rect
    }

    public boolean collideBottom(Ball ball){
        return  ball.getY() - ball.getRadius() <= getShape().getY() + getShape().getHeight()
                && ball.getY() - ball.getRadius() >= getShape().getY()
                && ball.getX()  <= getShape().getX() + getShape().getWidth()
                && ball.getX() >= getShape().getX(); // collision avec le dessous du rect
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
