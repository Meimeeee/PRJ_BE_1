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
    
    private int BookID ;
    private String bookName;
    private Author author;
    private double price;
    private int count;

    public Book() {
    }
    
    public Book(int BookID, String bookName, Author author,int count ,double price) {
        this.BookID = BookID;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.author.addBook(this);
        this.count = count;
    }
    
      public int getBookID(){
        return BookID;
    }
    
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

  

@Override
    public String toString() {
        return String.format("|%-5d |%-40s |%-40s |%10.2f |%5d |"
                , BookID, bookName, author, price, count);

    }    

    @Override
    public List<String> toDatFormat() {
        List<String> dat = new ArrayList<>();
        dat.add(String.valueOf(BookID));
        dat.add(bookName);
        dat.add(String.valueOf(author.getAuthorID()));
        dat.add(String.valueOf(count));
        dat.add(String.valueOf(price));
        return dat;
    }

    
}
