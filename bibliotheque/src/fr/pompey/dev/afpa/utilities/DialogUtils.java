package fr.pompey.dev.afpa.utilities;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DialogUtils {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String showInputDialog(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    public static void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public static LocalDate parseDate(String dateStr) throws Exception {
        return LocalDate.parse(dateStr, FORMATTER);
    }
}
