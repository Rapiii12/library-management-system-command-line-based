package classes;

import java.util.ArrayList;

public class Student extends Library {

    private static int studentCounter = 1;

    public int idStudent;
    public String username;
    String password;
    public ArrayList<Book> borrowedBook = new ArrayList<>();
    public boolean isLogin = false;
    boolean isBorrowed;


    static int noWidth = 4;
    static int usernameWidth = 25;
    static int borrowedWidth = 70;
    static String line = "+" +
            "-".repeat(noWidth) + "+" +
            "-".repeat(usernameWidth+2) + "+" +
            "-".repeat(borrowedWidth + 2) + "+";


    public Student() {
        return;
    }

    public Student(String username, String password) {
        this.idStudent = studentCounter++;
        this.username = username;
        this.password = password;
    }

    public ArrayList<Book> getBorrowedBook() {
        return borrowedBook;
    }

    public void displayBorrowedBook(Student student) {
        System.out.println("------------- Borrowed -------------");
        if (!student.getBorrowedBook().isEmpty()) {
            System.out.println("No\t\tTitle");
            for(Book b : student.getBorrowedBook()) {
                System.out.println(b.getIdBook()+"\t\t"+b.getTitle());
            }
        } else {
            System.out.println("\t\tNothing borrowed any books!");
        }
        System.out.println("------------------------------------");
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void borrow(int idBook, Student student) {
        Book selectedBook = null;

        for (Book book : books) {
            if (book.getIdBook() == idBook) {
                selectedBook = book;
                break;
            }
        }

        if (selectedBook != null) {
            if (selectedBook.isAvailable()) {
                selectedBook.setAvailable(false);
                selectedBook.setBorrowedBy(student.username);
                student.isBorrowed = true;

                student.borrowedBook.add(selectedBook);

                System.out.println("✅ You borrowed: " + selectedBook.getTitle());
            } else {
                System.out.println("❌ The book is already borrowed!");
            }
        } else {
            System.out.println("❌ You chose an invalid book ID!");
        }
    }

    public void returnBook(int idBook, ArrayList<Book> books) {

        Book selectedBook = null;

        for (Book book : borrowedBook) {
            if (book.getIdBook() == idBook) {
                selectedBook = book;
                break;
            }
        }

        if (selectedBook != null) {
            selectedBook.setAvailable(true);
            selectedBook.setBorrowedBy("-");
            System.out.println("You has been returned the book of "+selectedBook.getTitle()+" !");
            borrowedBook.remove(selectedBook);
        } else {
            System.out.println("You choose the that unavailable!");
        }
    }

    static public void register(Student student) {
        students.add(student);
        System.out.println("Successfully add new student!");
    }

    public static Student login(String username, String password) {
        for (Student student : students) {
            if (student.username.equals(username) && student.password.equals(password)) {
                System.out.println("Login successful! Welcome, " + student.username + ".");
                student.isLogin = true;
                return student;
            } else {
                System.out.println("Wrong password!");
            }
        }
        return null;
    }

    public void logout() {
        this.isLogin = false;
        System.out.println("You has been logout!");
    }
}
