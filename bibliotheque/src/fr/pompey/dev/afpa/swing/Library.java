package fr.pompey.dev.afpa.swing;

import fr.pompey.dev.afpa.controllers.LibraryController;
import fr.pompey.dev.afpa.models.Book;
import fr.pompey.dev.afpa.models.Subscriber;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Library extends JFrame {

    private JPanel contentPane;
    private JButton addSubscriberButton;
    private JButton addBookButton;
    private JButton addBorrowButton;
    private JButton displaySubscriberButton;
    private JButton displayBookButton;
    private JButton displayBorrowButton;
    private JButton searchSubscriberButton;
    private JButton searchBookButton;

    private LibraryController libraryController=new LibraryController();

    public Library() {
        setTitle("Gestion de bibliothèque");
        setSize(400, 400); // Taille ajustée pour les boutons alignés verticalement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(20, 5, 5, 5));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS)); // Alignement vertical
        setContentPane(contentPane);

        // Initialiser les boutons
        addSubscriberButton = new JButton("Ajouter un abonné");
        addBookButton = new JButton("Ajouter un livre");
        addBorrowButton = new JButton("Ajouter un prêt");
        displaySubscriberButton = new JButton("Afficher la liste des abonnés");
        displayBookButton = new JButton("Afficher la liste des livres");
        displayBorrowButton = new JButton("Afficher la liste des prêts");
        searchSubscriberButton = new JButton("Rechercher un abonné");
        searchBookButton = new JButton("Rechercher un livre");

        // définir la même taille por les boutons

        Dimension buttonSize = new Dimension(400, 30);
        addSubscriberButton.setMaximumSize(buttonSize);
        addBookButton.setMaximumSize(buttonSize);
        addBorrowButton.setMaximumSize(buttonSize);
        displaySubscriberButton.setMaximumSize(buttonSize);
        displayBookButton.setMaximumSize(buttonSize);
        displayBorrowButton.setMaximumSize(buttonSize);
        searchSubscriberButton.setMaximumSize(buttonSize);
        searchBookButton.setMaximumSize(buttonSize);

        // Ajouter les boutons au contentPane
        contentPane.add(addSubscriberButton);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10))); // Espace entre les boutons
        contentPane.add(addBookButton);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(addBorrowButton);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(displaySubscriberButton);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(displayBookButton);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(displayBorrowButton);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(searchSubscriberButton);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(searchBookButton);

        // Ajouter les ActionListener aux boutons
        addSubscriberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddSubscriberForm();
            }
        });

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddBookForm();
            }
        });

        addBorrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddBorrowForm();
            }
        });

        displaySubscriberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDisplaySubscriberList();
            }
        });

        displayBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDisplayBookList();
            }
        });

        displayBorrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDisplayBorrowList();
            }
        });

        searchSubscriberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSearchSubscriberForm();
            }
        });

        searchBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSearchBookForm();
            }
        });




    }

//    private void showAddSubscriberForm() {
//        JFrame formFrame = new JFrame("Add Subscriber");
//        formFrame.setSize(400, 300);
//        formFrame.setLayout(new GridLayout(5, 2));
//        formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        formFrame.setLocationRelativeTo(null);
//
//        JLabel nameLabel = new JLabel("Name:");
//        JTextField nameField = new JTextField();
//        JLabel surnameLabel = new JLabel("Surname:");
//        JTextField surnameField = new JTextField();
//        JLabel emailLabel = new JLabel("Email:");
//        JTextField emailField = new JTextField();
//        JLabel dateLabel = new JLabel("Date:");
//        JLabel dateField = new JLabel(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
//
//        JButton submitButton = new JButton("Submit");
//
//        formFrame.add(nameLabel);
//        formFrame.add(nameField);
//        formFrame.add(surnameLabel);
//        formFrame.add(surnameField);
//        formFrame.add(emailLabel);
//        formFrame.add(emailField);
//        formFrame.add(dateLabel);
//        formFrame.add(dateField);
//        formFrame.add(new JLabel()); // Empty cell
//        formFrame.add(submitButton);
//
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Enregistrer l'abonné (ou traiter les données)
//                String name = nameField.getText();
//                String surname = surnameField.getText();
//                String email = emailField.getText();
//                String date = dateField.getText();
//
//                // Affichage ou traitement des données
////                Subscriber subscriber = new Subscriber(name, email, date);
//                libraryController.registerSubscriber(name, surname, email);
//                JOptionPane.showMessageDialog(formFrame, "Subscriber added:\nName: " + name + "\nSurname: " + surname + "\nEmail: " + email + "\nDate: " + date);
//
//                formFrame.dispose(); // Fermer la fenêtre après soumission
//            }
//        });
//
//        formFrame.setVisible(true);
//    }

    private void showAddSubscriberForm() {
        JFrame formFrame = new JFrame("Ajouter un abonné");
        formFrame.setSize(400, 250);
        formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marges entre les composants
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel lastNameLabel = new JLabel("Nom:");
        JTextField lastNameField = new JTextField(20);
        JLabel firstNameLabel = new JLabel("Prénom:");
        JTextField firstNameField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JButton submitButton = new JButton("Valider");

        // Ajouter les composants au panneau
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lastNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(emailLabel, gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, gbc);

        formFrame.add(panel);

        // Action à effectuer lors du clic sur le bouton "Submit"
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lastName = lastNameField.getText();
                String firstName = firstNameField.getText();
                String email = emailField.getText();

                // Ajouter le nouvel abonné
                libraryController.addSubscriber(lastName, firstName, email);

                JOptionPane.showMessageDialog(formFrame, "Abonné ajouté:\nNom: " + lastName + "\nPrénom: " + firstName + "\nEmail: " + email);
                formFrame.dispose(); // Fermer la fenêtre après soumission
            }
        });

        formFrame.setVisible(true);
    }

    private void showAddBookForm() {
        JFrame formFrame = new JFrame("Ajouter livre");
        formFrame.setSize(400, 300);
//        formFrame.setLayout(new GridLayout(4, 2));
        formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formFrame.setLocationRelativeTo(null);

        // GridBagLayout pour un meilleur alignement
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel titleLabel = new JLabel("Titre:");
        JTextField titleField = new JTextField(20);
        JLabel authorLabel = new JLabel("Auteur:");
        JTextField authorField = new JTextField(20);
        JLabel isbnLabel = new JLabel("ISBN:");
        JTextField isbnField = new JTextField(20);
        JLabel quantityLabel = new JLabel("Quantité:");
        JTextField quantityField = new JTextField(5);
        JLabel dateLabel = new JLabel("Date:");
        JLabel dateField = new JLabel(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        JButton submitButton = new JButton("Valider");

        // Ajouter les composants au panneau
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(titleLabel, gbc);
        gbc.gridx = 1;
        panel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(authorLabel, gbc);
        gbc.gridx = 1;
        panel.add(authorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(isbnLabel, gbc);
        gbc.gridx = 1;
        panel.add(isbnField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(quantityLabel, gbc);
        gbc.gridx = 1;
        panel.add(quantityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(dateLabel, gbc);
        gbc.gridx = 1;
        panel.add(dateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Centrer le bouton
        panel.add(submitButton, gbc);

        formFrame.add(panel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enregistrer le livre (ou traiter les données)
                String title = titleField.getText();
                String author = authorField.getText();
                String isbn = isbnField.getText();
                String quantity = quantityField.getText();

                // Affichage ou traitement des données
                try {
                    libraryController.registerBook(title, author, Integer.parseInt(quantity));
                    JOptionPane.showMessageDialog(formFrame, "Livre ajouté:\nTitre: " + title + "\nAuteur: " + author + "\nISBN: " + isbn + "\nQuantité: ");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(formFrame, "Erreur: quantité invalide", "Entrée invalide", JOptionPane.WARNING_MESSAGE);
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(formFrame, "Erreur: problème d'affichage", "Erreur", JOptionPane.WARNING_MESSAGE);
                }

                formFrame.dispose(); // Fermer la fenêtre après soumission
            }
        });

        formFrame.setVisible(true);
    }

    private void showAddBorrowForm() {
        JFrame formFrame = new JFrame("Ajouter prêt");
        formFrame.setSize(400, 250);
        formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marges entre les composants
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel bookLabel = new JLabel("Titre du livre:");
        JTextField bookField = new JTextField(20);
        JLabel borrowerLabel = new JLabel("Emprunteur:");
        JTextField borrowerField = new JTextField(20);
        JLabel borrowDateLabel = new JLabel("Date du prêt:");
        JLabel borrowDateField = new JLabel(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        JButton submitButton = new JButton("Envoyer");

        // Ajouter les composants au panneau
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(bookLabel, gbc);
        gbc.gridx = 1;
        panel.add(bookField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(borrowerLabel, gbc);
        gbc.gridx = 1;
        panel.add(borrowerField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(borrowDateLabel, gbc);
        gbc.gridx = 1;
        panel.add(borrowDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, gbc);

        formFrame.add(panel);

        // Action à effectuer lors du clic sur le bouton "Envoyer"
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookTitle = bookField.getText();
                String subscriberMail = borrowerField.getText();
                String borrowDate = borrowDateField.getText();

                // Rechercher le livre et l'abonné
                Book book = libraryController.searchBook(bookTitle);
                Subscriber subscriber = libraryController.searchSubscriber(subscriberMail);

                // Enregistrer le prêt
                libraryController.registerBorrow(subscriber, book);

                JOptionPane.showMessageDialog(formFrame, "Prêt enregistré ! :\nTitre du livre: " + bookTitle + "\nEmail de l'emprunteur: " + subscriberMail + "\nDate d'emprunt: " + borrowDate);
                formFrame.dispose(); // Fermer la fenêtre après soumission
            }
        });

        formFrame.setVisible(true);
    }

    private void showDisplaySubscriberList() {
        JFrame displayFrame = new JFrame("Liste d'abonnés");
        displayFrame.setSize(400, 300);
        displayFrame.setLayout(new BorderLayout());
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.setLocationRelativeTo(null);

//        JTextArea textArea = new JTextArea("Displaying Subscriber List...\n[Data would be shown here]");
//        textArea.setEditable(false);


        DefaultListModel<String> listModel = new DefaultListModel<>();
        libraryController.getSubscribers().forEach(
                subscriber -> {
                    listModel.addElement(String.valueOf(subscriber));
                }
        );
        JList jlist = new JList(listModel);

        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(jlist);

        displayFrame.add(scrollPane, BorderLayout.CENTER);
        JButton closeButton = new JButton("Fermer");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFrame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        displayFrame.add(buttonPanel, BorderLayout.SOUTH);

        displayFrame.setVisible(true);
    }

    private void showDisplayBookList() {
        JFrame displayFrame = new JFrame("Liste de livres");
        displayFrame.setSize(400, 300);
        displayFrame.setLayout(new BorderLayout());
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.setLocationRelativeTo(null);

//        JTextArea textArea = new JTextArea("Displaying Book List...\n[Data would be shown here]");
//        textArea.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(textArea);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        libraryController.getBooks().forEach(
                book -> {
                    listModel.addElement(String.valueOf(book));
                }
        );
        JList jlist = new JList(listModel);

        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(jlist);

        displayFrame.add(scrollPane, BorderLayout.CENTER);
        JButton closeButton = new JButton("Fermer");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFrame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        displayFrame.add(buttonPanel, BorderLayout.SOUTH);

        displayFrame.setVisible(true);
    }

    private void showDisplayBorrowList() {
        JFrame displayFrame = new JFrame("Liste d' emprunts");
        displayFrame.setSize(400, 300);
        displayFrame.setLayout(new BorderLayout());
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.setLocationRelativeTo(null);

//        JTextArea textArea = new JTextArea("Displaying Borrow List...\n[Data would be shown here]");
//        textArea.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(textArea);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        libraryController.getBorrows().forEach(
                borrow -> {
                    listModel.addElement(String.valueOf(borrow));
                }
        );
        JList jlist = new JList(listModel);
        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(jlist);

        displayFrame.add(scrollPane, BorderLayout.CENTER);
        JButton closeButton = new JButton("Fermer");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFrame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        displayFrame.add(buttonPanel, BorderLayout.SOUTH);

        displayFrame.setVisible(true);
    }

    private void showSearchSubscriberForm() {
        JFrame formFrame = new JFrame("Rechercher un abonné");
        formFrame.setSize(400, 200);
        formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marges entre les composants
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel searchLabel = new JLabel("Entrer une adresse Email:");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Rechercher");

        // Ajouter les composants au panneau
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(searchLabel, gbc);
        gbc.gridx = 1;
        panel.add(searchField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(searchButton, gbc);

        formFrame.add(panel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Effectuer la recherche et afficher les résultats
                String searchTerm = searchField.getText();
                Subscriber result = libraryController.searchSubscriber(searchTerm);

                if (result != null) {
                    JOptionPane.showMessageDialog(formFrame, "Abonné trouvé:\nNom: " + result.getLastName() + "\nEmail: " + result.getEmail());
                } else {
                    JOptionPane.showMessageDialog(formFrame, "Abonné non trouvé", "Résultats de recherche", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        formFrame.setVisible(true);
    }

    private void showSearchBookForm() {
        JFrame formFrame = new JFrame("Rechercher livre");
        formFrame.setSize(400, 200);
        formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marges entre les composants
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel searchLabel = new JLabel("Entrer Titre ou ISBN:");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        // Ajouter les composants au panneau
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(searchLabel, gbc);
        gbc.gridx = 1;
        panel.add(searchField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(searchButton, gbc);

        formFrame.add(panel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Effectuer la recherche et afficher les résultats
                String searchTerm = searchField.getText();
                Book result = libraryController.searchBook(searchTerm);

                if (result != null) {
                    JOptionPane.showMessageDialog(formFrame, "Livre trouvé:\nTitre: " + result.getTitle() + "\nISBN: " + result.getIsbn());
                } else {
                    JOptionPane.showMessageDialog(formFrame, "Livre non trouvé", "Résultat de recherche", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        formFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Library().setVisible(true);
            }
        });
    }
}