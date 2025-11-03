package CSC372Mod4;

/**
 * Cylinder with radius and height.
 */

public class Cylinder extends Shape 
{
    private double radius;
    private double height;

    // parameterized constructor
    public Cylinder(double radius, double height) 
    {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() 
    {
        // returns the surface area of the cylinder
        return 2 * Math.PI * radius * (height + radius);
    }

    @Override
    public double volume() 
    {
        // returns the volume of the cylinder
        return Math.PI * radius * radius * height;
    }

    @Override
    public String toString() 
    {
        return String.format
        (
            "%s (radius=%.3f, height=%.3f)%n  surface area = %.3f%n  volume       = %.3f",
            super.toString(), radius, height, surface_area(), volume()
        );
    }
}