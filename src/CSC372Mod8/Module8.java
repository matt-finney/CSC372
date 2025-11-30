package CSC372Mod8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Module8 
{

    public static void main(String[] args) 
    {

        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) 
        {
            printMenu();
            try 
            {
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) 
                {
                    case 1: // add book
                        addBookFlow(inventory, scanner);
                        break;

                    case 2: // borrow book
                        borrowBookFlow(inventory, scanner);
                        break;

                    case 3: // return book
                        returnBookFlow(inventory, scanner);
                        break;

                    case 4: // search by title
                        searchByTitleFlow(inventory, scanner);
                        break;

                    case 5: // print all books
                        inventory.printAll();
                        break;

                    case 6: // exit
                        System.out.println("Exiting the program...");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option. Please choose 1–6.");
                }
            } catch (InputMismatchException ex) 
            {
                // checks for invalid numeric input
                System.out.println("Invalid input. Please enter a number for the menu or ID.");
                scanner.nextLine();
            }
            System.out.println();
        }

        scanner.close();
    }

    // menu display
    private static void printMenu() 
    {
        System.out.println("===== Library Menu =====");
        System.out.println("1. Add Book");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Search by Title");
        System.out.println("5. Print All Books");
        System.out.println("6. Exit");
    }

    // options to add book
    private static void addBookFlow(Inventory inventory, Scanner scanner) 
    {
        try 
        {
            System.out.print("Enter book id number: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            System.out.print("Enter author: ");
            String author = scanner.nextLine();

            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();

            System.out.print("Enter number of pages: ");
            int pages = scanner.nextInt();
            scanner.nextLine();

            Book book = new Book(id, title, author, isbn, pages);
            inventory.addBook(book);
        } catch (InputMismatchException ex) 
        {
            System.out.println("Invalid numeric input while adding a book.");
            scanner.nextLine(); 
        }
    }

    // options to borrow book
    private static void borrowBookFlow(Inventory inventory, Scanner scanner) 
    {
        try 
        {
            System.out.print("Enter the ID of the book to borrow: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            inventory.borrowBook(id);
        } catch (InputMismatchException ex) 
        {
            System.out.println("Invalid ID. Please enter a whole number.");
            scanner.nextLine();
        }
    }

    // options to return book
    private static void returnBookFlow(Inventory inventory, Scanner scanner) 
    {
        try 
        {
            System.out.print("Enter the ID of the book to return: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            inventory.returnBook(id);
        } catch (InputMismatchException ex) 
        {
            System.out.println("Invalid ID. Please enter a whole number.");
            scanner.nextLine();
        }
    }

    private static void searchByTitleFlow(Inventory inventory, Scanner scanner) 
    {
        System.out.print("Enter full or partial book title: ");
        String titlePart = scanner.nextLine();
        inventory.searchByTitle(titlePart);
    }
}

