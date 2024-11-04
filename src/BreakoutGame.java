import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
                                                                //https://www.youtube.com/playlist?list=PLrzWQu7Ajpi26jZvP8JhEJgFPFEj_fojO
                                                                //https://www.youtube.com/watch?v=_7OM-cMYWbQ&list=PLZPZq0r_RZOM-8vJA3NQFZB7JroDcMwev
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

        Scene scene = new Scene(root, 1760,880);

        // Définir une couleur de fond pour le Pane
        //https://stackoverflow.com/questions/58946669/using-setstyle-to-change-background-color-in-javafx

        root.setStyle("-fx-background-color: #3a3a4d;");

        //initialisation de l'objet balle
        ball = new Ball(880,750,5,5,10);   //pos en x,y et v en x,y et le rayon

        //initialisation de l'objet paddle

        paddle = new Paddle(780,800,400); //pos en x,y et largeur

        //initialisation des briques avec un tableau

        bricks = new Brick[20]; //10 briques


        //remplir le tableau de briques
        for (int i = 0;i < bricks.length;++i){
            bricks[i] = new Brick(70 + (i * 80),50); // le i * 80 est l'espacement entre les bricks
        }

        //creer les formes avec javafx  pour les afficher

        Circle BallShape = new Circle(ball.getpX(),ball.getpY(),ball.getRadius(),Color.RED);
        Rectangle Paddleshape = new Rectangle(paddle.getX(),paddle.getY(),paddle.getWidth(),10);

        Paddleshape.setStyle("-fx-fill: #7577c1;");
            //boucle pour creer et afficher les objets bricks avec javaFX
        for (Brick brick:bricks) {
            Rectangle brickShape = new Rectangle(brick.getpX(),brick.getpY(),60,40);

            //https://docs.oracle.com/javafx/2/api/javafx/scene/shape/Shape.html#setStyle(java.lang.String)
            //changement couleurs des briques + contour et largeur du contour + leurs couleurs
            brickShape.setStyle("-fx-fill: #835555; -fx-stroke: #150101; -fx-stroke-width: 2;");


            root.getChildren().add(brickShape);
        }


        //ajouter les formes a la pane

        root.getChildren().addAll(BallShape,Paddleshape);

        // deplacements du Paddle

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case LEFT :
                    Paddleshape.setX(Paddleshape.getX() -20);
                    paddle.setX(paddle.getX()- 20);// !! mise a jour de la pose du paddle, sans cette ligne le paddle bouge mais pas ses coordo
                    break;

                case RIGHT:
                    Paddleshape.setX(Paddleshape.getX() +20 );
                    paddle.setX(paddle.getX() + 20);//IDEM
                    break;
            }
        });
        scene.setOnMouseMoved(event ->{
            double padX = event.getX();

            Paddleshape.setX(event.getX()); //Mouvement du paddle avec la souris
            paddle.setX(event.getX()); // MAJ position du paddle

            //empecher le paddle de sortir de la fenetre
            if (padX + paddle.getWidth() >= scene.getWidth()){
                Paddleshape.setX(scene.getWidth() - paddle.getWidth());
                paddle.setX(scene.getWidth() - paddle.getWidth());
            }

        });



        //gerer les mouvements de la balle
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //déplacer la balle

                ball.move();


                BallShape.setCenterX(ball.getpX());
                BallShape.setCenterY(ball.getpY());
               if (ball.getpX() + ball.getRadius() >= scene.getWidth() || ball.getpX() - ball.getRadius()<= 0){
                   ball.setvX(-ball.getvX());
               }
                if (ball.getpY() + ball.getRadius() >= scene.getHeight() || ball.getpY() - ball.getRadius() <= 0){
                    ball.setvY(-ball.getvY());
                }

                // Gérer les rebonds sur le paddle
                if (ball.getpY() + ball.getRadius() >= paddle.getY() &&
                        ball.getpX() + ball.getRadius() >= paddle.getX() &&
                        ball.getpX() - ball.getRadius() <= paddle.getX() + paddle.getWidth()) {
                    ball.setvY(-ball.getvY()); // Inverser la direction Y de la balle
                    ball.setpY(paddle.getY() - ball.getRadius()); // Ajuster la position de la balle
                    System.out.println("Collision avec le paddle!"); // Pour débogage
                }






            }
        };
        timer.start();
        //https://stackoverflow.com/questions/10121991/javafx-application-icon
        Image icon = new Image("file:resources/icon.png");


        primaryStage.getIcons().add(icon);//ajouter une icone a la fenetre
        primaryStage.setTitle("Casse-briques"); //titre de la fenetre

        primaryStage.setScene(scene); //ajouter la scene a la fenetre

        primaryStage.show();//afficher la fenetre

    }



}
