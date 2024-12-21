import javafx.scene.paint.Color;

public class Paddle extends RectangularGameObject{

    static Color DEFAULT_COLOR = Color.PURPLE;
    public Paddle(double x, double y, double width, double height) {
        super(x, y, width, height, DEFAULT_COLOR);
    }

    public void onCollisionWith(Ball ball) {
        super.onCollisionWith(ball);
    }

}

//*Attributs :
//
//La classe Paddle possède en plus des paramètres hérités de ses classes parentes l’attribut statique
//Color DEFAUT_COLOR qui est initialiser avec la couleur mauve (Color.PURPLE) .
//
//• Constructeur :
//Cette classe doit contenir un constructeur qui :
//Reçoit les coordonnées x et y, la largeur width, et la hauteur height.
//Passe ces valeurs, ainsi que la couleur par défaut (DEFAUT_COLOR), au constructeur de la classe
//RectangularGameObject.
//
//• Méthodes :
//La classe Paddle hérite toutes les méthodes nécessaires des classes parentes et n’a pas besoin de
//méthodes spécifiques pour l’instant.