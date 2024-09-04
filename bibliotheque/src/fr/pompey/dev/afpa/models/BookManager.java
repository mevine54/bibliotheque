package fr.pompey.dev.afpa.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookManager {
    private final List<Book> books;

    public BookManager() {
        // Initialise la liste des livres
        this.books = new ArrayList<>();
    }

    // Méthode pour ajouter un livre
    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    // Méthode pour rechercher un livre par titre et auteur
    public List<Book> searchBook(String keyword) {
        return books.stream()
                .filter(book -> book.getTitle().contains(keyword)
                        || book.getAuthor().contains(keyword))
                .collect(Collectors.toList());
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
