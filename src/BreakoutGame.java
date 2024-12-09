import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BreakoutGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 700);
        // Création de la balle et de la raquette
        Ball ball = new Ball(scene.getWidth()/2, scene.getHeight()-100, 10, 2, 2);
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
}