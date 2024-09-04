package fr.pompey.dev.afpa.models;

import fr.pompey.dev.afpa.exception.MyExceptions;
import fr.pompey.dev.afpa.utilities.DialogUtils;

import java.time.LocalDate;

public class Borrow {
    private LocalDate startDate;
    private LocalDate endDate;
    private Subscriber subscriber;
//    private String bookTitle;
    private Book book;

    // Constructeur
//    public Borrow(LocalDate startDate, LocalDate endDate, String subscriber, String bookTitle) {
//        this.startDate = startDate;
//        this.endDate = startDate.plusDays(7);
//        this.subscriber = subscriber;
//        this.bookTitle = bookTitle;
//    }

    public Borrow(LocalDate startDate, LocalDate endDate, Subscriber subscriber, Book book) throws MyExceptions {
        this.startDate = startDate;
        this.endDate = startDate.plusDays(7);
        if (subscriber == null){
            throw new MyExceptions("L'abonné n'existe pas");
        } else if  (book == null) {
            throw new MyExceptions("Le livre n'existe pas");
        }else if  (book.getQuantity() < 1) {
            throw new MyExceptions("Le livre n'est pas disponible");
        }
        this.subscriber = subscriber;
        this.book = book;
//        this.bookTitle = book.getTitle();
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

//    public String getBookTitle() {
//        return bookTitle;
//    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Prêt" +
                " date début\n=" + DialogUtils.FORMATTER.format(startDate) +
                ", date fin\n=" + DialogUtils.FORMATTER.format(endDate) +
                ", nom abonné\n=" + subscriber +
                ", titre du livre\n= '" + book.getTitle() + '\'' +
                '}';
    }


    public Book getBook() {
        return book;
    }
}
