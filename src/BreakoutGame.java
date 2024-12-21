import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Random;

public class BreakoutGame extends Application {

    private Brick[] createBricks(Pane root, Scene scene) {
        int rows = 7; // nombre de range
        int cols = 5; // nombre de colonne
        double horizontalSpacing = 6; // espacement horizontal
        double verticalSpacing = 6; // espacement vertical
        double brickWidth = (scene.getWidth() - (cols - 1) * horizontalSpacing) / cols; // largeur
        double brickHeight = 40; // hauteur d'une brique

        Brick[] bricks = new Brick[rows * cols]; // tableau pour stocker les briques

        Random random = new Random();// on utilise random pour génerer des briques aléatoires, normales ou solides

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                double x = col * (brickWidth + horizontalSpacing); // position x
                double y = row * (brickHeight + verticalSpacing); // position y d
                Brick brick;
                if (random.nextBoolean()) { // 50% de chance
                    brick = new SolidBrick(x, y, brickWidth, brickHeight); // pour des  SolidBrick
                } else {
                    brick = new NormalBrick(x, y, brickWidth, brickHeight); // pour choisir des  NormalBrick
                }
                bricks[row * cols + col] = brick; // ajouter au tableau
                root.getChildren().add(brick.getShape()); // ajouter la forme au Pane
            }
        }

        System.out.println("Nombre total de briques : " + bricks.length);
        return bricks; // retourner le tableau
    }


    AnimationTimer timer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 700);
        // Création de la balle et de la raquette
        Ball ball = new Ball(scene.getWidth()/2, scene.getHeight()-100, 3, 3, 9);
        Paddle paddle = new Paddle(scene.getWidth()/2, scene.getHeight()-50 , 100, 20);
        // Ajouter les formes au pane
        root.getChildren().addAll(ball.getShape() , paddle.getShape());
        // Création et affichage des briques. Les briques sont ajoutées au Pane par la fonction et
        // leurs tailles varie en fonction des dimenssions de la scene
        Brick[] bricks = createBricks(root, scene);
        //Déplacement de la raquette
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:
                    // Empêche de dépasser le bord gauche
                    paddle.setX(Math.max(0, paddle.getX() - 5));
                    break;
                case RIGHT:
                    // Empêche de dépasser le bord droit
                    paddle.setX(Math.min(scene.getWidth() - paddle.getWidth(), paddle.getX() + 5));
                    break;
            }
        });
        scene.setOnMouseMoved(event ->{
            double padX = event.getX();

            paddle.setX(event.getX()); //Mouvement du paddle avec la souris
            paddle.setX(event.getX()); // MAJ position du paddle

            //empecher le paddle de sortir de la fenetre
            if (padX + paddle.getWidth() >= scene.getWidth()){
                paddle.setX(scene.getWidth() - paddle.getWidth());
                paddle.setX(scene.getWidth() - paddle.getWidth());
            }

        });

        // AnimationTimer pour déplacer la balle
        this.timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                ball.move(); // Met à jour la position de la balle
                // Rebondir sur les bords de la fenêtre
                if (ball.getX()- ball.getRadius() <= 0 // Si la balle touche le mur de gauche
                        || ball.getX() + ball.getRadius() >= scene.getWidth()) // ou le mur de Droite
                    ball.switchVx(); // Inverser la direction horizontale
                if (ball.getY() - ball.getRadius() <= 0) // Si la balle touche le plafont
                    ball.switchVy(); // Inverser la direction verticale
                // Vérifier si la balle tombe sous la raquette
                if (ball.getY() > scene.getHeight()) {
                    stopGame("Game Over!", root);
                }
                // Collision avec la raquette
                if ( paddle.collideWith(ball) ) {
                    paddle.onCollisionWith(ball);
                }
                // Collision avec les briques
                boolean allBrickBroken = true;
                for (Brick brick : bricks){
                    if ( !brick.isBroken() ){
                        allBrickBroken = false;
                        if ( brick.collideWith(ball) )
                            brick.onCollisionWith(ball);
                    }
                }
                //Si toutes les briques sont brisées, le joueur a gagné
                if(allBrickBroken)
                    stopGame("YOU WIN !!!", root);
            }
        };
        this.timer.start(); // Démarrer l'animation
        primaryStage.setTitle("Casse-briques - Itération 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void stopGame(String message, Pane root) {
        // Arrêter l'animation
        timer.stop();
        // Créer un Label pour afficher le message
        Label endMessage = new Label(message);
        endMessage.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        endMessage.setTextFill(Color.INDIANRED);
        endMessage.setTextAlignment(TextAlignment.CENTER);
        // Centrer le Label dans la fenêtre
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(endMessage);
        stackPane.setPrefSize(root.getWidth(), root.getHeight());
        stackPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7);"); // Fond semi-transparent
        root.getChildren().add(stackPane);
    }

}