/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Q1;

/**
 *
 * @author fahmihafiz
 */
public class Test {
    public static void main(String[] args) {
        GeometricFigures point = new Point();
        GeometricFigures line = new Line();
        GeometricFigures circle = new Circle();

        Aggregation aggregation = new Aggregation();
        aggregation.addFigure(point);
        aggregation.addFigure(line);
        aggregation.addFigure(circle);

        aggregation.display();

        System.out.println("\n\n\nMoving all figures:");
        aggregation.AGmove();

        System.out.println("\nRotating all figures:");
        aggregation.AGrotate();
    }
}
