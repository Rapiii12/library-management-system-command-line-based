import classes.*;
import cli.Cli;

import java.util.InputMismatchException;
import java.util.Scanner;

//Librarian librarian = Cli.librarian;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        Main APP

        while (true) {

            int choose = 0;

            try {
                System.out.println("please login or register if you don't have account!");
                System.out.println("(1 = register | 2 = login | 3 = login as a librarian | 0 = Quit )");
                System.out.print("choose : ");

                choose = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number (1 or 2).");
                scanner.nextLine();
                continue;
            }

            if (choose == 0) break;

            switch (choose) {
                case 1:
                    Cli.register();
                    break;
                case 2:
                    Cli.loginStudent();
                    Cli.studentPage();
                    break;
                case 3:
                    Cli.loginLibrarian();
                    Cli.librarianPage();
                    break;
                default:
                    System.out.println("❌ Invalid input number! Please enter 1 or 2.");
            }
        }

    }

}

