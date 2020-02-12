package figures;

import java.math.BigDecimal;

import components.Point;

public class Circle implements PlaneFigure {

    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        if (BigDecimal.valueOf(radius).compareTo(BigDecimal.valueOf(0.)) <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0");
        }

        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * radius;
    }
}
