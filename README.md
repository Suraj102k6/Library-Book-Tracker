# Library-Book-Tracker
The Library Book Tracker is a Java-based console application that simulates the basic functionality of a library system. It allows users to register, login, and manage a list of books with essential details such as book ID, title, author, and publisher. Designed with simplicity and educational value in mind, this project serves as a beginner-friendly introduction to file handling, user authentication, and object-oriented programming in Java.

Key Features:
User Registration and Login:
Users can create an account with a unique username and password. The credentials are securely stored in a users.txt file, and only valid users can access the book management system.

View Books:
Users can view the list of all available books stored in book.txt. Each book entry includes the book ID, title, publisher, author, and status (e.g., Available).

Search Book:
The system provides a search functionality that allows users to find books by typing in a keyword (which may match the title, author, or publisher). It helps quickly locate desired books from the list.

Add New Book:
Users can add a new book to the system by providing the required information. This book is then appended to the book.txt file, making it visible in the list of available books.

Modular Structure:
The project is divided into different packages (models and utils) to separate concerns. For instance, the Book class is stored under models, and all file-related operations like reading, writing, searching, and viewing are handled through the FileManager class under utils.

Purpose:
This project is ideal for students and beginners learning Java. It demonstrates how to work with files, classes, objects, and user input/output while reinforcing basic programming principles.
By keeping the interface simple and text-based, the Library Book Tracker remains easy to use while offering core functionalities expected in a real-world library system.
