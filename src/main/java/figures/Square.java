package figures;

import java.util.Arrays;
import java.util.List;

import components.Point;
import utils.GeometricUtil;

public class Square implements PlaneFigure {
    private final List<Point> points;
    private final double width;

    public Square(Point a, Point b, Point c, Point d) {
        if (!GeometricUtil.validateSquare(a, b, c, d)) {
            throw new IllegalArgumentException("This points do not create square");
        }
        points = Arrays.asList(a, b, c, d);
        GeometricUtil.sortPointsClockwise(points);
        List<Double> distances = GeometricUtil.getPossibleSquareDistancies(points);
        width = Math.sqrt(distances.get(0));
    }

    @Override
    public double getArea() {
        return width * width;
    }

    public List<Point> getPoints() {
        return points;
    }

    public double getWidth() {
        return width;
    }
}
