# Library Book Tracker System

This is a **Java-based Library Book Tracker System** developed as a simple console application for managing library records. It allows users to sign up, log in, view books, search for books, add new books, issue or return books — all managed through file-based storage (no database).

#Features
- User Sign-Up & Login
- View All Available Books
- Search Books by Title or ID
- Add New Books (Admin Function)
- Issue Book to User
- Return Book
- File-based Storage System (no SQL/DB)
- Simple console-based UI

#Tech Stack
- **Java SE** (Standard Edition)
- File I/O (java.io) for persistent storage
- OOP Concepts (Classes, Inheritance, Encapsulation)
- Runs on any OS with Java installed

#Project Structure
├── Main.java # Main class to run the application
├── Main.class
├── models/
 └── Book.java
 └── Book.class

├── utils/
 └── FileManager.java
 └── FileManager.class

├── data/
 ├── book.txt 
 └── users.txt 
 └── issuedBooked.txt


