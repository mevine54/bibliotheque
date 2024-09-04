package fr.pompey.dev.afpa.utilities;


public class ValidationUtils {

    // Regex pour différents champs
    private static final String NAME_REGEX = "^[A-Za-zÀ-ÖØ-öø-ÿ]+$";
    private static final String EMAIL_REGEX = "^[a-z0-9+_.-]+@[a-z0-9.-]+$";
//    private static final  String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
    private static final String QUANTITY_REGEX = "^[1-9]{1}[0-9]{0,2}$";
    private static final String TITLEAUTHOR_REGEX = "^[A-Za-z0-9À-ÖØ-öø-ÿ\\s\\-\\'\\(\\)]+$";

    // Méthode statique pour validation des champs
    public static boolean isValidName(String name) {
        return name.matches(NAME_REGEX);
    }

    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

//    public boolean isValidDate(String date) {
//        return date.matches(DATE_REGEX);
//    }

    public static boolean isValidQuantity(String quantity) {
        return quantity.matches(QUANTITY_REGEX);
    }

    public static boolean isValidTitle(String title) {
        return title.matches(TITLEAUTHOR_REGEX);
    }

    public static boolean isValidAuthor(String author) {
        return author.matches(TITLEAUTHOR_REGEX);
    }

}
