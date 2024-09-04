package fr.pompey.dev.afpa.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fr.pompey.dev.afpa.utilities.ValidationUtils;

public class Subscriber extends Person {
    private final String lastName;
    private final String firstName;
    private final String email;
    private final String inscriptionDate;

    public Subscriber(String lastName, String firstName, String email) {
        super(lastName, firstName);
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.inscriptionDate = LocalDate.now().format(formatter);
    }

//    @Override
//    public String toString() {
//        return "Subscriber{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", inscriptionDate=" + inscriptionDate + '}';
//    }

    public String getLastName() {
        return lastName;
    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getFirstName() {
        return firstName;
    }

//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }


    public String getEmail() {
        return email;
    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getInscriptionDate() {
        return inscriptionDate;
    }

//    public void setInscriptionDate(String inscriptionDate) {
//        this.inscriptionDate = inscriptionDate;
//    }

    @Override
    public String toString() {
        return lastName + " - " + firstName + " - " + email;
    }
}
