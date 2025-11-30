package CSC372Mod8;

import java.util.ArrayList;
import java.util.List;

public class Inventory 
{

    // main inventory and lending inventory
    private List<Book> main_inventory;
    private List<Book> lending_inventory;

    public Inventory() 
    {
        main_inventory = new ArrayList<>();
        lending_inventory = new ArrayList<>();
    }

    // create a new Book and add it to main inventory
    public void addBook(Book book) 
    {
        main_inventory.add(book);
        System.out.println("Book added to the library.");
    }

    // move from main to lending if available
    public void borrowBook(int id) 
    {
        Book found = findBookById(main_inventory, id);
        if (found != null) 
        {
            main_inventory.remove(found);
            lending_inventory.add(found);
            System.out.println("Book successfully borrowed.");
        } else 
        {
            // check if the book is already borrowed
            if (findBookById(lending_inventory, id) != null) 
            {
                System.out.println("Book is already borrowed.");
            } else 
            {
                System.out.println("Book not found in the library.");
            }
        }
    }

    // move from lending back to main
    public void returnBook(int id) 
    {
        Book found = findBookById(lending_inventory, id);
        if (found != null) 
        {
            lending_inventory.remove(found);
            main_inventory.add(found);
            System.out.println("Book successfully returned.");
        } else 
        {
            System.out.println("Book is not in the lending inventory.");
        }
    }

    // show all books currently in main inventory
    public void printAll() 
    {
        if (main_inventory.isEmpty()) 
        {
            System.out.println("No books currently available in the library.");
            return;
        }
        System.out.println("Books currently available in the library:");
        for (Book b : main_inventory) 
        {
            b.printBookInfo();
        }
    }

    // basic search by title name
    public void searchByTitle(String title_part) 
    {
        String query = title_part.toLowerCase();
        boolean found_any = false;

        for (Book b : main_inventory) 
        {
            if (b.getTitle().toLowerCase().contains(query)) 
            {
                b.printBookInfo();
                found_any = true;
            }
        }

        if (!found_any) 
        {
            System.out.println("No matching book found.");
        }
    }

    // find book by id in a List
    private Book findBookById(List<Book> list, int id) {
        for (Book b : list) 
        {
            if (b.getId() == id) 
            {
                return b;
            }
        }
        return null;
    }

    // getter for main inventory count
    public int getMainInventoryCount() 
    {
        return main_inventory.size();
    }
}