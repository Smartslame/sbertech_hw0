package figures;

import java.math.BigDecimal;

import components.Point;
import org.junit.Assert;
import org.junit.Test;

public class SquareTest {
    @Test
    public void getArea() {
        Square square = new Square(
                new Point(0, 5),
                new Point(5, 5),
                new Point(0, 0),
                new Point(5, 0)
        );

        double expectedArea = 25;
        Assert.assertEquals(BigDecimal.valueOf(expectedArea), BigDecimal.valueOf(square.getArea()));
    }
}
