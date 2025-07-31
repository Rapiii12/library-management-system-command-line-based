package classes;

import java.util.ArrayList;

public class Librarian extends Library {

    ArrayList<Librarian> librarians = new ArrayList<>();
    public String username;
    String password;
    public boolean isLogin = false;

    public Librarian() {return;}

    public Librarian(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    @Override
    public void displayAllBooks() {
        if (!books.isEmpty()) {
            System.out.print("+"+"-".repeat(131)+"+\n");
            System.out.printf("| %-2s | %-45s | %-30s | %-9s | %-31s |\n","No","Book","Author","Available","Borrowed By");
            System.out.print("+"+"-".repeat(131)+"+\n");
            for (Book book : books) {
                if (!book.getBorrowedBy().equals("-")) {
                    System.out.printf("| %-2d | %-45s | %-30s | %-9s | %-31s |\n",
                            book.getIdBook(),book.getTitle(),book.author,book.isAvailable(),book.getBorrowedBy());
                    System.out.print("+"+"-".repeat(131)+"+\n");
                } else {
                    System.out.printf("| %-2d | %-45s | %-30s | %-9s | %-31s |\n",
                            book.getIdBook(),book.getTitle(),book.author,book.isAvailable(),"-");
                    System.out.print("+"+"-".repeat(131)+"+\n");
                }

            }
        } else {
            System.out.print("+"+"-".repeat(131)+"+\n");
            System.out.printf("| %-129s |\n","The book doesn't exist! please add new book");
            System.out.print("+"+"-".repeat(131)+"+\n");
        }
    }

    public void displayAllStudents() {
        if (!students.isEmpty()) {
            System.out.println("+"+"-".repeat(4)+"+"+"-".repeat(27)+"+"+"-".repeat(72)+"+");
            System.out.printf("| %-2s | %-25s | %-70s |\n", "No", "Username", "Borrowed");
            System.out.println("+"+"-".repeat(4)+"+"+"-".repeat(27)+"+"+"-".repeat(72)+"+");
            for (Student s : students) {
                System.out.printf("| %-2d | %-25s |", s.idStudent, s.username);
                if (s.isBorrowed) {
                    for (Book book : s.getBorrowedBook()) {
                        System.out.printf(" %-70s |\n", book.getTitle());
                        if (!s.getBorrowedBook().isEmpty()) {
                            System.out.printf("| %-2s | %-25s |","","");
                        }
                    }
                    System.out.printf(" %-70s |\n","");
                    System.out.println("+"+"-".repeat(4)+"+"+"-".repeat(27)+"+"+"-".repeat(72)+"+");
                } else {
                    System.out.printf(" %-70s |\n"," - ");
                    System.out.println("+"+"-".repeat(4)+"+"+"-".repeat(27)+"+"+"-".repeat(72)+"+");
                }
            }
        } else {
            System.out.print("+"+"-".repeat(30)+"+\n");
            System.out.printf("| %-28s |\n","Nothing students registered!");
            System.out.print("+"+"-".repeat(30)+"+\n");
        }
    }


    public void register(Librarian librarian) {
        librarians.add(librarian);
        System.out.println("Registering new librarian!");
    }

    public void login(String username,String password) {
        for (Librarian librarian : librarians) {
            if (librarian.getUsername().equals(username)) {
                if (librarian.getPassword().equals(password)) {
                    System.out.println("Successfully login as librarian!");
                    this.username = username;
                    this.password = password;
                    this.isLogin = true;
                } else {
                    System.out.println("Invalid password or username! please try again");
                }
            } else {
                System.out.println("Invalid password or username! please try again");
            }
        }

    }

    public void logout() {
        this.isLogin = false;
        System.out.println("logout as librarian!");
    }

}
