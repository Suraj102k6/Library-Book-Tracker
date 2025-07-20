import models.Book;
import utils.FileManager;
import java.util.*;
import java.io.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final String BOOK_FILE = "data/book.txt";
    private static final String USER_FILE = "data/users.txt";

    public static void main(String[] args) {
        while (true) {
            System.out.println("==== Library Book Tracker ====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            String choiceInput = scanner.nextLine();

            switch (choiceInput) {
                case "1" -> {
                    if (login()) {
                        libraryMenu();
                    }
                }
                case "2" -> register();
                case "3" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }

    private static boolean login() {
        System.out.print("Enter username: ");
        String user = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String pass = scanner.nextLine().trim();

        try (Scanner fileScanner = new Scanner(new File(USER_FILE))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                if (parts.length == 2 && parts[0].equals(user) && parts[1].equals(pass)) {
                    System.out.println("Login successful!");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading users.txt: " + e.getMessage());
        }

        System.out.println("Invalid credentials.");
        return false;
    }

    private static void register() {
        System.out.print("Choose a username: ");
        String user = scanner.nextLine().trim();
        System.out.print("Choose a password: ");
        String pass = scanner.nextLine().trim();

        // Check if the username already exists
        try (Scanner fileScanner = new Scanner(new File(USER_FILE))) {
            while (fileScanner.hasNextLine()) {
                if (fileScanner.nextLine().split(",")[0].equals(user)) {
                    System.out.println("Username already exists. Try another.");
                    return;
                }
            }
        } catch (Exception e) {
            /* ignore if file not found */
        }

        // Append new user
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            bw.write(user + "," + pass);
            bw.newLine();
            System.out.println("Registration successful! You can now login.");
        } catch (IOException e) {
            System.out.println("Error writing to users.txt");
        }
    }

    private static void libraryMenu() {
        while (true) {
            System.out.println("\n1. View Books");
            System.out.println("2. Search Book");
            System.out.println("3. Add Book");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> FileManager.viewBooks(BOOK_FILE);
                case "2" -> {
                    System.out.print("Enter keyword: ");
                    String keyword = scanner.nextLine();
                    FileManager.searchBook(BOOK_FILE, keyword);
                }
                case "3" -> {
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    FileManager.addBook(BOOK_FILE, new Book(id, title, publisher, author, "available"));
                }
                case "4" -> {
                    System.out.println("Logged out.");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
