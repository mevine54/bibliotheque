package fr.pompey.dev.afpa.views;

import fr.pompey.dev.afpa.controllers.LibraryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dashboard extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> menuComboBox;
    private JPanel addSubscriberPanel;
    private JLabel labelEmail;
    private JTextField textEmail;
    private JTextField textPrenom;
    private JTextField textNom;
    private JButton btnAddSubscriberValid;
    private JButton btnAddSubscriberCancel;
    private JLabel lsname;
    private JLabel fsname;

    private JPanel addBookPanel;
    private JTextField textBookTitle;
    private JTextField textBookAuthor;
    private JTextField textBookQuantity;
    private JButton btnAddBookValid;
    private JButton btnAddBookCancel;


    JOptionPane message = new JOptionPane();
    JTextField borrowBookDateTextField = new JTextField(30);
    JButton btnAddBorrowBook = new JButton("Ajouter emprunt");
    JButton btnCancelBorrowBook = new JButton("Annuler emprunt");
    JComboBox<String> borrowBookSubscriberComboBox = new JComboBox<>();
    JComboBox<String> borrowBookComboBox = new JComboBox<>();
    JTextField borrowBookQuantityTextField = new JTextField(30);

    private JPanel addBorrowBookPanel;
    private JTextField textBorrowBookTitle;
    private JTextField textBorrowBookSubscriber;
//    private JTextField textBorrowQuantity;
    private JButton btnAddBorrowBookValid;
    private JButton btnAddBorrowBookCancel;

    private JPanel displaySubscriberListPanel;
    private JPanel displayBookListPanel;
    private JPanel displayBorrowListPanel;
    private JPanel searchSubscriberPanel;
    private JPanel searchBookPanel;
    private JPanel searchBorrowPanel;

    LibraryController libraryController = new LibraryController();

    public Dashboard() {
        setTitle("Tableau de bord Gestion de bibliothèque");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Panneau pour le menu déroulant
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuComboBox = new JComboBox<>();
        menuPanel.add(menuComboBox);
        contentPane.add(menuPanel, BorderLayout.NORTH);

        labelEmail = new JLabel("Email: ");
        textNom = new JTextField();

        // Panneau principal pour les cartes
        JPanel cardPanel = new JPanel(new CardLayout());
        contentPane.add(cardPanel, BorderLayout.CENTER);

        // Créer les panneaux de formulaire
        addSubscriberPanel = createAddSubscriberPanel();
        btnAddSubscriberValid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("textNom " + textNom.getText() + "textPrenom " + textPrenom.getText() + "textEmail " + textEmail.getText());
//                Subscriber subscriber = new Subscriber(textNom.getText(), textPrenom.getText(), textEmail.getText());
//                libraryController
                libraryController.addSubscriber(textNom.getText(), textPrenom.getText(), textEmail.getText());
                message.showMessageDialog(null, "Ajout de l'abonné : " + textNom.getText()+" - "+ textPrenom.getText()+" - "+ textEmail.getText());

                System.out.println(libraryController.getSubscribers());
            }
        });

        btnAddSubscriberCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNom.setText("");
                textEmail.setText("");
                textPrenom.setText("");

            }
        });

        addBookPanel = createAddBookPanel();
        btnAddBookValid.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                libraryController.registerBook(textBookTitle.getText(), textBookAuthor.getText(), Integer.parseInt(textBookQuantity.getText()));
                message.showMessageDialog(null, "Ajout du livre : " + textBookTitle.getText()+" - "+ textBookAuthor.getText());

            }
        });

        btnAddBookCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textBookTitle.setText("");
                textBookAuthor.setText("");
                textBookQuantity.setText("");

            }
        });

        addBorrowBookPanel = createAddBorrowBookPanel();
        btnAddBorrowBook.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                libraryController.registerBorrow(textBorrowBookTitle.getText(), textBorrowBookSubscriber.getText());

            }
        });

        btnCancelBorrowBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textBorrowBookTitle.setText("");
                textBorrowBookSubscriber.setText("");
            }
        });


        // Panneaux pour les listes et les recherches
        displaySubscriberListPanel = createDisplaySubscriberListPanel();
        displayBookListPanel = new JPanel();
        displayBorrowListPanel = new JPanel();
        searchSubscriberPanel = new JPanel();
        searchBookPanel = new JPanel();
        searchBorrowPanel = new JPanel();

        // Ajoute les panneaux au cardPanel
        cardPanel.add(addSubscriberPanel, "Ajouter un abonné");
        cardPanel.add(addBookPanel, "Ajouter un livre");
        cardPanel.add(addBorrowBookPanel, "Ajouter un prêt");
        cardPanel.add(displaySubscriberListPanel, "Afficher la liste des abonnés");
        cardPanel.add(displayBookListPanel, "Afficher la liste des livres");
        cardPanel.add(displayBorrowListPanel, "Afficher la liste des prêts");
        cardPanel.add(searchSubscriberPanel, "Rechercher un abonné");
        cardPanel.add(searchBookPanel, "Rechercher un livre");
        cardPanel.add(searchBorrowPanel, "Rechercher un prêt");

        // Ajoute les items à JComboBox
        menuComboBox.addItem("Ajouter un abonné");
        menuComboBox.addItem("Ajouter un livre");
        menuComboBox.addItem("Ajouter un prêt");
        menuComboBox.addItem("Afficher la liste des abonnés");
        menuComboBox.addItem("Afficher la liste des livres");
        menuComboBox.addItem("Afficher la liste des prêts");
        menuComboBox.addItem("Rechercher un abonné");
        menuComboBox.addItem("Rechercher un livre");
        menuComboBox.addItem("Rechercher un prêt");

        // Configure JComboBox action
        menuComboBox.addActionListener(e -> {
            CardLayout cl = (CardLayout) cardPanel.getLayout();
            cl.show(cardPanel, (String) menuComboBox.getSelectedItem());
        });

        // Initialise avec le panel "Ajouter un abonné"
        ((CardLayout) cardPanel.getLayout()).show(cardPanel, "Ajouter un abonné");

        setVisible(true);
    }

    private JPanel createDisplaySubscriberListPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel labelTitleTable = new JLabel("Liste des abonnés:");
        panel.add(labelTitleTable, BorderLayout.WEST);
        JTable table = new JTable();

        JScrollPane scrollPane = new JScrollPane(table);


        return panel;
    }

    private JPanel createAddSubscriberPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel lsname = new JLabel("Nom:");
        textNom = new JTextField(30);
        panel.add(createLabeledTextFieldPanel(lsname, textNom));

        JLabel fsname = new JLabel("Prénom:");
        textPrenom = new JTextField(30);
        panel.add(createLabeledTextFieldPanel(fsname, textPrenom));

        labelEmail = new JLabel("Email:");
        textEmail = new JTextField(30);
        panel.add(createLabeledTextFieldPanel(labelEmail, textEmail));

        btnAddSubscriberValid = new JButton("Valider");
        btnAddSubscriberCancel = new JButton("Annuler");
        panel.add(createButtonPanel(btnAddSubscriberValid, btnAddSubscriberCancel));

        return panel;
    }

    private JPanel createAddBookPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel bookTitleLabel = new JLabel("Titre");
        textBookTitle = new JTextField(30);
        panel.add(createLabeledTextFieldPanel(bookTitleLabel, textBookTitle));

        JLabel bookAuthorLabel = new JLabel("Auteur");
        textBookAuthor = new JTextField(30);
        panel.add(createLabeledTextFieldPanel(bookAuthorLabel, textBookAuthor));

        JLabel bookQuantityLabel = new JLabel("Quantité");
        textBookQuantity = new JTextField(30);
        panel.add(createLabeledTextFieldPanel(bookQuantityLabel, textBookQuantity));

        btnAddBookValid = new JButton("Ajouter");
        btnAddBookCancel = new JButton("Annuler");
        panel.add(createButtonPanel(btnAddBookValid, btnAddBookCancel));

        return panel;
    }

    private JPanel createAddBorrowBookPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel borrowBookTitleLabel = new JLabel("Livre");

        // Ajoutez des livres au JComboBox ici
        libraryController.getBooks().forEach(book ->
                borrowBookComboBox.addItem(book.toString())
                );

        panel.add(createLabeledComboBoxPanel(borrowBookTitleLabel, borrowBookComboBox));

        JLabel borrowBookSubscriberLabel = new JLabel("Abonné");

        // Ajoutez des abonnés au JComboBox ici
        libraryController.getSubscribers().forEach(subscriber ->
                borrowBookSubscriberComboBox.addItem(subscriber.toString()));

        panel.add(createLabeledComboBoxPanel(borrowBookSubscriberLabel, borrowBookSubscriberComboBox));

        JLabel borrowBookQuantityLabel = new JLabel("Quantité");

        panel.add(createLabeledTextFieldPanel(borrowBookQuantityLabel, borrowBookQuantityTextField));

        JLabel borrowBookDateLabel = new JLabel("Date");

        borrowBookDateTextField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        borrowBookDateTextField.setEditable(false); // Champ non modifiable par l'utilisateur
        panel.add(createLabeledTextFieldPanel(borrowBookDateLabel, borrowBookDateTextField));

        panel.add(createButtonPanel(btnAddBorrowBook, btnCancelBorrowBook));

        // Action pour le bouton "Ajouter emprunt"
        btnAddBorrowBook.addActionListener(e -> {
            // Implémenter la logique d'ajout d'emprunt ici, par exemple enregistrer l'emprunt dans une base de données
            String livre = (String) borrowBookComboBox.getSelectedItem();
            String abonne = (String) borrowBookSubscriberComboBox.getSelectedItem();
            String quantite = borrowBookQuantityTextField.getText();
            String date = borrowBookDateTextField.getText();

            // Affiche les informations de l'emprunt (à des fins de test)
            System.out.println("Emprunt ajouté :");
            System.out.println("Livre : " + livre);
            System.out.println("Abonné : " + abonne);
            System.out.println("Quantité : " + quantite);
            System.out.println("Date : " + date);
        });

        return panel;
    }


    private JPanel createLabeledTextFieldPanel(JLabel label, JTextField textField) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.WEST);
        panel.add(Box.createHorizontalStrut(10), BorderLayout.CENTER);
        panel.add(textField, BorderLayout.EAST);
        return panel;
    }

    private JPanel createLabeledComboBoxPanel(JLabel label, JComboBox<String> comboBox) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.WEST);
        panel.add(Box.createHorizontalStrut(10), BorderLayout.CENTER);
        panel.add(comboBox, BorderLayout.EAST);
        return panel;
    }

    private JPanel createButtonPanel(JButton btn1, JButton btn2) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createHorizontalGlue());
        panel.add(btn1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(btn2);
        panel.add(Box.createHorizontalGlue());
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Dashboard::new);
    }
}
