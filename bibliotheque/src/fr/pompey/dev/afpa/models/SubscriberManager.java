package fr.pompey.dev.afpa.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubscriberManager {
    private final List<Subscriber> subscribers;

    public SubscriberManager() {
        this.subscribers = new ArrayList<>();
    }

    // Méthode existante pour ajouter un abonné
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    // Recherche par nom ou email
    public List<Subscriber> searchSubscriber(String keyword) {
        return subscribers.stream()
                .filter(subscriber -> subscriber.getLastName().contains(keyword)
                        || subscriber.getFirstName().contains(keyword)
                        || subscriber.getEmail().contains(keyword))
                .collect(Collectors.toList());
    }

//    public List<Subscriber> getSubscribers() {
//        return subscribers;
//    }

//    public void addSubscriber(Subscriber subscriber) {
//        subscribers.add(subscriber);
//    }
//
//    public List<Subscriber> getSubscribers() {
//        return subscribers;
//    }
}
