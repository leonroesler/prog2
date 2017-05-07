package adressbuch_VT2;

/**
 * Eine Klasse die eine Exception darstellt, welche geworfen werden kann, wenn der uebergebene Schluessel ein leerer String war
 *
 * @author Maren Mattern
 * @version 007
 */
public class UngeueltigerSchluesselException extends Exception {

    private String schluessel;

    public UngeueltigerSchluesselException(String schluessel) {
        this.schluessel = schluessel;
    }



    public String getSchluessel(){
        return schluessel;
    }

    @Override
    public String toString() {
        return "Der eingegebene Schluessel " + schluessel + "ist ungueltig";
    }
}
