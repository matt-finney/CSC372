package CSC372Mod6;

import java.util.Comparator;

// Comparator to compare Students by roll number
public class RollNoComparator implements Comparator<Student> 
{
    @Override
    public int compare(Student s1, Student s2) 
    {
        return Integer.compare(s1.getRollno(), s2.getRollno());
    }
}

