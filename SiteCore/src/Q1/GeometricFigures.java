package Q1;

/**
 *
 * @author fahmihafiz
 */
public abstract class GeometricFigures {
    Behavior bh;
    
    public void performBehavior(){
        bh.move();
    }
    
    public void setBehavior(Behavior a){
        this.bh = a;
    }
    public abstract void display();
}
