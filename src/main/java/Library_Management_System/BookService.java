package Library_Management_System;

import java.util.ArrayList;
import java.util.List;

//Class which we perform actions about Book items

public class BookService {

    private final BookRepository bookRepository = new BookRepository();

    //Making a new book instance with desired parameters:
    public void addBookItem(String title, String author, String ISBN) {
        Book book = new Book(title, author, ISBN);
        bookRepository.save(book);
    }

    //Returning all books at Repository:
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //Searching a book according to title, and returning all books found:
    public List<Book> getBooksSearchedByTitle(String searchTitle) {
        List<Book> allBooks = bookRepository.findAll();
        List<Book> booksFoundByTitle = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                booksFoundByTitle.add(book);
            }
        }
        return booksFoundByTitle;
    }

    //Checking-out a book if it is Available and returns true:
    public boolean checkOutABook(String ISBN) {
        List<Book> booksFoundByISBN = bookRepository.findAllBooksByISBN(ISBN);
        if (booksFoundByISBN != null) {
            for (Book book : booksFoundByISBN) {
                if (Status.AVAILABLE.equals(book.getStatus())) {
                    book.setStatus(Status.CHECKED_OUT);
                    return true;
                }
            }
        }
        return false;
    }

    //Returning a book if there is a book already Checked-out with that ISBN, returns true in that case:
    public boolean returnABook(String ISBN) {
        List<Book> booksFoundByISBN = bookRepository.findAllBooksByISBN(ISBN);
        if (booksFoundByISBN != null) {
            for (Book book : booksFoundByISBN) {
                if (Status.CHECKED_OUT.equals(book.getStatus())) {
                    book.setStatus(Status.AVAILABLE);
                    return true;
                }
            }
        }
        return false;
    }


}
