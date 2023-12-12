package Misha.Week1.N6;

import java.util.Objects;

public class Circle extends Point {
    protected double radius;
    protected Point point1;
    protected Point point2;
    protected double S;

    public Circle(Point point1, Point point2) {
        super(point1.x, point1.y);
        this.point1 = point1;
        this.point2 = point2;
        this.radius = Math.sqrt(Math.pow((this.point1.x - this.point2.x), 2) + Math.pow((this.point1.y - this.point2.y), 2));
        S = Math.PI* Math.pow(this.radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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

    public double getS() {
        return S;
    }

    public void setS(double s) {
        S = s;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Equals -> "+ this + " : " + o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && Double.compare(circle.S, S) == 0 && Objects.equals(point1, circle.point1) && Objects.equals(point2, circle.point2);
    }

    @Override
    public int hashCode() {
        System.out.println("HashCode -> "+ this);
        return Objects.hash(super.hashCode(), radius, point1, point2, S);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", point1=" + point1 +
                ", point2=" + point2 +
                ", S=" + S +
                '}';
    }
}
