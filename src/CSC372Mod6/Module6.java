package CSC372Mod6;

import java.util.ArrayList;

/*
 * CSC 372 - Module 6
 * Matthew Finney
 * Sorts a list of Student objects using selection sort and different comparators
 * https://github.com/matt-finney/CSC372
 */

public class Module6 
{
    public static void main(String[] args) 
    {

        ArrayList<Student> students = new ArrayList<>();

        // Add 10 students (new names, new roll number order)
        students.add(new Student(8, "Ethan", "500 Ocean Ave"));
        students.add(new Student(1, "Lily", "23 Highland Blvd"));
        students.add(new Student(6, "Jackson", "77 Forest Dr"));
        students.add(new Student(3, "Grace", "9 Lakeview Rd"));
        students.add(new Student(10, "Mason", "120 Sunrise St"));
        students.add(new Student(2, "Ella", "305 Valley Ct"));
        students.add(new Student(9, "Logan", "18 Harbor Pl"));
        students.add(new Student(4, "Scarlett", "62 Summit Ln"));
        students.add(new Student(7, "Avery", "44 Glenwood Cir"));
        students.add(new Student(5, "Harper", "15 Brookside Way"));

        System.out.println("Original List:");
        printList(students);

        System.out.println("\nSorted by Name:");
        SelectionSorter.selectionSort(students, new NameComparator());
        printList(students);

        System.out.println("\nSorted by Roll Number:");
        SelectionSorter.selectionSort(students, new RollNoComparator());
        printList(students);
    }

    private static void printList(ArrayList<Student> list) 
    {
        for (Student s : list) {
            System.out.println(s);
        }
    }
}

