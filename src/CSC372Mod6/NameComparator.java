package CSC372Mod6;

import java.util.Comparator;

// Comparator to compare Students by name
public class NameComparator implements Comparator<Student> 
{
    @Override
    public int compare(Student s1, Student s2) 
    {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}

