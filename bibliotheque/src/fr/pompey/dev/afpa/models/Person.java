package fr.pompey.dev.afpa.models;

import fr.pompey.dev.afpa.utilities.ValidationUtils;

public class Person {
    private String lastName;
    private String firstName;

    // Constructeur
    public Person(String firstName, String lastName) {
        this.lastName = firstName;
        this.firstName = lastName;
    }

    // Getters & Setters
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





//    @Override
//    public String toString() {
//        return "Person [name=" + firstName + ", lastName=" + lastName + "]";
//    }

}
