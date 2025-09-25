package task3;

import java.util.*;

// Book class
class Book {
    int id;
    String title;
    boolean isIssued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false; // initially available
    }
}

// User class
class User {
    int userId;
    String name;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

// Library class
class Library {
    private List<Book> books = new ArrayList<>();

    // add books to library
    public void addBook(Book book) {
        books.add(book);
    }

    // issue book
    public void issueBook(int bookId, User user) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book '" + b.title + "' issued to " + user.name);
                } else {
                    System.out.println("Sorry, Book '" + b.title + "' is already issued.");
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // return book
    public void returnBook(int bookId, User user) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book '" + b.title + "' returned by " + user.name);
                } else {
                    System.out.println("Book '" + b.title + "' was not issued.");
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // display all books
    public void showBooks() {
        System.out.println("\nLibrary Books:");
        for (Book b : books) {
            System.out.println("ID: " + b.id + " | Title: " + b.title + " | Status: " + (b.isIssued ? "Issued" : "Available"));
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        // Add some books
        lib.addBook(new Book(1, "Java Basics"));
        lib.addBook(new Book(2, "Spring Boot Guide"));
        lib.addBook(new Book(3, "Data Structures"));

        // Create users
        User u1 = new User(101, "Ram");
        User u2 = new User(102, "Prasath");

        // Display books
        lib.showBooks();

        // Issue books
        lib.issueBook(1, u1);
        lib.issueBook(2, u2);

        // Try to issue an already issued book
        lib.issueBook(1, u2);

        // Return books
        lib.returnBook(1, u1);

        // Show books after transactions
        lib.showBooks();
    }
}
