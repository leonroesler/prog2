package adressbuch_VT2;

/**
 * Eine Klasse die eine Exception darstellt, welche geworfen werden kann, wenn zu dem uebergebenen Schluessel kein Kontakt im Adressbuch liegt
 *
 * @author Maren Mattern
 * @version 007
 */
public class KeinPassenderKontaktException extends UngeueltigerSchluesselException {

    private String schluessel;

    public KeinPassenderKontaktException(String schluessel) {
        super(schluessel);
        this.schluessel = schluessel;
    }

    public String getSchluessel() {
        return schluessel;
    }

    @Override
    public String toString() {
        return "Zu dem Schluessel " + this.getSchluessel() + " gibt es keinen passenden Kontakt im Adressbuch";
    }

}
