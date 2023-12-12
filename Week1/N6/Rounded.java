package Misha.Week1.N6;

import java.util.Objects;

public class Rounded extends Point {
    protected double radius;
    protected Point point1;
    protected Point point2;
    protected double C;

    public Rounded(Point point1, Point point2) {
        super(point1.x, point1.y);
        this.point1 = point1;
        this.point2 = point2;
        this.radius = Math.sqrt(Math.pow((point1.x - point2.x), 2) + Math.pow((point1.y - point2.y), 2));
        C = 2 * Math.PI * radius;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getC() {
        return C;
    }

    public void setC(double c) {
        C = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rounded rounded = (Rounded) o;
        return Double.compare(rounded.radius, radius) == 0 && Double.compare(rounded.C, C) == 0 && Objects.equals(point1, rounded.point1) && Objects.equals(point2, rounded.point2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius, point1, point2, C);
    }

    @Override
    public String toString() {
        return "Rounded{" +
                "radius=" + radius +
                ", point1=" + point1 +
                ", point2=" + point2 +
                ", C=" + C +
                '}';
    }
}
