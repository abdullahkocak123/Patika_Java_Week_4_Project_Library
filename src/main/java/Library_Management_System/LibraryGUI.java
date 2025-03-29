package Library_Management_System;

import java.util.List;
import java.util.Scanner;

//Class which shows menu to user, gets inputs from user and prints outputs to user.

public class LibraryGUI {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BookService bookService = new BookService();

    public static void main(String[] args) {

        System.out.println("Welcome to the Library Management System!" + '\n');

        boolean running = true;

        String choice; //In order not to get error when user gives other than integer, we define choice as String

        do {

            //Menu with 6 operations:

            printMenu();
            choice = scanner.next();
            scanner.nextLine();

            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    displayAllBooks();
                    break;
                case "3":
                    searchABookByTitle();
                    break;
                case "4":
                    checkOutABook();
                    break;
                case "5":
                    returnABook();
                    break;
                case "6":
                    System.out.println("Thank you for using the Library Management System!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (running);

        scanner.close();

    }

    //Menu for user to perform actions:
    private static void printMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Add a new book");
        System.out.println("2. Display all books");
        System.out.println("3. Search for a book by title");
        System.out.println("4. Check out a book");
        System.out.println("5. Return a book");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    //Adding book to Library:
    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        bookService.addBookItem(title, author, ISBN);
        System.out.println("Book added successfully!" + '\n');
    }

    //Showing all books to user:
    private static void displayAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        System.out.println('\n' + "All books:");
        System.out.println("----------------------");
        for (Book book : allBooks) {
            System.out.println(book);
            System.out.println("----------------------");
        }
        System.out.println();
    }

    //Searching a book if it exists according to title:
    private static void searchABookByTitle() {
        System.out.print("Enter book title to search: ");
        String searchTitle = scanner.nextLine();
        List<Book> foundBooksByTitle = bookService.getBooksSearchedByTitle(searchTitle);
        if (foundBooksByTitle.isEmpty()) {
            System.out.println('\n' + "No books found!");
        } else {
            System.out.println('\n' + "Found Books:");
            System.out.println("----------------------");
            for (Book book : foundBooksByTitle) {
                System.out.println(book);
                System.out.println("----------------------");
            }
        }
        System.out.println();

    }

    //Checking-out a book from Library:
    private static void checkOutABook() {
        System.out.print("Enter the ISBN of the book you want to check out: ");
        String searchedISBN = scanner.nextLine();
        if (bookService.checkOutABook(searchedISBN)) {
            System.out.println("Book checked-out successfully." + '\n');
        } else {
            System.out.println("Book not found or already checked out" + '\n');
        }
    }

    //Returning a book to Library:
    private static void returnABook() {
        System.out.print("Enter the ISBN of the book you want to return: ");
        String searhedISBN = scanner.nextLine();
        if (bookService.returnABook(searhedISBN)) {
            System.out.println("Book returned successfully." + '\n');
        } else {
            System.out.println("Invalid process! Be sure you type the ISBN of book you checked out." + '\n');
        }
    }


}
