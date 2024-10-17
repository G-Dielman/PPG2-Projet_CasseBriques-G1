import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
                                                                //https://www.youtube.com/playlist?list=PLrzWQu7Ajpi26jZvP8JhEJgFPFEj_fojO
public class BreakoutGame extends Application {

    public Ball ball;
    public Paddle paddle;
    public Brick[] bricks;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //creation de la pane pour afficher les elements du jeu
        Pane root = new Pane();

        Scene scene = new Scene(root, 1960,1080);

        //initialisation de l'objet balle
        ball = new Ball(200,150,1,1,10);   //pos en x,y et v en x,y et le rayon

        //initialisation de l'objet paddle

        paddle = new Paddle(780,1000,400); //pos en x,y et largeur

        //initialisation des briques avec un tableau

        bricks = new Brick[20]; //10 briques


        //remplir le tableau de briques
        for (int i = 0;i < bricks.length;++i){
            bricks[i] = new Brick(70 + (i * 80),50); // le i * 80 est l'espacement entre les bricks
        }

        //creer les formes avec javafx  pour les afficher

        Circle BallShape = new Circle(ball.getpX(),ball.getpY(),ball.getRadius(),Color.RED);
        Rectangle Paddleshape = new Rectangle(paddle.getX(),paddle.getY(),paddle.getWidth(),10);

        Paddleshape.setFill(Color.BLUE);
            //boucle pour creer et afficher les objets bricks avec javaFX
        for (Brick brick:bricks) {
            Rectangle brickShape = new Rectangle(brick.getpX(),brick.getpY(),60,40);
            brickShape.setFill(Color.GREEN);
            root.getChildren().add(brickShape);
        }


        //ajouter les formes a la pane

        root.getChildren().addAll(BallShape,Paddleshape);



        primaryStage.setTitle("Casse-briques"); //titre de la fenetre

        primaryStage.setScene(scene); //ajouter la scene a la fenetre

        primaryStage.show();//afficher la fenetre

    }

    //gerer les mouvements de la balle
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            //déplacer la balle

            ball.move();




        }
    };
}
