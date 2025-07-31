package classes;

public class Book {
    private static int bookCounter = 1;

    int idBook;
    String title;
    public String author;
    boolean isAvailable = true;
    public String borrowedBy = "-";

    public Book(String title, String author) {
        this.idBook = bookCounter++;
        this.title = title;
        this.author = author;
    }

    public int getIdBook() {
        return idBook;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getBorrowedBy() { return borrowedBy; }

    public void setBorrowedBy(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
}
