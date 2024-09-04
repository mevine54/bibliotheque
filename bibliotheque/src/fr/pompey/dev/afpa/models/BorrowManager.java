package fr.pompey.dev.afpa.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class BorrowManager {
    private List<Borrow> borrows;

    public BorrowManager() {
        this.borrows = new ArrayList<>();
    }

    // Méthode pour ajouter un prêt
    public void addBorrow(Borrow borrow) {
        borrows.add(borrow);
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    // Méthode pour rechercher des prêts par abonné, livre ou date
    public List<Borrow> searchBorrow(String keyword) {
        return borrows.stream()
                .filter(borrow -> borrow.getSubscriber().getEmail().contains(keyword)
                        || borrow.getBook().getTitle().contains(keyword)
                        || borrow.getStartDate().toString().contains(keyword)
                        || borrow.getEndDate().toString().contains(keyword))
                .collect(Collectors.toList());
    }

    public Borrow findBorrow(String subscriberName, String bookTitle) {
        for (Borrow borrow : borrows) {
            if (borrow.getSubscriber().getEmail().equalsIgnoreCase(subscriberName) &&
                    borrow.getBook().getTitle().equalsIgnoreCase(bookTitle)) {
                return borrow;
            }
        }
        return null;
    }
}
