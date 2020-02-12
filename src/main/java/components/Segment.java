package components;

import java.util.Objects;

public class Segment {
    private final Point left;
    private final Point right;

    public Segment(Point left, Point right) {
        this.left = left;
        this.right = right;
    }

    public double getSquareLength() {
        return Math.pow((right.getX() - left.getX()), 2) + Math.pow((right.getY() - left.getY()), 2);
    }

    public double getLength() {
        return Math.sqrt(getSquareLength());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return left.equals(segment.left) &&
                right.equals(segment.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
