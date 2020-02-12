package figures;

import java.math.BigDecimal;

import components.Point;
import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

    @Test
    public void getArea() {
        Rectangle rectangle = new Rectangle(
                new Point(0, 5),
                new Point(6, 5),
                new Point(0, 0),
                new Point(6, 0)
        );

        double expectedArea = 30;
        Assert.assertEquals(BigDecimal.valueOf(expectedArea), BigDecimal.valueOf(rectangle.getArea()));
    }
}
