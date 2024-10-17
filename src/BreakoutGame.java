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

        Scene scene = new Scene(root, 800,600);

        //initialisation de l'objet balle
        ball = new Ball(200,150,1,1,10);   //pos en x,y et v en x,y et le rayon

        //initialisation de l'objet paddle

        paddle = new Paddle(350,550,100); //pos en x,y et largeur

        //initialisation des briques avec un tableau

        bricks = new Brick[10]; //10 briques


        //remplir le tableau de briques


        //creer les formes avec javafx  pour les afficher

        Circle BallShape = new Circle(ball.getpX(),ball.getpY(),ball.getRadius(),Color.RED);
        Rectangle Paddleshape = new Rectangle(paddle.getX(),paddle.getY(),paddle.getWidth(),10);

        Paddleshape.setFill(Color.BLUE);


        //ajouter les formes a la pane

        root.getChildren().add(BallShape);



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
