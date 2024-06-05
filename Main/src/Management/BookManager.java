/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.util.ArrayList;
import java.util.List;

    public class BookManager{
//        private static BookManager instance;
//        public static BookManager getInstance(){
//            if(instance == null) instance = new BookManager();
//            return instance;
//        }
        
        private List<Book> books = new ArrayList<>();
        
        public void BookManager(){
//            FileManager fileManager = FileManager.getInstance();
//            AuthorManager authorManager = AuthorManager.getInstance();

            FileManager fileManager = new FileManager();
            AuthorManager authorManager = new AuthorManager();

            List<List<String>> data = fileManager.readFile("src/Management/books.dat");
            for(List<String> lineData : data){
                Author author = authorManager.findByAuthorID(Integer.parseInt(lineData.get(2)));
                Book b = new Book(Integer.parseInt(lineData.get(0)), lineData.get(0), author, Double.parseDouble(lineData.get(3)));
                books.add(b);
            }
        }
        
    public Book createBook(int BookID, String bookName, Author author, double price)
    {
        Book b = new Book(BookID, bookName, author, price);
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
        }
    }
    
    public void updateBook(String bookName, String NewBookName){
        for(Book book : books){
            if(book.getBookName().equals(bookName)){
                book.setBookName(NewBookName);
                break;
            }
        }
    }
    
    public Book findByBookName(String bookName){
        for(Book book : books){
            if(book.getBookName().equals(bookName));
            return book;
        }
        return null;
    }
    
//    public void displayAllBook(){
//        for(Book book : books){
//            System.out.println(book);
//        }
//    }     
}
