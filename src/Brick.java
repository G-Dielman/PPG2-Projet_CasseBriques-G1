public class Brick {
    private double pX, pY;
    private boolean broken;

    public Brick(double pX , double pY){
        this.pX= pX;
        this.pY =pY;
        this.broken= false;
    }

    public double getpX(){
        return pX;
    }
    public void setpX(double pX){
        this.pX = pX;
    }

    public double getpY(){
        return pY;
    }

    // une érreur ici dans le setter de pY, il faut changer le nom de la variable en pY
    public void setpY(double pX){
        this.pY = pY;
    }

    public boolean getBroken(){
        return broken;
    }
    public void setBroken(boolean broken){
        this.broken=broken;
    }
}
