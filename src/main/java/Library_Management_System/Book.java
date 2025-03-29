package Library_Management_System;

//Primary Book class which we make book instances.

public class Book {

    private String title;
    private String author;
    private String ISBN; //String type, because ISBN can contain '-' character
    private Status status; //Restricted to only 2 status: Availabale or Checked-out

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.status = Status.AVAILABLE; //We make status available for every book initially.
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Title: " + title + '\n' +
                "Author: " + author + '\n' +
                "ISBN: " + ISBN + '\n' +
                "Status: " + status
                ;
    }
}
