package CSC372Mod4;

/**
 * Abstract base class for 3D shapes.
 */

public abstract class Shape 
{
    // Returns the surface area of the shape as a double
    public abstract double surface_area();

    // Returns the volume of the shape as a double
    public abstract double volume();

    // Returns the class name e.g., "Sphere", "Cylinder", "Cone"
    @Override
    public String toString() 
    {
        return getClass().getSimpleName();
    }
}