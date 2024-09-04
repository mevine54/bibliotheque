package fr.pompey.dev.afpa;

import fr.pompey.dev.afpa.controllers.LibraryController;
import fr.pompey.dev.afpa.exception.MyExceptions;
import fr.pompey.dev.afpa.models.Book;
import fr.pompey.dev.afpa.models.Borrow;
import fr.pompey.dev.afpa.models.Subscriber;
import fr.pompey.dev.afpa.utilities.DialogUtils;
import fr.pompey.dev.afpa.views.LibraryView;
//import fr.pompey.dev.afpa.views.LibraryView;


import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);


        LibraryController libraryController = new LibraryController();
        LibraryView view = new LibraryView(libraryController);
        view.displayChoice();

        // Enregistrer des abonnés
        libraryController.addSubscriber(" veeren", "mévine", "mevine@free.fr");
        libraryController.addSubscriber("gence", "fabien", "fabien@free.fr");

        // Récupérer la liste des abonnés
        List<Subscriber> subscribers = libraryController.getSubscribers();

        // Afficher les abonnés
        System.out.println("Liste des abonnés: ");
        for (Subscriber subscriber : subscribers) {
            System.out.println(subscriber);
        }

        // Enregistrer des livres
        libraryController.registerBook("Voyage au pays du grand condor", "Nadine Garel", 2);
        libraryController.registerBook("Le lion", "Joseph Kessel", 2);

        // Récupérer la liste des livres
        List<Book> books = libraryController.getBooks();

        // Afficher la liste des livres
        for (Book book : books) {
            System.out.println(book);
        }

        // Enregistrer un prêt
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(7);

//        libraryController.registerBorrow(subscribers.get(0).getLastName(), books.get(0).getTitle());
        libraryController.registerBorrow(subscribers.get(0), books.get(0));

        // Récupérer la liste des prêts
        List<Borrow> borrows = libraryController.getBorrows();

        // Afficher les prêts
        for (Borrow borrow : borrows) {
            System.out.println(borrow);
        }

        // Rechercher un abonné par email ou nom
//        libraryController.searchSubscriber(subscribers)

    }

}

