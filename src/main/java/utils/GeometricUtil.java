package utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import components.Point;
import components.Segment;

public class GeometricUtil {
    public static Point getCenterPoint(List<Point> points) {
        double centralX = points.stream().map(Point::getX).reduce(0., Double::sum) / points.size();
        double centralY = points.stream().map(Point::getY).reduce(0., Double::sum) / points.size();
        return new Point(centralX, centralY);
    }


    public static List<Double> getPossibleSquareDistancies(List<Point> points) {
        // dist will store unique 'square of distances'
        Set<Double> dist = new HashSet<>();

        for (int i = 0; i < points.size() - 1; ++i) {
            for (int j = i + 1; j < points.size(); j++) {
                dist.add(new Segment(points.get(i), points.get(j)).getSquareLength());
            }
        }

        return new ArrayList<>(dist);
    }

    public static boolean validateSquare(Point a, Point b, Point c, Point d) throws IllegalArgumentException {
        return validateRectangle(a, b, c, d) && getPossibleSquareDistancies(Arrays.asList(a, b, c, d)).size() == 2;
    }

    public static boolean validateRectangle(Point a, Point b, Point c, Point d) throws IllegalArgumentException {
        try {
            Set.of(a, b, c, d);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("All points must be different");
        }

        List<Point> points = Arrays.asList(a, b, c, d);

        List<Double> possibleDistancies = getPossibleSquareDistancies(points);

        // if total unique distance are more than 3,
        // then line segment can't make a rectangle
        if (possibleDistancies.size() > 3)
            return false;

        // If line seqments form a square
        if (possibleDistancies.size() == 2)
            return BigDecimal.valueOf(2 * possibleDistancies.get(0)).equals(BigDecimal.valueOf(possibleDistancies.get(1)));

        // distance of sides should satisfy pythagorean theorem
        return BigDecimal.valueOf(possibleDistancies.get(0) + possibleDistancies.get(1)).equals(BigDecimal.valueOf(possibleDistancies.get(2)));
    }

    public static void sortPointsClockwise(List<Point> points) {
        Point center = getCenterPoint(points);

        points.sort(getClockwiseComparator(center));
    }

    private static Comparator<Point> getClockwiseComparator(Point center) {
        return (p1, p2) -> {
            if (p1.getX() - center.getX() >= 0 && p2.getX() - center.getX() < 0)
                return -1;
            if (p1.getX() - center.getX() < 0 && p2.getX() - center.getX() >= 0)
                return 1;
            if (p1.getX() - center.getX() == 0 && p2.getX() - center.getX() == 0) {
                if (p1.getY() - center.getY() >= 0 || p2.getY() - center.getY() >= 0)
                    return Double.compare(p2.getY(), p1.getY());
                return Double.compare(p1.getY(), p2.getY());
            }

            // compute the cross product of vectors (center -> a) x (center -> b)
            double det =
                    (p1.getX() - center.getX()) * (p2.getY() - center.getY()) - (p2.getX() - center.getX()) * (p1.getY() - center.getY());
            if (det < 0)
                return -1;
            if (det > 0)
                return 1;

            // points p1 and p2 are on the same line from the center
            // check which point is closer to the center
            double d1 =
                    (p1.getX() - center.getX()) * (p1.getX() - center.getX()) + (p1.getY() - center.getY()) * (p1.getY() - center.getY());
            double d2 =
                    (p2.getX() - center.getX()) * (p2.getX() - center.getX()) + (p2.getY() - center.getY()) * (p2.getY() - center.getY());
            return Double.compare(d2, d1);
        };
    }
}
