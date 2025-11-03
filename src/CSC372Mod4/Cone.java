package CSC372Mod4;

/**
 * Cone with radius and height.
 */

public class Cone extends Shape 
{
    private double radius;
    private double height;

    // parameterized constructor
    public Cone(double radius, double height) 
    {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() 
    {
        // returns the surface area of the cone
        double slant = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slant);
    }

    @Override
    public double volume() 
    {
        // returns the volume of the cone
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
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