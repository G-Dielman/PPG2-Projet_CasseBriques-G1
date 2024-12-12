public interface Collidable {

    // return true si ball est en colision
    boolean collideWith(Ball ball);
    // que fais la balle quand elle collisione
    void onCollisionWith(Ball ball);
}
