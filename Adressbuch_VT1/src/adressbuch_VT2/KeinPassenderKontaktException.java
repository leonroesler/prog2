package adressbuch_VT2;

/**
 * Eine Klasse die eine Exception darstellt, welche geworfen werden kann, wenn zu dem uebergebenen Schluessel kein Kontakt im Adressbuch liegt
 *
 * @author Maren Mattern
 * @version 007
 */
public class KeinPassenderKontaktException extends Exception {

    private String schluessel;

    public KeinPassenderKontaktException(String schluessel) {
        this.schluessel = schluessel;
    }

    public String getSchluessel() {
        return schluessel;
    }

    @Override
    public String toString() {
        return "Zu dem Schluessel " + this.schluessel + " gibt es keinen passenden Kontakt im Adressbuch";
    }

}
