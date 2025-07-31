package cli;

import java.util.InputMismatchException;
import java.util.Scanner;

import classes.*;

public class Cli {

    static Library library = new Library();
    public static Librarian librarian = new Librarian();
    static Student student = null;
    static Scanner scanner = new Scanner(System.in);

    public static void register() {

        System.out.println("=== Register ===");

        String username;

        while (true) {

            System.out.print("username : ");
            username = scanner.nextLine();

            if (username.isEmpty()) {
                System.out.println("username can't be empty!");
            } else {
                break;
            }
        }

        String password;

        while (true) {

            System.out.print("password : ");
            password = scanner.nextLine();

            if (password.isEmpty()) {
                System.out.println("username can't be empty!");
            } else {
                break;
            }
        }

        System.out.println("============");

        Student.register(new Student(username,password));
    }

    public static void loginStudent() {

        System.out.println("=== Login ===");

        System.out.print("username : ");
        String username = scanner.nextLine();

        System.out.print("password : ");
        String password = scanner.nextLine();

        System.out.println("============");

        student = Student.login(username,password);

        while (student != null && student.isLogin) {

            System.out.println("===========================");
            System.out.println("Welcome to Library " + student.username + "!");
            System.out.println("===========================");

            Cli.studentPage();
            break;
        }
    }


    public static void studentPage() {

        while (student.isLogin) {

            System.out.println("1 = display books");
            System.out.println("2 = display borrowed book");
            System.out.println("3 = borrowing book");
            System.out.println("4 = returning book");
            System.out.println("0 = logout");
            System.out.print("please choose a number to see the options: ");

            int options;

            try {
                options = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (options) {
                case 1: {
                    library.displayAllBooks();
                    back();
                    break;
                }
                case 2: {
                    student.displayBorrowedBook(student);
                    back();
                    break;
                }
                case 3: {
                    while (true) {
                        library.displayAllBooks();
                        System.out.print("choose a (No) of the book for borrowing the book: ");
                        int chooseNumber;
                        try {
                            chooseNumber = scanner.nextInt();
                            scanner.nextLine();
                            student.borrow(chooseNumber, student);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input match!");
                            scanner.nextLine();
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("You're choose a wrong (no) of the book! please choose (no) of the book that available");
                        }

                    }
                    back();
                    break;
                }
                case 4: {
                    while (true) {
                        student.displayBorrowedBook(student);
                        if (!student.getBorrowedBook().isEmpty()) {
                            System.out.print("choose a (no) of the book if you want to returning the book: ");
                            int chooseNumber;
                            try {
                                chooseNumber = scanner.nextInt();
                                scanner.nextLine();
                                student.returnBook(chooseNumber, Library.books);
                                back();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input match!");
                                scanner.nextLine();
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("You're choose a wrong (no) of the book! please choose (no) of the book that available");
                            }
                        } else {
                            back();
                        }
                        break;
                    }
                    break;
                }
                case 0: {
                    student.logout();
                    break;
                }
                default: {
                    System.out.println("invalid options!");
                    break;
                }
            }
        }
    }

    public static void loginLibrarian() {

        librarian.register(new Librarian("admin","admin1234"));

        System.out.println("=== Login Librarian ===");

        System.out.print("username : ");
        String username = scanner.nextLine();

        System.out.print("password : ");
        String password = scanner.nextLine();

        System.out.println("============");

        librarian.login(username,password);

    }

    public static void librarianPage() {


        while (librarian.isLogin) {

            System.out.println("============ Library Management ============\n");
            System.out.println("=== Options ===");
            System.out.println("1 = Display All Books");
            System.out.println("2 = Add New Book");
            System.out.println("3 = Remove Book");
            System.out.println("===============\n");
            System.out.println("=== Student Activity ===");
            System.out.println("4 = Display All Students");
            System.out.println("0 = Logout");
            System.out.println("========================");
            System.out.print("choose a number: ");

            int options;

            try {
                options = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (options) {
                case 1: {
                    librarian.displayAllBooks();
                    break;
                }
                case 2: {
                    System.out.println("=== Add New Book ===");

                    System.out.print("title: ");
                    String title = scanner.nextLine();

                    System.out.print("author: ");
                    String author = scanner.nextLine();

                    librarian.addBook(new Book(title,author));
                    break;
                }
                case 3: {
                    System.out.println("=== Removing Book ===");

                    System.out.print("Please enter the (No) of the book to remove: ");
                    int idBook = scanner.nextInt();
                    scanner.nextLine();

                    librarian.removeBook(idBook);
                    break;
                }
                case 4: {
                    librarian.displayAllStudents();
                    break;
                }
                case 0: {
                    librarian.logout();
                    break;
                }
                default: {
                    System.out.println("invalid options!");
                    break;
                }
            }
        }
    }

    public static void back() {
        while (true) {
            System.out.print("Enter number (9) to go back: ");
            try {
                int back = scanner.nextInt();
                if (back == 9) {
                    break;
                } else {
                    System.out.println("❌ Wrong number! Please enter 9 to go back.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}
