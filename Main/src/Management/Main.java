
package Management;

public class Main {

    public static void main(String[] args) {
        
        AuthorManager authorManager = AuthorManager.getInstance();
        BookManager bookManager = BookManager.getInstance();
        Author a1 = new Author(110, "Neyui");
        Author a2 = new Author(111, "Nunu");
        
        authorManager.addAuthor(a1);
        authorManager.addAuthor(a2);
        
        Book b1 = new Book(001, "Saasa", a1, 19.99);
        Book b2 = new Book(002, "Dadaa", a2, 15.50);
        Book b3 = new Book(003, "another", a2, 12.50);
        
        bookManager.addBook(b1);
        bookManager.addBook(b2);
        bookManager.addBook(b3);
        
        a1.wirteBook(004, "The Meeting", 10.00); 
        
        authorManager.displayAllAuthor();
        bookManager.displayAllBook();
        
        System.out.println("The Neyui's Books: ");
        a1.printBook();
        
        
        
        

    }
    
}
