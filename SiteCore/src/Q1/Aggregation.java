package Q1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fahmihafiz
 */
public class Aggregation extends GeometricFigures{
    private List<GeometricFigures> figureList = new ArrayList<>();
    
    public void addFigure(GeometricFigures a) {
        figureList.add(a);
    }
    
    public void AGperformBehavior(){
        for(int x = 0; x < figureList.size(); x++ ){
            figureList.get(x).performBehavior();
        }
    }
    
    public void AGrotate(){
        for (GeometricFigures figure : figureList) {
            figure.setBehavior(new Rotate());
            figure.display();
            figure.performBehavior();
        }
        
    }
    
    public void AGmove(){
        for (GeometricFigures figure : figureList) {
            figure.setBehavior(new Move());
            figure.display();
            figure.performBehavior();
        }
    }
    
    
    @Override
    public void display() {
        System.out.print("\nI am an aggregation of figures: ");
        for (GeometricFigures figure : figureList) {
            figure.display();
        }
    }
}
