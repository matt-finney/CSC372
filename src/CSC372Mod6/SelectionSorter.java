package CSC372Mod6;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSorter 
{

    // Generic selection sort for Student objects
    public static void selectionSort(ArrayList<Student> list, Comparator<Student> comp) 
    {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) 
        {
            int min_index = i;

            for (int j = i + 1; j < n; j++) 
            {
                // Use comparator to find the min element
                if (comp.compare(list.get(j), list.get(min_index)) < 0) 
                {
                    min_index = j;
                }
            }
            // Swap the found minimum element with the first element
            Student temp = list.get(i);
            list.set(i, list.get(min_index));
            list.set(min_index, temp);
        }
    }
}

