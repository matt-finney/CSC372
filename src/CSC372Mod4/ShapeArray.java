package CSC372Mod4;

/*
 * CSC372 - Module 4
 * Matthew Finney
 * A class to demonstrate polymorphism with an array of Shape objects
 * Prints the surface area and volume of each shape
 * https://github.com/matt-finney/CSC372
 */

public class ShapeArray 
{
    public static void main(String[] args) 
    {
        // create one of each shape
        Sphere sphere = new Sphere(3.0);                   // radius 3
        Cylinder cylinder = new Cylinder(2.0, 5.0); // radius 2, height 5
        Cone cone = new Cone(2.0, 5.0);             // radius 2, height 5

        // store shapes in an array
        Shape[] shape_array = {sphere, cylinder, cone};

        // loop through the array and print each shape's data
        for (Shape s : shape_array) 
        {
            System.out.println(s.toString());
            System.out.println();
        }
    }
}