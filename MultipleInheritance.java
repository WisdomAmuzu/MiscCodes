/**
 *
 * @author Sneaky
 */
 
/**
 * Separate .java files can be created for the separate classes
 */
 
//abstract class GeometricObject
abstract class GeometricObject {
    public abstract double getPerimeter();
    public abstract double getArea();
}
 
//interface Resizable
public interface Resizeable {
    void resize(int percent);
}
 
//class Circle extends GeometricObject
public class Circle extends GeometricObject  {
    protected double radius = 1.0;
    public Circle() {
 
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getPerimeter() {
        return 0.0;
    }
 
    public double getArea() {
        return 0.0;
    }
 
    @Override
    public String toString() {
        return "";
    }
}
 
//class Rectangle extends GeometricObject
public class Rectangle extends GeometricObject{
    protected double width = 1.0;
    protected double length = 1.0;
    public Rectangle() {
 
    }
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public double getPerimeter() {
        return 0.0;
    }
 
    public double getArea() {
        return 0.0;
    }
 
    @Override
    public String toString() {
        return "";
    }
}
 
//class ResizeableCircle extends circle implements Resizeable
public class ResizeableCircle extends Circle implements Resizeable{
    public ResizeableCircle(double radius) {
 
    }
 
    public void resize(int radius) {
 
    }
}
 
//class ResizeableRectangle extends Rectangle implements Resizeable
public class ResizeableRectangle extends Rectangle implements Resizeable{
    public ResizeableRectangle(double width, double length) {
 
    }
    public void resize(int percent) {
 
    }
}
 
