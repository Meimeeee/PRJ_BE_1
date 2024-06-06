
package Management;
import java.util.ArrayList;
import java.util.List;

public class Author implements DatFormat{
    private final int authorID;
    private String authorName;
    private List<Book> books;

     public int getAuthorID() {
        return authorID;
    }
    
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String Name) {
        this.authorName = Name;
    }

    public List<Book> getBooks() {
        return books; //lấy danh sách sách của tác giả
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
     public Author(int authorID, String Name) {
        this.authorID = authorID;
        this.authorName = Name;
        this.books = new ArrayList<>();
    }

    public Book wirteBook(int BookID, String bookName, int count, double price) {
        BookManager bookManager = new BookManager();
        Book b = bookManager.createBook(BookID, bookName, this, count, price);
        return b;
    }
   
    public void addBook(Book b){
        books.add(b);
        b.setAuthor(this);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public void printAllBook(){
        for(Book b : books){
            if(b.getAuthor() == this) {
                System.out.println(b);
            }
        }
    }
    
    @Override
    public String toString() {
        return "Author{" + authorID + ", "
                + authorName + "}";  
   }     

    @Override
    public List<String> toDatFormat() {
        List<String> dat = new ArrayList<>();
        dat.add(String.valueOf(authorID));
        dat.add(authorName);
        return dat;
    }
}
