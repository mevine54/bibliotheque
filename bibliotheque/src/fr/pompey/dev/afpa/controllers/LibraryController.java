package fr.pompey.dev.afpa.controllers;


import fr.pompey.dev.afpa.exception.MyExceptions;
import fr.pompey.dev.afpa.models.Book;
import fr.pompey.dev.afpa.models.Borrow;
import fr.pompey.dev.afpa.models.Subscriber;
import fr.pompey.dev.afpa.models.BookManager;
import fr.pompey.dev.afpa.models.BorrowManager;
import fr.pompey.dev.afpa.models.SubscriberManager;
import fr.pompey.dev.afpa.utilities.ValidationUtils;
import fr.pompey.dev.afpa.utilities.DialogUtils;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryController {
    private List<Subscriber> subscribers;
    private SubscriberManager subscriberManager;
    private BookManager bookManager = new BookManager();
    private BorrowManager borrowManager = new BorrowManager();

    public LibraryController() {
        this.subscribers = new ArrayList<>();
        init();
    }

    private void init() {
        addSubscriber("lastname", "firstname", "email@email.com");
//        registerSubscriber("lastnamep", "firstnamep", "emailp@email.com");
//        registerSubscriber("lastnamen", "firstnamen", "emailn@email.com");

        registerBook("title1",  "author1", 1);
//        registerBook("title2",  "author2", 5);
//        registerBook("title3",  "author3", 4);
//        registerBook("title4",  "author1", 5);
//        registerBook("title5",  "author2", 8);
//        registerBook("title6",  "author3", 1);



        registerBorrow(getSubscribers().getFirst(),getBooks().getFirst());

    }

    // Méthode pour enregistrer un abonné
    public void addSubscriber(String lastname, String firstname, String email) {
        if (ValidationUtils.isValidName(lastname) && ValidationUtils.isValidName(firstname) && ValidationUtils.isValidEmail(email)) {
            Subscriber newSubscriber = new Subscriber(lastname, firstname, email);
            subscribers.add(newSubscriber);
            System.out.println("Abonné ajouté: " + newSubscriber);
            System.out.println("Nombre d'abonnés actuellement: " + subscribers.size());
        } else {
            DialogUtils.showErrorDialog("Données invalides pour l'abonné");
        }
    }

    // Méthode pour enregistrer un livre
    public void registerBook(String title, String author, int quantity) {
        if (ValidationUtils.isValidTitle(title) && ValidationUtils.isValidAuthor(author) && ValidationUtils.isValidQuantity(String.valueOf(quantity)))
        {
            Book book;
            try {
                book = new Book(title, author, quantity);
            } catch (MyExceptions e) {
                throw new RuntimeException(e);
            }
            bookManager.addBook(book);
        } else {
            DialogUtils.showErrorDialog("Données invalides pour le livre");
        }
    }

    // Méthode pour enregistrer un prêt
    public void registerBorrow(Subscriber subscriber, Book book) {
        try {
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusDays(7);

            Borrow borrow = new Borrow(startDate, endDate, subscriber, book);
            borrowManager.addBorrow(borrow);
        } catch (Exception e) {
            DialogUtils.showErrorDialog("Erreur lors de l'enregistrement du prêt "+ e.getMessage());

            throw new RuntimeException(e);
        }
    }

//    public void registerBorrow(Subscriber subscriber, Book book) {
//        try {
//            LocalDate startDate = LocalDate.now();
//            LocalDate endDate = startDate.plusDays(7);
//
//            Borrow borrow = new Borrow(startDate, endDate, subscriber, book);
//            borrowManager.addBorrow(borrow);
//        } catch (Exception e) {
//            DialogUtils.showErrorDialog("Erreur lors de l'enregistrement du prêt");
//            throw new RuntimeException(e);
//        }
//    }


    // Méthode pour récupérer la liste des abonnés
    public List<Subscriber> getSubscribers() {
        System.out.println("Récupération de la liste des abonnés..");
        return new ArrayList<>(subscribers);
    }

    // Méthode pour récupérer la liste des livres
    public List<Book> getBooks() {
        return bookManager.getBooks();
    }

    // Méthode pour récupérer la liste des prêts
    public List<Borrow> getBorrows() {
        return borrowManager.getBorrows();
    }

    // Ajout des méthodes de recherche
    public Subscriber searchSubscriber(String keyword) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getEmail().equalsIgnoreCase(keyword)) {
                return subscriber;
            }
        }
        return null;
    }

    public Book searchBook(String title) {
        return bookManager.findByTitle(title);
    }

    public Borrow searchBorrow(String subscriberName, String bookTitle) {
        return borrowManager.findBorrow(subscriberName, bookTitle);
    }


}
