/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    BookManager bookManager = BookManager.getInstance();
    AuthorManager authorManager = AuthorManager.getInstance();

    public void updateBookName(){//3 cập nhật
        System.out.println("Input book's name renamed: ");
        String currentName = sc.nextLine();
        System.out.println("Input your new name: ");
        String newName = sc.nextLine();
        bookManager.updateBook(currentName, newName);        
    }
    
    public void searchBook() {//5
        sc.nextLine();
        while (true) {
            System.out.println("1. Search book by Author's Name ");
            System.out.println("2. Search book by Book's Name ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Input Author's Name: ");
                    Author author = authorManager.findByAuthorName(sc.nextLine());
                    if (author == null) {
                        System.out.println("Author's name doesn't exist");
                    } else {
                        System.out.println(author);
                    }
                    break;
                case 2:
                    System.out.println("Input Book's Name: ");
                    Book book = bookManager.findByBookName(sc.nextLine());
                    if (book == null) {
                        System.out.println("Book' name doesn't exist");
                    } else {
                        System.out.println(book);
                    }
            }
        }

    }

    public void showMenu() {

        while (true) {
            System.out.println("HKT Book Store Management");
            System.out.println("ENTER YOUR CHOICE: ");
            System.out.println("1. Show book list");
            System.out.println("2. Add new book");
            System.out.println("3. Update book's Name");
            System.out.println("4. Delete book");
            System.out.println("5. Search book");
            System.out.println("6. Store data to file");
            System.out.println("0. Quit");

            int choice = sc.nextInt();
            sc.nextLine();// không nhận Enter

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    return;

                case 1: // hiển thị tất cả sách
                    bookManager.displayAllBook();
                    break;

                case 2: // tạo
                    System.out.println("Enter BookID: ");
                    int ID = sc.nextInt();
                    System.out.println("Enter Book's Name: ");
                    String bookName = sc.nextLine();
                    System.out.println("Enter Author");
                    System.out.println("Enter AuthorID: ");
                    int authorID = sc.nextInt();
                    System.out.println("Enter Author's Name: ");
                    String authorName = sc.nextLine();
                    System.out.println("Enter Book's price: ");
                    double price = sc.nextDouble();

                    Author author = new Author(authorID, authorName);
                    bookManager.createBook(ID, bookName, author, price);
                    break;

                case 3: //Cập nhập 
                    updateBookName();
                    break;
                    
                case 4:
                    System.out.println("Enter book's name: ");
                    bookManager.RemoveBook(sc.nextLine());
                    break;

                case 5:// tìm kiếm
                    searchBook();
                    break;
                    
                case 6:
                    bookManager.BookManager();
                    

            }
        }
    }
}
