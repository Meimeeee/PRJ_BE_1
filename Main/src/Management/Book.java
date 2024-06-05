/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoct
 */
public class Book implements DatFormat{
    
    private final int BookID;
    private String bookName;
    private Author author;
    private double price;
    
    public Book(int BookID, String bookName, Author author, double price) {
        this.BookID = BookID;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.author.addBook(this);
    }
    
    
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookID(){
        return BookID;
    }

@Override
    public String toString() {
        return "| " + BookID 
                + "\t| " + bookName 
                + "\t| " + author 
                + "\t| " + price + "\t|";
    }    

    @Override
    public List<String> toDatFormat() {
        List<String> dat = new ArrayList<>();
        dat.add(String.valueOf(BookID));
        dat.add(bookName);
        dat.add(String.valueOf(author.getAuthorID()));
        return dat;
        
    }

    
}
