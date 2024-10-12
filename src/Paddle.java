public class Paddle {
    //N'hésité pas a faire plus de commentaire pour expliquer le code, c'est un travail de groupe

    // Attribut privé
    private double x;       // Position horizontale
    private double y;       // Position verticale qui restera fixe pour le coup
    private double width;   // Largeur du paddle

    // Constructeur du paddle, je ne sais pas si il faut en fair un donc je l'ai fais comme costi
    public Paddle(double x, double y, double width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    // getter pour la position x
    public double getX() {
        return x;
    }

    // Setter pour la position x
    public void setX(double x) {
        this.x = x;
    }

    // Getter pour la position y
    public double getY() {
        return y;
    }

    // Setter pour la position y
    public void setY(double y) {
        this.y = y;
    }

    // Getter pour le largeur du paddle
    public double getWidth() {
        return width;
    }

    // Setter pour la largeur du paddle
    public void setWidth(double width) {
        this.width = width;
    }

    // méthode pour déplacer le paddle en x seulement
    public void move(double moveX) {
        this.x += moveX;  // On ajoute ou soustrait ce qui est dans moveX à la position actuelle
    }
}
