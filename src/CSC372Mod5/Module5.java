package CSC372Mod5;

import java.util.Scanner;

/*
 * CSC372 - Module 5
 * Matthew Finney
 * Prompts the user to enter 5 numbers and calculates their product using a recursive method
 * https://github.com/matt-finney/CSC372
 */

public class Module5 {

    // Recursive method to calculate product
    public static int product(int[] numbers, int index) 
    {
        // Base case: if we're at the last number, return it
        if (index == numbers.length - 1) 
        {
            return numbers[index];
        }

        // Recursive case: multiply current number by product of the rest
        return numbers[index] * product(numbers, index + 1);
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");

        // get 5 numbers from user
        for (int i = 0; i < 5; i++) 
        {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // get product using recursion
        int result = product(numbers, 0);

        System.out.println("The product of all 5 numbers is: " + result);

        scanner.close();
    }
}
