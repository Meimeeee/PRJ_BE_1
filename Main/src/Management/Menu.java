package Management;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    BookManager bookManager = new BookManager();
    AuthorManager authorManager = new AuthorManager();

    public void showMenu() {

        while (true) {
            Menu();
            int choice = sc.nextInt();
            sc.nextLine();// không nhận Enter

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    return;

                case 1: // hiển thị tất cả sách
                    bookManager.printAllBook();
                    break;

                case 2: // tạo thêm sách mới
                    addNewBook();
                    break;

                case 3: //Cập nhập sách
                    updateBookName();
                    break;

                case 4: //Xóa sách
                    System.out.println("Enter book's name: ");
                    bookManager.RemoveBook(sc.nextLine());
                    bookManager.save();
                    break;

                case 5:// tìm kiếm sách
                    searchBook();
                    break;

                case 6://Lưu dữ liệu vào file
                    bookManager.save();
                    System.out.println("SAVED!!");
                    break;

                default:
                    System.out.println("Input again!!");
                    System.out.println("Choice number 0 to 6\n");
            }
        }
    }

    public void Menu() {
        System.out.println("HKT Book Store Management");
        System.out.println("1. Show book list");
        System.out.println("2. Add new book");
        System.out.println("3. Update book's Name");
        System.out.println("4. Delete book");
        System.out.println("5. Search book");
        System.out.println("6. Store data to file");
        System.out.println("0. Quit");
        System.out.println("ENTER YOUR CHOICE: ");
    }

    public void addNewBook() {
        System.out.print("Enter BookID: ");
        int ID = sc.nextInt();
        sc.nextLine(); //xóa bộ nhớ đệm

        Book b = bookManager.findByBookID(ID);
        if (b != null) {
            System.out.println("Duplicate Book ID! Please enter a unique ID.\n");
            return;
        }

        System.out.println("Enter Book's Name: ");
        String bookName = sc.nextLine();

        System.out.println("Enter Author");
        System.out.println("Enter AuthorID: ");
        int authorID = sc.nextInt();
        sc.nextLine();

        Author author = authorManager.findByAuthorID(authorID);
        if (author == null) {
            System.out.println("Enter Author's Name: ");
            String authorName = sc.nextLine();
            author = new Author(authorID, authorName);
        }

        System.out.println("Enter book's count: ");
        int count = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Book's price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        bookManager.createBook(ID, bookName, author, count, price);
        System.out.println("Book added successfully!\n");
        bookManager.save();
    }

    public void updateBookName() {//3 cập nhật
        System.out.println("Input book's name renamed: ");
        String currentName = sc.nextLine();
        System.out.println("Input your new name: ");
        String newName = sc.nextLine();
        bookManager.updateBook(currentName, newName);
        bookManager.save();

    }

    public void searchBook() {//5 tìm kiếm
        System.out.println("Input Book's Name: ");
        Book book = bookManager.findByBookName(sc.nextLine());
        if (book == null) {
            System.out.println("Book' name doesn't exist\n");
        } else {
            System.out.println(book);
        }

    }
}

