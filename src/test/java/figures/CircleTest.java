package figures;

import java.math.BigDecimal;

import components.Point;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class CircleTest {

    @Test
    public void creationTest() {
        try {
            new Circle(new Point(0, 0), -1);
            fail("Exception was excepted for negative radius input");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void getArea() {
        Circle circle = new Circle(new Point(0, 0), 5);
        double expectedArea = Math.PI * 25;
        Assert.assertEquals(BigDecimal.valueOf(expectedArea), BigDecimal.valueOf(circle.getArea()));
    }
}
