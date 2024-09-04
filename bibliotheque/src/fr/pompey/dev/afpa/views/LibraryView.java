package fr.pompey.dev.afpa.views;

import fr.pompey.dev.afpa.controllers.LibraryController;
import fr.pompey.dev.afpa.models.Book;
import fr.pompey.dev.afpa.models.Borrow;
import fr.pompey.dev.afpa.models.Subscriber;
import fr.pompey.dev.afpa.utilities.ValidationUtils;
//import fr.pompey.dev.afpa.models.BorrowManager;

import java.time.LocalDate;
//import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.time.format.DateTimeFormatter;

//import fr.pompey.dev.afpa.utilities.DialogUtils;

// Supprimer cette ligne si Scanner n'est plus utilisé
import java.util.Scanner;


public class LibraryView {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final LibraryController controller;
    private final Scanner scanner; // désactivé pour DialogBox

    public LibraryView(LibraryController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in); // désactivé pour DialogBox
    }

    public void addSubscriber() {
        System.out.println("Entrez le nom de l'abonné :");
        String lastname = scanner.nextLine().trim();
        System.out.println("Entrez le prénom de l'abonné :");
        String firstname = scanner.nextLine().trim();
        System.out.println("Entrez l'email de l'abonné :");
        String email = scanner.nextLine().trim();
//        System.out.println("Entrez la date d'inscription de l'abonné");
//        String inscriptionDateStr = scanner.nextLine().trim();

        // Validation des champs
        if (!ValidationUtils.isValidName(lastname)) {
            System.out.println("Erreur: Nom non valide");
            return;
        }

        if (!ValidationUtils.isValidName(firstname)) {
            System.out.println("Erreur: Prénom non valide");
            return;
        }

        if (!ValidationUtils.isValidEmail(email)) {
            System.out.println("Erreur: Email non valide");
            return;
        }

        // Crée DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        // si toutes les validations passent alors
        // Enregistre l'abonné avec la date d'inscription formattée
        controller.addSubscriber(lastname, firstname, email);
        System.out.println("Abonné enregistré avec succès !");
    }

    public void registerBook() {
        // Console
        try {
            System.out.println("Entrez le titre du livre :");
            String title = scanner.nextLine();
            System.out.println("Entrez l'auteur du livre' :");
            String author = scanner.nextLine();
            System.out.println("Entrez la quantité du livre :");
            String quantity = scanner.nextLine();

            // Validation des champs
            if (!ValidationUtils.isValidTitle(title)) {
                System.out.println("Erreur: titre non valide");
                return;
            }

            if (!ValidationUtils.isValidAuthor(author)) {
                System.out.println("Erreur: auteur non valide");
                return;
            }

            int quant = Integer.parseInt(quantity);
            if (quant <= 0) {
                System.out.println("Erreur : la quantité doit être supérieure à zéro");
                return;
            }


            // Si tous les champs sont validés alors on enregistre le livre
            controller.registerBook(title, author, Integer.parseInt(quantity));
            System.out.println("Livre enregistré avec succès !");
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide pour la quantité");
        }
    }

    public void registerBorrow() {
//        System.out.println("Entrez la date de début du prêt: ");
//        String startDateStr = scanner.nextLine();
//        System.out.println("Entrez la date de fin du prêt: ");
//        String endDateStr = scanner.nextLine();

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
//        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        try {
            System.out.println("Entrez le nom de l'abonné ayant emprunté le livre: ");
            String subscriberName = scanner.nextLine();
            System.out.println("Entrez le titre du livre emprunté: ");
            String bookTitle = scanner.nextLine();

            // Valider le nom de l'abonné et le titre du livre
            if (!ValidationUtils.isValidName(subscriberName) || !ValidationUtils.isValidTitle(bookTitle)) {
                System.out.println("Erreur: Nom ou titre non valide");
                return;
            }

            // Vérifier l'existence de l'abonné
            Subscriber subscriber = controller.searchSubscriber(subscriberName);
            if (subscriber == null) {
                System.out.println("Erreur abonné non trouvé");
                return;
            }

            // Vérifier l'existence du livre
            Book book = controller.searchBook(bookTitle);
            if (book == null || book.getQuantity() < 0) {
                System.out.println("Erreur : livre non trouvé ou en rupture de stock");
                return;
            }

            // Enregistrer les dates automatiquement
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusDays(7);

            // Si les champs sont validés alors on enregistre le prêt
            controller.registerBorrow(subscriber, book);
            System.out.println("Prêt enregistré avec succès !");
        } catch (NullPointerException e) {
            System.out.println("Erreur: un élément nécéssaire est introuvabe");
        }


    }

    public void displaySubscriber() {
        List<Subscriber> subscribers = controller.getSubscribers();
        for (Subscriber subscriber : subscribers) {
            System.out.println("Nom: " + subscriber.getLastName() + ", Prénom: " + subscriber.getFirstName() + ", Email: " + subscriber.getEmail() + ", Date: " + subscriber.getInscriptionDate());

        }
    }

    public void displayBookManager(LibraryController controller) {
        List<Book> books = controller.getBooks();
        for (Book book : books) {
            System.out.println("Titre: " + book.getTitle() + ", Auteur: " + book.getAuthor() + ", Quantité: " + book.getQuantity());
        }

    }

    public void displayBorrowManager() {
        List<Borrow> borrows = controller.getBorrows();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (borrows.isEmpty()) {
            System.out.println("Aucun prêt enregistré");
        } else {
            for (Borrow borrow : borrows) {
                String startDateFormatted = borrow.getStartDate().format(formatter);
                String endDateFormatted = borrow.getEndDate().format(formatter);

                System.out.println("Date de début: " + startDateFormatted + ", Date de fin: " + endDateFormatted + ", Abonné: " + borrow.getSubscriber() + ", Livre: " + borrow.getBook().getTitle());

            }
        }

    }

    public void searchSubscriber() {
        System.out.println("Entrez le nom ou le prénom de l'abonné :");
        String name = scanner.nextLine().trim();
        Subscriber subscriber = controller.searchSubscriber(name);

        if (subscriber != null) {
            System.out.println("Abonné trouvé : " + subscriber);
        } else {
            System.out.println("Aucun abonné trouvé pour ce nom : " + name);
        }
    }

    public void searchBook() {
        System.out.println("Entrer le titre du livre :");
        String title = scanner.nextLine().trim();
        Book book = controller.searchBook(title);

        if (book != null) {
            System.out.println("Livre trouvé : " + book);
        } else {
            System.out.println("Aucun livre trouvé pour ce titre : " + title);
        }
    }

    public void searchBorrow() {
        System.out.println("Entrer le nom de l'abonné :");
        String subscriberName = scanner.nextLine().trim();
        System.out.println("Entrer le titre du livre :");
        String bookTitle = scanner.nextLine().trim();
        Borrow borrow = controller.searchBorrow(subscriberName, bookTitle);

        if (borrow != null) {
            System.out.println("Prêt trouvé : " + borrow);
        } else {
            System.out.println("Aucun prêt trouvé pour cet abonné et le livre spécifié.");
        }
    }


    public void displayChoice() {
        int choice = 0;
        do {
            System.out.println("\n--------------------------");
            System.out.println("1. Enregistrer un nouvel abonné");
            System.out.println("2. Enregistrer un nouveau livre");
            System.out.println("3. Enregistrer un nouveau prêt");
            System.out.println("4. Afficher la liste des abonnés");
            System.out.println("5. Afficher la liste des livres");
            System.out.println("6. Afficher la liste des prêts");
            System.out.println("7. Rechercher un abonné");
            System.out.println("8. Rechercher un livre");
            System.out.println("9. Rechercher un prêt");
            System.out.println("0. Quitter");
            System.out.println("--------------------------");
            System.out.println("Choisissez une option");

            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide");
                scanner.next();
            }
            try {
                choice = scanner.nextInt();
                scanner.nextLine();


                switch (choice) {
                    case 1:
                        addSubscriber();
                        break;
                    case 2:
                        registerBook();
                        break;
                    case 3:
                        registerBorrow();
                        break;
                    case 4:
                        displaySubscriber();
                        break;
                    case 5:
                        displayBookManager(controller);
                        break;
                    case 6:
                        displayBorrowManager();
                        break;
                    case 7:
                        searchSubscriber();
                        break;
                    case 8:
                        searchBook();
                        break;
                    case 9:
                        searchBorrow();
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Veuillez choisir une option valide");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur : veuillez entrer un nombre valide");
                scanner.next();
            }

        } while (choice != 0);
        scanner.close();
    }
}