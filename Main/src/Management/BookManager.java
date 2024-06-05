
package Management;

import java.util.ArrayList;
import java.util.List;

    public class BookManager{
        
        private List<Book> books = new ArrayList<>();
        private List<Author> authors = new ArrayList<>();
        
        public void readBooks(){
            FileManager fileManager = new FileManager();
            AuthorManager authorManager = new AuthorManager();

            List<List<String>> data = fileManager.readFile("src/Management/books.dat");
            for(List<String> lineData : data){
                Author author = authorManager.findByAuthorID(Integer.parseInt(lineData.get(2)));
                Book b = new Book(Integer.parseInt(lineData.get(0)), lineData.get(1), author, Integer.parseInt(lineData.get(4)),Double.parseDouble(lineData.get(5)));
                books.add(b);
                
            }
        }
        
        public void printAllBook(){
            readBooks();
            for(Book book : books){
                System.out.println(book);
            }
        }
        
    public Book createBook(int BookID, String bookName, Author author, int count, double price)
    {
        Book b = new Book(BookID, bookName, author, count, price);
        books.add(b);
        return b;
    }
    
     public Book addBook(Book b){
        books.add(b);
        return b;
    }

    public void RemoveBook(String bookName){
        for(Book book : books){
            if(book.getBookName().equals(bookName)){
               books.remove(book);
               break;
            }
            else
                System.out.println("Book's name doesn't exist!!");
        }
    }
    
    public void updateBook(String bookName, String NewBookName){
        for(Book book : books){
            if(book.getBookName().equals(bookName)){
                book.setBookName(NewBookName);
                break;
            } else System.out.println("Book's name doesn't exist !!");
                
        }
    }
    
    public Book findByBookName(String bookName){
        readBooks();
        for(Book book : books){
            if(book.getBookName().equals(bookName)){
                return book;
            }
        }
        return null;
    }   
    
    public Book findByBookID(int bookID){
        readBooks();
        for(Book book : books){
            if(book.getBookID() == bookID){
                return book;
            }
        }
        return null;
    }   
    
//    public Book findByAuthorName(String authorName){
//        for(Book book : books){
//            if(author.getAuthor().equals(authorName));
//            return book;
//        }
//    }
    
       public void save(){
        FileManager fileManager = new FileManager();
        fileManager.writeFile("src/Management/books.dat", new ArrayList<>());
    }
    
}
