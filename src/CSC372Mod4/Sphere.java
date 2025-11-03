package CSC372Mod4;

/**
 * Sphere with a given radius.
 */

public class Sphere extends Shape 
{
    private double radius;

    // parameterized constructor
    public Sphere(double radius) 
    {
        this.radius = radius;
    }

    @Override
    public double surface_area() 
    {
        // returns the surface area of the sphere
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double volume() 
    {
        // returns the volume of the sphere
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    @Override
    public String toString() 
    {
        return String.format
        (
            "%s (radius=%.3f)%n  surface area = %.3f%n  volume       = %.3f",
            super.toString(), radius, surface_area(), volume()
        );
    }
}