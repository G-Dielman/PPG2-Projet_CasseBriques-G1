public class Ball {
    private double pX,pY,vX,vY,radius; //Initialisation des attributs de l'objet

    public Ball(double pX,double pY,double vX,double vY){ //constructeur
        this.pX = pX;
        this.pY = pY;
        this.vX = vX;
        this.vY = vY;
    }

    public double getpX(){
        return pX;
    } //Getters de la position X
    public void setpX(double pX){
        this.pX = pX;
    } //Setters del a position X
    public double getpY(){
        return pY;
    }
    public void setpY(double pY){
        this.pY = pY;
    }
    public double getvX(){
        return vX;
    } //getters Vitesse X
    public void setvX(double vX){
        this.vX = vX;
    } //Setters Vitesse X
    public double getvY(){
        return vY;
    }
    public void setvY(double vY){
        this.vY = vY;
    }
    public double getRadius(){
        return radius;
    } //getters du radius
    public void setRadius(double radius){
        this.radius = radius;
    } //setters du radius

    public void move(){
        this.pX += this.vX;
        this.pY += this.vY;
    }


    
}
        

