package models;

public class Book {
    private String id, title, publisher, author, status;

    public Book(String id, String title, String publisher, String author, String status) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.status = status;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + publisher + "," + author + "," + status;
    }

    public String display() {
        return "ID: " + id + "\nTitle: " + title + "\nPublisher: " + publisher + "\nAuthor: " + author + "\nStatus: " + status;
    }
}
