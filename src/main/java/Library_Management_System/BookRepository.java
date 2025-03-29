package Library_Management_System;

import java.util.ArrayList;
import java.util.List;

//Class which we store books

public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    //Saving a book to list if user adds a book:
    public void save(Book book) {
        books.add(book);
    }

    /*
    Finding all books by ISBN. Because ISBN is unique for a book in a specific edition,
    there will be more than 1 book in Library. Thus, we return a list of found books.
     */
    public List<Book> findAllBooksByISBN(String ISBN) {
        List<Book> allBooksFoundByISBN = new ArrayList<>();
        for (Book book : books) {
            if (ISBN.equals(book.getISBN())) {
                allBooksFoundByISBN.add(book);
            }
        }
        return allBooksFoundByISBN;
    }

    //Returning all books in the Library:
    public List<Book> findAll() {
        return books;
    }
}
