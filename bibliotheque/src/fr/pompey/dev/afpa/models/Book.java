package fr.pompey.dev.afpa.models;

import fr.pompey.dev.afpa.exception.MyExceptions;
import fr.pompey.dev.afpa.utilities.ValidationUtils;

public class Book {

    private String title;
    private String author;
    private int quantity;
    private String isbn;

    // Constructeur
    public Book(String title, String author, int quantity) throws MyExceptions {

        this.title = title;
        setAuthor(author);
        this.quantity = quantity;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws MyExceptions {
        this.author = author;

        if (author.isEmpty()) {
            // genere un message d'erreur
            throw new MyExceptions("Author cannot be empty");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
//        return "Livre [titre=" + title + ", auteur=" + author + ", quantité=" + quantity + "]";
        return getTitle() + " - " + getAuthor() +" - " + getQuantity();
    }
}
