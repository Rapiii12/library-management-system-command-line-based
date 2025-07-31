package classes;

import java.util.ArrayList;

public class Library {

    static ArrayList<Student> students = new ArrayList<>();
    static public ArrayList<Book> books = new ArrayList<>();

    public void displayAllBooks() {
        if (!books.isEmpty()) {
            System.out.print("+"+"-".repeat(97)+"+\n");
            System.out.printf("| %-2s | %-45s | %-30s | %-9s |\n","No","Book","Author","Available");
            System.out.print("+"+"-".repeat(97)+"+\n");
            for (Book book : books) {
                if (!book.getBorrowedBy().equals("-")) {
                    System.out.printf("| %-2d | %-45s | %-30s | %-9s |\n",
                            book.getIdBook(),book.getTitle(),book.author,book.isAvailable());
                    System.out.print("+"+"-".repeat(97)+"+\n");
                } else {
                    System.out.printf("| %-2d | %-45s | %-30s | %-9s |\n",
                            book.getIdBook(),book.getTitle(),book.author,book.isAvailable());
                    System.out.print("+"+"-".repeat(97)+"+\n");
                }

            }
        } else {
            System.out.print("+"+"-".repeat(97)+"+\n");
            System.out.printf("| %-95s |\n","The book doesn't exist! please add new book");
            System.out.print("+"+"-".repeat(97)+"+\n");
        }
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book successfully added!");
    }

    public void removeBook(int idBook) {
        Book toRemove = null;

        for (Book book : books) {
            if (book.getIdBook() == idBook) {
                toRemove = book;
                break;
            }
        }

        if (toRemove != null) {
            books.remove(toRemove);
            System.out.println("Book \"" + toRemove.getTitle() + "\" removed successfully.");
        } else {
            System.out.println("❌ Book with ID " + idBook + " not found!");
        }
    }
}
