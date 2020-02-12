package utils;

import java.util.Arrays;
import java.util.List;

import components.Point;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class GeometricUtilTest {

    @Test
    public void getCenterPoint() {
        List<Point> points = Arrays.asList(
                new Point(-1, 0),
                new Point(0, 1),
                new Point(1, 0),
                new Point(0, -1)
        );
        Assert.assertEquals(new Point(0, 0), GeometricUtil.getCenterPoint(points));
    }

    @Test
    public void validateSquare() {
        try {
            GeometricUtil.validateSquare(
                    new Point(1, 1),
                    new Point(-1, 1),
                    new Point(-1, -1),
                    new Point(1, 1)
            );
            fail("Exception was excepted for repeatable points input");
        } catch (IllegalArgumentException e) {
        }

        // non square
        Assert.assertFalse(GeometricUtil.validateSquare(
                new Point(1, 1),
                new Point(-1, 1),
                new Point(-1, -1),
                new Point(1, 0)
        ));

        // square
        Assert.assertTrue(GeometricUtil.validateSquare(
                new Point(1, 1),
                new Point(-1, 1),
                new Point(-1, -1),
                new Point(1, -1)
        ));
    }

    @Test
    public void validateRectangle() {
        try {
            GeometricUtil.validateRectangle(
                    new Point(1, 1),
                    new Point(-1, 1),
                    new Point(-1, -1),
                    new Point(1, 1)
            );
            fail("Exception was excepted for repeatable points input");
        } catch (IllegalArgumentException e) {
        }

        // non square
        Assert.assertFalse(GeometricUtil.validateRectangle(
                new Point(1, 1),
                new Point(-1, 1),
                new Point(-1, -1),
                new Point(1, 0)
        ));

        // square
        Assert.assertTrue(GeometricUtil.validateRectangle(
                new Point(1, 1),
                new Point(-1, 1),
                new Point(-1, -1),
                new Point(1, -1)
        ));

        // rectangle
        Assert.assertTrue(GeometricUtil.validateRectangle(
                new Point(0, 1),
                new Point(0, 0),
                new Point(5, 1),
                new Point(5, 0)
        ));
    }

    @Test
    public void sortPointsClockwise() {
        List<Point> points = Arrays.asList(
                new Point(1, 0),
                new Point(-1, 0),
                new Point(0, 1),
                new Point(0, -1)
        );

        List<Point> expectedPoints = Arrays.asList(
                new Point(0, 1),
                new Point(1, 0),
                new Point(0, -1),
                new Point(-1, 0)
        );

        GeometricUtil.sortPointsClockwise(points);

        Assert.assertEquals(expectedPoints, points);
    }
}
