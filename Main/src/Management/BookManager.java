package Management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookManager {

    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    public void readBooks() {
        FileManager fileManager = new FileManager();
        AuthorManager authorManager = new AuthorManager();
        books = new ArrayList<>();
        
        List<List<String>> data = fileManager.readFile("src/Management/books.dat");
        for (List<String> lineData : data) {
            Author author = new Author(Integer.parseInt(lineData.get(2)), lineData.get(3));
            if (author != null) {
                Book b = new Book(Integer.parseInt(lineData.get(0)), lineData.get(1), author, Integer.parseInt(lineData.get(4)), Double.parseDouble(lineData.get(5)));
                books.add(b);

            }
        }
    }

    public void printAllBook() {
        readBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book createBook(int BookID, String bookName, Author author, int count, double price) {
        Book b = new Book(BookID, bookName, author, count, price);
        books.add(b);
        return b;
    }

    public void RemoveBook(String bookName) {
    Iterator<Book> iterator = books.iterator(); 
    while (iterator.hasNext()) {
        Book book = iterator.next();
        if (book.getBookName().equals(bookName)) {
            iterator.remove();
            System.out.println("Removed!!");
            return;
        }
    }
    System.out.println("Book's name doesn't exist!!");
}

    public void updateBook(String bookName, String NewBookName) {
        readBooks();
        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                book.setBookName(NewBookName);
                System.out.println("Update successfully!!");
                return;
            }
        }
        System.out.println("Book's name doesn't exist !!");
    }

    public Book findByBookName(String bookName) {
        readBooks();
        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public Book findByBookID(int bookID) {
        readBooks();
        for (Book book : books) {
            if (book.getBookID() == bookID) {
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
    public void save() {
        List<List<String>> data = new ArrayList<>();
        FileManager fileManager = new FileManager();
        for (Book book : books) {
            List<String> lineData = new ArrayList<>();
            lineData.add(String.valueOf(book.getBookID()));
            lineData.add(book.getBookName());
            lineData.add(String.valueOf(book.getAuthor().getAuthorID()));
            lineData.add(String.valueOf(book.getAuthor().getAuthorName()));
            lineData.add(String.valueOf(book.getCount()));
            lineData.add(String.valueOf(book.getPrice()));
            data.add(lineData);
        }
        fileManager.writeFile("src/Management/books.dat", data);
    }
}
