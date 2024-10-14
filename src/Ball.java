public class Ball {
    private double pX,pY,vX,vY,radius,move; //Initialisation des attributs de l'objet

    public Ball(double pX,double pY,double vX,double vY){ //constructeur
        this.pX = pX;
        this.pY = pY;
        this.vX = vX;
        this.vY = vY;
    }

    public double getpX(){ //Getters de la position X
        return pX;
    }
    public void setpX(double pX){ //Setters del a position X
        this.pX = pX;
    }
    public double getpY(){
        return pY;
    }
    public void setpY(double pY){
        this.pY = pY;
    }
    public double getvX(){ //getters Vitesse X
        return vX;
    }
    public void setvX(double vX){ //Setters Vitesse X
        this.vX = vX;
    }
    public double getvY(){
        return vY;
    }
    public void setvY(double vY){
        this.vY = vY;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }

    public void move(){
        this.pX += this.vX;
        this.pY += this.vY;
    }


    
}
        

