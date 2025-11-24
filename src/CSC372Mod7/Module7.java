package CSC372Mod7;

import java.util.Scanner;

/*
 * CSC372 - Module 7 Portfolio Assignment
 * Matthew Finney
 * Prompts user for 5 numbers and uses recursion to calculate the product, sum, average, min, and max
 * https://github.com/matt-finney/CSC372
 */

public class Module7 
{
    // recursive method to calculate product
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

    // recursive method to calculate sum
    public static int sum(int[] numbers, int index)
    {
        // Base case: last element
        if (index == numbers.length - 1)
        {
            return numbers[index];
        }

        // Recursive case: current number + sum of remaining numbers
        return numbers[index] + sum(numbers, index + 1);
    }

    // Method to calculate average
    public static double average(int[] numbers)
    {
        // use recursive sum
        int total = sum(numbers, 0);
        return (double) total / numbers.length;
    }

    // recursive method to find minimum number
    public static int min(int[] numbers, int index)
    {
        // Base case: last element
        if (index == numbers.length - 1)
        {
            return numbers[index];
        }

        // Recursive case: compare the current number to min of rest
        int next_min = min(numbers, index + 1);

        if (numbers[index] < next_min)
        {
            return numbers[index];
        }
        else
        {
            return next_min;
        }
    }

    // recursive method to find maximum number
    public static int max(int[] numbers, int index)
    {
        // Base case: last element
        if (index == numbers.length - 1)
        {
            return numbers[index];
        }

        // Recursive case: compare the current number to max of rest
        int next_max = max(numbers, index + 1);
        if (numbers[index] > next_max)
        {
            return numbers[index];
        }
        else
        {
            return next_max;
        }
    }

    // prints all numbers entered by the user
    public static void printNumbers(int[] numbers)
    {
        System.out.println("You entered: ");

        for (int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i]);

            if (i < numbers.length - 1)
            {
                System.out.print(", ");
            }
        }

        System.out.println();
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

        // echo all numbers back to user
        printNumbers(numbers);

        // recursive calculations
        int product_result = product(numbers, 0);
        int sum_result = sum(numbers, 0);
        double avg_result = average(numbers);
        int min_result = min(numbers, 0);
        int max_result = max(numbers, 0);

        // display results
        System.out.println("The product of all 5 numbers is: " + product_result);
        System.out.println("The sum of the numbers is: " + sum_result);
        System.out.println("The average of the numbers is: " + avg_result);
        System.out.println("The minimum value is: " + min_result);
        System.out.println("The maximum value is: " + max_result);

        scanner.close();
    }
}