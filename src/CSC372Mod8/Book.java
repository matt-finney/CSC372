package CSC372Mod8;

public class Book 
{

    private int id;          
    private String title;
    private String author;
    private String isbn;
    private int pages;

    // default constructor
    public Book() 
    {
        this.id = 0;
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.pages = 0;
    }

    // parameterized constructor
    public Book(int id, String title, String author, String isbn, int pages) 
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    // getters
    public int getId() 
    {
        return id;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    public String getIsbn() 
    {
        return isbn;
    }

    public int getPages() 
    {
        return pages;
    }

    // setters
    public void setId(int id) 
    {
        this.id = id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public void setIsbn(String isbn) 
    {
        this.isbn = isbn;
    }

    public void setPages(int pages) 
    {
        this.pages = pages;
    }

    // method to print book information
    public void printBookInfo() 
    {
        System.out.println("--------------------------------------");
        System.out.println("ID:     " + id);
        System.out.println("Title:  " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN:   " + isbn);
        System.out.println("Pages:  " + pages);
    }
}