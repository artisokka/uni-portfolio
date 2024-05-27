
package fi.tuni.prog3.shapes;

/**
 *
 * @author janik
 */
public class Rectangle implements IShapeMetrics {

    private double height = 0.00;
    private double width = 0.00;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public String toString() {
        return String.
                format("Rectangle with height %.2f and width %.2f", height,
                        width);
    }

    public String name() {
        return "rectangle";
    }

    public double area() {
        return width * height;
    }

    public double circumference() {
        return this.width * 2 + this.height * 2;
    }
}
