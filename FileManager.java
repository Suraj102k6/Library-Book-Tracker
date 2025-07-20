package utils;

import models.Book;
import java.io.*;
import java.util.Scanner;

public class FileManager {
    public static void viewBooks(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 5) {
                    Book b = new Book(data[0], data[1], data[2], data[3], data[4]);
                    System.out.println(b.display());
                    System.out.println("---------------");
                }
            }
        } catch (IOException e) {
            System.out.println("No books found.");
        }
    }

    public static void addBook(String filename, Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(book.toString());
            writer.newLine();
            System.out.println("Book added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding book.");
        }
    }

    public static void searchBook(String filename, String keyword) {
        boolean found = false;
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 5 &&
                    (data[0].toLowerCase().contains(keyword.toLowerCase()) ||
                     data[1].toLowerCase().contains(keyword.toLowerCase()) ||
                     data[2].toLowerCase().contains(keyword.toLowerCase()) ||
                     data[3].toLowerCase().contains(keyword.toLowerCase()))) {
                    Book b = new Book(data[0], data[1], data[2], data[3], data[4]);
                    System.out.println(b.display());
                    System.out.println("---------------");
                    found = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error searching books.");
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }
}
