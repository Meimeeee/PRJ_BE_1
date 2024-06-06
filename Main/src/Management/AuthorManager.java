/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.util.ArrayList;
import java.util.List;


public class AuthorManager {
    private List<Author> authors = new ArrayList<>(); 

    public AuthorManager() {
        readAuthor();
    }
    
    
    protected void readAuthor(){
        FileManager fileManager = new FileManager();
        List<List<String>> data = fileManager.readFile("src/Management/authors.dat");
        for (List<String> lineData : data){
            Author author = new Author(Integer.parseInt(lineData.get(0)), lineData.get(1));
            authors.add(author);
        }
    }
    
    public Author findByAuthorID(int authorID){

        for(Author author : authors){
            if (author.getAuthorID()== authorID){
                return author;
            }
        }                               
        return null;
    }
    
    public Author findByAuthorName(String authorName){

        for(Author author : authors){
            if (author.getAuthorName().equals(authorName)){
                return author;
            }
        }
        return null;
    }

    public Author addAuthor(Author a){
        authors.add(a);
        return a;
    }
    
    private List<Book> books = new ArrayList<>();

    public void removeAuthor(Author author){
        authors.remove(author);
        List<Book> BookRemoved = new ArrayList<>();
        for(Book book : books){
            if(book.getAuthor().equals(author)){
                BookRemoved.remove(book);
            }
        }
    }
    
    public String updateAuthor(String authorName, String newAuthorName){
        for(Author author : authors){
            if(author.getAuthorName().equals(authorName)){
                author.setAuthorName(newAuthorName);
                break;
            } 
        }
        return newAuthorName;   
    }
    
    public void displayAllAuthor(){
        for(Author author : authors){
            System.out.println(author);
        }
    }
    
    public void save(){
        List<List<String>> data = new ArrayList<>();
        FileManager fileManager = new FileManager();
        for(Author author : authors){
            List<String> lineData = new ArrayList<>();
            lineData.add(String.valueOf(author.getAuthorID()));
            lineData.add(author.getAuthorName());
            data.add(lineData);
        }
        fileManager.writeFile("src/Management/authors.dat", data);
    }
    
    @Override
    public String toString() {
        return "AuthorManager(" + "authors = " + authors + ", books = " + books + ')';
    }
    
}
