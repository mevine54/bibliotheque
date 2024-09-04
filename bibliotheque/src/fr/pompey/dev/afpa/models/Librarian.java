package fr.pompey.dev.afpa.models;

import fr.pompey.dev.afpa.utilities.ValidationUtils;

public class Librarian extends Person {
    String lastname;
    String firstname;
    String id;

    // Constructeur
    public Librarian(String lastname, String firstname, String id) {
        super(lastname, firstname);
        this.lastname = lastname;
        this.firstname = firstname;
        this.id = id;
    }

    // Getters & Setters
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

//    @Override
//    public String toString() {
//        return "Librarian{" + "lastname=" + lastname + ", firstname=" + firstname + ", id=" + id + '}';
//    }
}
