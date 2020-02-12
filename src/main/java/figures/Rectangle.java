package figures;

import java.util.Arrays;
import java.util.List;

import components.Point;
import utils.GeometricUtil;

public class Rectangle implements PlaneFigure {
    private final List<Point> points;
    private final double width;
    private final double length;

    public Rectangle(Point a, Point b, Point c, Point d) {
        if (!GeometricUtil.validateRectangle(a, b, c, d)) {
            throw new IllegalArgumentException("This points do not create rectangle");
        }

        points = Arrays.asList(a, b, c, d);
        GeometricUtil.sortPointsClockwise(points);
        List<Double> distances = GeometricUtil.getPossibleSquareDistancies(points);
        width = Math.sqrt(distances.get(0));
        length = Math.sqrt(distances.get(1));
    }

    @Override
    public double getArea() {
        return width * length;
    }

    public List<Point> getPoints() {
        return points;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
}
