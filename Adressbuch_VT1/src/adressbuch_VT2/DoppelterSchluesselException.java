package adressbuch_VT2;

/**
 * Eine Klasse die eine Exception darstellt, welche geworfen werden kann, wenn zu dem uebergebenen Schluessel bereits ein Kontakt im Adressbuch vorliegt
 *
 * @author Maren Mattern
 * @version 007
 */
public class DoppelterSchluesselException extends UngeueltigerSchluesselException{

    private String schluessel;

    public DoppelterSchluesselException(String schluessel) {

        super(schluessel);
    }

    public String getSchluessel() {
        return schluessel;
    }

    @Override
    public String toString() {
        return "Zu dem Schluessel \"" + this.getSchluessel() + "\" gibt es bereits ein Kontakt im Adressbuch";
    }
}
