package fi.tuni.prog3.shapes;

/**
 *
 * @author janik
 */
public class Circle implements IShapeMetrics {

    private double radius = 0.00;

    public Circle(double radius) {

        this.radius = radius;
    }

    public String toString() {
        return String.format("Circle with radius: %.2f", radius);
    }

    public String name() {
        return "circle";
    }

    public double area() {
        return IShapeMetrics.PI * (radius * radius);
    }

    public double circumference() {
        return 2 * IShapeMetrics.PI * radius;
    }
}
